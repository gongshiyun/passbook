package com.gsyun.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gongshiyun
 * @Description 库存请求响应VO
 * @date 2018/7/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 优惠券模板信息
     */
    private List<PassTemplateInfo> passTemplateInfos;

}
