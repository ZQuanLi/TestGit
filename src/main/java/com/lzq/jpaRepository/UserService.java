package com.lzq.jpaRepository;

import com.lzq.doamin.User;

/**
 * @author SakuraLLL权
 * @create 2019-06-22 21:51
 */
public interface UserService {

    void addUser(User user);
    User getUser(Long id);

}
