package com.sh.monitor;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com.sh.monitor.mapper")
public class MonitorApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(MonitorApplication.class, args);
    }
}
