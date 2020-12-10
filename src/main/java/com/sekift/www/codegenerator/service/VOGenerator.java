package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;
import com.sekift.www.codegenerator.JDBCOperator;
import org.apache.commons.collections.CollectionUtils;

import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: yinzhang.lu
 * @date: 2020/10/30 17:20
 * @description: 从model一键生成基本VO，属性说明需生成后再填写
 */
public class VOGenerator {
    public static final  String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    public static final  String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    public static final  boolean NEED_NOTE = GeneratorConfig.NEED_NOTE;
    public static final  boolean NEED_PAGE = GeneratorConfig.VO_NEED_PAGE;
    public static final  boolean NEED_SWAGGER = GeneratorConfig.VO_NEED_SWAGGER;
    public static final  String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    public static final  String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "model/";
    public static final  String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "vo/";
    public static final  String FROM_PATH = MODEL_DIR + CLASS_NAME + GeneratorConfig.PRO_NAME;
    public static final  String WRITE_NAME = "VO" + GeneratorConfig.PRO_NAME;
    public static final  String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;

    public static void generateVO(){
        int position = 1;
        try {
            BufferedReader reader = GeneratorUtil.readFile(FROM_PATH);

            String comment = "";
            String line, trimedLine;
            int firstLine = 0;
            while ((line = reader.readLine()) != null) {
                trimedLine = line.trim();

                // 第一条写的时候判断是否文件已存在，如果存在则不做操作，避免搞错
                //可以使用NEED_APPEND参数进行控制是否判断
                if(firstLine == 0){
                    File file = new File(TO_PATH);
                    if(file.exists() && !GeneratorConfig.NEED_APPEND){
                        throw new Exception("写入的文件：" + TO_PATH + "已存在，请保存原文件并删除后再生成。" +
                                "或者将GeneratorConfig的NEED_APPEND参数设置为true跳过此限制。");
                    }
                }
                //包名
                if (trimedLine.startsWith("package " + PACKAGE_NAME)) {
                    firstLine++;
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace(".model", ".vo"));
                    if (NEED_SWAGGER) {
                        GeneratorUtil.writeFile(TO_PATH, "\n" + "import io.swagger.annotations.ApiModel;");
                        GeneratorUtil.writeFile(TO_PATH, "import io.swagger.annotations.ApiModelProperty;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "import lombok.Data;");
                }
                if (trimedLine.startsWith("import ")) {
                    GeneratorUtil.writeFile(TO_PATH, "");
                    GeneratorUtil.writeFile(TO_PATH, trimedLine);
                }

                if (trimedLine.startsWith("public class ")) {
                    GeneratorUtil.writeFile(TO_PATH, "");

                    //类注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "/**");
                        GeneratorUtil.writeFile(TO_PATH, " * @author: " + GeneratorConfig.NOTE_AUTHOR);
                        GeneratorUtil.writeFile(TO_PATH, " * @date: " + GeneratorUtil.getStringDate());
                        GeneratorUtil.writeFile(TO_PATH, " * @description: " + NOTE_DESC);
                        GeneratorUtil.writeFile(TO_PATH, " **/");
                    }

                    GeneratorUtil.writeFile(TO_PATH, "@Data");
                    if (NEED_SWAGGER) {
                        GeneratorUtil.writeFile(TO_PATH, String.format("@ApiModel(description=\"%s\")", NOTE_DESC));
                    }
                    GeneratorUtil.writeFile(TO_PATH,
                            NEED_PAGE ? trimedLine.replace(" {","VO extends BaseEntity {") :
                                    trimedLine.replace(" {","VO {"));
                }

                if (trimedLine.startsWith("private ")) {
                    if (NEED_SWAGGER) {
                        String dateType = "";
                        if(trimedLine.contains("private Date")){
                            dateType= "dataType = \"date\", example = \"2020-10-20 10:40:00\",";
                        }else{
                            dateType= "example = \"\",";
                        }

                        List<Map<String, Object>> list = JDBCOperator.queryTableMetadata();
                        if(list == null || CollectionUtils.isEmpty(list)){
                            GeneratorUtil.writeFile(TO_PATH, String.format("    @ApiModelProperty(value = \"%s\", "
                                            + "required = false, readOnly = false,%s allowEmptyValue = true, position = %d)",
                                    comment, dateType, position++));
                        }else{
                            Set<Object> set = new HashSet<>();
                            //得到属性/字段名称
                            Class<?> clazz = Class.forName(GeneratorConfig.PACKAGE_NAME + ".model." + GeneratorConfig.CLASS_NAME );
                            Field[] fields = clazz.getDeclaredFields();
                            for(Field field : fields) {
                                for(Map<String, Object> map : list){
                                    if(trimedLine.contains(" " + field.getName()+";") && field.getName().toLowerCase().equals(map.get("columnName"))){
                                        String remark = map.get("remark").toString();
                                        if(remark.contains("\"")){
                                            remark = remark.replace("\"","\\\"");
                                        }
                                        GeneratorUtil.writeFile(TO_PATH, String.format("    @ApiModelProperty(value = \"%s\", "
                                                        + "required = false, readOnly = false,%s allowEmptyValue = true, position = %d)",
                                                remark, dateType, position++));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    " + trimedLine);
                    GeneratorUtil.writeFile(TO_PATH, "");
                }
            }
            GeneratorUtil.writeFile(TO_PATH, "}");
            System.out.println(CLASS_NAME + WRITE_NAME + "生成成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(CLASS_NAME + WRITE_NAME + "生成失败");
        }
    }
}
