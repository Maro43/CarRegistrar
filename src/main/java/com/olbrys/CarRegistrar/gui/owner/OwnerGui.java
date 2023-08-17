package com.olbrys.CarRegistrar.gui.owner;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import static com.olbrys.CarRegistrar.gui.owner.NavigationGui.navigateToCheckOwner;
import static com.olbrys.CarRegistrar.gui.owner.NavigationGui.navigateToSaveOwner;

@Route
public class OwnerGui extends VerticalLayout {

    public OwnerGui() {
        Label label = new Label("Menu wyboru opcji Owner");
        Button saveOwnerButton = new Button("Save Owner", buttonClickEvent -> navigateToSaveOwner());
        Button checkOwnerButton = new Button("Check Owner", buttonClickEvent -> navigateToCheckOwner());

        add(label, saveOwnerButton, checkOwnerButton);
    }
}