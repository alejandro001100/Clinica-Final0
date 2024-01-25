package com.example.application.services;

import com.example.application.models.Paciente;
import com.example.application.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private static final Logger logger = LoggerFactory.getLogger(PacienteService.class);

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }




    public Paciente guardarPaciente(Paciente paciente) {
        if (paciente == null) {
            logger.error("Paciente object is null");
            return null;
        }

        Paciente savedPaciente = pacienteRepository.save(paciente);

        if (savedPaciente == null) {
            logger.error("Failed to save Paciente object");
        } else {
            logger.info("Successfully saved Paciente object with id: " + savedPaciente.getId());
        }

        return savedPaciente;
    }
    public Optional<Paciente> obtenerPacientePorId(String id) {
        return pacienteRepository.findById(id);
    }

    public Paciente obtenerPacientePorCedula(String cedula) {
        return pacienteRepository.findByCedula(cedula);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    public void eliminarPaciente(String id) {
        pacienteRepository.deleteById(id);
    }
    // En PacienteService
    public String obtenerNombrePacientePorId(String id) {
        if (id == null) {
            return "ID de paciente no disponible";
        }
        return pacienteRepository.findById(id)
                .map(paciente -> paciente.getNombre() + " " + paciente.getApellido() + " - " + paciente.getCedula())
                .orElse("Paciente no encontrado");
    }
}

