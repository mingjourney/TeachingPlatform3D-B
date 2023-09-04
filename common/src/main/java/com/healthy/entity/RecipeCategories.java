package com.healthy.entity;

import java.io.Serializable;

/**
 * (TRecipeCategories)实体类
 *
 * @author makejava
 * @since 2023-05-06 21:38:21
 */
public class RecipeCategories implements Serializable {
    private static final long serialVersionUID = 294253405853316722L;
    
    private Integer id;
    
    private String title;
    
    private String word;
    
    private String cover;
    
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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

