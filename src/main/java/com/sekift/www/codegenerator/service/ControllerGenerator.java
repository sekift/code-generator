package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;

import java.io.BufferedReader;
import java.io.File;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/04 16:34
 * @description: 从service类生成controller类
 */
public class ControllerGenerator {
    public static final String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    public static final String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    public static final boolean NEED_NOTE = GeneratorConfig.NEED_NOTE;
    public static final boolean NEED_SWAGGER = GeneratorConfig.CONTROLLER_NEED_SWAGGER;
    public static final String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    public static final String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "service/";
    public static final String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "controller/";
    public static final String FROM_PATH = MODEL_DIR + CLASS_NAME + "Service" + GeneratorConfig.PRO_NAME;
    public static final String WRITE_NAME = "Controller" + GeneratorConfig.PRO_NAME;
    public static final String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;
    public static final String VALUE_OBJECT = CLASS_NAME + "VO";

    public static void generateController() {
        try{
            BufferedReader reader = GeneratorUtil.readFile(FROM_PATH);

            String line, trimedLine;
            int firstLine = 0;
            while ((line = reader.readLine()) != null) {
                trimedLine = line.trim();

                // 第一条写的时候判断是否文件已存在，如果存在则不做操作，避免搞错
                if(firstLine == 0){
                    File file = new File(TO_PATH);
                    if(file.exists()&& !GeneratorConfig.NEED_APPEND){
                        throw new Exception("写入的文件：" + TO_PATH + "已存在，请保存原文件并删除后再生成。" +
                                "或者将GeneratorConfig的NEED_APPEND参数设置为true跳过此限制。");
                    }
                }
                //包名
                if (trimedLine.startsWith("package " + PACKAGE_NAME)) {
                    firstLine++;
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace(".service", ".controller"));
                    GeneratorUtil.writeFile(TO_PATH,"");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".service."+ CLASS_NAME +"Service;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".tool.CommUtils;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".tool.LogUtils;");
                    GeneratorUtil.writeFile(TO_PATH,"import org.springframework.beans.factory.annotation.Autowired;");
                    GeneratorUtil.writeFile(TO_PATH,"import org.springframework.web.bind.annotation.*;");
                    if (NEED_SWAGGER) {
                        GeneratorUtil.writeFile(TO_PATH, "\n" + "import io.swagger.annotations.Api;");
                        GeneratorUtil.writeFile(TO_PATH, "import io.swagger.annotations.ApiOperation;");
                    }
                    GeneratorUtil.writeFile(TO_PATH,"");

                }
                //原来包的引入
                if (trimedLine.startsWith("import ")) {
                    GeneratorUtil.writeFile(TO_PATH, trimedLine);
                }

                if (trimedLine.startsWith("public interface ")) {
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //类注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "/**");
                        GeneratorUtil.writeFile(TO_PATH, " * @author: " + GeneratorConfig.NOTE_AUTHOR);
                        GeneratorUtil.writeFile(TO_PATH, " * @date: " + GeneratorUtil.getStringDate());
                        GeneratorUtil.writeFile(TO_PATH, " * @description: " + NOTE_DESC);
                        GeneratorUtil.writeFile(TO_PATH, " **/");
                    }
                    //引入注解
                    GeneratorUtil.writeFile(TO_PATH, "@RestController");
                    GeneratorUtil.writeFile(TO_PATH, "@RequestMapping(\"/api/" + CLASS_NAME.toLowerCase() +"\")");
                    if(NEED_SWAGGER) {
                        GeneratorUtil.writeFile(TO_PATH, "@Api(tags = {\"" + NOTE_DESC + "\"})");
                    }
                    //类名
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace("interface", "class")
                            .replace(CLASS_NAME+"Service", CLASS_NAME + "Controller"));
                    GeneratorUtil.writeFile(TO_PATH, "");
                    GeneratorUtil.writeFile(TO_PATH, "    @Autowired");
                    GeneratorUtil.writeFile(TO_PATH, "    private " + CLASS_NAME + "Service "+
                            GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service;");
                }

                //insert方法
                if(GeneratorConfig.SERVICE_NEED_INSERT && trimedLine.startsWith("JsonRslt insert(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 插入数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    @PostMapping(\"/insert\")");
                    if(NEED_SWAGGER){
                        GeneratorUtil.writeFile(TO_PATH, "    @ApiOperation(value = \"插入"+NOTE_DESC+"数据(完成)\"," +
                                "notes=\"传入具体内容\",httpMethod = \"POST\",hidden = false)");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    public " + trimedLine.replace(";","{")
                                  .replace("insert(", "insert(@RequestBody "));
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        return "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.insert("
                                + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +  ");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "        return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");
                }

                //delete方法
                if(GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.startsWith("JsonRslt delete(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //获取括号中的内容
                    String strSub = trimedLine.split("\\(")[1].replace(");","");
                    //String paramType = strSub.split(" ")[0];
                    String paramName = strSub.split(" ")[1];

                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按主键删除数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }

                    GeneratorUtil.writeFile(TO_PATH, "    @PostMapping(\"/delete\")");
                    if(NEED_SWAGGER){
                        GeneratorUtil.writeFile(TO_PATH, "    @ApiOperation(value = \"删除"+NOTE_DESC+"数据(完成)\"," +
                                "notes=\"传入对象的唯一键即可\",httpMethod = \"POST\",hidden = false)");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    public JsonRslt delete(@RequestBody "
                            + VALUE_OBJECT + " " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){" );
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        return "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.delete("
                                + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                                + GeneratorUtil.firstCharUpperCase(paramName) + "());");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "        return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");
                }

                //update方法
                if(GeneratorConfig.SERVICE_NEED_UPDATE && trimedLine.startsWith("JsonRslt update(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 修改数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    @PostMapping(\"/update\")");
                    if(NEED_SWAGGER){
                        GeneratorUtil.writeFile(TO_PATH, "    @ApiOperation(value = \"更新"+NOTE_DESC+"数据(完成)\"," +
                                "notes=\"修改的数据与原来不改的数据需一起上传\",httpMethod = \"POST\",hidden = false)");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    public " + trimedLine.replace(";","{")
                            .replace("update(", "update(@RequestBody "));
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                        GeneratorUtil.writeFile(TO_PATH, "        return "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.update("
                                + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +  ");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "        return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");

                }

                //select方法
                if(GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("JsonRslt select(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //获取括号中的内容
                    String strSub = trimedLine.split("\\(")[1].replace(");","");
                    //String paramType = strSub.split(" ")[0];
                    String paramName = strSub.split(" ")[1];

                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按主键查询一条数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    @PostMapping(\"/select\")");
                    if(NEED_SWAGGER){
                        GeneratorUtil.writeFile(TO_PATH, "    @ApiOperation(value = \"按键查询"+NOTE_DESC+"数据(完成)\"," +
                                "notes=\"传入对象的唯一键即可\",httpMethod = \"POST\",hidden = false)");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    public JsonRslt select(@RequestBody "
                            + VALUE_OBJECT + " " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){");
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        return "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.select("
                                + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                                + GeneratorUtil.firstCharUpperCase(paramName) + "());");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "        return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");
                }

                //search方法
                if(GeneratorConfig.SERVICE_NEED_SEARCH  && trimedLine.contains("JsonRslt search(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按条件查询数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    @PostMapping(\"/search\")");
                    if(NEED_SWAGGER){
                        GeneratorUtil.writeFile(TO_PATH, "    @ApiOperation(value = \"按条件查询"+NOTE_DESC+"数据(完成)\"," +
                                "notes=\"传入你想过滤的字段条件\",httpMethod = \"POST\",hidden = false)");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    public JsonRslt search(@RequestBody "+VALUE_OBJECT+" "
                            + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){");

                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        return "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.search("
                                + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +  ");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "        return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");
                }
            }
            GeneratorUtil.writeFile(TO_PATH, "");
            GeneratorUtil.writeFile(TO_PATH, "}");
            System.out.println(CLASS_NAME + WRITE_NAME + "生成成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(CLASS_NAME + WRITE_NAME + "生成失败");
        }
    }

}