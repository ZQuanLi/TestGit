package com.lzq.service;

import com.lzq.doamin.User;
import com.lzq.jpaRepository.UserRepository;
import com.lzq.jpaRepository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author SakuraLLL权
 * @create 2019-06-22 21:51
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }


}
