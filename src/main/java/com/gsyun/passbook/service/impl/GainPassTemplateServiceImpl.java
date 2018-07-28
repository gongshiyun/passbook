package com.gsyun.passbook.service.impl;

import com.gsyun.passbook.service.IGainPassTemplateService;
import com.gsyun.passbook.vo.GainPassTemplateRequest;
import com.gsyun.passbook.vo.Response;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gongshiyun
 * @Description 用户领取优惠券功能实现 TODO
 * @date 2018/7/28
 */
@Slf4j
@Service
public class GainPassTemplateServiceImpl implements IGainPassTemplateService {

    /**
     * hbase客户端
     */
    private HbaseTemplate hbaseTemplate;

    @Autowired
    public GainPassTemplateServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public Response gainPassTemplate(GainPassTemplateRequest request) throws Exception {
        return null;
    }
}
