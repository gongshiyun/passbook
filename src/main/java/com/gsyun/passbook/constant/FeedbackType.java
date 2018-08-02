package com.gsyun.passbook.constant;

public enum FeedbackType {
    PASS("pass", "针对优惠券的评论"),
    APP("app", "针对卡包App的评论");

    /**
     * 评论类型编码
     */
    private String code;

    /**
     * 评论类型描述
     */
    private String desc;

    FeedbackType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
