package com.gsyun.passbook.service;

import com.gsyun.passbook.vo.GainPassTemplateRequest;
import com.gsyun.passbook.vo.Response;

/**
 * @author gongshiyun
 * @Description 用户领取优惠券功能接口
 * @date 2018/7/28
 */
public interface IGainPassTemplateService {

    /**
     * 用户领取优惠券
     * @param request
     * @return
     * @throws Exception
     */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;

}
