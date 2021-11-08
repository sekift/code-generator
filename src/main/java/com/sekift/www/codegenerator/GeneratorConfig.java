package com.sekift.www.codegenerator;

/**
 * @author sekift
 * @date 2020/11/04 9:08
 * @description 代码生成常量
 */
public class GeneratorConfig {
    //传入类名或表名，表注释描述
    public GeneratorConfig(String className, String noteDesc){
        CLASS_NAME = className;
        NOTE_DESC = noteDesc;

        init();
    }

    // 配置文件常量
    public static String DATABASE_NAME = "coupon"; //数据库名
    public static String CLASS_NAME = ""; // 类名
    public static String NOTE_DESC = ""; //注释描述

    public static final String PACKAGE_NAME = "com.sekift.www"; //需要生成代码的包名
    public static final String SUBJECT_NAME = ""; //项目名称，如果user.dir已包含则留空，code-generator
    public static final boolean NEED_NOTE = true; //是否需要注释
    public static final boolean VO_NEED_SWAGGER = true; //vo是否需要swagger信息
    public static final boolean VO_NEED_PAGE = false; //vo是否需要分页的page和rows
    public static final boolean SERVICE_NEED_INSERT = true; //sevice生成需要哪些方法
    public static final boolean SERVICE_NEED_DELETE = true; //
    public static final boolean SERVICE_NEED_UPDATE = true; //
    public static final boolean SERVICE_NEED_SELECT = true; //
    public static final boolean SERVICE_NEED_SEARCH = true; //
    public static final boolean SERVICE_IMPL_NEED_IMPL = true; //是否需要实现方法
    public static final boolean CONTROLLER_NEED_SWAGGER = true; //controller是否需要swagger信息

    public static final boolean NEED_APPEND = false; //如果写入的文件已经存在，如果需要继续写入则设为true，但是代码会出错(慎重)。

    //如果是数据库表名，有_的，则先转换为驼峰
    private void init() {
        if(CLASS_NAME.contains("_")){
            CLASS_NAME = GeneratorUtil.lineToHump(CLASS_NAME);
        }
    }

    //包位于maven中的路径
    public static final  String PACKAGE_PATH = "src/main/java/";
    //resources文件位于maven中的路径
    public static final  String RESOURCES_PATH = "src/main/resources/";
    //项目在电脑上的路径
    public static final String SUBJECT_DIR = System.getProperty("user.dir");
    //注释的作者
    public static final String NOTE_AUTHOR = System.getenv().get("USERNAME");

    //package的路径
    public static final  String BASE_PKG_DIR = GeneratorConfig.SUBJECT_DIR + GeneratorConfig.SUBJECT_NAME +"/"
            + GeneratorConfig.PACKAGE_PATH + GeneratorUtil.packageToPath(PACKAGE_NAME+ "/");

    //package的路径
    public static final  String BASE_RES_DIR = GeneratorConfig.SUBJECT_DIR + GeneratorConfig.SUBJECT_NAME +"/"
            + GeneratorConfig.RESOURCES_PATH + "/";

    //文件后缀
    public static final String PRO_NAME = ".java";

}
