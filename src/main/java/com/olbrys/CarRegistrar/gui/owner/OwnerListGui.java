package com.olbrys.CarRegistrar.gui.owner;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import java.util.List;

import static com.olbrys.CarRegistrar.gui.owner.NavigationOwnerGui.navigateToOwnerGui;

@Route("/Owner_List")
public class OwnerListGui extends VerticalLayout {

    private String listText;

    public OwnerListGui(OwnerController ownerController) {
        TextArea list = new TextArea("Lista Właścicieli");
        List<OwnerDto> ownerList = ownerController.getList();
        listText = generateListText(ownerList);
        list.setValue(listText);
        Button sortedById = new Button("Sortuj po ID", buttonClickEvent -> {
            listText = generateListText(ownerController.getSortedByIdList());
            list.setValue(listText);
        });
        Button sortedByName = new Button("Sortuj po Nazwisku", buttonClickEvent -> {
            listText = generateListText(ownerController.getSortedByNameList());
            list.setValue(listText);
        });
        Button goBack = new Button("Menu", buttonClickEvent -> navigateToOwnerGui());
        HorizontalLayout buttonContainer = new HorizontalLayout(sortedById, sortedByName, goBack);

        add(buttonContainer, list, goBack);

    }

    private String generateListText(List<OwnerDto> ownerList) {
        StringBuilder text = new StringBuilder();
        for (OwnerDto owner : ownerList) {
            text.append("Id: ").append(owner.getId()).append("\n");
            text.append("Imię: ").append(owner.getFirstName()).append("\n");
            text.append("Nazwisko: ").append(owner.getLastName()).append("\n");
            text.append("Czy ma ważne prawo jazdy: ").append(owner.isValidLicence()).append("\n\n");
        }
        return text.toString();
    }
}
