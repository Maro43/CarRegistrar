package com.olbrys.CarRegistrar.gui.homepage;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import static com.olbrys.CarRegistrar.gui.owner.NavigationOwnerGui.navigateToOwnerGui;
import static com.olbrys.CarRegistrar.gui.vehicle.NavigationVehicleGui.navigateToVehicleGui;

@Route("/")
public class SiteGui extends VerticalLayout {

    public SiteGui() {
        Label label = new Label("Menu Wyboru");
        Button siteOwner = new Button("Opcje Właścicieli", buttonClickEvent -> navigateToOwnerGui());
        Button siteVehicle = new Button("Opcje Pojazdów", buttonClickEvent -> navigateToVehicleGui());

        add(welcomeText(), label, siteOwner, siteVehicle);
    }

    private Div welcomeText(){
        String welcomeText = "Witaj na stronie demo. Mariusz Olbryś.<br>" +
                "Jestem osobą, która skupia się na backend, więc frontend może sie wydawać mocno \"surowy\". <br>" +
                "Strona ta została stworzona przy pomocy frameworka Vaadin i jest prezentacją umiejętności.<br>" +
                "Cały projekt jest oparty o wzorzec MVC. Logika działania strony jest w package service.<br>" +
                "Za działanie odpowiada package controller, a przesyłanie danych package DTO.<br>" +
                "Jeżeli chodzi o GUI, to jest oparte na zasobach z controller. Skonfigurowana baza danych to PostgreSQL.<br>" +
                "Strona jest cały czas rozwijana, ale każdy endpoint jest funkcjonalny.<br>" +
                "Jeżeli chcesz sprawdzić kod, to zapraszam na:<br>" +
                "<a href=\"https://github.com/Maro43/CarRegistrar\">https://github.com/Maro43/CarRegistrar</a>";
        Div welcomeDiv = new Div();
        welcomeDiv.getStyle().set("border", "1px solid black");
        welcomeDiv.add(new Html("<div>" + welcomeText + "</div>"));
        return welcomeDiv;
    }
}
