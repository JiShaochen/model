package com.model.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Morning JS
 * @date 2021/8/9 14:24
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleInfoVO {
    private String trans;
    private String orig;
    private String backend;
}