package com.model.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Morning JS
 * @date 2021/12/28 15:40
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private Integer id;
    private String name;
    private String message;
    private String title;
    private String mail;
    private Integer sendStatus;
}