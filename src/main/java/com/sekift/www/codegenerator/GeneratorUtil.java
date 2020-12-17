package com.sekift.www.codegenerator;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/02 18:04
 * @description: 代码生成工具类
 */
public class GeneratorUtil {

    /**
     * 读文件
     * @return
     * @throws Exception
     */
    public static BufferedReader readFile(String fromPath)throws Exception{
        File file = new File(fromPath);
        if(!file.exists()){
            throw new Exception("文件：" + fromPath + "不存在，请检查你的配置！");
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader;
    }

    /**
     * 第一条写的时候判断是否文件已存在，如果存在则不做操作，避免搞错
     * 可以使用NEED_APPEND参数进行控制是否判断
     * @throws Exception
     */
    public static void isAppendFile(String toPath) throws Exception {
        boolean flag = new File(toPath).exists() && !GeneratorConfig.NEED_APPEND;
        if (flag) {
            throw new Exception("写入的文件：" + toPath + "已存在，请保存原文件并删除后再生成。" +
                    "或者将GeneratorConfig的NEED_APPEND参数设置为true跳过此限制。");
        }
    }

    /**
     * 写文件
     * @param line
     * @throws Exception
     */
    public static void writeFile(String toPath, String line)throws Exception{
        FileUtils.writeStringToFile(new File(toPath), line, Charset.forName("UTF-8"), true);
    }

    /**
     * 包名到路径的转换
     * @return
     */
    public static String packageToPath(String packageName){
        return packageName.replace(".","/");
    }

    /**
     * 日期格式化
     * @return
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 第一个字母小写转大写
     * @param str
     * @return
     */
    public static String firstCharUpperCase(String str){
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 第一个字母大写转小写
     * @param str
     * @return
     */
    public static String firstCharLowerCase(String str){
        char[] ch = str.toCharArray();
        if (ch[0] >= 'A' && ch[0] <= 'Z') {
            ch[0] = (char) (ch[0] + 32);
        }
        return new String(ch);
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    /** 下划线转驼峰 */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        // 第一个小写字母也要转为大写
        String s = firstCharUpperCase(sb.toString());
        return s;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    /** 驼峰转下划线,效率比上面高 */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        //第一个_不需要
        String s = sb.toString();
        if(s.startsWith("_")){
            s = s.substring(1);
        }
        return s;
    }
}
