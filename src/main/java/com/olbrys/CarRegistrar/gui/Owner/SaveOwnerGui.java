package com.olbrys.CarRegistrar.gui.Owner;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/Save_Owner")
public class SaveOwnerGui extends VerticalLayout implements NavigateToGui {

    private final OwnerController ownerController;

    private final TextField firstNameField;
    private final TextField lastNameField;
    private final Checkbox validLicenceCheckbox;
    private final TextArea resultArea;

    public SaveOwnerGui(OwnerController ownerController) {
        this.ownerController = ownerController;

        firstNameField = new TextField("Podaj Imię");
        lastNameField = new TextField("Podaj Nazwisko");
        validLicenceCheckbox = new Checkbox("Czy masz ważne prawo jazdy");
        Button saveButton = new Button("Zapisz do bazy dancyh", buttonClickEvent -> saveOwner());
        Button ownerGuiButton = new Button("Powrót do Owner Menu", buttonClickEvent -> navigateToOwnerGui());
        resultArea = new TextArea("Wynik:");

        add(firstNameField, lastNameField, validLicenceCheckbox, saveButton, resultArea, ownerGuiButton);
    }

    private void saveOwner() {
        String firstName = firstNameField.getValue();
        String lastName = lastNameField.getValue();
        boolean validLicence = validLicenceCheckbox.getValue();

        OwnerDto ownerDto = new OwnerDto(firstName, lastName, validLicence);
        OwnerDto savedOwner = ownerController.saveOwner(ownerDto);

        resultArea.setValue("Dodano użytkownika: " + savedOwner.getFirstName() + " " + savedOwner.getLastName());
        Notification.show("Owner saved: " + savedOwner.getFirstName() + " " + savedOwner.getLastName(),
                3000, Notification.Position.TOP_CENTER);
    }
}