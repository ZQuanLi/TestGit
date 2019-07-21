package com.lzq.jpaRepository;

import com.lzq.doamin.Contacts;
import com.lzq.doamin.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author SakuraLLL权
 * @create 2019-06-21 21:31
 */
@Repository
@Transactional
public interface ContactsRepository extends JpaRepository<Contacts,Long>{


    @Modifying
    @Query("update Contacts c set c.name = ?1 where c.id = ?2")
    void updateContactsName(String name, Long id);

    @Modifying
    @Query("update Contacts c set c.phoneNumber = ?1 where c.id = ?2")
    void updateContactsPhone(Long phoneNumber,Long id);

    @Query("select phoneNumber from Contacts where name like %?1% and user = ?2")
    List<Long> findPhoneNumberByContactsName(String name, User user);

    @Modifying
    @Query("")
    void deleteByName (String name);

}
