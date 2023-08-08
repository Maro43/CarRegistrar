package com.olbrys.CarRegistrar.gui.Owner;

import com.vaadin.flow.component.UI;

public interface NavigateToGui {

    default void navigateToSaveOwner() {
        UI.getCurrent().navigate(SaveOwnerGui.class);
    }

    default void navigateToOwnerGui() {
        UI.getCurrent().navigate(OwnerGui.class);
    }

    default void navigateToGetOwner() {
        UI.getCurrent().navigate(GetOwnerGui.class);
    }
}
