package com.gugu.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * (TEssay)实体类
 *
 * @author makejava
 * @since 2023-05-07 15:01:00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Essay implements Serializable {
    private static final long serialVersionUID = -33146110290178877L;
    
    private Integer id;
    
    private Integer essayType;
    
    private String title;
    
    private String description;
    
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEssayType() {
        return essayType;
    }

    public void setEssayType(Integer essayType) {
        this.essayType = essayType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

