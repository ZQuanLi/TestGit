package com.lzq.jpaRepository;

import com.lzq.doamin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author SakuraLLL权
 * @create 2019-06-22 21:47
 */

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
}
