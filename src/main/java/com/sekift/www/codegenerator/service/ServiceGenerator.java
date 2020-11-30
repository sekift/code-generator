package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;

import java.io.BufferedReader;
import java.io.File;

/**
 * @author: yinzhang.lu
 * @date: 2020/10/30 17:20
 * @description: 根据dao的mapper生成service类
 */
public class ServiceGenerator {
    public static final String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    public static final String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    public static final boolean NEED_NOTE = GeneratorConfig.NEED_NOTE;
    public static final String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    public static final String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "dao/";
    public static final String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "service/";
    public static final String FROM_PATH = MODEL_DIR + CLASS_NAME + "Mapper" + GeneratorConfig.PRO_NAME;
    public static final String WRITE_NAME = "Service" + GeneratorConfig.PRO_NAME;
    public static final String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;
    public static final String VALUE_OBJECT = CLASS_NAME + "VO";

    public static void generateService() {
        try{
            BufferedReader reader = GeneratorUtil.readFile(FROM_PATH);

            String line, trimedLine;
            String paramName = ""; //select或delete时的主键名，例如id或code
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
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace(".dao", ".service"));
                    GeneratorUtil.writeFile(TO_PATH,"");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".tool.JsonRslt;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".vo." + VALUE_OBJECT + ";");
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

                    //类名
                    GeneratorUtil.writeFile(TO_PATH, "public interface " + CLASS_NAME + "Service {");
                }

                /**
                 * 取主键的名称，例如id或者code
                 */
                if((GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("JsonRslt select("))||
                        GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.contains("JsonRslt delete(")) {
                    //获取括号中的内容
                    String strSub = trimedLine.split("\\(")[1].replace(");", "");
                    //String paramType = strSub.split(" ")[0];
                    paramName = strSub.split(" ")[1];
                }

                //insert方法
                if(GeneratorConfig.SERVICE_NEED_INSERT && trimedLine.startsWith("int insert(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 插入数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace("int insert(", "    JsonRslt insert(")
                                  .replace(CLASS_NAME, VALUE_OBJECT)
                                  .replace("record", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT)));

                }

                //delete方法
                if(GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.startsWith("int deleteByPrimaryKey(")){
                    GeneratorUtil.writeFile(TO_PATH, "");

                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按主键删除数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + paramName);
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, trimedLine
                            .replace("int deleteByPrimaryKey(", "    JsonRslt delete("));
                }

                //update方法
                if(GeneratorConfig.SERVICE_NEED_UPDATE && trimedLine.startsWith("int updateByPrimaryKey(")){
                    GeneratorUtil.writeFile(TO_PATH, "");
                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 修改数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, trimedLine
                            .replace("int updateByPrimaryKey(", "    JsonRslt update(")
                            .replace(CLASS_NAME, VALUE_OBJECT)
                            .replace("record", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT)));

                }

                //select方法
                if(GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("selectByPrimaryKey(")){
                    GeneratorUtil.writeFile(TO_PATH, "");

                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按主键查询一条数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + paramName);
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, trimedLine
                            .replace(CLASS_NAME, "    JsonRslt")
                            .replace("selectByPrimaryKey(", "select("));
                }
            }

            //search方法
            if(GeneratorConfig.SERVICE_NEED_SEARCH){
                GeneratorUtil.writeFile(TO_PATH, "");
                //方法注释信息
                if (NEED_NOTE) {
                    GeneratorUtil.writeFile(TO_PATH, "    /**");
                    GeneratorUtil.writeFile(TO_PATH, "     * 按条件查询数据");
                    GeneratorUtil.writeFile(TO_PATH, "     * @param " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
                    GeneratorUtil.writeFile(TO_PATH, "     * @return");
                    GeneratorUtil.writeFile(TO_PATH, "     **/");
                }
                GeneratorUtil.writeFile(TO_PATH, "    JsonRslt search("+VALUE_OBJECT+" "
                        + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +");");
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
