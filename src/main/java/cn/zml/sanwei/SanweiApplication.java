package cn.zml.sanwei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 启动类
 * @author nanbei
 */
@SpringBootApplication
@MapperScan("cn.zml.sanwei.dao")
public class SanweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanweiApplication.class, args);
    }

}

