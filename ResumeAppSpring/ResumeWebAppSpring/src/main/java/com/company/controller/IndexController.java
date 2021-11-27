/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.resume.etinity.UserLogin;
import com.company.resume.service.inter.UserLoginServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author x
 */
@Controller
public class IndexController
{

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() throws Exception
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        String login = String.valueOf(auth.getPrincipal());
        if (!login.equals("anonymousUser"))
            return "redirect:/user";
        
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String indexPage() throws Exception
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        String login = String.valueOf(auth.getPrincipal());
        if (!login.equals("anonymousUser"))
            return "redirect:/user";
        
        return "index";
    }
}
