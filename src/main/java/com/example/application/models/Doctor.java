package com.example.application.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctores")
public class Doctor {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String email;

    // Constructor por defecto necesario para Spring
    public Doctor() {
    }

    // Constructor con los campos necesarios
    public Doctor(String nombre, String apellido, String especialidad, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.email = email;
    }
    // En la clase Doctor
    public String getNombreCompletoYEspecialidad() {
        return nombre + " " + apellido + " - " + especialidad;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}