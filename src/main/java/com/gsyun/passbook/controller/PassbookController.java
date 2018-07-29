package com.gsyun.passbook.controller;

import com.gsyun.passbook.log.LogConstants;
import com.gsyun.passbook.log.LogGenerator;
import com.gsyun.passbook.service.IFeedbackService;
import com.gsyun.passbook.service.IGainPassTemplateService;
import com.gsyun.passbook.service.IInventoryService;
import com.gsyun.passbook.service.IUserPassService;
import com.gsyun.passbook.vo.Feedback;
import com.gsyun.passbook.vo.GainPassTemplateRequest;
import com.gsyun.passbook.vo.Pass;
import com.gsyun.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gongshiyun
 * @Description Passbook Rest Controller
 * @date 2018/7/30
 */
@RestController
@Slf4j
@RequestMapping("/passbook")
public class PassbookController {

    /**
     * 用户优惠券服务
     */
    private final IUserPassService userPassService;

    /**
     * 优惠券库存服务
     */
    private final IInventoryService inventoryService;

    /**
     * 领取优惠券服务
     */
    private final IGainPassTemplateService gainPassTemplateService;

    /**
     * 反馈服务
     */
    private final IFeedbackService feedbackService;

    /**
     * HttpServletRequest
     */
    private HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService, IInventoryService inventoryService, IGainPassTemplateService gainPassTemplateService, IFeedbackService feedbackService) {
        this.userPassService = userPassService;
        this.inventoryService = inventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackService = feedbackService;
    }

    /**
     * 获取用户个人优惠券信息
     *
     * @param userId 用户id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userPassInfo")
    Response userPassInfo(Long userId) throws Exception {

        LogGenerator.generateLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_PASS_INFO,
                null
        );

        return userPassService.getUserPassInfo(userId);
    }

    /**
     * 获取用户使用了的个人优惠券信息
     *
     * @param userId 用户id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userUsedPassInfo")
    Response userUsedPassInfo(Long userId) throws Exception {

        LogGenerator.generateLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_USED_PASS_INFO,
                null
        );

        return userPassService.getUserUsedPassInfo(userId);
    }

    /**
     * 用户使用优惠券
     *
     * @param pass {@link Pass}
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("userUsePass")
    Response userUsePass(@RequestBody Pass pass) throws Exception {
        LogGenerator.generateLog(
                httpServletRequest,
                pass.getUserId(),
                LogConstants.ActionName.USER_USE_PASS,
                pass
        );
        return userPassService.userUsedPass(pass);
    }

    /**
     * 获取库存信息
     *
     * @param userId 用户 id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/inventoryInfo")
    Response inventoryInfo(Long userId) throws Exception {

        LogGenerator.generateLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.INVENTORY_INFO,
                null
        );

        return inventoryService.getInventoryInfo(userId);
    }

    /**
     * 用户领取优惠券
     *
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/gainPassTemplate")
    Response gainPassTemplate(@RequestBody GainPassTemplateRequest request)
            throws Exception {

        LogGenerator.generateLog(
                httpServletRequest,
                request.getUserId(),
                LogConstants.ActionName.GAIN_PASS_TEMPLATE,
                request
        );
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
     * 用户创建评论
     *
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/createFeedback")
    Response createFeedback(@RequestBody Feedback feedback) {

        LogGenerator.generateLog(
                httpServletRequest,
                feedback.getUserId(),
                LogConstants.ActionName.CREATE_FEEDBACK,
                feedback
        );
        return feedbackService.createFeedback(feedback);
    }

    /**
     * 用户获取评论信息
     *
     * @param userId 用户 id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/getFeedback")
    Response getFeedback(Long userId) {

        LogGenerator.generateLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.GET_FEEDBACK,
                null
        );

        return feedbackService.getFeedback(userId);
    }

    /**
     * 异常演示接口
     *
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception {
        throw new Exception("Welcome To PassBook");
    }

}
