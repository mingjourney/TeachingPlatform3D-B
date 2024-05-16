package com.gugu.dto;

public class EssaySearchDTO {
    private Integer type;
    private String searchTerm;
    private Integer sortType;
    private Integer pageSize;
    private Integer pageIndex;
    private Integer offset;
    private Integer limit;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "EssaySearchDTO{" +
                "type=" + type +
                ", searchTerm='" + searchTerm + '\'' +
                ", sortType=" + sortType +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}