package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.rest.request.CarModelRequest;
import org.springframework.util.Assert;

public class CarModelRequestToCarModel {

    public static CarModel from(final CarModelRequest carModelRequest) {

        Assert.notNull(carModelRequest, "car model request can't be null");

        return CarModel.builder()
                .model(carModelRequest.getModel())
                .manufacturer(Manufacturer.builder()
                        .id(carModelRequest.getManufacturerId())
                        .build())
                .modelYear(carModelRequest.getModelYear())
                .build();

    }

    public static CarModel from(final CarModelRequest carModelRequest, final Long id) {
        final CarModel carModel = from(carModelRequest);
        return carModel.toBuilder().id(id).build();
    }
}
