package com.example.helloworld.datasourece;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	private final static Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);
	
    private static DynamicDataSource instance;
    private static byte[] lock = new byte[0];

    /**
     * 用于存储已实例数据源
     */
    private static Map<Object, Object> dataSourceMap = new HashMap<Object, Object>();

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DynamicDataSourceContextHolder.getDataSourceKey();
//        logger.info("[当前线程的数据源为：{}]", dataSource);
        return dataSource;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();// 必须添加该句，否则新添加数据源无法识别到
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    public static synchronized DynamicDataSource getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DynamicDataSource();
                }
            }
        }
        return instance;
    }

    public static boolean isExistDataSource(String key) {
        return dataSourceMap.containsKey(key);
    }
}
