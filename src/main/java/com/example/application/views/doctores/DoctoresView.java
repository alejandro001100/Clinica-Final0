package com.example.application.views.doctores;

import com.example.application.models.Doctor;
import com.example.application.services.DoctorService;
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

@PageTitle("Ingresar Doctor")
@Route(value = "ingresar-doctor", layout = MainLayout.class)
public class DoctoresView extends VerticalLayout {

    private final TextField nombre = new TextField("Nombre");
    private final TextField apellido = new TextField("Apellido");
    private final TextField especialidad = new TextField("Especialidad");
    private final TextField email = new TextField("Email");

    private final DoctorService doctorService;

    @Autowired
    public DoctoresView(DoctorService doctorService) {
        this.doctorService = doctorService;
        addClassName("ingresar-doctor-view");
        setSizeFull();

        // Configura los campos del formulario
        configureFields();

        FormLayout formLayout = new FormLayout();
        formLayout.add(nombre, apellido, especialidad, email);

        Button saveButton = new Button("Guardar");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickListener(e -> guardarDoctor());

        Button cancelButton = new Button("Cancelar");
        cancelButton.addClickListener(e -> limpiarFormulario());

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, cancelButton);
        buttonLayout.setSpacing(true);

        add(new H2("Ingresar Doctor"), formLayout, buttonLayout);
    }

    private void configureFields() {
        nombre.setRequired(true);
        apellido.setRequired(true);
        especialidad.setRequired(true);
        email.setRequiredIndicatorVisible(true);
        // Puedes agregar más configuraciones a los campos si es necesario.
    }

    private void guardarDoctor() {
        if (nombre.getValue().trim().isEmpty() || apellido.getValue().trim().isEmpty() ||
                especialidad.getValue().trim().isEmpty() || email.getValue().trim().isEmpty()) {
            Notification.show("Todos los campos son obligatorios.", 5000, Notification.Position.BOTTOM_START);
            return;
        }

        Doctor doctor = new Doctor(nombre.getValue(), apellido.getValue(), especialidad.getValue(), email.getValue());
        Doctor savedDoctor = doctorService.guardarDoctor(doctor);
        if (savedDoctor != null) {
            Notification.show("Doctor guardado con éxito");
        } else {
            Notification.show("Error al guardar el doctor");
        }
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        nombre.clear();
        apellido.clear();
        especialidad.clear();
        email.clear();
    }
}
