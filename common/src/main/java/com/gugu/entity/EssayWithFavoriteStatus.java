package com.gugu.entity;

public class EssayWithFavoriteStatus {
    private Essay essay;
    private boolean favorite;

    public Essay getEssay() {
        return essay;
    }

    public void setEssay(Essay essay) {
        this.essay = essay;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
