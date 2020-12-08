package com.model.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JiShaochen
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
}