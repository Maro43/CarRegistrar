package com.olbrys.CarRegistrar.gui.vehicle;

import com.olbrys.CarRegistrar.gui.homepage.SiteGui;
import com.vaadin.flow.component.UI;

public class NavigationVehicleGui {

    public static void navigateToVehicleGui() {
        UI.getCurrent().navigate(VehicleGui.class);
    }
    public static void navigateToHomepageGui() {
        UI.getCurrent().navigate(SiteGui.class);
    }
    public static void navigateToSaveVehicleGui() {
        UI.getCurrent().navigate(VehicleSaveGui.class);
    }
}
