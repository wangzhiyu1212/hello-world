package com.example.helloworld.datasourece;

import org.springframework.stereotype.Component;

/**
 * 
 *  @Description: 通过ThreadLocal获取当前线程的数据源
 *
 *	@author mike.wang
 *
 *  @date 2019年12月29日
 */

@Component
public class DynamicDataSourceContextHolder {

	/**
	 * 	线程私有
	 */
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	/**
	 * 
	 * @Title: setDataSourceKey
	 * @Description: 添加当前线程数据源
	 * @param @param key
	 * @return void
	 * @throws
	 */
	public static synchronized void setDataSourceKey(String key) {
        contextHolder.set(key);
    }
	
	/**
	 * 
	 * @Title: getDataSourceKey
	 * @Description: 获取当前线程数据源
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getDataSourceKey() {
        return contextHolder.get();
    }
	
	/**
	 * 
	 * @Title: clearDataSourceKey
	 * @Description: 清除当前线程数据源
	 * @param 
	 * @return void
	 * @throws
	 */
	public static void clearDataSourceKey() {
        contextHolder.remove();
    }
}
