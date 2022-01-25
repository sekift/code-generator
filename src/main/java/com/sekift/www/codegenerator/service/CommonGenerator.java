package com.sekift.www.codegenerator.service;

import com.sekift.www.codegenerator.GeneratorConfig;
import com.sekift.www.codegenerator.GeneratorUtil;

/**
 * @author sekift
 * @date 2020/11/04 16:34
 * @description 代码生成辅助类
 */
public class CommonGenerator {

    /**
     * 取主键的名称，例如id或者code
     *
     * @param trimedLine
     * @return
     */
    public static String getParamName(String trimedLine) {
        //获取括号中的内容
        String strSub = trimedLine.split("\\(")[1].replace(");", "");
        return strSub.split(" ")[1];
    }

    /**
     * 类注释信息
     *
     * @param sb
     */
    public static void classDescription(StringBuilder sb) {
        if (GeneratorConfig.NEED_NOTE) {
            sb.append("/**" + "\n");
            sb.append(" * @author ").append(GeneratorConfig.NOTE_AUTHOR).append("\n");
            sb.append(" * @date ").append(GeneratorUtil.getStringDate()).append("\n");
            sb.append(" * @description ").append(GeneratorConfig.NOTE_DESC).append("\n");
            sb.append(" **/" + "\n");
        }
    }

    /**
     * 方法注释信息
     *
     * @param sb
     */
    public static void methodDescription(StringBuilder sb, String desc, String paramName) {
        if (GeneratorConfig.NEED_NOTE) {
            sb.append("    /**" + "\n");
            sb.append("     * ").append(desc).append("\n");
            sb.append("     * ").append("\n");
            sb.append("     * @param ").append(paramName).append(" 入参").append("\n");
            sb.append("     * @return JSON" + "\n");
            sb.append("     **/" + "\n");
        }
    }
}
