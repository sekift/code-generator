package com.sekift.www.util;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sekift
 * @date 2020/10/30 16:00
 * @description MyBatis工具类，主要处理与数据库的交互
 */
public class MyBatisUtil {
	private static SqlSession sqlSession;

	//事务回滚
	public static void rollback(){
		sqlSession.rollback();
	}

	//事务提交
	public static void commit(){
		sqlSession.commit();
	}

	public static <T> T getMapper(Class<T> t, String... resources) {
		if (sqlSession == null) {
			sqlSession = getSqlSessionFactory(resources).openSession();
		}
		return sqlSession.getMapper(t);
	}

	@Bean(name = "mysql-dataSource")
	public static DataSource dataSource(){
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
		String username="root";
		String password="123456";
		DataSource dataSource = new PooledDataSource(driver,url,username,password);
		return dataSource;
	}

	@Bean(name = "mysql-jdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("mysql-dataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	public static SqlSessionFactory getSqlSessionFactory(String... resources) {


		//创建事务
		/*
		 * <transactionManager type="JDBC" />
		 */
		TransactionFactory transactionFactory = new JdbcTransactionFactory();

		Environment environment = new Environment("development", transactionFactory, dataSource());// /configuration/environments/environment

		Configuration configuration = new Configuration(environment);// configuration

		//TODO 如果是mapper/*.xml，则重新赋值resources，把mapper.xml全部加载进来
		String[] resourcesNew = reInitResources(resources);
		System.out.println("resources length: " + resourcesNew.length);

		//加入资源
		/*
		 * <mapper resource="xxx/***.xml"/>
		 */
		//configuration.addMapper(BaseIndustryClassMapper.class); // 可能XML和类路径完全自一致时可用？
		for (String resource : resourcesNew) {
			ErrorContext.instance().resource(resource);
			try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
				XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
				mapperParser.parse();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 配置pageHelper拦截器，否则单元测试分页无效
		Properties prop = new Properties();
		prop.setProperty("helperDialect", "postgresql");
		prop.setProperty("reasonable", "false");
		prop.setProperty("supportMethodsArguments", "true");
		prop.setProperty("params", "count=countSql");
		PageInterceptor pageInterceptor = new PageInterceptor();
		pageInterceptor.setProperties(prop);
		configuration.addInterceptor(pageInterceptor);

		return new SqlSessionFactoryBuilder().build(configuration);
	}

	/**
	 * 重新初始化resources（如果以/* 或者 /*.xml结尾的话）
	 * @param resources
	 * @return
	 */
	private static String[] reInitResources(String[] resources){
		//如果以*.xml结尾 或者 * 结尾，则把mapper全部加载进来
		if(resources != null && resources.length == 1){
			if(resources[0].startsWith("mapper/")
					&& (resources[0].endsWith("*.xml") || resources[0].endsWith("*"))){
				try {
					File dir = Resources.getResourceAsFile("mapper");
					if (dir.isDirectory()) {
						String[] mapperNameArr = dir.list();
						return addPrefixIfNeeded(mapperNameArr);
					}
				} catch (Exception e){
					System.out.println("获取所有mapper出错！");
					e.printStackTrace();
				}
			}
		}

		return resources;
	}

	private static String[] addPrefixIfNeeded(String[] mapperNameArr){
		String[] mapperArrNew = new String[mapperNameArr.length];
		for(int i = 0; i < mapperNameArr.length; i++){
			String mapperName = mapperNameArr[i];
			if(!mapperName.startsWith("mapper/")){
				mapperName = "mapper/" + mapperName;
			}
			mapperArrNew[i] = mapperName;
		}
		return mapperArrNew;
	}

	public static void main(String[] args) {
		String[] resources = {"mapper/*.xml"};
		String[] fileNameArr = reInitResources(resources);
		for(String fileName : fileNameArr) {
			System.out.println(fileName);
		}
	}
}
