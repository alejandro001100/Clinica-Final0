package com.example.application.views.crearcita;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Crear Cita")
@Route(value = "crear-cita", layout = MainLayout.class)
@Uses(Icon.class)
public class CrearCitaView extends Composite<VerticalLayout> {

    public CrearCitaView() {
        H4 h4 = new H4();
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Hr hr = new Hr();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H6 h6 = new H6();
        H6 h62 = new H6();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        FormLayout formLayout2Col = new FormLayout();
        Select select = new Select();
        Select select2 = new Select();
        DateTimePicker dateTimePicker = new DateTimePicker();
        Hr hr2 = new Hr();
        Button buttonPrimary3 = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h4.setText("Ingresa tu cedula para crear tu cita");
        h4.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.LARGE);
        layoutRow.setWidth("900px");
        layoutRow.setHeight("70px");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.START);
        textField.setLabel("Cedula");
        layoutRow.setAlignSelf(FlexComponent.Alignment.START, textField);
        textField.setWidth("min-content");
        buttonPrimary.setText("Ingresar");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Cancelar");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary2);
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.XLARGE);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("40px");
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.START);
        h6.setText("Bienvenido:");
        h6.setWidth("max-content");
        h6.setHeight("30px");
        h62.setText("\"Nombre paciente\"");
        h62.setWidth("max-content");
        h62.setHeight("30px");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Padding.SMALL);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        select.setLabel("Especialidad");
        select.setWidth("min-content");
        setSelectSampleData(select);
        select2.setLabel("Doctor");
        select2.setWidth("min-content");
        setSelectSampleData(select2);
        dateTimePicker.setLabel("Fecha y hora");
        dateTimePicker.setWidth("min-content");
        buttonPrimary3.setText("Agendar");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(h4);
        getContent().add(layoutRow);
        layoutRow.add(textField);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonPrimary2);
        getContent().add(hr);
        getContent().add(layoutRow2);
        layoutRow2.add(h6);
        layoutRow2.add(h62);
        getContent().add(layoutColumn2);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(select);
        formLayout2Col.add(select2);
        formLayout2Col.add(dateTimePicker);
        layoutColumn2.add(hr2);
        layoutColumn2.add(buttonPrimary3);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
