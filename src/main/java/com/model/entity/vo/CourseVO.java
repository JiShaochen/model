package com.model.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.model.common.config.BigDecimalSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Morning JS
 * @date 2020/12/7 17:07
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO {
    private String cId;
    private String cName;
    private String tId;
    @JsonSerialize(using = BigDecimalSerialize.class)
    private BigDecimal money;
}