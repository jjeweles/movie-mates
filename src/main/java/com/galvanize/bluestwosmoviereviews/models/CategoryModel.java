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


    @Column(name = "userID")
    Integer userID;

    @Column(name = "category_name")
    String category_name;

    public CategoryModel(){

    }

    public CategoryModel(Integer categoryID, Integer userID, String category_name) {
        this.categoryID = categoryID;
        this.userID = userID;
        this.category_name = category_name;
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
        return Objects.equals(categoryID, that.categoryID) && Objects.equals(userID, that.userID) && Objects.equals(category_name, that.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, userID, category_name);
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryID=" + categoryID +
                ", userID=" + userID +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
