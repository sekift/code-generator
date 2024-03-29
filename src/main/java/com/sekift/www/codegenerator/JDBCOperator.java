package com.sekift.www.codegenerator;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sekift
 * @date 2020/11/05 15:34
 * @description 从数据库中拿出表的建表语句
 */
public class JDBCOperator {

    public static final String DATABASE_NAME = GeneratorConfig.DATABASE_NAME; // 数据库名
    public static final String CLASS_NAME = GeneratorConfig.CLASS_NAME; // 类名
    public static void main(String[] args) {
//        System.out.println(queryTableMetadata());
        System.out.println(printTableNames());
    }

    /**
     * 从application拿jdbc的连接信息，连接到mysql数据库，然后查询表，得到建表语句
     *
     * @return
     */
    public static List<Map<String, Object>> queryTableMetadata() {
        Connection connection = jdbcConnection();
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            list = printColumnInfo(databaseMetaData);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(connection, null, null);
        }
        return null;
    }

    /**
     * 输出表名和注解，url链接需要加上&amp;useInformationSchema=true
     */
    public static List<Map<String, String>> printTableNames() {
        Connection connection = jdbcConnection();
        List<Map<String, String>> list = new ArrayList<>();
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            //获取表名的结果集
            ResultSet rs = databaseMetaData.getTables(DATABASE_NAME, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                Map<String, String> map = new HashMap<>(4);
                map.put("tableName", rs.getString("TABLE_NAME"));
                map.put("remark", rs.getString("REMARKS"));
                list.add(map);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(connection, null, null);
        }
        return null;
    }

    //输出列名、类型、注释
    private static List<Map<String, Object>> printColumnInfo(DatabaseMetaData databaseMetaData)throws Exception{
        ResultSet rs = databaseMetaData.getColumns(null, "%",
                GeneratorUtil.humpToLine(CLASS_NAME), "%");
        List<Map<String, Object>> list = new ArrayList<>();
        while(rs.next()){
            Map<String, Object> map = new HashMap<>(10);
            //去掉横杠
            String columnName = rs.getString("COLUMN_NAME").replace("_", "");
            //大写转小写
            columnName = columnName.toLowerCase();
            map.put("columnName", columnName);//列名
            map.put("typeName", rs.getString("TYPE_NAME"));//类型
            map.put("columnSize", rs.getInt("COLUMN_SIZE"));//字段的长度
            map.put("decimalDigits", rs.getInt("DECIMAL_DIGITS"));//小数部分的位数
            map.put("nullable", rs.getInt("NULLABLE"));//是否可null，1就表示可以是Null,而0就表示Not Null
            map.put("remark", rs.getString("REMARKS"));//说明
            list.add(map);
        }
        return list;
    }

    //输出表名
    private static void printTableNames(DatabaseMetaData databaseMetaData)throws Exception{
        //获取表名的结果集
        ResultSet rs = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
        while(rs.next()){
            String tableName = rs.getString("TABLE_NAME");
            System.out.println(tableName);
        }
    }

    private static Connection jdbcConnection() {
        Map<String, String> map = readXmlFile();
        Connection connection = null;
        try {
            String driver = map.get("driver");
            String url = map.get("url");
            String user = map.get("username");
            String password = map.get("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if(resultSet!=null) {
                resultSet.close();
            }
            if (preparedStatement!=null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Map<String, String> readXmlFile() {
        // 从generatorConfig.xml文件进行读取
        try {
            String fileName = GeneratorConfig.BASE_RES_DIR + "generatorConfig.xml";
            Document document = useDomReadXml(fileName);
            Node node = document.selectNodes("//jdbcConnection").get(0);
            Map<String, String> map = new HashMap<String, String>(4);
            map.put("driver", node.valueOf("@driverClass"));
            map.put("url", node.valueOf("@connectionURL"));
            map.put("username", node.valueOf("@userId"));
            map.put("password", node.valueOf("@password"));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Document useDomReadXml(String soucePath) {
        try {
            File file = new File(soucePath);
            if (!file.exists()) {
                throw new Exception("文件：" + soucePath + "不存在，请检查你的配置！");
            }
            SAXReader read = new SAXReader();
            return read.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
