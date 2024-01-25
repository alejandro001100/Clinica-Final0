package com.example.application.views.verpacientes;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Ver Pacientes")
@Route(value = "ver-pacientes", layout = MainLayout.class)
@Uses(Icon.class)
public class VerPacientesView extends Composite<VerticalLayout> {

    public VerPacientesView() {
        H4 h4 = new H4();
        HorizontalLayout layoutRow = new HorizontalLayout();
        H5 h5 = new H5();
        H5 h52 = new H5();
        H5 h53 = new H5();
        H5 h54 = new H5();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H6 h6 = new H6();
        H6 h62 = new H6();
        H6 h63 = new H6();
        H6 h64 = new H6();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h4.setText("Pacientes ingresados");
        h4.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("25px");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.START);
        h5.setText("Cedula");
        h5.setWidth("90px");
        h52.setText("Nombres");
        h52.setWidth("200px");
        h53.setText("Apeliidos");
        h53.setWidth("200px");
        h54.setText("Edad");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h54);
        h54.setWidth("70px");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        h6.setText("1720175189");
        h6.setWidth("90px");
        h62.setText("JUSTIN ALEJANDRO");
        h62.setWidth("200px");
        h63.setText("PAQUI VEGA");
        h63.setWidth("200px");
        h64.setText("19");
        h64.setWidth("70px");
        getContent().add(h4);
        getContent().add(layoutRow);
        layoutRow.add(h5);
        layoutRow.add(h52);
        layoutRow.add(h53);
        layoutRow.add(h54);
        getContent().add(layoutRow2);
        layoutRow2.add(h6);
        layoutRow2.add(h62);
        layoutRow2.add(h63);
        layoutRow2.add(h64);
    }
}
