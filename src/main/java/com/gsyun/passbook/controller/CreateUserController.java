package com.gsyun.passbook.controller;

import com.gsyun.passbook.log.LogConstants;
import com.gsyun.passbook.log.LogGenerator;
import com.gsyun.passbook.service.IUserService;
import com.gsyun.passbook.vo.Response;
import com.gsyun.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gongshiyun
 * @Description TODO
 * @date 2018/7/30
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class CreateUserController {

    /**
     * 创建用户服务
     */
    private final IUserService userService;

    /**
     * HttpServletRequest
     */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public CreateUserController(IUserService userService,
                                HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 创建用户
     *
     * @param user {@link User}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/createuser")
    Response createUser(@RequestBody User user) throws Exception {

        LogGenerator.generateLog(
                httpServletRequest,
                -1L,
                LogConstants.ActionName.CREATE_USER,
                user
        );
        return userService.createUser(user);
    }

}
