package com.gsyun.passbook.service;

import com.gsyun.passbook.vo.Response;

/**
 * @author gongshiyun
 * @Description 获取库存信息: 只返回用户没有领取的
 * 优惠券库存功能实现接口定义
 * @date 2018/7/28
 */
public interface IInventoryService {

    /**
     * 获取库存信息
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    Response getInventoryInfo(Long userId) throws Exception;

}
