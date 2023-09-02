package com.olbrys.CarRegistrar.gui.vehicle;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import static com.olbrys.CarRegistrar.gui.vehicle.NavigationVehicleGui.navigateToHomepageGui;
import static com.olbrys.CarRegistrar.gui.vehicle.NavigationVehicleGui.navigateToSaveVehicleGui;

@Route("/Vehicle")
public class VehicleGui extends VerticalLayout {

    public VehicleGui(){
        Label label = new Label("Menu opcji Pojazdów");
        Button saveVehicleButton = new Button("Dodaj Samochód", buttonClickEvent -> navigateToSaveVehicleGui());
        Button homepageButton = new Button("Menu Główne", buttonClickEvent -> navigateToHomepageGui());
        add(label, saveVehicleButton, homepageButton);
    }
}
