package com.ivo.qqreader.bookStack.category.response;

import java.util.List;

public class BookCategoryResponse1 extends BookCategoryResponse{

    private List<Category> boyCategoryList;
    private List<Category> girlCategoryList;

    public List<Category> getBoyCategoryList() {
        return boyCategoryList;
    }

    public void setBoyCategoryList(List<Category> boyCategoryList) {
        this.boyCategoryList = boyCategoryList;
    }

    public List<Category> getGirlCategoryList() {
        return girlCategoryList;
    }

    public void setGirlCategoryList(List<Category> girlCategoryList) {
        this.girlCategoryList = girlCategoryList;
    }
}
