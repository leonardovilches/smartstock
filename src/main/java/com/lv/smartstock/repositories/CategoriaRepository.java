package com.lv.smartstock.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lv.smartstock.entities.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String>{

}
