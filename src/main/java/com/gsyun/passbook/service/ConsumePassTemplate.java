package com.gsyun.passbook.service;

import com.alibaba.fastjson.JSON;
import com.gsyun.passbook.constant.Constants;
import com.gsyun.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author gongshiyun
 * @Description 消费Kafka中的PassTemplate
 * @date 2018/7/28
 */
@Slf4j
@Component
public class ConsumePassTemplate {

    private final IHBasePassService hBasePassService;

    @Autowired
    public ConsumePassTemplate(IHBasePassService hBasePassService) {
        this.hBasePassService = hBasePassService;
    }

    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})
    public void receive(@Payload String passTemplate,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Consumer Receive PassTemplate: {}", passTemplate);

        PassTemplate pt;
        try {
            pt = JSON.parseObject(passTemplate,PassTemplate.class);
        } catch (Exception e) {
            log.error("Parse PassTemplate Error: {}", e.getMessage());
            return;
        }

        log.info("DropPassTemplateToHBase: {}", hBasePassService.dropPassTemplateToHBase(pt));
    }
}
