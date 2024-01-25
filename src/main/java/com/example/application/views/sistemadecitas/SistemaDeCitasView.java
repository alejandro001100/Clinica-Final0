package com.example.application.views.sistemadecitas;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Sistema De Citas")
@Route(value = "Sistema-de-citas", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class SistemaDeCitasView extends VerticalLayout {

    public SistemaDeCitasView() {
        setWidth("100%");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.START);

        H1 h1 = new H1("SISTEMAS DE CITAS - CLINICA");
        H6 h6 = new H6("BIENVENIDOS Al SISTEMA DE CITAS");
        Paragraph textMedium = new Paragraph(
                "Aquí valoramos tu tiempo y esfuerzo, por eso hemos creado una experiencia de citas sencilla y eficiente. Nuestro objetivo es ayudarte a encontrar la cita perfecta en solo unos pocos pasos.");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");

        Button registrarPacienteBtn = new Button("Soy nuevo", e -> {
            getUI().ifPresent(ui -> ui.navigate("paciente"));
        });

        Button verCitasBtn = new Button("Ver Citas", e -> {
            getUI().ifPresent(ui -> ui.navigate("ver-citas"));
        });

        Button crearCitaBtn = new Button("Crear Cita", e -> {
            getUI().ifPresent(ui -> ui.navigate("crear-cita"));
        });

        // Añade todos los botones al layout principal
        add(h1, new Hr(), h6, textMedium, new Hr(), registrarPacienteBtn, verCitasBtn, crearCitaBtn);
    }
}