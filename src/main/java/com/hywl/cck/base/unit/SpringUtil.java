package com.hywl.cck.base.unit;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * 
 * 调用service的工具类
 * 
 * @author YZW
 * 
 */
@Component
public final class SpringUtil {

	public static <T> T getBean(String beanName) {
		// 获取当前运行环境下Spring上下文
		WebApplicationContext webApp = ContextLoader
				.getCurrentWebApplicationContext();
		return (T) webApp.getBean(beanName);
	}

}
