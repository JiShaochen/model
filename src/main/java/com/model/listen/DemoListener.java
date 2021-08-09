package com.model.listen;

import com.model.entity.dto.account.LoginDTO;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Morning JS
 * @date 2021/7/2 13:49
 * @desc
 */
@Component
@Async
public class DemoListener {


    @EventListener
    public void de(LoginDTO loginDTO){
        try {
            System.out.println("log start...");
            Thread.sleep(3000L);
            System.out.println("log end....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

}