package com.olbrys.CarRegistrar.gui.vehicle;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class VehicleGui extends VerticalLayout {

    private TextField testField;

    public VehicleGui(){
        Label label = new Label("Menu opcji Pojazdów");

        add(label);
    }
}
