package com.model.service.syncmodel.abstrcat;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Morning JS
 * @date 2021/4/15 15:07
 * @desc 包装多个service
 */
public abstract class SyncModelAbstract {
    public static final String TYPE_A = "SyncTypeADataService";
    public static final String TYPE_B = "SyncTypeBDataService";

    public abstract void SyncModelData(String json);

    // 此处可以加入一些两个service公用的一些方法，或者一些静态变量等等

    public ThreadPoolExecutor getThread() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        return threadPoolExecutor;
    }

}