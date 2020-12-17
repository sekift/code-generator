package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;

import java.io.BufferedReader;

/**
 * @author: yinzhang.lu
 * @date: 2020/10/30 17:20
 * @description: 根据dao的mapper生成service类
 */
public class ServiceGenerator {
    private static final String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    private static final String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    private static final String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "dao/";
    private static final String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "service/";
    private static final String FROM_PATH = MODEL_DIR + CLASS_NAME + "Mapper" + GeneratorConfig.PRO_NAME;
    private static final String WRITE_NAME = "Service" + GeneratorConfig.PRO_NAME;
    private static final String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;
    private static final String VALUE_OBJECT = CLASS_NAME + "VO";

    private static String paramName = "";
    public static void generateService() {
        String line, trimedLine;
        StringBuilder sb = new StringBuilder();
        try{
            // 是否覆盖文件
            GeneratorUtil.isAppendFile(TO_PATH);
            BufferedReader reader = GeneratorUtil.readFile(FROM_PATH);
            while ((line = reader.readLine()) != null) {
                trimedLine = line.trim();
                // 生成包名和引入包
                generatePackageAndImport(sb, trimedLine);
                // 生成注释和类名
                generateDocAndClassName(sb, trimedLine);
                // 生成insert方法
                generateInsertMethod(sb, trimedLine);
                // 生成delete方法
                generateDeleteMethod(sb, trimedLine);
                // 生成update方法
                generateUpdateMethod(sb, trimedLine);
                // 生成select方法
                generateSelectMethod(sb, trimedLine);
            }
            // 生成search方法
            generateSearchMethod(sb, null);
            sb.append("\n");
            sb.append("}");

            System.out.println(sb.toString());
            GeneratorUtil.writeFile(TO_PATH, sb.toString());
            System.out.println(CLASS_NAME + WRITE_NAME + "生成成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(CLASS_NAME + WRITE_NAME + "生成失败");
        }
    }

    /**
     * 生成包名和引入包
     * @param sb
     * @param trimedLine
     */
    private static void generatePackageAndImport(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("package " + PACKAGE_NAME)) {
            String packageName = trimedLine.replace(".dao", ".service");
            sb.append(packageName + "\n");
            sb.append("\n");
            sb.append("import " + PACKAGE_NAME + ".tool.JsonRslt;" + "\n");
            sb.append("import " + PACKAGE_NAME + ".vo." + VALUE_OBJECT + ";" + "\n");
            sb.append("\n");
        }
        // 引入原来的包
        if (trimedLine.startsWith("import ")) {
            sb.append(trimedLine + "\n");
        }
    }

    /**
     * 生成注释和类名
     * @param sb
     * @param trimedLine
     */
    private static void generateDocAndClassName(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("public interface ")) {
            sb.append("\n");
            // 类注释信息
            CommonGenerator.classDescription(sb);

            // 类名
            String className = "public interface " + CLASS_NAME + "Service {";
            sb.append(className + "\n");
        }
    }

    /**
     * 生成插入方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private static void generateInsertMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_INSERT && trimedLine.startsWith("int insert(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "插入数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            String method = trimedLine.replace("int insert(", "    JsonRslt insert(")
                                      .replace(CLASS_NAME, VALUE_OBJECT)
                                      .replace("record", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
            sb.append(method + "\n");
        }
    }

    /**
     * 生成删除方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private static void generateDeleteMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.startsWith("int deleteByPrimaryKey(")){
            sb.append("\n");
            paramName = CommonGenerator.getParamName(trimedLine);
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按主键删除数据", paramName);

            String method = trimedLine.replace("int deleteByPrimaryKey(", "    JsonRslt delete(");
            sb.append(method + "\n");
        }
    }

    /**
     * 生成更新方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private static void generateUpdateMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_UPDATE && trimedLine.startsWith("int updateByPrimaryKey(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "修改数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            String method = trimedLine
                    .replace("int updateByPrimaryKey(", "    JsonRslt update(")
                    .replace(CLASS_NAME, VALUE_OBJECT)
                    .replace("record", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));
            sb.append(method + "\n");
        }
    }

    /**
     * 生成查询方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private static void generateSelectMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("selectByPrimaryKey(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按主键查询一条数据", paramName);

            String method = trimedLine.replace(CLASS_NAME, "    JsonRslt")
                                      .replace("selectByPrimaryKey(", "select(");
            sb.append(method + "\n");
        }
    }

    /**
     * 生成搜索方法
     * @param sb
     * @throws Exception
     */
    private static void generateSearchMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_SEARCH){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按条件查询数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            String method = "    JsonRslt search("+VALUE_OBJECT+" "
                    + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +");";
            sb.append(method + "\n");
        }
    }
}
