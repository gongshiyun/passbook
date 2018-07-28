package com.gsyun.passbook.service;

import com.gsyun.passbook.vo.Response;
import com.gsyun.passbook.vo.User;

/**
 * @author gongshiyun
 * @Description 创建用户服务
 * @date 2018/7/28
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    Response createUser(User user) throws Exception;

}
