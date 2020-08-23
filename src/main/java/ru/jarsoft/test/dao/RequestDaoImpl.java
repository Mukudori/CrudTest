package ru.jarsoft.test.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.jarsoft.test.model.Category;
import ru.jarsoft.test.model.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RequestDaoImpl implements RequestDAO{



    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Request> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Request ").list();
    }

    @Override
    public void add(Request request) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(request);
    }


    @Override
    public void delete(Request request) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(request);
    }



    @Override
    public Request getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Request.class, id);
    }
}
