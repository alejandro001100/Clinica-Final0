package com.example.application.views.verdoctores;

import com.example.application.models.Doctor;
import com.example.application.services.DoctorService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Ver Doctores")
@Route(value = "ver-doctores", layout = MainLayout.class)
public class VerDoctoresView extends VerticalLayout {

    private Grid<Doctor> gridDoctores;
    private final DoctorService doctorService;

    @Autowired
    public VerDoctoresView(DoctorService doctorService) {
        this.doctorService = doctorService;
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        H4 titulo = new H4("Doctores ingresados");
        configurarGrid();
        add(titulo, gridDoctores);
        cargarDoctores();
    }

    private void configurarGrid() {
        gridDoctores = new Grid<>(Doctor.class, false);
        gridDoctores.setSizeFull();
        gridDoctores.addColumn(Doctor::getNombre).setHeader("Nombre");
        gridDoctores.addColumn(Doctor::getApellido).setHeader("Apellido");
        gridDoctores.addColumn(Doctor::getEspecialidad).setHeader("Especialidad");
    }

    private void cargarDoctores() {
        List<Doctor> doctores = doctorService.obtenerTodosLosDoctores();
        if (doctores.isEmpty()) {
            // Este log es solo para depuración, debería quitarse o comentarse en producción
            System.out.println("No se encontraron doctores para cargar en el Grid");
        }
        gridDoctores.setItems(doctores);
    }
}
