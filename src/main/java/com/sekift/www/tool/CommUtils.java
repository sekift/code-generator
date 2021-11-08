package com.sekift.www.tool;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author sekift
 * @date 2020/10/20 11:15
 * @description 通用工具类
 */
public class CommUtils {

    /**
     * 描 述：[A] 把两个类间相同属性的值从源类复制到目的类
     *
     * @param dest   目的类
     * @param source 源类
     * @throws Exception
     **/
    public static void copyProperties(Object dest, Object source) throws Exception {
        try {
            PropertyUtils.copyProperties(dest, source);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 将异常转为明显的string输出
     * @param e
     * @return
     */
    public static String getException(Exception e){
        StackTraceElement[] ste = e.getStackTrace();
        StringBuffer sb = new StringBuffer();
        sb.append(e.getMessage() + "\r\n");
        for (int i = 0; i < ste.length; i++) {
            sb.append("\t"+ste[i].toString() + "\r\n");
        }
        return sb.toString();
    }
}
