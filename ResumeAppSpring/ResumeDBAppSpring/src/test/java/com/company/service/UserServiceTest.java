package com.company.service;

import com.company.resume.dao.UserRepository;
import com.company.resume.etinity.User;
import com.company.resume.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTest
{
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public static void setUp ()
    {
        System.out.println("Set up called");
    }

    @Before
    public void before ()
    {
        System.out.println("Before called");

        MockitoAnnotations.openMocks(this);

        List<User> list = new ArrayList<>();

        User u = new User();
        u.setName("test");
        u.setSurname("test");

        list.add(u);

        Mockito.when(userRepository.getAll(null, null, null)).thenReturn(list);
        Mockito.when(userRepository.getAll("test", "test", null)).thenReturn(list);
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(u));
    }

    @Test
    public void testGetAll ()
    {
        List<User> list = userService.getAll(null, null, null);

        Assert.assertEquals("size must be equal to 1", 1, list.size());
    }

    @Test
    public void testGetAllWithParameters ()
    {
        List<User> list = userService.getAll("test", "test", null);

        Assert.assertTrue( "user size must be greater than zero", list.size() > 0);

        User user = list.get(0);

        Assert.assertEquals("name is not equal", "test", user.getName());
        Assert.assertEquals("surname is not equal", "test", user.getSurname());
    }

    @Test
    public void testFindById ()
    {
        User user = userService.getUserById(1);

        Assert.assertNotNull( "user must not be null", user);

        Mockito.verify(userRepository, Mockito.atLeastOnce()).findById(1);
    }
}
