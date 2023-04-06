package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.CategoryRepository;
import com.galvanize.bluestwosmoviereviews.data.ReplyRepository;
import com.galvanize.bluestwosmoviereviews.models.CategoryModel;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoryModel> findAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryModel findCategoryByCategoryID(Integer categoryID){
        return categoryRepository.findCategoryByCategoryID(categoryID);
    }

    public CategoryModel addCategory(CategoryModel reply){
        return categoryRepository.save(reply);
    }

    public CategoryModel updateCategories(Integer categoryID, CategoryModel reply){
        CategoryModel categoryToUpdate = categoryRepository.findCategoryByCategoryID(categoryID);

        if(categoryToUpdate != null){
            categoryToUpdate.setCategory_name(reply.getCategory_name());
        }

        assert categoryToUpdate != null;
        return categoryRepository.save(categoryToUpdate);
    }

    public CategoryModel deleteCategoryByCategoryID (Integer categoryID){
        CategoryModel categoryToDelete = categoryRepository.findCategoryByCategoryID(categoryID);
        if (categoryToDelete != null){
            categoryRepository.delete(categoryToDelete);
        }
        return categoryToDelete;
    }

    public CategoryModel updateCategory(Integer categoryID, CategoryModel category){
        CategoryModel categoryToUpdate = categoryRepository.findCategoryByCategoryID(categoryID);

        if(categoryToUpdate != null){
            categoryToUpdate.setCategory_name(category.getCategory_name());
        }

        assert categoryToUpdate != null;
        return categoryRepository.save(categoryToUpdate);
    }


}
