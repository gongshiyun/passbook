package com.gsyun.passbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试程序入口
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PassbookApplicationTests {

    @Test
    public void contextLoads() {
    }

}
