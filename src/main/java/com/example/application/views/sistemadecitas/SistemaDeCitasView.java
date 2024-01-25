package com.example.application.views.sistemadecitas;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Sistema De Citas")
@Route(value = "Sistema-de-citas", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class SistemaDeCitasView extends Composite<VerticalLayout> {

    public SistemaDeCitasView() {
        H1 h1 = new H1();
        Hr hr = new Hr();
        H6 h6 = new H6();
        Paragraph textMedium = new Paragraph();
        Hr hr2 = new Hr();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        h1.setText("SISTEMAS DE CITAS - CLINICA");
        h1.setWidth("max-content");
        h6.setText("BIENVENIDOS AL sistema de citas");
        h6.setWidth("max-content");
        textMedium.setText(
                "Aquí valoramos tu tiempo y esfuerzo, por eso hemos creado una experiencia de citas sencilla y eficiente. Nuestro objetivo es ayudarte a encontrar la cita perfecta en solo unos pocos pasos.");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textMedium);
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        getContent().add(h1);
        getContent().add(hr);
        getContent().add(h6);
        getContent().add(textMedium);
        getContent().add(hr2);
    }
}
