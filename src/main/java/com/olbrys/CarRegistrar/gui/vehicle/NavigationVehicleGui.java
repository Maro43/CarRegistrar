package com.olbrys.CarRegistrar.gui.vehicle;

import com.vaadin.flow.component.UI;

public class NavigationVehicleGui {

    public static void navigateToVehicleGui() {
        UI.getCurrent().navigate(VehicleGui.class);
    }
}
