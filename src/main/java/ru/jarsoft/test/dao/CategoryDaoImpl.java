package ru.jarsoft.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;
import ru.jarsoft.test.model.Request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CategoryDaoImpl implements CategoryDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public List<Category> getAllCategories() {

        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Category ").list();

    }

    @Override
    public List<Category> getAllCategoriesNotDeleted() {
        List<Category> aCategories = new ArrayList<>();
        for (Category category : getAllCategories())
            if (!category.isDeleted())
                aCategories.add(category);
        return aCategories;
    }

    @Override
    public void add(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
    }

    @Override
    public void markDelete(Category category) {
        Session session = sessionFactory.getCurrentSession();
        if (category.isDeleted()) {
            delete(category);
        }
        else {
            category.setDeleted(true);
            session.update(category);
        }
    }

    @Override
    public void delete(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }

    @Override
    public void edit(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public Category getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }
}
