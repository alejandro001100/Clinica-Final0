package com.example.application.repository;

import com.example.application.models.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Paciente findByCedula(String cedula);

    // Otros métodos personalizados si son necesarios
}

