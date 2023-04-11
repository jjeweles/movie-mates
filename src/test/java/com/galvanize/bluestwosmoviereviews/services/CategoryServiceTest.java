package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.CategoryRepository;
import com.galvanize.bluestwosmoviereviews.models.CategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private CategoryModel category;

    @BeforeEach
    void setUp() {
        category = new CategoryModel();
        category.setCategoryID(1);
        category.setCategory_name("TestCategory");
    }

    @Test
    void findAllCategories() {
        categoryService.findAllCategories();
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void findCategoryByCategoryID() {
        when(categoryRepository.findCategoryByCategoryID(1)).thenReturn(category);
        categoryService.findCategoryByCategoryID(1);
        verify(categoryRepository, times(1)).findCategoryByCategoryID(1);
    }

    @Test
    void addCategory() {
        categoryService.addCategory(category);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void updateCategories() {
        when(categoryRepository.findCategoryByCategoryID(1)).thenReturn(category);
        CategoryModel updatedCategory = new CategoryModel();
        updatedCategory.setCategory_name("UpdatedCategory");
        categoryService.updateCategories(1, updatedCategory);
        verify(categoryRepository, times(1)).findCategoryByCategoryID(1);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void deleteCategoryByCategoryID() {
        when(categoryRepository.findCategoryByCategoryID(1)).thenReturn(category);
        categoryService.deleteCategoryByCategoryID(1);
        verify(categoryRepository, times(1)).findCategoryByCategoryID(1);
        verify(categoryRepository, times(1)).delete(category);
    }

    @Test
    void updateCategory() {
        when(categoryRepository.findCategoryByCategoryID(1)).thenReturn(category);
        CategoryModel updatedCategory = new CategoryModel();
        updatedCategory.setCategory_name("UpdatedCategory");
        categoryService.updateCategory(1, updatedCategory);
        verify(categoryRepository, times(1)).findCategoryByCategoryID(1);
        verify(categoryRepository, times(1)).save(category);
    }
}
