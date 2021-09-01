/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author x
 */
public class UserLoginDTO
{
    @NotBlank(message = "Enter your email!")
    @Email(message = "Enter a valid email adress")
    private String email;
    
    @NotBlank(message = "Enter your password!")
    @Length(min = 4, message = "Password must be atleast 4 characters")
    private String password;
    
    @NotBlank(message = "Re-Enter your password!")
    @Length(min = 4, message = "Password must be atleast 4 characters")
    private String confirmPassword;

    public UserLoginDTO()
    {
    }

    public UserLoginDTO(String email, String password, String confirmPassword)
    {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString()
    {
        return "UserLoginDTO{" + "email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + '}';
    }
    
    
}
