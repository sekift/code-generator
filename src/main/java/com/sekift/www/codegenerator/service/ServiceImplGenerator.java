package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;
import com.sekift.www.tool.ErrorCodeEnum;

import java.io.BufferedReader;
import java.io.File;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/04 14:32
 * @description: 从service类生成serviceImpl类
 */
public class ServiceImplGenerator {
    public static final String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    public static final String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    public static final boolean NEED_NOTE = GeneratorConfig.NEED_NOTE;
    public static final String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    public static final String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "service/";
    public static final String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "service/impl/";
    public static final String FROM_PATH = MODEL_DIR + CLASS_NAME + "Service" + GeneratorConfig.PRO_NAME;
    public static final String WRITE_NAME = "ServiceImpl" + GeneratorConfig.PRO_NAME;
    public static final String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;
    public static final String VALUE_OBJECT = CLASS_NAME + "VO";

    public static void generateServiceImpl() {
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
                    firstLine ++;
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace(".service", ".service.impl"));
                    GeneratorUtil.writeFile(TO_PATH,"");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".dao."+ CLASS_NAME +"Mapper;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".service."+ CLASS_NAME +"Service;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".tool.CommUtils;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".tool.ErrorCodeEnum;");
                    GeneratorUtil.writeFile(TO_PATH,"import " + PACKAGE_NAME + ".tool.LogUtils;");
                    GeneratorUtil.writeFile(TO_PATH,"import org.springframework.beans.factory.annotation.Autowired;");
                    GeneratorUtil.writeFile(TO_PATH,"import org.springframework.stereotype.Service;");
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
                    GeneratorUtil.writeFile(TO_PATH, "@Service");
                    //类名
                    GeneratorUtil.writeFile(TO_PATH, trimedLine.replace("interface", "class")
                            .replace(CLASS_NAME+"Service", CLASS_NAME + "ServiceImpl implements "
                                    + CLASS_NAME+"Service"));
                    GeneratorUtil.writeFile(TO_PATH, "");
                    GeneratorUtil.writeFile(TO_PATH, "    @Autowired");
                    GeneratorUtil.writeFile(TO_PATH, "    private " + CLASS_NAME + "Mapper "+
                            GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Mapper;");
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
                    GeneratorUtil.writeFile(TO_PATH, "    @Override");
                    GeneratorUtil.writeFile(TO_PATH, "    public " + trimedLine.replace(";","{"));
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        try {");
                        GeneratorUtil.writeFile(TO_PATH, "            " +
                                CLASS_NAME + " " + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                                + " = new " + CLASS_NAME +"();");
                        GeneratorUtil.writeFile(TO_PATH, "            CommUtils.copyProperties("
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ", " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "VO);");
                        GeneratorUtil.writeFile(TO_PATH, "            int rows = "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.insert("
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ");");
                        GeneratorUtil.writeFile(TO_PATH, "            if(rows > 0){");
                        GeneratorUtil.writeFile(TO_PATH, "                return JsonRslt.putSuccessMessage(\""+NOTE_DESC+"插入成功\");");
                        GeneratorUtil.writeFile(TO_PATH, "            }");
                        GeneratorUtil.writeFile(TO_PATH, "         } catch (Exception e) {");
                        GeneratorUtil.writeFile(TO_PATH, "                LogUtils.logError(CommUtils.getException(e));");
                        GeneratorUtil.writeFile(TO_PATH, "         }");
                        GeneratorUtil.writeFile(TO_PATH, "         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \""+NOTE_DESC+"插入失败\");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "         return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");
                }

                //delete方法
                if(GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.startsWith("JsonRslt delete(")){
                    GeneratorUtil.writeFile(TO_PATH, "");

                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按主键删除数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + paramName);
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }

                    GeneratorUtil.writeFile(TO_PATH, "    @Override");
                    GeneratorUtil.writeFile(TO_PATH, "    public " + trimedLine.replace(";","{"));
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        try {");
                        GeneratorUtil.writeFile(TO_PATH, "            int rows = "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.deleteByPrimaryKey("
                                + paramName + ");");
                        GeneratorUtil.writeFile(TO_PATH, "            if (rows > 0) {");
                        GeneratorUtil.writeFile(TO_PATH, "                return JsonRslt.putSuccessMessage(\""+NOTE_DESC+"删除成功\");");
                        GeneratorUtil.writeFile(TO_PATH, "            }");
                        GeneratorUtil.writeFile(TO_PATH, "         } catch (Exception e) {");
                        GeneratorUtil.writeFile(TO_PATH, "                LogUtils.logError(CommUtils.getException(e));");
                        GeneratorUtil.writeFile(TO_PATH, "         }");
                        GeneratorUtil.writeFile(TO_PATH, "         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \""+NOTE_DESC+"删除失败\");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "         return null;");
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

                    GeneratorUtil.writeFile(TO_PATH, "    @Override");
                    GeneratorUtil.writeFile(TO_PATH, "    public " + trimedLine.replace(";","{"));
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {


                        GeneratorUtil.writeFile(TO_PATH, "        try {");
                        GeneratorUtil.writeFile(TO_PATH, "            " +
                                CLASS_NAME + " " + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                                + " = new " + CLASS_NAME +"();");
                        GeneratorUtil.writeFile(TO_PATH, "            CommUtils.copyProperties("
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ", " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "VO);");
                        GeneratorUtil.writeFile(TO_PATH, "            int rows = "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.updateByPrimaryKey("
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ");");
                        GeneratorUtil.writeFile(TO_PATH, "            if (rows > 0) {");
                        if(GeneratorConfig.SERVICE_NEED_SELECT) {
                            GeneratorUtil.writeFile(TO_PATH, "                return this.select(" + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                                    + ".get" + GeneratorUtil.firstCharUpperCase(paramName) + "());");
                        }else{
                            GeneratorUtil.writeFile(TO_PATH, "                return JsonRslt.putSuccessMessage(\"" + NOTE_DESC + "修改成功\");");
                        }
                        GeneratorUtil.writeFile(TO_PATH, "            }");
                        GeneratorUtil.writeFile(TO_PATH, "         } catch (Exception e) {");
                        GeneratorUtil.writeFile(TO_PATH, "                LogUtils.logError(CommUtils.getException(e));");
                        GeneratorUtil.writeFile(TO_PATH, "         }");
                        GeneratorUtil.writeFile(TO_PATH, "         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \""+NOTE_DESC+"修改失败\");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "         return null;");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    }");

                }

                //select方法
                if(GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("JsonRslt select(")){
                    GeneratorUtil.writeFile(TO_PATH, "");

                    //方法注释信息
                    if (NEED_NOTE) {
                        GeneratorUtil.writeFile(TO_PATH, "    /**");
                        GeneratorUtil.writeFile(TO_PATH, "     * 按主键查询一条数据");
                        GeneratorUtil.writeFile(TO_PATH, "     * @param " + paramName);
                        GeneratorUtil.writeFile(TO_PATH, "     * @return");
                        GeneratorUtil.writeFile(TO_PATH, "     **/");
                    }
                    GeneratorUtil.writeFile(TO_PATH, "    @Override");
                    GeneratorUtil.writeFile(TO_PATH, "    public " + trimedLine.replace(";","{"));
                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        " + CLASS_NAME + " "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + " = "
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.selectByPrimaryKey("
                                + paramName + ");");
                        GeneratorUtil.writeFile(TO_PATH, "        "
                                + "if (null != " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ") {");
                        GeneratorUtil.writeFile(TO_PATH, "             return JsonRslt.putSuccess("
                                + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+");");
                        GeneratorUtil.writeFile(TO_PATH, "         }");
                        GeneratorUtil.writeFile(TO_PATH, "        "
                                + " return JsonRslt.putSuccessMessage(\""+ paramName +"=\" + " + paramName + " + \"的"
                                + NOTE_DESC + "数据不存在\");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "         return null;");
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
                    GeneratorUtil.writeFile(TO_PATH, "    @Override");
                    GeneratorUtil.writeFile(TO_PATH, "    public JsonRslt search("+VALUE_OBJECT+" "
                            + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){");

                    if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                        GeneratorUtil.writeFile(TO_PATH, "        try {");
                        GeneratorUtil.writeFile(TO_PATH, "             "
                                + CLASS_NAME + "Example example = new " + CLASS_NAME +"Example();");
                        GeneratorUtil.writeFile(TO_PATH, "             "
                                + CLASS_NAME+"Example.Criteria criteria = example.createCriteria();");
                        GeneratorUtil.writeFile(TO_PATH, "             List<"
                                + CLASS_NAME + "> list = " + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                                + "Mapper.selectByExample(example);");
                        GeneratorUtil.writeFile(TO_PATH, "             return JsonRslt.putSuccess(list);");
                        GeneratorUtil.writeFile(TO_PATH, "         } catch (Exception e) {");
                        GeneratorUtil.writeFile(TO_PATH, "                LogUtils.logError(CommUtils.getException(e));");
                        GeneratorUtil.writeFile(TO_PATH, "         }");
                        GeneratorUtil.writeFile(TO_PATH, "         return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \""+NOTE_DESC+"查询失败\");");
                    }else{
                        GeneratorUtil.writeFile(TO_PATH, "         return null;");
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