package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.rest.request.CarRequest;

public class CarRequestToCar {

    public static Car from(final CarRequest carRequest) {
        return Car.builder()
                .mileage(carRequest.getMileage())
                .carModel(CarModel.builder().id(carRequest.getCarModel()).build())
                .plate(carRequest.getPlate())
                .build();
    }

}
