package com.faimdeloup.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faimdeloup.takeout.entity.AddressBook;
import com.faimdeloup.takeout.mapper.AddressBookMapper;
import com.faimdeloup.takeout.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
