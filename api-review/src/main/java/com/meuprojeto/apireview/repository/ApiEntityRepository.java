package com.meuprojeto.apireview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuprojeto.apireview.model.ApiEnt;

@Repository
public interface ApiEntityRepository extends JpaRepository<ApiEnt, Long> {
   
}
