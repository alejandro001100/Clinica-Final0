package com.example.application.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "citas")
public class Cita {

    @Id
    private String id;
    private LocalDateTime fechaHora;
    private String doctorId;
    private String pacienteId;


    public Cita(LocalDateTime fechaHora, String doctorId, String pacienteId){
        this.fechaHora = fechaHora;
        this.doctorId = doctorId;
        this.pacienteId = pacienteId;

    }


    public Cita() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }


}
