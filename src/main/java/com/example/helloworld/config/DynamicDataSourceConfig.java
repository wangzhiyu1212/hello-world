//package com.example.helloworld.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import com.example.helloworld.datasourece.DynamicDataSource;
//import com.zaxxer.hikari.HikariDataSource;
//
////@Configuration
//public class DynamicDataSourceConfig {
//
//	private final static Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);
//
//	static final String prefix = "spring.datasource.";
//	static final String druidPrefix = prefix + "druid.";
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public DynamicDataSource dynamicDataSource() {
//		DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
//		String[] dbUrlArray = env.getProperty(prefix + "url").split(",");
//		Map<Object, Object> map = createDataSource(dbUrlArray);
//		dynamicDataSource.setTargetDataSources(map);
//		// 设置默认数据源
//		dynamicDataSource.setDefaultTargetDataSource(getDefaultDataSource(map, getDbName(dbUrlArray[0])));
//		return dynamicDataSource;
//	}
//
//	private Map<Object, Object> createDataSource(String[] dbUrlArray) {
//		Map<Object, Object> map = new HashMap<>();
//		String driverClassName = env.getProperty(prefix + "driver-class-name");
//		String username = env.getProperty(prefix + "username");
//		String password = env.getProperty(prefix + "password");
////		String type = env.getProperty(prefix + "type");
////		int initialSize = Integer.valueOf(env.getProperty(druidPrefix +"initial-size"));
////		int minIdle = Integer.valueOf(env.getProperty(druidPrefix + "min-idle"));
////		int maxActive = Integer.valueOf(env.getProperty(druidPrefix + "max-active"));
////		int maxWait = Integer.valueOf(env.getProperty(druidPrefix + "max-wait"));
//		for (String url : dbUrlArray) {
////			DruidDataSource dataSource = new DruidDataSource();
////			dataSource.setUrl(url);
////			dataSource.setUsername(username);
////			dataSource.setPassword(password);
////			dataSource.setDriverClassName(driverClassName);
//			DataSourceBuilder<HikariDataSource> dataSourceBuilder = (DataSourceBuilder<HikariDataSource>) DataSourceBuilder.create();
//			dataSourceBuilder.driverClassName(driverClassName);
//			dataSourceBuilder.url(url);
//			dataSourceBuilder.username(username);
//			dataSourceBuilder.password(password);
////			dataSource.setDbType(type);
////			dataSource.setInitialSize(initialSize);
////			dataSource.setMaxActive(maxActive);
////			dataSource.setMaxWait(maxWait);
////			dataSource.setMinIdle(minIdle);
//			map.put(getDbName(url), dataSourceBuilder.build());
//		}
//		return map;
//	}
//
//	private Object getDefaultDataSource(Map<Object, Object> map, String dbName) {
//		return map.get(dbName);
//	}
//
//	private String getDbName(String url) {
//		String[] one = url.split("\\?");
//		String[] two = one[0].split("\\/");
//		int length = two.length;
//		return two[length - 1];
//	}
//}
