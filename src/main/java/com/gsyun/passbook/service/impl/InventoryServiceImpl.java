package com.gsyun.passbook.service.impl;

import com.gsyun.passbook.service.IInventoryService;
import com.gsyun.passbook.vo.Response;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gongshiyun
 * @Description 优惠券库存功能实现 TODO
 * @date 2018/7/28
 */
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {

    /**
     * hbase客户端
     */
    private HbaseTemplate hbaseTemplate;

    @Autowired
    public InventoryServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public Response getInventoryInfo(Long userId) throws Exception {
        return null;
    }
}
