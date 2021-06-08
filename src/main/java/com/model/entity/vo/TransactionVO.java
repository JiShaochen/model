package com.model.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Morning JS
 * @date 2021/6/8 14:45
 * @desc 翻译
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionVO {
    private List<TransactionInfoVO> trans_result;
}