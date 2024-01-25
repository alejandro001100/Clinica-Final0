package com.example.application.views.verpacientes;

import com.example.application.models.Paciente;
import com.example.application.services.PacienteService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Ver Pacientes")
@Route(value = "ver-pacientes", layout = MainLayout.class)
public class VerPacientesView extends VerticalLayout {

    private Grid<Paciente> gridPacientes;
    private final PacienteService pacienteService;

    @Autowired
    public VerPacientesView(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        H4 titulo = new H4("Pacientes ingresados");
        configurarGrid();
        add(titulo, gridPacientes);
        cargarPacientes();
    }

    private void configurarGrid() {
        gridPacientes = new Grid<>(Paciente.class, false);
        gridPacientes.setSizeFull();
        gridPacientes.addColumn(Paciente::getNombre).setHeader("Nombres");
        gridPacientes.addColumn(Paciente::getApellido).setHeader("Apellidos");
        gridPacientes.addColumn(Paciente::getCedula).setHeader("Cédula");
        gridPacientes.addColumn(Paciente::getDireccion).setHeader("Dirección");
        gridPacientes.addColumn(Paciente::getTelefono).setHeader("Teléfono");
        gridPacientes.addColumn(Paciente::getEmail).setHeader("Email");
    }

    private void cargarPacientes() {
        gridPacientes.setItems(pacienteService.obtenerTodosLosPacientes());
    }
}
