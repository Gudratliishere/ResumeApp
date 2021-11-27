/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.UserLoginDTO;
import com.company.resume.etinity.UserLogin;
import com.company.resume.service.inter.UserLoginServiceInter;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dunay Gudratli
 */
@Controller
public class UserLoginController
{

    private static final Logger LOG = LoggerFactory.getLogger(UserLoginController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @Autowired
    private UserLoginServiceInter userLoginService;

    @GetMapping("/login")
    public String login() throws Exception
    {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() throws Exception
    {
        return "logout";
    }

    @GetMapping("/signin")
    public String signin(@ModelAttribute UserLoginDTO userLoginDTO, Model model)
    {
        model.addAttribute("userLoginDTO", userLoginDTO);
        return "signin";
    }

    @PostMapping("/signin")
    public ModelAndView register(
            @Valid
            @ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO,
            BindingResult bindingResult
    )
    {
        ModelAndView mv = new ModelAndView("signin");

        if (bindingResult.hasErrors())
            return mv;

        if (userLoginService.findLogin(userLoginDTO.getEmail()) != null)
        {
            mv.addObject("emailexist", true);
            return mv;
        }

        if (userLoginDTO.getPassword() != null && userLoginDTO.getConfirmPassword() != null)
            if (!userLoginDTO.getPassword().equals(userLoginDTO.getConfirmPassword()))
            {
                mv.addObject("passworddifferent", true);
                return mv;
            }
        UserLogin login = new UserLogin(null, userLoginDTO.getEmail(), userLoginDTO.getPassword());
        userLoginService.saveLogin(login);

        ModelAndView mvlogin = new ModelAndView("redirect:/login");
        mvlogin.addObject("success", true);

        return mvlogin;
    }
}
