package com.company.controller;

import com.company.dto.CountryDTO;
import com.company.dto.UserDTO;
import com.company.resume.etinity.Country;
import com.company.resume.etinity.UserLogin;
import com.company.resume.service.inter.CountryServiceInter;
import com.company.resume.service.inter.EmploymentHistoryServiceInter;
import com.company.resume.service.inter.SkillServiceInter;
import com.company.resume.service.inter.UserLoginServiceInter;
import com.company.resume.service.inter.UserServiceInter;
import com.company.resume.service.inter.UserSkillServiceInter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController
{

    private final UserLoginServiceInter userLoginService;
    private final UserServiceInter userService;
    private final UserSkillServiceInter userSkillService;
    private final SkillServiceInter skillService;
    private final EmploymentHistoryServiceInter empService;
    private final CountryServiceInter countryService;

    public UserController(UserLoginServiceInter userLoginService, UserServiceInter userService,
            UserSkillServiceInter userSkillService, SkillServiceInter skillService,
            EmploymentHistoryServiceInter empService, CountryServiceInter countryService)
    {
        this.userLoginService = userLoginService;
        this.userService = userService;
        this.userSkillService = userSkillService;
        this.skillService = skillService;
        this.empService = empService;
        this.countryService = countryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

    }

    @GetMapping("/user")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("user");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        UserLogin login = userLoginService.findLogin(user.getUsername());

        UserDTO u;
        if (login.getUser() == null)
            u = new UserDTO();
        else
            u = UserDTO.of(login.getUser());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthdate = sdf.format(u.getBirthdate());

        mv.addObject("userDTO", u);
        mv.addObject("birthdate", birthdate);

        return mv;
    }

    @GetMapping("/useredit")
    public ModelAndView userEdit(
            HttpServletRequest request
    ) throws Exception
    {
        ModelAndView mv = new ModelAndView("useredit");

        String idStr = request.getParameter("id");

        if (idStr.trim().isEmpty())
            throw new Exception("Id is null!");

        Integer id = Integer.valueOf(idStr);

        UserDTO userDTO;
        if (id != 0)
        {
            userDTO = UserDTO.of(userService.getUserById(id));

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User userLogin = (User) auth.getPrincipal();

            UserLogin login = userLoginService.findLogin(userLogin.getUsername());

            if (login.getUser().getId() != userDTO.getId())
                throw new IllegalAccessException("Acces denied!");
        } else
        {
            userDTO = new UserDTO();
            userDTO.setId(0);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthdate = sdf.format(userDTO.getBirthdate());

        mv.addObject("userDTO", userDTO);
        mv.addObject("birthdate", birthdate);

        List<Country> countryList = countryService.getAll();

        mv.addObject("country", countryList);

        return mv;
    }

    @PostMapping("/useredit")
    public ModelAndView userEditPost(
            @Valid
            @ModelAttribute("userDTO") UserDTO userDTO,
            BindingResult bindingResult,
            HttpServletRequest request
    )
    {
        ModelAndView mv = new ModelAndView("useredit");

        if (bindingResult.hasErrors())
            return mv;

        com.company.resume.etinity.User user;

        if (userDTO.getId() == 0)
            user = new com.company.resume.etinity.User();
        else
            user = userService.getUserById(userDTO.getId());

        Integer birthplaceId = Integer.valueOf(request.getParameter("birthplaceId"));
        Country birthplace = countryService.getCountryById(birthplaceId);
        userDTO.setBirthplace(CountryDTO.of(birthplace));

        Integer nationalityId = Integer.valueOf(request.getParameter("nationalityId"));
        Country nationality = countryService.getCountryById(nationalityId);
        userDTO.setNationality(CountryDTO.of(nationality));

        UserDTO.toUser(userDTO, user, userSkillService, skillService, empService, countryService);

        user = userService.saveUser(user);

        if (userDTO.getId() == 0)
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User userLogin = (User) auth.getPrincipal();

            UserLogin login = userLoginService.findLogin(userLogin.getUsername());
            login.setUser(user);

            userLoginService.saveLogin(login);
        }

        ModelAndView mvUser = new ModelAndView("redirect:/user");
        mvUser.addObject("edit", true);

        return mvUser;
    }
}
