package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

@Entity
@Table (name = "categories")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    Integer categoryID;


    @JoinColumn(name = "userID")
    UserModel userModel;

    @Column(name = "category_name")
    String category_name;

    public CategoryModel(){

    }

    public CategoryModel(Integer categoryID, UserModel userModel, String category_name) {
        this.categoryID = categoryID;
        this.userModel = userModel;
        this.category_name = category_name;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return Objects.equals(categoryID, that.categoryID) && Objects.equals(userModel, that.userModel) && Objects.equals(category_name, that.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, userModel, category_name);
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryID=" + categoryID +
                ", userModel=" + userModel +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
