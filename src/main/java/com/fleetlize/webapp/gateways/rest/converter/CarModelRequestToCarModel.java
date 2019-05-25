package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.rest.request.CarModelRequest;

public class CarModelRequestToCarModel {

    public static CarModel from(final CarModelRequest carModelRequest) {

        return CarModel.builder()
                .model(carModelRequest.getModel())
                .manufacturer(Manufacturer.builder()
                        .id(carModelRequest.getManufacturerId())
                        .build())
                .modelYear(carModelRequest.getModelYear())
                .build();

    }

}
