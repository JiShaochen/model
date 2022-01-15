package com.model.controller.model;

import com.model.common.queue.dto.DemoQueueDTO;
import com.model.common.user.UserThreadLocalDTO;
import com.model.common.utils.apiresult.AbstractApiResult;
import com.model.common.utils.exception.ExceptionManager;
import com.model.common.utils.page.PageParam;
import com.model.entity.model.Account;
import com.model.entity.vo.CourseVO;
import com.model.service.model.ModelService;
import com.model.service.syncmodel.abstrcat.SyncModelAbstract;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Morning JS
 * @date 2020/12/7 16:46
 * @desc 模板controller
 */
@Api(value = "/model", tags = "模板模块")
@RestController
@RequestMapping(value = "/model")
public class ModelController {

    @Resource
    ModelService modelService;

    @GetMapping(value = "/mail")
    @ApiOperation(value = "发邮件")
    public AbstractApiResult mail() {
        modelService.sendMail();
        return AbstractApiResult.success();
    }

}