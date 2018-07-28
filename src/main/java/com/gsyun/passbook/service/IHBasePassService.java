package com.gsyun.passbook.service;

import com.gsyun.passbook.vo.PassTemplate;

/**
 * @author gongshiyun
 * @Description Pass HBase 服务接口
 * @date 2018/7/28
 */
public interface IHBasePassService {

    /**
     * 将PassTemplate写入HBase
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
