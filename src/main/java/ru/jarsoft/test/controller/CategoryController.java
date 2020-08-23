package ru.jarsoft.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.jarsoft.test.model.Banner;
import ru.jarsoft.test.model.Category;
import ru.jarsoft.test.service.CategoryService;
import ru.jarsoft.test.service.CategoryServiceImpl;

import java.util.List;


@Controller
@ComponentScan
public class CategoryController {
    @Autowired
    private CategoryService categoryService = new CategoryServiceImpl();

    @RequestMapping(value="/categories", method= RequestMethod.GET)
    public ModelAndView categories(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categories");
        modelAndView.addObject("categoryList", categoryService.getAllCategoriesNotDeleted());
        return modelAndView;
    }

    @RequestMapping(value="/allCategories", method= RequestMethod.GET)
    public ModelAndView allCategories(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categories");
        modelAndView.addObject("categoryList", categoryService.getAllCategories());
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBanner(@PathVariable("id") int id) {
        Category category = categoryService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCategory");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editBannerPage(@ModelAttribute("category") Category category){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/categories");
        categoryService.edit(category);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addBannerPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCategory");

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addBanner(@ModelAttribute("category") Category category){
        ModelAndView modelAndView = new ModelAndView();
        categoryService.add(category);

        modelAndView.setViewName("redirect:/categories");

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Category category = categoryService.getById(id);
        categoryService.markDelete(category);
        return modelAndView;
    }

    @RequestMapping(value = "/findByCategoryName", method = RequestMethod.GET)
    public  ModelAndView findByName(@RequestParam("findName") String findName){
        List<Category> categories = categoryService.findByName(findName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categories");
        modelAndView.addObject("categoryList", categories);

        return  modelAndView;
    }

}
