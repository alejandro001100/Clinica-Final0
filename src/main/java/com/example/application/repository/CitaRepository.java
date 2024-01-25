package com.example.application.repository;

import com.example.application.models.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {
    List<Cita> findByPacienteId(String pacienteId);
    List<Cita> findByDoctorId(String doctorId);
    // Otros métodos personalizados si son necesarios
}
