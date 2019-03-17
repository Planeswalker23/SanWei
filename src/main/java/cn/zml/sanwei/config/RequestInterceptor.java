package cn.zml.sanwei.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理跨域访问的拦截器
 * @author fanyidong
 * @date Created in 2018-12-26
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

    /** options请求方式 */
    private static final String OPTIONS = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("X-Powered-By","Jetty");
        String method= request.getMethod();
        log.info("处理跨域访问拦截器");
        if (OPTIONS.equals(method)){
            response.setStatus(200);
            return false;
        }
        return true;
    }
}
