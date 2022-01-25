package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;
import com.sekift.www.codegenerator.JDBCOperator;
import org.apache.commons.collections4.CollectionUtils;

import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author sekift
 * @date 2020/10/30 17:20
 * @description 从model一键生成基本VO，某些属性说明需生成后再填写
 */
public class VOGenerator {
    private String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    private String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    private boolean NEED_SWAGGER = GeneratorConfig.VO_NEED_SWAGGER;
    private String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "model/";
    private String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "vo/";
    private String FROM_PATH = MODEL_DIR + CLASS_NAME + GeneratorConfig.PRO_NAME;
    private String WRITE_NAME = "VO" + GeneratorConfig.PRO_NAME;
    private String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;

    // swagger顺序累加
    private int position = 1;

    public void generateVO(){
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            // 是否覆盖文件
            GeneratorUtil.isAppendFile(TO_PATH);
            BufferedReader reader = GeneratorUtil.readFile(FROM_PATH);
            while ((line = reader.readLine()) != null) {
                String trimedLine = line.trim();
                // 生成包名和引入包
                generatePackageAndImport(sb, trimedLine);
                // 生成注释和类名
                generateDocAndClassName(sb, trimedLine);
                // 生成属性和方法
                generateFields(sb, trimedLine);
            }
            // 最后一个大括号
            sb.append("}");

            GeneratorUtil.writeFile(TO_PATH, sb.toString());
            System.out.println(CLASS_NAME + WRITE_NAME + " 生成成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(CLASS_NAME + WRITE_NAME + " 生成失败");
        }
    }

    /**
     * 生成包名和引入包
     * @param sb
     * @param trimedLine
     */
    private void generatePackageAndImport(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("package " + GeneratorConfig.PACKAGE_NAME)) {
            // 包名
            String packageName = trimedLine.replace(".model", ".vo");
            sb.append(packageName + "\n");
            sb.append("\n");
            // 引入swagger的包
            if (NEED_SWAGGER) {
                sb.append("import io.swagger.annotations.ApiModel;" + "\n");
                sb.append("import io.swagger.annotations.ApiModelProperty;" + "\n");
            }
            // 引入lombak包
            sb.append("import lombok.Data;" + "\n");
            sb.append("\n");
        }
        // 引入model原有包
        if (trimedLine.startsWith("import ")) {
            sb.append(trimedLine + "\n");
        }
    }

    /**
     * 生成注释和类名
     * @param sb
     * @param trimedLine
     */
    private void generateDocAndClassName(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("public class ")) {
            sb.append("\n");
            // 类注释信息
            CommonGenerator.classDescription(sb);

            // 注解
            sb.append("@Data" + "\n");
            if (NEED_SWAGGER) {
                sb.append(String.format("@ApiModel(description = \"%s\")", NOTE_DESC) + "\n");
            }
            // 类名，是否需分页
            String className = (GeneratorConfig.VO_NEED_PAGE ? trimedLine.replace(" {","VO extends BaseEntity {") :
                    trimedLine.replace(" {","VO {"));
            sb.append(className + "\n");
        }
    }

    /**
     * 生成属性和方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateFields(StringBuilder sb, String trimedLine) throws Exception{
        if (trimedLine.startsWith("private ")) {
            if (NEED_SWAGGER) {
                // 类型的swagger示例
                String typeExample = "";
                if(trimedLine.contains("private Date")){
                    typeExample = "dataType = \"date\", example = \"2020-12-12 12:00:00\",";
                }else if(trimedLine.contains("private Integer")||trimedLine.contains("private Long")
                        ||trimedLine.contains("private Byte")){
                    typeExample = "example = \"1\",";
                }else if(trimedLine.contains("private BigDecimal")||trimedLine.contains("private Double")){
                    typeExample = "example = \"1.00\",";
                }else if(trimedLine.contains("private String")){
                    typeExample = "example = \"a\",";
                }
                else{
                    typeExample = "example = \"\",";
                }


                String swaggerRemark = "    @ApiModelProperty(value = \"%s\", accessMode = ApiModelProperty.AccessMode.READ_WRITE,\n"
                        + "            %s allowEmptyValue = true, position = %d)";

                // 从数据库拿字段说明
                List<Map<String, Object>> list = JDBCOperator.queryTableMetadata();
                if(CollectionUtils.isEmpty(list)){
                    // 拿不到就写默认的swagger
                    sb.append(String.format(swaggerRemark, "", typeExample, position++) + "\n");
                } else {
                    //得到属性、字段名称
                    Class<?> clazz = Class.forName(GeneratorConfig.PACKAGE_NAME + ".model." + GeneratorConfig.CLASS_NAME );
                    for(Field field : clazz.getDeclaredFields()) {
                        for(Map<String, Object> map : list){
                            boolean flag = trimedLine.contains(" " + field.getName()+";") && field.getName().toLowerCase().equals(map.get("columnName"));
                            if(flag){
                                String remark = map.get("remark").toString();
                                remark = remark.contains("\"")?remark.replace("\"","\\\""):remark;
                                // 写带注释的swagger
                                sb.append(String.format(swaggerRemark, remark, typeExample, position++) + "\n");
                                break;
                            }
                        }
                    }
                }
            }
            // 写属性
            sb.append("    " + trimedLine + "\n");
            sb.append("\n");
        }
    }

}
