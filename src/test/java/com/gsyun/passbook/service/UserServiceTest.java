package com.gsyun.passbook.service;

import com.alibaba.fastjson.JSON;
import com.gsyun.passbook.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gongshiyun
 * @Description 用户服务测试
 * @date 2018/7/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setBaseInfo(
                new User.BaseInfo("gsyun",19,"m")
        );
        user.setOtherInfo(
                new User.OtherInfo("1134","广州市天河区")
        );
        System.out.println(JSON.toJSONString(userService.createUser(user)));
    }
}
