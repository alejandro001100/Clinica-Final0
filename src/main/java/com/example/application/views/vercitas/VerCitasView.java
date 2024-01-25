package com.example.application.views.vercitas;

import com.example.application.models.Cita;
import com.example.application.services.CitaService;
import com.example.application.services.DoctorService;
import com.example.application.services.PacienteService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Ver Citas")
@Route(value = "ver-citas", layout = MainLayout.class)
public class VerCitasView extends VerticalLayout {

    private final CitaService citaService;
    private final DoctorService doctorService;
    private final PacienteService pacienteService;

    private Grid<Cita> grid = new Grid<>(Cita.class, false);

    @Autowired
    public VerCitasView(CitaService citaService, DoctorService doctorService, PacienteService pacienteService) {
        this.citaService = citaService;
        this.doctorService = doctorService;
        this.pacienteService = pacienteService;
        configuraGrid();
        add(grid);
        updateList();
    }

    private void configuraGrid() {
        grid.addClassNames("cita-grid");
        grid.addColumn(Cita::getFechaHora).setHeader("Fecha y Hora");
        grid.addColumn(cita -> doctorService.obtenerNombreDoctorPorId(cita.getDoctorId())).setHeader("Doctor");
        grid.addColumn(cita -> pacienteService.obtenerNombrePacientePorId(cita.getPacienteId())).setHeader("Paciente");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(citaService.obtenerTodasLasCitas());
    }
}
