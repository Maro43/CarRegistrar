package com.olbrys.CarRegistrar.gui.owner;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import java.util.List;

import static com.olbrys.CarRegistrar.gui.owner.NavigationGui.navigateToOwnerGui;

@Route("/Owner_List")
public class OwnerListGui extends VerticalLayout {

    public OwnerListGui(OwnerController ownerController){
        TextArea list = new TextArea("Lista Właścicieli");

        List<OwnerDto> ownerList = ownerController.getList();
        String listText = generateListText(ownerList);
        list.setValue(listText);
        Button goBack = new Button("Menu", buttonClickEvent -> navigateToOwnerGui());

        add(list,goBack);

    }

    private String generateListText(List<OwnerDto> ownerList) {
        StringBuilder sb = new StringBuilder();

        for (OwnerDto owner : ownerList) {
            sb.append("Id: ").append(owner.getId()).append("\n");
            sb.append("Imię: ").append(owner.getFirstName()).append("\n");
            sb.append("Nazwisko: ").append(owner.getLastName()).append("\n");
            sb.append("Czy ma ważne prawo jazdy: ").append(owner.isValidLicence()).append("\n\n");
        }

        return sb.toString();
    }
}
