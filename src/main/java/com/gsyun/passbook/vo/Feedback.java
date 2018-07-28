package com.gsyun.passbook.vo;

import com.google.common.base.Enums;
import com.gsyun.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongshiyun
 * @Description 用户评论类
 * @date 2018/7/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 评论类型
     */
    private String type;

    /**
     * PassTemplate RowKey ，如果是app类型的评论，则没有
     */
    private String templateId;

    /**
     * 评论内容
     */
    private String comment;

    public boolean validate(){
        FeedbackType feedbackType = Enums.getIfPresent(
            FeedbackType.class,this.type.toUpperCase()
        ).orNull();

        return !(null == feedbackType || null == comment);
    }
}
