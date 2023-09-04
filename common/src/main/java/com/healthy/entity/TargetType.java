package com.healthy.entity;

import java.io.Serializable;

/**
 * (TTargettype)实体类
 *
 * @author makejava
 * @since 2023-05-01 10:38:23
 */
public class TargetType implements Serializable {
    private static final long serialVersionUID = -89023250628892791L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 类型
     */
    private String targetType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

}

