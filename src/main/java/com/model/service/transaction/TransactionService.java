package com.model.service.transaction;

import com.model.entity.dto.transaction.TransactionDTO;

/**
 * @author Morning JS
 * @date 2021/6/4 15:58
 * @desc 翻译
 */
public interface TransactionService {
    void transaction(TransactionDTO transactionDTO) throws Exception;
}