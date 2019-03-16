package cn.zml.sanwei.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static cn.zml.sanwei.common.Constant.SYSTEM_ERROR;

/**
 * 全局异常处理
 * @author fanyidong
 * @date Created in 2018-12-18
 */
@RestControllerAdvice
public class SanweiAdvice {

    private static Logger log = LoggerFactory.getLogger(SanweiAdvice.class);

    /**
     * 拦截捕捉异常 Exception.class
     * @param e 所有异常
     * @return java.lang.String
     */
    @ExceptionHandler(value = Exception.class)
    public SanWeiRes monitorErrorHandler(Exception e) {
        if (e instanceof SanweiException) {
            log.error(e.getClass() + e.getMessage());
            return SanWeiRes.failed(e.getMessage());
        } else {
            log.error(e.getMessage(), e);
            return SanWeiRes.failed(SYSTEM_ERROR);
        }
    }

}
