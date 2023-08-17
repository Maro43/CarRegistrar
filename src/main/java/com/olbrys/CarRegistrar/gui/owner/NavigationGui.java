package com.olbrys.CarRegistrar.gui.owner;

import com.vaadin.flow.component.UI;

public class NavigationGui {

    public static void navigateToSaveOwner() {
        UI.getCurrent().navigate(SaveOwnerGui.class);
    }

    public static void navigateToOwnerGui() {
        UI.getCurrent().navigate(OwnerGui.class);
    }

    public static void navigateToCheckOwner() {
        UI.getCurrent().navigate(CheckOwnerGui.class);
    }
}