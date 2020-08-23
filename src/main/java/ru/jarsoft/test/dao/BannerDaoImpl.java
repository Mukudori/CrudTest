package ru.jarsoft.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;
import ru.jarsoft.test.service.CategoryService;
import ru.jarsoft.test.service.CategoryServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class BannerDaoImpl implements BannerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Banner> allBanners() {

        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Banner").list();
    }

    @Override
    public List<Banner> allBannersNotDeleted() {
        List<Banner> aBanners = new ArrayList<>();
        for (Banner banner : allBanners())
            if (!banner.isDeleted())
                aBanners.add(banner);
        return aBanners;
    }

    @Override
    public void add(Banner banner) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(banner);
    }

    @Override
    public void markDelete(Banner banner) {
        Session session = sessionFactory.getCurrentSession();
        if (banner.isDeleted()) {
            delete(banner);
        }
        else {
            banner.setDeleted(true);
            session.update(banner);
        }
    }

    @Override
    public void delete(Banner banner) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(banner);
    }

    @Override
    public void edit(Banner banner) {
        Session session = sessionFactory.getCurrentSession();
        session.update(banner);
    }

    @Override
    public Banner getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Banner.class, id);
    }



}
