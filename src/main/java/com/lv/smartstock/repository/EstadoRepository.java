package com.lv.smartstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lv.smartstock.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
