package com.olbrys.CarRegistrar.gui.owner;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import static com.olbrys.CarRegistrar.gui.owner.NavigationGui.*;

@Route
public class OwnerGui extends VerticalLayout {

    public OwnerGui() {
        Label label = new Label("Menu wyboru opcji Owner");
        Button listOwnerButton = new Button("Lista Właścicieli", buttonClickEvent -> navigateToOwnerList());
        Button saveOwnerButton = new Button("Zapisz Właściciela", buttonClickEvent -> navigateToSaveOwner());
        Button checkOwnerButton = new Button("Opcje Właściciela", buttonClickEvent -> navigateToCheckOwner());

        add(label, listOwnerButton, saveOwnerButton, checkOwnerButton);
    }
}