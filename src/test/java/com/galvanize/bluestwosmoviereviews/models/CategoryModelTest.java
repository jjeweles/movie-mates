package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CategoryModelTest {

    private CategoryModel category1;
    private CategoryModel category2;

    @BeforeEach
    void setUp() {
        category1 = new CategoryModel(1, 1, "Category 1");
        category2 = new CategoryModel(2, 2, "Category 2");
    }

    @Test
    void getCategoryID() {
        assertEquals(1, category1.getCategoryID());
        assertEquals(2, category2.getCategoryID());
    }

    @Test
    void setCategoryID() {
        category1.setCategoryID(3);
        category2.setCategoryID(4);
        assertEquals(3, category1.getCategoryID());
        assertEquals(4, category2.getCategoryID());
    }

    @Test
    void getUserID() {
        assertEquals(1, category1.getUserID());
        assertEquals(2, category2.getUserID());
    }

    @Test
    void setUserID() {
        category1.setUserID(3);
        category2.setUserID(4);
        assertEquals(3, category1.getUserID());
        assertEquals(4, category2.getUserID());
    }

    @Test
    void getCategory_name() {
        assertEquals("Category 1", category1.getCategory_name());
        assertEquals("Category 2", category2.getCategory_name());
    }

    @Test
    void setCategory_name() {
        category1.setCategory_name("New Category 1");
        category2.setCategory_name("New Category 2");
        assertEquals("New Category 1", category1.getCategory_name());
        assertEquals("New Category 2", category2.getCategory_name());
    }

    @Test
    void testEquals() {
        CategoryModel category1Copy = new CategoryModel(1, 1, "Category 1");
        assertEquals(category1, category1Copy);
        assertNotEquals(category1, category2);
    }

    @Test
    void testHashCode() {
        CategoryModel category1Copy = new CategoryModel(1, 1, "Category 1");
        assertEquals(category1.hashCode(), category1Copy.hashCode());
        assertNotEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    void testToString() {
        String expected1 = "CategoryModel{categoryID=1, userID=1, category_name='Category 1'}";
        String expected2 = "CategoryModel{categoryID=2, userID=2, category_name='Category 2'}";
        assertEquals(expected1, category1.toString());
        assertEquals(expected2, category2.toString());
    }
}
