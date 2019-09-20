package com.uniware.dao.repository;

import com.uniware.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRep
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 10:45
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String userName);


}
