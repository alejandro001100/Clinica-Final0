package com.example.application.views.verdoctores;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Ver Doctores")
@Route(value = "ver-doctores", layout = MainLayout.class)
@Uses(Icon.class)
public class VerDoctoresView extends Composite<VerticalLayout> {

    public VerDoctoresView() {
        H4 h4 = new H4();
        HorizontalLayout layoutRow = new HorizontalLayout();
        H5 h5 = new H5();
        H5 h52 = new H5();
        H5 h53 = new H5();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H6 h6 = new H6();
        H6 h62 = new H6();
        H6 h63 = new H6();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h4.setText("Doctores ingresados");
        h4.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("25px");
        h5.setText("Nombres");
        h5.setWidth("200px");
        h5.setHeight("25px");
        h52.setText("Apellidos");
        h52.setWidth("200px");
        h52.setHeight("25px");
        h53.setText("Especialidad");
        h53.setWidth("200px");
        h53.setHeight("25px");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        h6.setText("ROBISON RICHARD");
        h6.setWidth("200px");
        h62.setText("Fernandez hidalgo");
        h62.setWidth("200px");
        h63.setText("Cirguia");
        h63.setWidth("200px");
        getContent().add(h4);
        getContent().add(layoutRow);
        layoutRow.add(h5);
        layoutRow.add(h52);
        layoutRow.add(h53);
        getContent().add(layoutRow2);
        layoutRow2.add(h6);
        layoutRow2.add(h62);
        layoutRow2.add(h63);
    }
}
