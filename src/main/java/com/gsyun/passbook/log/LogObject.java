package com.gsyun.passbook.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongshiyun
 * @Description 日志类
 * @date 2018/7/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogObject {

    /**
     * 日志动作类型
     */
    private String action;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 当前时间戮
     */
    private Long timestamp;

    /**
     * 客户端ip地址
     */
    private String remoteIp;

    /**
     * 日志信息
     */
    private Object info = null;
}
