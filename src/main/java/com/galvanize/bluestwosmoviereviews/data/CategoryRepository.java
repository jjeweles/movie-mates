package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    CategoryModel findCategoryByCategoryID(Integer categoryID);
    void deleteCategoryByCategoryID(Integer categoryID);
}
