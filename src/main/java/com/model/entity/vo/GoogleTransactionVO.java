package com.model.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Morning JS
 * @date 2021/8/9 14:23
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleTransactionVO {
    private List<GoogleInfoVO> sentences;
}