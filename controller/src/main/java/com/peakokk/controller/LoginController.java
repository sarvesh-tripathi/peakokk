package com.peakokk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peakokk.DTO.UserDTO;
import com.peakokk.service.IUserService;

@Controller
public class LoginController extends BaseController
{

    @Autowired
    IUserService userService;

    /**
     * PRIVATE VARIABLES
     */

    private static final String PAGE_LOGIN = "login";

    /**
     * To show login page
     * 
     * @return
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelMap model)
    {
        model.addAttribute("true", "error");

        return new ModelAndView("signIn");
    }
    
    

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(ModelMap model)
    {
        model.addAttribute("true", "error");
        return new ModelAndView("home");

    }

    @RequestMapping(value = "/howItWorks", method = RequestMethod.GET)
    public ModelAndView howItworks(ModelMap model)
    {
        model.addAttribute("true", "error");
        return new ModelAndView("howItWorks");

    }
    
    @RequestMapping(value = "/howItWorks2", method = RequestMethod.GET)
    public ModelAndView howItworks2(ModelMap model)
    {
        model.addAttribute("true", "error");
        return new ModelAndView("howItWorks2");

    }
    
    
    @RequestMapping(value= "/loginFunction", method = RequestMethod.POST)
    public String loginFunction(@ModelAttribute("user")UserDTO user,
                   BindingResult bindResult, HttpServletRequest request,
                   HttpServletResponse response, ModelMap model) {
         
       
         String message = ERROR_MESSAGE;
                 
     //   String result = userService.authentification(user);
       /* 
        if(result != null && result.equals("OK"))
        
        {
           return "redirect:home";
        }
        
        else
        {
            return "signIn";
        }
      */
        
      return null;
    }
    
    
   

    /**
     * Logout user
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model)
    {

        return SUCCESS;

    }

}