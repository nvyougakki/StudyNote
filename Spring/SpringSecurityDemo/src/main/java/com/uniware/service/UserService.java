package com.uniware.service;

import com.uniware.bean.User;
import com.uniware.dao.mapper.UserDao;
import com.uniware.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 10:48
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRep;

    @Autowired
    UserDao userDao;

    public List<User> users(){
        List<User> list = userRep.findAll();
        System.out.println(list.get(0).toString());
        return list;
    }

}
