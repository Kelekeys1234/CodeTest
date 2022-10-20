package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SurburbModel;
@Repository
public interface SurburbRepository extends JpaRepository<SurburbModel,String>{
 
@Query("fROM SurburbModel ORDER BY suburbName ASC")
public List<SurburbModel> findByPostCode(String postCode);
}
