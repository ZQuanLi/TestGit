package com.lzq.service;

import com.lzq.doamin.Contacts;
import com.lzq.doamin.User;
import com.lzq.jpaRepository.ContactsService;
import com.lzq.jpaRepository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author SakuraLLL权
 * @create 2019-06-21 21:43
 */

//@Component("ContactsService")
@Service
@Transactional
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    public void updateContactsName(String name,Long id){
        contactsRepository.updateContactsName(name,id);
    }

    @Override
    public void updateContactsPhone(Long phoneNumber, Long id) {
        contactsRepository.updateContactsPhone(phoneNumber,id);
    }

    @Override
    public List<Long> findPhoneNumberByContactsName(String name,User user) {
        List<Long> list =contactsRepository.findPhoneNumberByContactsName(name,user);
        return list;
    }

    @Override
    public void deleteByName(String name) {
        contactsRepository.deleteByName(name);
    }

    public void addContacts(Contacts contacts){
        contactsRepository.save(contacts);
    }
    public void deleteContacts(Contacts contacts){
        contactsRepository.delete(contacts);
    }

    public Contacts getContacts(long id){
        return contactsRepository.getOne(id);
    }

    public List<Contacts> getAllContacts(){
        return contactsRepository.findAll();
    }
}
