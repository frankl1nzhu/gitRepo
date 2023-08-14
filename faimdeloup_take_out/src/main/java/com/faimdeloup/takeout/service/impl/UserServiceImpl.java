package com.faimdeloup.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faimdeloup.takeout.entity.User;
import com.faimdeloup.takeout.mapper.UserMapper;
import com.faimdeloup.takeout.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
