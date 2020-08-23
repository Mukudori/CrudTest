package ru.jarsoft.test.service;

import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;

import java.util.List;

public interface BannerService {
    List<Banner> allBanners();
    List<Banner> allBannersNotDeleted();
    void add(Banner banner);
    void markDelete(Banner banner);
    void delete(Banner banner);
    void edit(Banner banner);
    Banner getById(int id);
    List<Banner> findByName(String findName);

}
