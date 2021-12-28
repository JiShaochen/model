package com.model.controller.model;

import com.model.service.model.ModelService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Morning JS
 * @date 2021/12/28 16:04
 * @desc
 */
@Component
public class Job {

    @Resource
    ModelService modelService;

    @Scheduled(cron = "0 0 10 * * ? ")
//    @Scheduled(cron = "* * * * * ? *")
    public void execute() {
        modelService.sendMail();
//        System.out.println(111);
    }

}