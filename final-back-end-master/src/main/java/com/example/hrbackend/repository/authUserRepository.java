package com.example.hrbackend.repository;

import com.example.hrbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface authUserRepository extends JpaRepository<User,Integer> {

    User findUserByUsername(String username);
     User findUserById(Integer id);
    User findCustomerByUsernameAndPassword(String username,String password);

    List<User> findAllByRole(String role);

}
