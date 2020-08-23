package ru.jarsoft.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jarsoft.test.dao.BannerDAO;
import ru.jarsoft.test.dao.BannerDaoImpl;
import ru.jarsoft.test.model.Banner;


import java.util.ArrayList;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDAO bannerDAO = new BannerDaoImpl();


    @Override
    @Transactional
    public List<Banner> allBanners() {
        return bannerDAO.allBanners();
    }

    @Override
    @Transactional
    public List<Banner> allBannersNotDeleted() {
        return bannerDAO.allBannersNotDeleted();
    }

    @Override
    @Transactional
    public void add(Banner banner) {
        bannerDAO.add(banner);
    }

    @Override
    @Transactional
    public void markDelete(Banner banner) {
        bannerDAO.markDelete(banner);
    }

    @Override
    @Transactional
    public void delete(Banner banner) {
        bannerDAO.delete(banner);
    }

    @Override
    @Transactional
    public void edit(Banner banner) {
        bannerDAO.edit(banner);
    }

    @Override
    @Transactional
    public Banner getById(int id) {
        return bannerDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Banner> findByName(String findName){
        List<Banner> result  = new ArrayList<>();
        List<Banner> all = allBanners();
        String findLower = findName.toLowerCase();
        for (Banner banner :  all){
            String bannerName = banner.getName().toLowerCase(); 
            if (bannerName.contains(findLower) || findLower.contains(bannerName)) {
                result.add(banner);
            }
        }

        return result;
    }

}
