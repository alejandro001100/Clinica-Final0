package com.example.application.repository;

import com.example.application.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    // Métodos personalizados si son necesarios
}
