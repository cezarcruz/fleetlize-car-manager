package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCarModel {

    private CarModelRepository carModelRepository;

    public CarModel execute(final CarModel carModel) {

        Assert.notNull(carModel, "car model can't be null");

        log.info("executing create car model");

        return carModelRepository.insert(carModel);
    }

}
