package com.olbrys.CarRegistrar.gui.Owner;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class OwnerGui extends VerticalLayout implements NavigateToGui {

    public OwnerGui() {
        Label label = new Label("Menu wyboru opcji Owner");
        Button saveOwnerButton = new Button("Save Owner", buttonClickEvent -> navigateToSaveOwner());
        Button chckOwnerButton = new Button("Check Owner", buttonClickEvent -> navigateToCheckOwner());

        add(label, saveOwnerButton, chckOwnerButton);
    }
}
