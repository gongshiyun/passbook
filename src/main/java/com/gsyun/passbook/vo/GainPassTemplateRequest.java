package com.gsyun.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongshiyun
 * @Description 用户领取优惠券的请求对象
 * @date 2018/7/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 领取的优惠券对象
     */
    private PassTemplate passTemplate;

}
