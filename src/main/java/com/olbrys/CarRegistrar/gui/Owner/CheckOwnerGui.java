package com.olbrys.CarRegistrar.gui.Owner;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.NoSuchElementException;

@Route("/Get_Owner")
public class CheckOwnerGui extends VerticalLayout implements NavigateToGui {

    private final OwnerController ownerController;

    private final TextArea respond;
    private final TextField idSearch;
    private final Button delete;

    public CheckOwnerGui(OwnerController ownerController) {
        this.ownerController = ownerController;

        idSearch = new TextField("Podaj ID Właściciela");
        idSearch.addKeyDownListener(Key.ENTER, keyDownEvent -> searchById());
        Button search = new Button("Szukaj", buttonClickEvent -> searchById());
        respond = new TextArea("Dane:");
        delete = new Button("Usuń", buttonClickEvent -> deleteOwnerById());
        delete.setVisible(false);
        Button ownerGuiButton = new Button("Powrót do menu", buttonClickEvent -> navigateToOwnerGui());

        add(idSearch, search, respond, delete, ownerGuiButton);
    }

    private void searchById() {
        try {
            Long ownerId = Long.parseLong(idSearch.getValue());
            OwnerDto ownerDto = ownerController.getOwnerById(ownerId);

            if (ownerDto != null) {
                respond.setValue("Imie: " + ownerDto.getFirstName() +
                        "\nNazwisko: " + ownerDto.getLastName() +
                        "\nWażne prawo jazdy: " + ownerDto.isValidLicence());
                delete.setVisible(true);
            } else {
                respond.setValue("Nie znaleziono właściciela o podanym ID: " + ownerId);
                delete.setVisible(false);
            }

        } catch (NumberFormatException e) {
            respond.setValue("Nie poprawne wprowadzenie ID. Podaj numer ID");
            delete.setVisible(false);
        }
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
}
