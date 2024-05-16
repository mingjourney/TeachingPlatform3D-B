package com.gugu.entity;

import java.io.Serializable;

/**
 * (HealthCategory)实体类
 *
 * @author makejava
 * @since 2023-05-03 09:00:58
 */
public class HealthCategory implements Serializable {
    private static final long serialVersionUID = 350087270237055582L;
    
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 英文名
     */
    private String key;
    /**
     * 图片
     */
    private String cover;
    /**
     * 面试
     */
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

