package com.gsyun.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongshiyun
 * @Description 用户类
 * @date 2018/7/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户基本信息
     */
    private BaseInfo baseInfo;

    /**
     * 用户额外信息
     */
    private OtherInfo otherInfo;

    /**
     * 基本信息内部类
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BaseInfo{
        private String name;
        private String age;
        private String sex;
    }

    /**
     * 用户额外信息内部类
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherInfo {
        private String phone;
        private String address;
    }
}
