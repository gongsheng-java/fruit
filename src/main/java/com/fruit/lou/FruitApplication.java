package com.fruit.lou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-02-29 16:17
 */
@MapperScan({"com.fruit.lou.dao.mapper"})
@SpringBootApplication(scanBasePackages = {"com.fruit.lou"})
@EnableCaching
@EnableScheduling
public class FruitApplication {
    public static void main(String[] args) {
        SpringApplication.run(FruitApplication.class, args);
    }
}
