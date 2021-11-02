package com.model.common.queue.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Morning JS
 * @date 2021/10/11 17:47
 * @desc demo
 */
@Data
public class DemoQueueDTO implements Serializable {
    private static final long serialVersionUID = -8165015867536157603L;
    private Long id;
    private String name;
}