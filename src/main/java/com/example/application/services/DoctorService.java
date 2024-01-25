package com.example.application.services;

import com.example.application.models.Doctor;
import com.example.application.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor guardarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> obtenerDoctorPorId(String id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorRepository.findAll();
    }

    public void eliminarDoctor(String id) {
        doctorRepository.deleteById(id);
    }

    // En DoctorService
    public String obtenerNombreDoctorPorId(String id) {
        if (id == null) {
            return "ID de doctor no disponible";
        }
        return doctorRepository.findById(id)
                .map(doctor -> doctor.getNombre() + " " + doctor.getApellido() + " - " + doctor.getEspecialidad())
                .orElse("Doctor no encontrado");
    }



}
