package org.digitalcity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/22
 */
@MapperScan(basePackages = {"org.digitalcity.dao"})
@SpringBootApplication(scanBasePackages = {"org.digitalcity"})
@EnableCaching
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
    }
}
