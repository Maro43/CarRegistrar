package com.olbrys.CarRegistrar.gui.owner;

import com.vaadin.flow.component.UI;

public class NavigationOwnerGui {

    public static void navigateToSaveOwner() {
        UI.getCurrent().navigate(SaveOwnerGui.class);
    }

    public static void navigateToOwnerGui() {
        UI.getCurrent().navigate(OwnerGui.class);
    }

    public static void navigateToCheckOwner() {
        UI.getCurrent().navigate(CheckOwnerGui.class);
    }

    public static void navigateToOwnerList() {
        UI.getCurrent().navigate(OwnerListGui.class);
    }
}