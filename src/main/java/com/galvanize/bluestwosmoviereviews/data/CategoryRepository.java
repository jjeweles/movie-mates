package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.CategoryModel;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {


    CategoryModel findCategoryByCategoryID(Integer categoryID);
    CategoryModel save(CategoryModel category);
    void deleteCategoryByCategoryID(Integer categoryID);
}
