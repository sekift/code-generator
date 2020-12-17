package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;

public class CommonGenerator {

    /**
     * 取主键的名称，例如id或者code
     * @param trimedLine
     * @return
     */
    public static String getParamName(String trimedLine){
        //获取括号中的内容
        String strSub = trimedLine.split("\\(")[1].replace(");", "");
        return strSub.split(" ")[1];
    }

    /**
     * 类注释信息
     * @param sb
     * @return
     */
    public static void classDescription(StringBuilder sb) {
        if (GeneratorConfig.NEED_NOTE) {
            sb.append("/**" + "\n");
            sb.append(" * @author: " + GeneratorConfig.NOTE_AUTHOR + "\n");
            sb.append(" * @date: " + GeneratorUtil.getStringDate() + "\n");
            sb.append(" * @description: " + GeneratorConfig.NOTE_DESC + "\n");
            sb.append(" **/" + "\n");
        }
    }

    /**
     * 方法注释信息
     * @param sb
     * @return
     */
    public static void methodDescription(StringBuilder sb, String desc, String paramName) {
        if (GeneratorConfig.NEED_NOTE) {
            sb.append("    /**" + "\n");
            sb.append("     * " + desc + "\n");
            sb.append("     * @param " + paramName + "\n");
            sb.append("     * @return" + "\n");
            sb.append("     **/" + "\n");
        }
    }
}
