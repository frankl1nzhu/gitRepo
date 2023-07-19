package com.service;

import com.bean.User;
import com.util.BusinessException;

public interface UserService {
    public User register(User user) throws BusinessException;
}
