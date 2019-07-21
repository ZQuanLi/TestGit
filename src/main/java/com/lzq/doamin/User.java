package com.lzq.doamin;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author SakuraLLL权
 * @create 2019-06-22 21:27
 */

@Entity
@Proxy(lazy = false)
@Table(name = "user")
public class User implements Serializable{

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//提供主键的生成策略
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    //cascade = CascadeType.PERSIST：级联持久化（保存）操作
    //mappedBy：相当于inverse=”true”，让多的一方维护，如果两方都由本方来维护的话，会多出一些update语句，性能有一定的损耗。
    //fetch = FetchType.EAGER：取消懒加载
    @OneToMany(targetEntity = Contacts.class,mappedBy = "user",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Contacts> contactsList;

    public List<Contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
