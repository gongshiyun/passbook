package com.gsyun.passbook.vo;

import com.gsyun.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongshiyun
 * @Description 用户领取的优惠券信息
 * @date 2018/7/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassInfo {

    /**
     * 优惠券
     */
    private Pass pass;

    /**
     * 优惠券模板
     */
    private PassTemplate passTemplate;

    /**
     * 优惠券商户对象
     */
    private Merchants merchants;

}
