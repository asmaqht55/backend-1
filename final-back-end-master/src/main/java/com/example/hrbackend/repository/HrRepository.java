package com.example.hrbackend.repository;

import com.example.hrbackend.model.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrRepository extends JpaRepository<Hr,Integer> {
    Hr findCustomerById(Integer id);

    List<Hr> findAllByCategory(String category);




        //    Hr findCustomerById(Integer hrId);
        Hr findByUserId(Integer id);
    }

