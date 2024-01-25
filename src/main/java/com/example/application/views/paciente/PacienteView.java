package com.example.application.views.paciente;

import com.example.application.models.Paciente;
import com.example.application.services.PacienteService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Paciente")
@Route(value = "paciente", layout = MainLayout.class)
public class PacienteView extends VerticalLayout {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteView(PacienteService pacienteService) {
        this.pacienteService = pacienteService;

        H2 titulo = new H2("Ingrese Datos del Paciente");
        TextField nombres = new TextField("Nombres");
        TextField apellidos = new TextField("Apellidos");
        TextField cedula = new TextField("Cédula");
        TextField direccion = new TextField("Dirección");
        TextField telefono = new TextField("Teléfono");
        TextField email = new TextField("Email");

        Button guardar = new Button("Guardar", e -> guardarPaciente(nombres, apellidos, cedula, direccion, telefono, email));
        Button cancelar = new Button("Cancelar", e -> limpiarFormulario(nombres, apellidos, cedula, direccion, telefono, email));

        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        HorizontalLayout acciones = new HorizontalLayout(guardar, cancelar);
        FormLayout formLayout = new FormLayout(nombres, apellidos, cedula, direccion, telefono, email);
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        add(titulo, formLayout, acciones);
    }

    private void guardarPaciente(TextField nombres, TextField apellidos, TextField cedula, TextField direccion, TextField telefono, TextField email) {
        Paciente paciente = new Paciente(nombres.getValue(), apellidos.getValue(), cedula.getValue(), direccion.getValue(), telefono.getValue(), email.getValue());
        pacienteService.guardarPaciente(paciente);
        Notification.show("Paciente guardado con éxito");
        limpiarFormulario(nombres, apellidos, cedula, direccion, telefono, email);
    }

    private void limpiarFormulario(TextField nombres, TextField apellidos, TextField cedula, TextField direccion, TextField telefono, TextField email) {
        nombres.clear();
        apellidos.clear();
        cedula.clear();
        direccion.clear();
        telefono.clear();
        email.clear();
    }
}
