package com.hywl.cck.base.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * 过滤器
 *
 */
public class PathFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 获取项目路径
        String path = httpServletRequest.getRequestURI().replace(
                httpServletRequest.getServletPath(), "");
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;
        // 路径添加到session
        ((HttpServletRequest) request).getSession().setAttribute("path", basePath);
        filterChain.doFilter(request, response);
        // spring mvc拦截器和过滤器的区别
        /**
         springmvc过滤器和拦截器的区别：
         （1）拦截器是基于Java的反射机制的，而过滤器是基于函数回调。
         （2）拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
         （3）拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
         （4）拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
         （5）在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
         （6）拦截器可以获取IOC容器中的各个bean，而过滤器就不行。
         */
    }

    public void destroy() {

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }
}

