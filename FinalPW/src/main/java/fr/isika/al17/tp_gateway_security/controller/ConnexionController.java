package fr.isika.al17.tp_gateway_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.isika.al17.tp_gateway_security.life_insurance_management_service.LifeInsuranceManagementService;

@Controller
public class ConnexionController {

    @Autowired
    LifeInsuranceManagementService lifeInsuranceManagementService;
    
    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/","/connect"}, method = RequestMethod.GET)
    public ModelAndView connect() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("connect");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/","/save"}, method = RequestMethod.GET)
    public ModelAndView save() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("save");
        return modelAndView;
    }

}
