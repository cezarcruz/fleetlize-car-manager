package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.rest.response.CarModelResponse;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CarModelToCarModelResponse {

    public static CarModelResponse from(final CarModel carModelSaved) {

        Assert.notNull(carModelSaved, "car model can't be null");

        return CarModelResponse.builder()
                .id(carModelSaved.getId())
                .creationDate(carModelSaved.getCreationDate())
                .manufacturer(carModelSaved.getManufacturer().getId())
                .model(carModelSaved.getModel())
                .updateDate(carModelSaved.getUpdateDate())
                .build();

    }

    public static List<CarModelResponse> from(final List<CarModel> carModelList) {

        Assert.notEmpty(carModelList, "execute of car model can't be null or empty");

        return carModelList.parallelStream().map(CarModelToCarModelResponse::from).collect(Collectors.toList());

    }

}
