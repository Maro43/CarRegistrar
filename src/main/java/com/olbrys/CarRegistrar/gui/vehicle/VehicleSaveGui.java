package com.olbrys.CarRegistrar.gui.vehicle;

import com.olbrys.CarRegistrar.controler.OwnerController;
import com.olbrys.CarRegistrar.controler.VehicleController;
import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.olbrys.CarRegistrar.dto.VehicleDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import static com.olbrys.CarRegistrar.gui.vehicle.NavigationVehicleGui.navigateToVehicleGui;

@Route("/test")
public class VehicleSaveGui extends VerticalLayout {

    private final VehicleController vehicleController;
    private final OwnerController ownerController;

    private final TextField idCar;
    private final TextField model;
    private final TextField series;
    private final TextField yearPr;
    private final TextField yearReg;
    private final Checkbox validRe;
    private final TextField idOwner;
    private final TextArea resultField;
    private final Label registrationExistsLabel;
    Button resultButton;

    public VehicleSaveGui(VehicleController vehicleController, OwnerController ownerController) {
        this.vehicleController = vehicleController;
        this.ownerController = ownerController;

        idCar = new TextField("Rejestracja");
        model = new TextField("Marka");
        series = new TextField("Model");
        yearPr = new TextField("Rok Produkcji");
        yearReg = new TextField("Rok Rejestracji");
        validRe = new Checkbox("Ważność");
        idOwner = new TextField("Właściciel");
        resultField = new TextArea("Wynik:");
        registrationExistsLabel = new Label("Podana rejestracja już istnieje.");
        registrationExistsLabel.setVisible(false);
        checkId();
        resultButton = new Button("Zapisz", buttonClickEvent -> saveVehicle());
        Button goBack = new Button("Powrót do Menu", buttonClickEvent -> navigateToVehicleGui());

        add(registrationExistsLabel, idCar, model, series, yearPr, yearReg, validRe, idOwner,
                resultButton, resultField, goBack);
    }

    private void saveVehicle() {
        String id = idCar.getValue();
        String modelCar = model.getValue();
        String seriesCar = series.getValue();
        int production = Integer.parseInt(yearPr.getValue());
        int regis = Integer.parseInt(yearReg.getValue());
        Boolean valid = validRe.getValue();
        Long idOw = Long.parseLong(idOwner.getValue());
        OwnerDto ownerDto = ownerController.getOwnerById(idOw);
        VehicleDto vehicleDto = new VehicleDto(id, modelCar, seriesCar, production, regis, valid);
        VehicleDto savedVehicle = vehicleController.saveVehicle(vehicleDto, idOw);
        String ownerInfo = "Właściciel: " + ownerDto.getFirstName() + " " + ownerDto.getLastName();
        resultField.setValue("Dodano Pojazd:\n" +
                "Rejestracja: " + savedVehicle.getId() + "\n" +
                savedVehicle.getModel() + " " + savedVehicle.getSeries() + "\n" +
                "Rok Produkcji: " + savedVehicle.getYearProduction() + "\n" +
                "Rok Rejestracji: " + savedVehicle.getYearRegistration() + "\n" +
                ownerInfo);
    }

    private void checkId() {
        idCar.addValueChangeListener(event -> {
            String enteredId = event.getValue();
            boolean registrationExists = vehicleController.checkIdInDB(enteredId);
            registrationExistsLabel.setVisible(registrationExists);
            resultButton.setVisible(!registrationExists);
        });
    }
}
