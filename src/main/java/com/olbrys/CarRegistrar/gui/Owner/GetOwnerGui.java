package com.olbrys.CarRegistrar.gui.Owner;

import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.olbrys.CarRegistrar.service.OwnerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/Get_Owner")
public class GetOwnerGui extends VerticalLayout {

    private final OwnerService ownerService;

    private final TextArea respond;
    private final TextField idSearch;

    public GetOwnerGui(OwnerService ownerService) {

        this.ownerService = ownerService;

        idSearch = new TextField("Podaj ID Właściciela");
        Button search = new Button("Szukaj");
        search.addClickListener(buttonClickEvent -> searchById());
        respond = new TextArea("Dane:");

        add(idSearch, search, respond);
    }

    private void searchById() {

        try {
            Long ownerId = Long.parseLong(idSearch.getValue());
            OwnerDto ownerDto = ownerService.findById(ownerId);

            if (ownerDto != null) {
                respond.setValue("Imie: " + ownerDto.getFirstName() +
                        "\nNazwisko: " + ownerDto.getLastName() +
                        "\nWażne prawo jazdy: " + ownerDto.isValidLicence());
            } else {
                respond.setValue("Nie znaleziono właściciela o podanym ID: " + ownerId);
            }

        } catch (NumberFormatException e) {
            respond.setValue("Nie poprawne wprowadzenie ID. Podaj numer ID");
        }
    }
}
