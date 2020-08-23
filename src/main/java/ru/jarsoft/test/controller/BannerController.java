package ru.jarsoft.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;
import ru.jarsoft.test.model.Request;
import ru.jarsoft.test.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BannerController {
    @Autowired
    private BannerService bannerService = new BannerServiceImpl();
    @Autowired
    private CategoryService categoryService = new CategoryServiceImpl();
    @Autowired
    private RequestService requestService = new RequestServiceImpl();

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView allBannersNotDeleted(){
        List<Banner> banners = bannerService.allBannersNotDeleted();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("banners");
        modelAndView.addObject("bannersList", banners);
        modelAndView.addObject("findName", new String());




        return modelAndView;
    }

    @RequestMapping(value = "/editBanner/{id}", method = RequestMethod.GET)
    public ModelAndView editBanner(@PathVariable("id") int id) {
        Banner banner = bannerService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBanner");
        modelAndView.addObject("banner", banner);
        List<Category> categoryList = categoryService.getAllCategoriesNotDeleted();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("selectedCategpry", banner.getCategory().getId());
        System.out.println(categoryList.size());

        return modelAndView;
    }

    @RequestMapping(value = "/editBanner", method = RequestMethod.POST)
    public ModelAndView editBannerPage(@ModelAttribute("banner") Banner banner){
        ModelAndView modelAndView = new ModelAndView();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        int idC= Integer.parseInt(request.getParameter("categorySelector"));
        Category newCategory = categoryService.getById(idC);

        modelAndView.setViewName("redirect:/");
        banner.setCategory(newCategory);
        bannerService.edit(banner);
        return modelAndView;
    }

    @RequestMapping(value = "/addBanner", method = RequestMethod.GET)
    public ModelAndView addBannerPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBanner");
        List<Category> categoryList = categoryService.getAllCategoriesNotDeleted();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("selectedCategpry", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/addBanner", method = RequestMethod.POST)
    public ModelAndView addBanner(@ModelAttribute("banner") Banner banner){
        ModelAndView modelAndView = new ModelAndView();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        int idC= Integer.parseInt(request.getParameter("categorySelector"));
        Category newCategory = categoryService.getById(idC);

        modelAndView.setViewName("redirect:/");
        banner.setCategory(newCategory);
        bannerService.add(banner);
        return modelAndView;
    }

    @RequestMapping(value = "/allBanners", method = RequestMethod.GET)
    public  ModelAndView allBanners(){
        List<Banner> banners = bannerService.allBanners();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("banners");
        modelAndView.addObject("bannersList", banners);
        return  modelAndView;
    }

    @RequestMapping(value="/deleteBanner/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Banner banner = bannerService.getById(id);
        bannerService.markDelete(banner);
        return modelAndView;
    }

    @RequestMapping(value = "/bannerInfo/{id}", method = RequestMethod.GET)
    public ModelAndView viewBanner(@PathVariable("id") int id) {
        Banner banner = bannerService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bannerInfo");
        modelAndView.addObject("banner", banner);

        HttpServletRequest servReq = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();

        Request request = new Request();
        request.setBanner(banner);
        request.setIp_address(servReq.getRemoteAddr());
        request.setUser_agent(servReq.getHeader("User-Agent"));
        request.setDate(new Date(System.currentTimeMillis()));

        System.out.println(request);

        requestService.add(request);

        return modelAndView;
    }

    @RequestMapping(value = "/findByBannerName", method = RequestMethod.GET)
    public  ModelAndView findByName(@RequestParam("findName") String findName){
        List<Banner> banners = bannerService.findByName(findName.toLowerCase());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("banners");
        modelAndView.addObject("bannersList", banners);

        return  modelAndView;
    }



}
