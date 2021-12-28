/*
package com.model.common.queue;

import com.model.common.queue.dto.DemoQueueDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

*/
/**
 * @author Morning JS
 * @date 2021/10/11 14:52
 * @desc
 *//*

@Component
public class RedisDelayListener implements CommandLineRunner {


    @Resource
    RedisDelayQueueUtil redissonClient;

    @Override
    public void run(String... args) {
        RedisDelayQueueUtil.RedisDelayQueueHandle<DemoQueueDTO> listener =  new RedisDelayQueueUtil.RedisDelayQueueHandle<DemoQueueDTO>() {
            @Override
            public void execute(DemoQueueDTO stringObjectMap) {
                // do something
                System.out.println("队列执行： " + stringObjectMap.toString());
            }
        };

        redissonClient.getQueue(DemoQueueDTO.class.getName(), listener);
    }
}*/
