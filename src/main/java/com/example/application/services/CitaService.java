package com.example.application.services;

import com.example.application.models.Cita;
import com.example.application.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Optional<Cita> obtenerCitaPorId(String id) {
        return citaRepository.findById(id);
    }

    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    public void eliminarCita(String id) {
        citaRepository.deleteById(id);
    }

}
