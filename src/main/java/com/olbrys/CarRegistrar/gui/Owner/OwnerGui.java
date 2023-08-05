package com.olbrys.CarRegistrar.gui.Owner;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class OwnerGui extends VerticalLayout {

    public OwnerGui(){
        Button saveOwnerButton = new Button("Save Owner", buttonClickEvent -> navigateToSaveOwner());

        add(saveOwnerButton);
    }

    private void navigateToSaveOwner(){
        UI.getCurrent().navigate(SaveOwnerGui.class);
    }
}
