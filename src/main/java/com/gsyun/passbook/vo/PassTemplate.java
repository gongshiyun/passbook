package com.gsyun.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author gongshiyun
 * @Description 投放的优惠券类
 * @date 2018/7/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassTemplate {

    /**
     * 商户id
     */
    private Integer id;

    /**
     * 优惠券标题
     */
    private String title;

    /**
     * 优惠券摘要
     */
    private String summary;

    /**
     * 优惠券详细信息
     */
    private String desc;

    /**
     * 最大个数限制
     */
    private Long limit;

    /**
     * 背景颜色
     */
    private Integer background;

    /**
     * 开始时间
     */
    private Date start;

    /**
     * 结束时间
     */
    private Date end;
}
