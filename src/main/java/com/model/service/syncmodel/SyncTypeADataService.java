package com.model.service.syncmodel;

import com.model.service.syncmodel.abstrcat.SyncModelAbstract;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Morning JS
 * @date 2021/4/15 15:09
 * @desc 同步A形状数据
 */
@Service(SyncModelAbstract.TYPE_A)
public class SyncTypeADataService extends SyncModelAbstract {

    @Override
    public void SyncModelData(String json) {
        ThreadPoolExecutor thread = this.getThread();
        Arrays.stream(json.split(".")).forEach(data -> thread.execute(() -> System.out.println(data)));
    }

}