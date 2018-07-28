package com.gsyun.passbook.utils;

import com.gsyun.passbook.vo.Feedback;
import com.gsyun.passbook.vo.GainPassTemplateRequest;
import com.gsyun.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author gongshiyun
 * @Description RowKey生成器 工具类
 * @date 2018/7/28
 */
@Slf4j
public class RowKeyGenerateUtil {
    /**
     * 根据提供的 PassTemplate 对象生成 RowKey
     *
     * @param passTemplate {@link PassTemplate}
     * @return String RowKey
     */
    public static String generatePassTemplateRowKey(PassTemplate passTemplate) {
        String passInfo = String.valueOf(passTemplate.getId()) + "_" + passTemplate.getTitle();
        String rowKey = DigestUtils.md5Hex(passInfo);

        log.info("GenPassTemplateRowKey: {}, {}", passInfo, rowKey);

        return rowKey;
    }

    /**
     * 根据 Feedback 构造 RowKey
     * 由翻转后的userId和Long最大值与时间戮之差拼合
     * 加入userId:
     *     同一个用户feedback存储在相近的位置是比较好的,便于feedback的扫描操作
     * 1.翻转userId:
     *     由于系统的中的userId前缀与当前系统用户数有关,后面是随机数,将其反转后,数据越随机使feedback数据越分散,将不同用户的数据分散到不用的机器上
     * 2.Long最大值与时间戮之差
     *     越晚创建的评论,差值越小,所以查询出来的反馈结果中最先获取的是创建最晚的,便于分页展示前十条
     *
     * @param feedback {@link Feedback}
     * @return String RowKey
     */
    public static String generateFeedbackRowKey(Feedback feedback) {
        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }

    /**
     * 根据领取的优惠券请求生成RowKey
     * RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     * 越晚添加的优惠券展示的越前
     * @param request {@link GainPassTemplateRequest}
     * @return String RowKey
     */
    public static String generatePassRowKey(GainPassTemplateRequest request) {
        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + generatePassTemplateRowKey(request.getPassTemplate());
    }

}
