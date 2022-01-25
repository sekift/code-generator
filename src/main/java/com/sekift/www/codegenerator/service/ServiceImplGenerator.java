package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author sekift
 * @date 2020/11/04 14:32
 * @description 从service类生成serviceImpl类
 */
public class ServiceImplGenerator {
    public String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    public String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    public String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    public String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "service/";
    public String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "service/impl/";
    public String FROM_PATH = MODEL_DIR + CLASS_NAME + "Service" + GeneratorConfig.PRO_NAME;
    public String WRITE_NAME = "ServiceImpl" + GeneratorConfig.PRO_NAME;
    public String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;
    public String VALUE_OBJECT = CLASS_NAME + "VO";

    private String paramName = "";

    public void generateServiceImpl() {
        String line, trimedLine;
        StringBuilder sb = new StringBuilder();
        try {
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
                // 生成search方法
                generateSearchMethod(sb, trimedLine);
            }
            sb.append("\n");
            sb.append("}");

            GeneratorUtil.writeFile(TO_PATH, sb.toString());
            System.out.println(CLASS_NAME + WRITE_NAME + " 生成成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(CLASS_NAME + WRITE_NAME + " 生成失败");
        }
    }

    /**
     * 生成包名和引入包
     *
     * @param sb
     * @param trimedLine
     */
    private void generatePackageAndImport(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("package " + PACKAGE_NAME)) {
            String packageName = trimedLine.replace(".service", ".service.impl");
            sb.append(packageName + "\n");
            sb.append("\n");
            sb.append("import " + PACKAGE_NAME + ".dao." + CLASS_NAME + "Mapper;" + "\n");
            sb.append("import " + PACKAGE_NAME + ".service." + CLASS_NAME + "Service;" + "\n");
            sb.append("import " + PACKAGE_NAME + ".tool.CommUtils;" + "\n");
            sb.append("import " + PACKAGE_NAME + ".tool.ErrorCodeEnum;" + "\n");
            sb.append("import lombok.extern.slf4j.Slf4j;" + "\n");
            // 是否需要引入PageHelper
            if (GeneratorConfig.VO_NEED_PAGE) {
                sb.append("import com.github.pagehelper.PageHelper;" + "\n");
                sb.append("import com.github.pagehelper.PageInfo;" + "\n");
            }
            sb.append("import org.springframework.beans.factory.annotation.Autowired;" + "\n");
            sb.append("import org.springframework.stereotype.Service;" + "\n");
            sb.append("\n");
        }
        // 引入原来的包
        if (trimedLine.startsWith("import ")) {
            sb.append(trimedLine + "\n");
        }
    }

    /**
     * 生成注释和类名
     *
     * @param sb
     * @param trimedLine
     */
    private void generateDocAndClassName(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("public interface ")) {
            sb.append("\n");
            //类注释信息
            CommonGenerator.classDescription(sb);

            //引入注解

            sb.append("@Slf4j" + "\n");
            sb.append("@Service" + "\n");
            //类名
            String className = trimedLine.replace("interface", "class")
                    .replace(CLASS_NAME + "Service", CLASS_NAME + "ServiceImpl implements "
                            + CLASS_NAME + "Service");
            sb.append(className + "\n");
            sb.append("\n");
            // 注入
            String autowiredClass = "    private final " + CLASS_NAME + "Mapper " +
                    GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper;";
            sb.append(autowiredClass + "\n");
            sb.append("\n");
            String autowiredConstructor = "    public " + CLASS_NAME + "ServiceImpl("
                    + CLASS_NAME + "Mapper " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper){"
                    + "\n" + "        this." + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper = "
                    + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper;" + "\n"
                    + "    }" + "\n";
            sb.append(autowiredConstructor + "\n");
        }
    }

    /**
     * 生成插入方法
     *
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateInsertMethod(StringBuilder sb, String trimedLine) throws Exception {
        if (GeneratorConfig.SERVICE_NEED_INSERT && trimedLine.startsWith("JsonRslt insert(")) {
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "插入数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @Override" + "\n");
            sb.append("    public " + trimedLine.replace(";", "{") + "\n");
            if (GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                sb.append("        try {" + "\n");
                sb.append("            " +
                        CLASS_NAME + " " + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                        + " = new " + CLASS_NAME + "();" + "\n");
                sb.append("            CommUtils.copyProperties("
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ", " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "VO);" + "\n");
                sb.append("            int rows = "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.insert("
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ");" + "\n");
                sb.append("            if(rows > 0){" + "\n");
                sb.append("                return JsonRslt.putSuccessMessage(\"插入" + NOTE_DESC + "成功\");" + "\n");
                sb.append("            }" + "\n");
                sb.append("        } catch (Exception e) {" + "\n");
                sb.append("            log.error(\"插入" + NOTE_DESC + "出错，\",e);" + "\n");
                sb.append("        }" + "\n");
                sb.append("        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \"" + NOTE_DESC + "插入失败\");" + "\n");
            } else {
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }

    /**
     * 生成删除方法
     *
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateDeleteMethod(StringBuilder sb, String trimedLine) throws Exception {
        if (GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.startsWith("JsonRslt delete(")) {
            sb.append("\n");
            paramName = CommonGenerator.getParamName(trimedLine);
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按主键删除数据", paramName);

            sb.append("    @Override" + "\n");
            sb.append("    public " + trimedLine.replace(";", "{") + "\n");
            if (GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                sb.append("        try {" + "\n");
                sb.append("            int rows = "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.deleteByPrimaryKey("
                        + paramName + ");" + "\n");
                sb.append("            if (rows > 0) {" + "\n");
                sb.append("                return JsonRslt.putSuccessMessage(\"删除" + NOTE_DESC + "成功\");" + "\n");
                sb.append("            }" + "\n");
                sb.append("        } catch (Exception e) {" + "\n");
                sb.append("            log.error(\"删除" + NOTE_DESC + "出错，\",e);" + "\n");
                sb.append("        }" + "\n");
                sb.append("        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \"删除" + NOTE_DESC + "失败\");" + "\n");
            } else {
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }

    }

    /**
     * 生成更新方法
     *
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateUpdateMethod(StringBuilder sb, String trimedLine) throws Exception {
        if (GeneratorConfig.SERVICE_NEED_UPDATE && trimedLine.startsWith("JsonRslt update(")) {
            sb.append("\n");

            if (StringUtils.isEmpty(paramName)) {
                paramName = CommonGenerator.getParamName(trimedLine);
            }
            //方法注释信息
            CommonGenerator.methodDescription(sb, "修改数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @Override" + "\n");
            sb.append("    public " + trimedLine.replace(";", "{") + "\n");
            if (GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                sb.append("        try {" + "\n");
                sb.append("            " +
                        CLASS_NAME + " " + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                        + " = new " + CLASS_NAME + "();" + "\n");
                sb.append("            CommUtils.copyProperties("
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ", " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "VO);" + "\n");
                sb.append("            int rows = "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.updateByPrimaryKeySelective("
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ");" + "\n");
                sb.append("            if (rows > 0) {" + "\n");
                if (GeneratorConfig.SERVICE_NEED_SELECT) {
                    sb.append("                return this.select(" + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                            + ".get" + GeneratorUtil.firstCharUpperCase(paramName) + "());" + "\n");
                } else {
                    sb.append("                return JsonRslt.putSuccessMessage(\"修改" + NOTE_DESC + "成功\");" + "\n");
                }
                sb.append("            }" + "\n");
                sb.append("        } catch (Exception e) {" + "\n");
                sb.append("            log.error(\"修改" + NOTE_DESC + "出错，\",e);" + "\n");
                sb.append("        }" + "\n");
                sb.append("        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \"修改" + NOTE_DESC + "失败\");" + "\n");
            } else {
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");

        }
    }

    /**
     * 生成查询方法
     *
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateSelectMethod(StringBuilder sb, String trimedLine) throws Exception {
        if (GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("JsonRslt select(")) {
            sb.append("\n");

            if (StringUtils.isEmpty(paramName)) {
                paramName = CommonGenerator.getParamName(trimedLine);
            }
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按主键查询一条数据", paramName);

            sb.append("    @Override" + "\n");
            sb.append("    public " + trimedLine.replace(";", "{") + "\n");
            if (GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                sb.append("        " + CLASS_NAME + " "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + " = "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + "Mapper.selectByPrimaryKey("
                        + paramName + ");" + "\n");
                sb.append("        "
                        + "if (null != " + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ") {" + "\n");
                sb.append("             return JsonRslt.putSuccess("
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME) + ");" + "\n");
                sb.append("         }" + "\n");
                sb.append("        "
                        + " return JsonRslt.putSuccessMessage(\"" + paramName + "=\" + " + paramName + " + \"的"
                        + NOTE_DESC + "数据不存在\");" + "\n");
            } else {
                sb.append("         return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }

    /**
     * 生成搜索方法，自带分页
     *
     * @param sb
     * @throws Exception
     */
    private void generateSearchMethod(StringBuilder sb, String trimedLine) throws Exception {
        if (GeneratorConfig.SERVICE_NEED_SEARCH && trimedLine.contains("JsonRslt search(")) {
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按条件查询数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @Override" + "\n");
            sb.append("    public JsonRslt search(" + VALUE_OBJECT + " "
                    + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + "){" + "\n");

            if (GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                sb.append("        try {" + "\n");
                if (GeneratorConfig.VO_NEED_PAGE) {
                    sb.append("             PageHelper.startPage(" + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT)
                            + ".getPage(), " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".getRows());" + "\n");
                }
                sb.append("             "
                        + CLASS_NAME + "Example example = new " + CLASS_NAME + "Example();" + "\n");
                sb.append("             "
                        + CLASS_NAME + "Example.Criteria criteria = example.createCriteria();" + "\n");
                // 添加查询条件
                if (GeneratorConfig.SERIVCE_IMPL_SEARCH_CONDITION) {
                    this.generateSearchCondition(sb);
                }

                sb.append("             List<"
                        + CLASS_NAME + "> list = " + GeneratorUtil.firstCharLowerCase(CLASS_NAME)
                        + "Mapper.selectByExample(example);" + "\n");
                if (GeneratorConfig.VO_NEED_PAGE) {
                    sb.append("             return JsonRslt.putSuccess(new PageInfo<>(list));" + "\n");
                } else {
                    sb.append("             return JsonRslt.putSuccess(list);" + "\n");
                }
                sb.append("        } catch (Exception e) {" + "\n");
                sb.append("            log.error(\"查询" + NOTE_DESC + "出错，\",e);" + "\n");
                sb.append("        }" + "\n");
                sb.append("        return JsonRslt.putErrorCode(ErrorCodeEnum.SERVICE_ERROR_C0300.getCode(), \"查询" + NOTE_DESC + "失败\");" + "\n");
            } else {
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }

    /**
     * 生成搜索条件
     * 暂时参与的类型为：Integer、Long、Byte、String
     *
     * @param sb 入参
     */
    private void generateSearchCondition(StringBuilder sb) {
        try {
            Class<?> clazz = Class.forName(GeneratorConfig.PACKAGE_NAME + ".model." + GeneratorConfig.CLASS_NAME);
            for (Field field : clazz.getDeclaredFields()) {
                // Integer
                if (Objects.equals(field.getType().getName(), "java.lang.Byte") ||
                        Objects.equals(field.getType().getName(), "java.lang.Integer") ||
                        Objects.equals(field.getType().getName(), "java.lang.Long")) {

                    sb.append("             if (" + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                            + GeneratorUtil.firstCharUpperCase(field.getName()) + "() != null) {" + "\n");
                    sb.append("                 criteria.and" + GeneratorUtil.firstCharUpperCase(field.getName())
                            + "EqualTo(" + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                            + GeneratorUtil.firstCharUpperCase(field.getName()) + "());" + "\n");
                    sb.append("             }" + "\n");
                }

                // String
                if (Objects.equals(field.getType().getName(), "java.lang.String")) {
                    sb.append("             if (" + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                            + GeneratorUtil.firstCharUpperCase(field.getName()) + "() != null) {" + "\n");
                    sb.append("                 criteria.and" + GeneratorUtil.firstCharUpperCase(field.getName())
                            + "Like(\"%\" + " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                            + GeneratorUtil.firstCharUpperCase(field.getName()) + "() + \"%\");" + "\n");
                    sb.append("             }" + "\n");
                }
            }
            sb.append("             example.setOrderByClause(\" id asc \");" + "\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}