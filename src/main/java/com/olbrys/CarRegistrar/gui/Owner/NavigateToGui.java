package com.olbrys.CarRegistrar.gui.Owner;

import com.vaadin.flow.component.UI;

public interface NavigateToGui {

    default void navigateToSaveOwner() {
        UI.getCurrent().navigate(SaveOwnerGui.class);
    }
}
