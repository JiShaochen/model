package com.model.service.syncmodel;

import com.model.service.syncmodel.abstrcat.SyncModelAbstract;
import org.springframework.stereotype.Service;

/**
 * @author Morning JS
 * @date 2021/4/15 15:09
 * @desc 同步B形状数据
 */
@Service(SyncModelAbstract.TYPE_B)
public class SyncTypeBDataService extends SyncModelAbstract {

    @Override
    public void SyncModelData(String json) {

    }
}