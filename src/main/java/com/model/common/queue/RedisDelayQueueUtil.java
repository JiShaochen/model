/*
package com.model.common.queue;

import org.redisson.api.RBlockingDeque;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

*/
/**
 * 封装 Redis 延迟队列工具
 * <p>
 * Created by michael on 2021-04-25.
 *//*

@Component
public class RedisDelayQueueUtil {

    @Resource
    private RedissonClient redissonClient;

    public interface RedisDelayQueueHandle<T> {
        void execute(T t);
    }

    */
/**
     * 添加延迟队列
     *
     * @param t
     * @param delay
     * @param timeUnit
     * @param <T>
     *//*

    public <T> void addDelayQueue(T t, long delay, TimeUnit timeUnit) {
        try {
            RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(t.getClass().getName());
            RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
            delayedQueue.offer(t, delay, timeUnit);
            System.out.println("添加延时队列成功，队列键："+t.getClass().getName()+"，队列值："+t+"，延迟时间：" + timeUnit.toSeconds(delay));
        } catch (Exception e) {
            throw new RuntimeException("添加延时队列失败");
        }
    }

    public <T> void getQueue(String name, RedisDelayQueueHandle<T> taskEventListener) {
        RBlockingQueue<T> blockingQueue = redissonClient.getBlockingQueue(name);
        ((Runnable) () -> {
            while (true) {
                try {
                    T t = blockingQueue.take();
                    taskEventListener.execute(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }
}
*/
