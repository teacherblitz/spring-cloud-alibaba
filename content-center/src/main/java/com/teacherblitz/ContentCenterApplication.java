package com.teacherblitz;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 内容中心微服务
 * @author teacherblitz
 * @since  2019/10/19 14:10
 */
@MapperScan("com.teacherblitz.mapper")
@EnableBinding(Source.class)
@EnableFeignClients
@SpringBootApplication
public class ContentCenterApplication {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }
}

