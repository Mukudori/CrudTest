package ru.jarsoft.test.service;

import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    List<Category> getAllCategoriesNotDeleted();
    void add(Category category);
    void markDelete(Category category);
    void delete(Category category);
    void edit(Category category);
    Category getById(int id);
    List<Category> findByName(String findName);
}
