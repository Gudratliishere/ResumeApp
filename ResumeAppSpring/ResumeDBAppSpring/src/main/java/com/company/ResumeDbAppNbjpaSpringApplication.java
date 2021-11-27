package com.company;

import com.company.resume.etinity.User;
import com.company.resume.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ResumeDbAppNbjpaSpringApplication
{

    @Autowired
    UserServiceInter userService;

    public static void main(String[] args)
    {
        SpringApplication.run(ResumeDbAppNbjpaSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run()
    {
        return args -> System.out.println("DB App is running!");
    }
}
