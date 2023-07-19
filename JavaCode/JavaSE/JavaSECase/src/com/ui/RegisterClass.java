package com.ui;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.util.BusinessException;

public class RegisterClass extends BaseClass{
    public void register() throws BusinessException{
        println((getString("input.username")));
        String username = input.nextLine();
        println((getString("input.password")));
        String password = input.nextLine();

        User user = new User(username, password);
        UserService userService = new UserServiceImpl();
        userService.register(user);
    }
}
