package com.model.common.pool;

import com.model.common.utils.json.JsonUtils;
import com.model.entity.dto.account.LoginDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Morning JS
 * @date 2021/8/16 10:33
 * @desc
 */
@Component
public class PoolTest {

   /* private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

    public PoolTest() {
        executor.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + " \t 执行任务中");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + "\t 执行任务结束");
        }, 1, 3, TimeUnit.SECONDS);
    }

    @Bean
    public LoginDTO getJson(){
        System.out.println(11111);
        return new LoginDTO();
    }*/
}