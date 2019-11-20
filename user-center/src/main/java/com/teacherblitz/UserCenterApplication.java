package com.teacherblitz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author teacherblitz
 * @version v1.0
 * @description
 * @date 2019/9/25 20:51
 */
@MapperScan("com.teacherblitz.mapper")
@EnableBinding(Sink.class)
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
