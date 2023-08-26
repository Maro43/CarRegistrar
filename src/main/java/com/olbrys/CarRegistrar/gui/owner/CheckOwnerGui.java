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

    private final TextArea respondField;
    private final TextField idSearchField;
    private final HorizontalLayout buttonContainer;
    private VerticalLayout centerLayout;
    private final Button searchButton;
    private final Button ownerGuiButton;
    private TextField firstNameField;
    private TextField lastNameField;
    private Checkbox validLicenceCheckbox;
    private Button updateButton;
    private final Button changeIdButton;
    private Button undoUpdateButton;

    public CheckOwnerGui(OwnerController ownerController) {
        this.ownerController = ownerController;

        idSearchField = new TextField("Podaj ID Właściciela");
//        todo add Validation
        idSearchField.addKeyDownListener(Key.ENTER, keyDownEvent -> searchById());
        searchButton = new Button("Szukaj", buttonClickEvent -> searchById());
        respondField = new TextArea("Dane:");
        respondField.setReadOnly(true);
        changeIdButton = new Button("Zmiana ID", buttonClickEvent -> changeIdButton());
        changeIdButton.setVisible(false);
        Button delete = new Button("Usuń", buttonClickEvent -> deleteOwnerById());
        Button updateOn = new Button("Aktualizuj Dane", buttonClickEvent -> addUpdate());
        buttonContainer = new HorizontalLayout(delete, updateOn);
        buttonContainer.setVisible(false);
        ownerGuiButton = new Button("Powrót do menu", buttonClickEvent -> navigateToOwnerGui());

        setLayout();
    }

    private void setLayout() {
        centerLayout = new VerticalLayout();
        centerLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        centerLayout.add(idSearchField, searchButton, respondField, changeIdButton, buttonContainer, ownerGuiButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        add(centerLayout);
    }

    private void idSearchButton() {
        buttonContainer.setVisible(true);
        idSearchField.setReadOnly(true);
        searchButton.setVisible(false);
        idSearchField.setLabel("ID");
        changeIdButton.setVisible(true);
    }

    private void changeIdButton() {
        buttonContainer.setVisible(false);
        idSearchField.setReadOnly(false);
        searchButton.setVisible(true);
        idSearchField.setLabel("Podaj ID Właściciela");
        changeIdButton.setVisible(false);
        respondField.clear();
    }

    private void undoUpdateButton() {
        resetSite();
        changeIdButton.setVisible(false);
        respondField.clear();
    }

    private void resetSite(){
        centerLayout.remove(undoUpdateButton);
        centerLayout.remove(firstNameField);
        centerLayout.remove(lastNameField);
        centerLayout.remove(validLicenceCheckbox);
        centerLayout.remove(updateButton);
        searchButton.setVisible(true);
        idSearchField.setReadOnly(false);
        idSearchField.setLabel("Podaj ID Właściciela");
    }

    private void searchById() {
        try {
            enteredId();
            OwnerDto ownerDto = ownerController.getOwnerById(enteredId());
            if (ownerDto != null) {
                respondField.setValue("Imie: " + ownerDto.getFirstName() +
                        "\nNazwisko: " + ownerDto.getLastName() +
                        "\nWażne prawo jazdy: " + ownerDto.isValidLicence());
                buttonContainer.setVisible(true);
                idSearchButton();
            } else {
                respondField.setValue("Nie znaleziono właściciela o podanym ID: " + enteredId());
            }
        } catch (NumberFormatException e) {
            respondField.setValue("Nie poprawne wprowadzenie ID. Podaj numer ID");
        }
    }

    private void addUpdate() {
        changeIdButton.setVisible(false);
        undoUpdateButton = new Button("Anuluj zmainę danych", buttonClickEvent -> undoUpdateButton());
        firstNameField = new TextField("Imię");
        lastNameField = new TextField("Nazwisko");
        validLicenceCheckbox = new Checkbox("Ważne prawo jazdy");
        updateButton = new Button("Aktualizuj", buttonClickEvent -> {
            updateOwner();
            resetSite();
        });
        centerLayout.remove(ownerGuiButton);
        centerLayout.add(undoUpdateButton, firstNameField, lastNameField, validLicenceCheckbox, updateButton, ownerGuiButton);
        buttonContainer.setVisible(false);
    }

    private void deleteOwnerById() {
        try {
            enteredId();
            ownerController.deleteOwner(enteredId());
            respondField.setValue("Usunięto właściciela o ID: " + enteredId());
            buttonContainer.setVisible(false);
        } catch (NumberFormatException e) {
            respondField.setValue("Niepoprawne wprowadzenie ID. Podaj numer ID");
        } catch (NoSuchElementException e) {
            respondField.setValue("Właściciel o podanym ID nie istnieje");
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
            respondField.setValue("Zaktualizowano właściciela o ID: " + enteredId());
        } catch (NumberFormatException e) {
            respondField.setValue("Niepoprawne wprowadzenie ID. Podaj numer ID");
        } catch (NoSuchElementException e) {
            respondField.setValue("Właściciel o podanym ID nie istnieje");
        }
    }

    private Long enteredId() {
        return Long.parseLong(idSearchField.getValue());
    }
}