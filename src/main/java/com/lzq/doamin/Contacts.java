package com.lzq.doamin;



import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author SakuraLLL权
 * @create 2019-06-21 21:00
 */

@Entity
@Proxy(lazy = false)
@Table(name = "contacts")
public class Contacts implements Serializable{
    private static final long serialVersionUID = 1L;

    public Contacts(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//提供主键的生成策略
    private Long id;//主键

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long phoneNumber;

    @ManyToOne(targetEntity = User.class)//指向User实体类
    @JoinColumn(name = "user_id")//创建外键列名
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
