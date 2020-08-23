package ru.jarsoft.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jarsoft.test.dao.CategoryDAO;
import ru.jarsoft.test.dao.CategoryDaoImpl;
import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    @Transactional
    public List<Category> getAllCategoriesNotDeleted() {
        return categoryDAO.getAllCategoriesNotDeleted();
    }

    @Override
    @Transactional
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Override
    @Transactional
    public void markDelete(Category category) {
        categoryDAO.markDelete(category);
    }

    @Override
    @Transactional
    public void delete(Category category) {
        categoryDAO.delete(category);
    }

    @Override
    @Transactional
    public void edit(Category category) {
        categoryDAO.edit(category);
    }

    @Override
    @Transactional
    public Category getById(int id) {
        return categoryDAO.getById(id);
    }


    @Autowired
    public void setCategoryDAO(CategoryDaoImpl categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional
    public List<Category> findByName(String findName){
        List<Category> result  = new ArrayList<>();
        String findLower = findName.toLowerCase();
        for (Category category :  getAllCategories()){
            String categoryName = category.getName().toLowerCase();
            if (categoryName.contains(findLower) || findLower.contains(categoryName))
                result.add(category);
        }

        return result;
    }
}
