package com.model.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Morning JS
 * @date 2021/6/8 14:45
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInfoVO {
    private String src;
    private String dst;
}