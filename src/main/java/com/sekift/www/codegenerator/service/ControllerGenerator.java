package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;

import java.io.BufferedReader;

/**
 * @author sekift
 * @date 2020/11/04 16:34
 * @description 从service类生成controller类
 */
public class ControllerGenerator {
    public String CLASS_NAME = GeneratorConfig.CLASS_NAME;
    public String NOTE_DESC = GeneratorConfig.NOTE_DESC;
    public boolean NEED_SWAGGER = GeneratorConfig.CONTROLLER_NEED_SWAGGER;
    public String PACKAGE_NAME = GeneratorConfig.PACKAGE_NAME;
    public String MODEL_DIR = GeneratorConfig.BASE_PKG_DIR + "service/";
    public String TO_DIR = GeneratorConfig.BASE_PKG_DIR + "controller/";
    public String FROM_PATH = MODEL_DIR + CLASS_NAME + "Service" + GeneratorConfig.PRO_NAME;
    public String WRITE_NAME = "Controller" + GeneratorConfig.PRO_NAME;
    public String TO_PATH = TO_DIR + CLASS_NAME + WRITE_NAME;
    public String VALUE_OBJECT = CLASS_NAME + "VO";

    private String paramName = "";
    public void generateController() {
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
                // 生成search方法
                generateSearchMethod(sb, trimedLine);
            }
            sb.append("\n");
            sb.append("}");

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
    private void generatePackageAndImport(StringBuilder sb, String trimedLine) {
        if (trimedLine.startsWith("package " + PACKAGE_NAME)) {
            String packageName = trimedLine.replace(".service", ".controller");
            sb.append(packageName + "\n");
            sb.append("\n");
            sb.append("import " + PACKAGE_NAME + ".service."+ CLASS_NAME +"Service;" + "\n");
            sb.append("import " + PACKAGE_NAME + ".tool.CommUtils;" + "\n");
            sb.append("import org.springframework.beans.factory.annotation.Autowired;" + "\n");
            sb.append("import org.springframework.web.bind.annotation.*;" + "\n");
            if (NEED_SWAGGER) {
                sb.append("\n" + "import io.swagger.annotations.Api;" + "\n");
                sb.append("import io.swagger.annotations.ApiOperation;" + "\n");
            }
            sb.append("\n");
        }
        //原来包的引入
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
        if (trimedLine.startsWith("public interface ")) {
            sb.append("\n");
            //类注释信息
            CommonGenerator.classDescription(sb);

            //引入注解
            sb.append("@RestController" + "\n");
            sb.append("@RequestMapping(\"/api/" + CLASS_NAME.toLowerCase() +"\")" + "\n");
            if(NEED_SWAGGER) {
                sb.append("@Api(tags = {\"" + NOTE_DESC + "\"})" + "\n");
            }
            // 类名
            String className = trimedLine.replace("interface", "class")
                    .replace(CLASS_NAME+"Service", CLASS_NAME + "Controller");
            sb.append(className + "\n");
            sb.append("\n");
            // 注入
            String autowiredClass = "    private final " + CLASS_NAME + "Service "+
                    GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service;";
            sb.append(autowiredClass + "\n");
            sb.append("\n");
            String autowiredConstructor = "    public "+CLASS_NAME + "Controller("
                    + CLASS_NAME + "Service "+ GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service){"
                    + "\n" + "        this."+ GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service = "
                    + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service;" + "\n"
                    + "    }" + "\n";
            sb.append(autowiredConstructor + "\n");
        }
    }

    /**
     * 生成插入方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateInsertMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_INSERT && trimedLine.startsWith("JsonRslt insert(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "插入数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @PostMapping(\"/insert\")" + "\n");
            if(NEED_SWAGGER){
                sb.append("    @ApiOperation(value = \"插入"+NOTE_DESC+"数据(完成)\"," +
                        "notes=\"传入具体内容\",httpMethod = \"POST\",hidden = false)" + "\n");
            }
            sb.append("    public " + trimedLine.replace(";","{")
                    .replace("insert(", "insert(@RequestBody ") + "\n");
            if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                sb.append("        return "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.insert("
                        + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +  ");" + "\n");
            }else{
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }

    /**
     * 生成删除方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateDeleteMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_DELETE && trimedLine.startsWith("JsonRslt delete(")){
            sb.append("\n");
           paramName = CommonGenerator.getParamName(trimedLine);
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按主键删除数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @PostMapping(\"/delete\")" + "\n");
            if(NEED_SWAGGER){
                sb.append("    @ApiOperation(value = \"删除"+NOTE_DESC+"数据(完成)\"," +
                        "notes=\"传入对象的唯一键即可\",httpMethod = \"POST\",hidden = false)" + "\n");
            }
            sb.append("    public JsonRslt delete(@RequestBody "
                    + VALUE_OBJECT + " " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){"  + "\n");
            if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                sb.append("        return "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.delete("
                        + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                        + GeneratorUtil.firstCharUpperCase(paramName) + "());" + "\n");
            }else{
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }

    /**
     * 生成更新方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateUpdateMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_UPDATE && trimedLine.startsWith("JsonRslt update(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "修改数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @PostMapping(\"/update\")" + "\n");
            if(NEED_SWAGGER){
                sb.append("    @ApiOperation(value = \"更新"+NOTE_DESC+"数据(完成)\"," +
                        "notes=\"修改的数据与原来不改的数据需一起上传\",httpMethod = \"POST\",hidden = false)" + "\n");
            }
            sb.append("    public " + trimedLine.replace(";","{")
                    .replace("update(", "update(@RequestBody ") + "\n");
            if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL) {
                sb.append("        return "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.update("
                        + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +  ");" + "\n");
            }else{
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");

        }
    }

    /**
     * 生成查询方法
     * @param sb
     * @param trimedLine
     * @throws Exception
     */
    private void generateSelectMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_SELECT && trimedLine.contains("JsonRslt select(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按主键查询一条数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @PostMapping(\"/select\")" + "\n");
            if(NEED_SWAGGER){
                sb.append("    @ApiOperation(value = \"按键查询"+NOTE_DESC+"数据(完成)\"," +
                        "notes=\"传入对象的唯一键即可\",httpMethod = \"POST\",hidden = false)" + "\n");
            }
            sb.append("    public JsonRslt select(@RequestBody "
                    + VALUE_OBJECT + " " + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){" + "\n");
            if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                sb.append("        return "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.select("
                        + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) + ".get"
                        + GeneratorUtil.firstCharUpperCase(paramName) + "());" + "\n");
            }else{
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }

    /**
     * 生成搜索方法
     * @param sb
     * @throws Exception
     */
    private void generateSearchMethod(StringBuilder sb, String trimedLine) throws Exception{
        if(GeneratorConfig.SERVICE_NEED_SEARCH  && trimedLine.contains("JsonRslt search(")){
            sb.append("\n");
            //方法注释信息
            CommonGenerator.methodDescription(sb, "按条件查询数据", GeneratorUtil.firstCharLowerCase(VALUE_OBJECT));

            sb.append("    @PostMapping(\"/search\")" + "\n");
            if(NEED_SWAGGER){
                sb.append("    @ApiOperation(value = \"按条件查询"+NOTE_DESC+"数据(完成)\"," +
                        "notes=\"传入你想过滤的字段条件\",httpMethod = \"POST\",hidden = false)" + "\n");
            }
            sb.append("    public JsonRslt search(@RequestBody "+VALUE_OBJECT+" "
                    + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +"){" + "\n");

            if(GeneratorConfig.SERVICE_IMPL_NEED_IMPL){
                sb.append("        return "
                        + GeneratorUtil.firstCharLowerCase(CLASS_NAME)+ "Service.search("
                        + GeneratorUtil.firstCharLowerCase(VALUE_OBJECT) +  ");" + "\n");
            }else{
                sb.append("        return null;" + "\n");
            }
            sb.append("    }" + "\n");
        }
    }
}