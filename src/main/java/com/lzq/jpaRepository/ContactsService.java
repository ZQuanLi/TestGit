package com.lzq.jpaRepository;

import com.lzq.doamin.Contacts;
import com.lzq.doamin.User;

import java.util.List;

/**
 * @author SakuraLLL权
 * @create 2019-06-22 0:06
 */

public interface ContactsService {
    void updateContactsName(String name, Long id);
    void updateContactsPhone(Long phoneNumber, Long id);
    List<Long> findPhoneNumberByContactsName(String name, User user);
    void deleteByName (String name);
}
