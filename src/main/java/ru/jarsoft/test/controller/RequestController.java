package ru.jarsoft.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.jarsoft.test.service.RequestService;
import ru.jarsoft.test.service.RequestServiceImpl;

@Controller
public class RequestController {
    @Autowired
    private RequestService requestService = new RequestServiceImpl();

    @RequestMapping(value="/requests", method= RequestMethod.GET)
    public ModelAndView allRequests(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("requests");
        modelAndView.addObject("requestsList", requestService.getAll());
        return modelAndView;
    }
}
