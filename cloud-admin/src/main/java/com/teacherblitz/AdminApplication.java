package com.teacherblitz;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot admin
 * @author teacherblitz
 * @since 2019/12/15
 */
@MapperScan("com.teacherblitz.mapper")
@EnableAdminServer
@SpringBootApplication
public class AdminApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AdminApplication.class, args);
    }
}
