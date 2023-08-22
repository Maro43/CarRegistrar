package com.olbrys.CarRegistrar.gui.owner;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.NoSuchElementException;

import static com.olbrys.CarRegistrar.gui.owner.NavigationGui.navigateToOwnerGui;

@Route("/Get_Owner")
public class CheckOwnerGui extends VerticalLayout {

    private final OwnerController ownerController;

    private final TextArea respond;
    private final TextField idSearch;
    private final Button delete;
    private final Button update;
    private final Checkbox validLicenceCheckbox;
    private final TextField firstNameField;
    private final TextField lastNameField;

    public CheckOwnerGui(OwnerController ownerController) {
        this.ownerController = ownerController;

        idSearch = new TextField("Podaj ID Właściciela");
//        todo add Validation
        idSearch.addKeyDownListener(Key.ENTER, keyDownEvent -> searchById());
        Button search = new Button("Szukaj", buttonClickEvent -> searchById());
        respond = new TextArea("Dane:");
        delete = new Button("Usuń", buttonClickEvent -> deleteOwnerById());
        delete.setVisible(false);
        firstNameField = new TextField("Imię");
        lastNameField = new TextField("Nazwisko");
        validLicenceCheckbox = new Checkbox("Ważne prawo jazdy");
        update = new Button("Aktualizuj Dane", buttonClickEvent -> updateOwner());
        update.setVisible(false);

        Button ownerGuiButton = new Button("Powrót do menu", buttonClickEvent -> navigateToOwnerGui());

        add(idSearch, search, respond, delete, update, firstNameField, lastNameField, validLicenceCheckbox, ownerGuiButton);
    }

    private void searchById() {
        Long ownerId = retrieveId(idSearch.getValue());

        OwnerDto ownerDto = ownerController.getOwnerById(ownerId);

        if (ownerDto != null) {
            respond.setValue("Imie: " + ownerDto.getFirstName() +
                    "\nNazwisko: " + ownerDto.getLastName() +
                    "\nWażne prawo jazdy: " + ownerDto.isValidLicence());
            delete.setVisible(true);
            update.setVisible(true);
        } else {
            respond.setValue("Nie znaleziono właściciela o podanym ID: " + ownerId);
            delete.setVisible(false);
        }
    }

    private Long retrieveId(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            respond.setValue("Nie poprawne wprowadzenie ID. Podaj numer ID");
            delete.setVisible(false);
        }
        return null;
    }

    private void deleteOwnerById() {
        try {
            Long ownerId = Long.parseLong(idSearch.getValue());
            ownerController.deleteOwner(ownerId);
            respond.setValue("Usunięto właściciela o ID: " + ownerId);
        } catch (NumberFormatException e) {
            respond.setValue("Niepoprawne wprowadzenie ID. Podaj numer ID");
        } catch (NoSuchElementException e) {
            respond.setValue("Właściciel o podanym ID nie istnieje");
        }
    }

    private void updateOwner() {
        try {
            Long ownerId = Long.parseLong(idSearch.getValue());

            String newFirstName = firstNameField.getValue();
            String newLastName = lastNameField.getValue();
            boolean newValidLicence = validLicenceCheckbox.getValue();

            OwnerDto updatedOwner = ownerController.updateOwner(new OwnerDto(newFirstName, newLastName, newValidLicence), ownerId);

            respond.setValue("Zaktualizowano właściciela o ID: " + ownerId);
        } catch (NumberFormatException e) {
            respond.setValue("Niepoprawne wprowadzenie ID. Podaj numer ID");
        } catch (NoSuchElementException e) {
            respond.setValue("Właściciel o podanym ID nie istnieje");
        }
    }
}