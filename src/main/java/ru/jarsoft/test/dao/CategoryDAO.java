package ru.jarsoft.test.dao;

import ru.jarsoft.test.model.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();
    List<Category> getAllCategoriesNotDeleted();
    void add(Category category);
    void markDelete(Category category);
    void delete(Category category);
    void edit(Category category);
    Category getById(int id);

}
