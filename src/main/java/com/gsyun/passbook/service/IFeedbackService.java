package com.gsyun.passbook.service;

import com.gsyun.passbook.vo.Feedback;
import com.gsyun.passbook.vo.Response;

/**
 * @author gongshiyun
 * @Description 评论功能接口
 * @date 2018/7/28
 */
public interface IFeedbackService {

    /**
     * 创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    Response createFeedback(Feedback feedback);

    /**
     * 获取用户评论
     * @param userId 用户id
     * @return {@link Response}
     */
    Response getFeedback(Long userId);
}
