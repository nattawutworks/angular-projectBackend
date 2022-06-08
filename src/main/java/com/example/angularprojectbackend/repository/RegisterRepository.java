package com.example.angularprojectbackend.repository;

import com.example.angularprojectbackend.model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepository extends MongoRepository<Register,String> {
}
