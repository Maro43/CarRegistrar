package com.olbrys.CarRegistrar.gui.owner;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    private final HorizontalLayout buttonContainer;
    private Checkbox validLicenceCheckbox;
    private TextField firstNameField;
    private TextField lastNameField;
    private Button update;
    private final Button ownerGuiButton;

    public CheckOwnerGui(OwnerController ownerController) {
        this.ownerController = ownerController;

        idSearch = new TextField("Podaj ID Właściciela");
//        todo add Validation
        idSearch.addKeyDownListener(Key.ENTER, keyDownEvent -> searchById());
        Button search = new Button("Szukaj", buttonClickEvent -> searchById());
        respond = new TextArea("Dane:");
        Button delete = new Button("Usuń", buttonClickEvent -> deleteOwnerById());
        Button updateOn = new Button("Aktualizuj Dane", buttonClickEvent -> addUpdate());
        buttonContainer = new HorizontalLayout(delete, updateOn);
        buttonContainer.setVisible(false);
        ownerGuiButton = new Button("Powrót do menu", buttonClickEvent -> navigateToOwnerGui());

        add(idSearch, search, respond, buttonContainer, ownerGuiButton);
    }

    private void visibleOff() {
        buttonContainer.setVisible(false);
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        validLicenceCheckbox.setVisible(false);
        update.setVisible(false);
    }

    private void searchById() {
        String value = idSearch.getValue();
        try {
            enteredId();
            OwnerDto ownerDto = ownerController.getOwnerById(enteredId());
            if (ownerDto != null) {
                respond.setValue("Imie: " + ownerDto.getFirstName() +
                        "\nNazwisko: " + ownerDto.getLastName() +
                        "\nWażne prawo jazdy: " + ownerDto.isValidLicence());
                buttonContainer.setVisible(true);
            } else {
                respond.setValue("Nie znaleziono właściciela o podanym ID: " + enteredId());
                visibleOff();
            }
        } catch (NumberFormatException e) {
            respond.setValue("Nie poprawne wprowadzenie ID. Podaj numer ID");
            visibleOff();
        }
    }

    private void addUpdate() {
        firstNameField = new TextField("Imię");
        lastNameField = new TextField("Nazwisko");
        validLicenceCheckbox = new Checkbox("Ważne prawo jazdy");
        update = new Button("Aktualizuj", buttonClickEvent -> {
            updateOwner();
            visibleOff();
        });
        remove(ownerGuiButton);
        add(firstNameField, lastNameField, validLicenceCheckbox, update, ownerGuiButton);
        buttonContainer.setVisible(false);
    }

    private void deleteOwnerById() {
        try {
            enteredId();
            ownerController.deleteOwner(enteredId());
            respond.setValue("Usunięto właściciela o ID: " + enteredId());
        } catch (NumberFormatException e) {
            respond.setValue("Niepoprawne wprowadzenie ID. Podaj numer ID");
        } catch (NoSuchElementException e) {
            respond.setValue("Właściciel o podanym ID nie istnieje");
        }
    }

    private void updateOwner() {
        try {
            enteredId();
            String newFirstName = firstNameField.getValue();
            String newLastName = lastNameField.getValue();
            boolean newValidLicence = validLicenceCheckbox.getValue();
            OwnerDto updatedOwner = ownerController.updateOwner(
                    new OwnerDto(newFirstName, newLastName, newValidLicence), enteredId());
            respond.setValue("Zaktualizowano właściciela o ID: " + enteredId());
        } catch (NumberFormatException e) {
            respond.setValue("Niepoprawne wprowadzenie ID. Podaj numer ID");
        } catch (NoSuchElementException e) {
            respond.setValue("Właściciel o podanym ID nie istnieje");
        }
    }

    private Long enteredId() {
        return Long.parseLong(idSearch.getValue());
    }
}