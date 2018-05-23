package com.hywl.cck.base.unit.ehcache;

import com.hywl.cck.base.unit.SpringUtil;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheUtils {
	public static final String GENERAL_CACHE_ADMINISTRATOR_BEAN_NAME = "cacheManager";

	/**
	 * 根据Key读取缓存
	 * 
	 * @return 缓存对象
	 */
	public static Object getFromCache(String cacheName, String key) {
		CacheManager manage = SpringUtil
				.getBean(GENERAL_CACHE_ADMINISTRATOR_BEAN_NAME);
		
		Element e = manage.getCache(cacheName).get(key);

		if (e == null)
			return null;

		return e.getObjectValue();
	}

	/**
	 * 加入或刷新对象到缓存
	 * 
	 */
	public static void putInCache(String cacheName, String key, Object object) {
		CacheManager manage = SpringUtil
				.getBean(GENERAL_CACHE_ADMINISTRATOR_BEAN_NAME);
		
		manage.getCache(cacheName).put(new Element(key, object));
	}

	/**
	 * 删除缓存
	 * 
	 */
	public static void delInCache(String cacheName, String key) {
		CacheManager manage = SpringUtil
				.getBean(GENERAL_CACHE_ADMINISTRATOR_BEAN_NAME);
		manage.getCache(cacheName).remove(key);
	}

}
