package com.lzq.demo;

import com.lzq.doamin.Contacts;
import com.lzq.doamin.User;
import com.lzq.service.ContactsServiceImpl;
import com.lzq.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	ContactsServiceImpl contactsServiceImpl;

	@Autowired
	UserServiceImpl userService;



    //==========新建用户和联系人==========
	@Test
	public void getUserAndContacts(){
//		User user1 = new User();
//		user1.setUsername("小红");
//		user1.setPassword("1234");
//		userService.addUser(user1);

//		User user2 = new User();
//      user2.setUsername("小明");
//      user2.setPassword("1234");
//		userService.addUser(user2);

//        User user1=userService.getUser(2l);
//
//        Contacts contacts1 = new Contacts();
//        contacts1.setUser(user1);
//        contacts1.setName("叔叔");
//        contacts1.setPhoneNumber(13425849546l);
//
//        Contacts contacts2 = new Contacts();
//        contacts2.setUser(user1);
//        contacts2.setName("阿姨");
//        contacts2.setPhoneNumber(13598659562l);
//
//		contactsServiceImpl.addContacts(contacts1);
//        contactsServiceImpl.addContacts(contacts2);

	}

    /***************增*****************/
    //=======增加一个联系人=======
	@Test
	public void contextLoads() {
        User user=userService.getUser(2l);
		Contacts contacts = new Contacts();
		contacts.setUser(user);
		contacts.setName("爸爸3");
		contacts.setPhoneNumber(1311111111l);
		contactsServiceImpl.addContacts(contacts);
	}

    /***************删*****************/
    //=======根据ID删除联系人=======
    @Test
    public void testDelete() {
        Contacts contacts = contactsServiceImpl.getContacts(9l);
        contactsServiceImpl.deleteContacts(contacts);
        System.out.println("删除成功");
    }

    //=======根据名字删除联系人=======
    @Test
    public void deleteByName(){
        contactsServiceImpl.deleteByName("爸爸3");
    }

    /***************改*****************/
    //=======根据ID修改联系人=======
    @Test
    public void testUpdate() {
        contactsServiceImpl.updateContactsName("changed",4l);
        contactsServiceImpl.updateContactsPhone(1311111111l,4l);
        Contacts contacts = contactsServiceImpl.getContacts(4l);
        System.out.println(contacts);
    }

    /***************查*****************/
    //==========查看该用户下的所有联系人==========
    @Test
    public void getUser(){
        User user = userService.getUser(1l);
        for(int i=0;i<user.getContactsList().size();i++){
            System.out.println(user.getContactsList().get(i));
        }
    }

    //==========查看所有联系人==========
    @Test
    public void getAllContacts(){
        List<Contacts> contacts=contactsServiceImpl.getAllContacts();
        for (int i=0;i<contacts.size();i++){
            System.out.println(contacts.get(i));
        }
    }

    //=======根据ID查找联系人=======
	@Test
	public void testSelect() {
		Contacts contacts = contactsServiceImpl.getContacts(3);
		System.out.println(contacts);

	}

    //=======通过名字查找联系人的电话号码=======
    @Test
    public void findPhoneNumberByContactsName(){
        User user=userService.getUser(2l);
        List<Long> number=contactsServiceImpl.findPhoneNumberByContactsName("爸",user);
        System.out.println(number);
    }
}
