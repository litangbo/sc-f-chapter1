package com.jc.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 *
 * pre：路由之前
 * routing：路由之时
 * post： 路由之后
 * error：发送错误调用
 *
 *
 * filterOrder：过滤的顺序
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 *
 * ---------------------
 *
 * 本文来自 方志朋 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/forezp/article/details/81041012?utm_source=copy
 *
 * 测试地址：
 * http://localhost:8769/api-a/hi?name=ltb
 * http://localhost:8769/api-a/hi?name=ltb&token=22
 */
@Component
public class MyFilter extends ZuulFilter {

    /**
     * slf4j日志
     */
    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体运行逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();// 从ThreadLocal中获取
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(token == null){
            String msg = "token is empty";
            logger.warn(msg);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);// 一般来说该错误消息表明您首先需要登录（输入有效的用户名和密码）
            try {
                ctx.getResponse().getWriter().print(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            logger.info("ok");
        }
        return null;
    }
}
