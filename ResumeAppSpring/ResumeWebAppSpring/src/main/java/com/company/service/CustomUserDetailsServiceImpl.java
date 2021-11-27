package com.company.service;

import com.company.resume.etinity.UserLogin;
import com.company.resume.service.inter.UserLoginServiceInter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService
{
    private final UserLoginServiceInter userLoginService;

    public CustomUserDetailsServiceImpl (UserLoginServiceInter userLoginService)
    {
        this.userLoginService = userLoginService;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
    {
        UserLogin userLogin = userLoginService.findLogin(username);

        if (userLogin != null)
        {
            User.UserBuilder userBuilder = User.withUsername(username);

            userBuilder.disabled(false);
            userBuilder.password(userLogin.getPassword());

            String[] authoritiesArr = new String[]{"USER"};
            userBuilder.authorities(authoritiesArr);

            return userBuilder.build();
        }
        else
        {
            throw new UsernameNotFoundException("User was not found!");
        }
    }
}
