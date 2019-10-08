package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.rest.response.CarResponse;

public class CarModelToCarResponse {
    public static CarResponse from(final Car carSaved) {

        return CarResponse.builder()
                .id(carSaved.getId())
                .mileage(carSaved.getMileage())
                .plate(carSaved.getPlate())
                .carModel(carSaved.getCarModel().getId())
                .build();

    }
}
