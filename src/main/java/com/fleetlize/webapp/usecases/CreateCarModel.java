package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.exceptions.ManufacturerNotFoundException;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import com.fleetlize.webapp.gateways.database.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCarModel {

    private CarModelRepository carModelRepository;
    private ManufacturerRepository manufacturerRepository;

    public CarModel execute(final CarModel carModel) {

        log.info("executing create car model");

        Assert.notNull(carModel, "car model can't be null");

        final Optional<Manufacturer> manufacturer = manufacturerRepository.findById(carModel.getManufacturer().getId());

        if (manufacturer.isPresent()) {
            return carModelRepository.insert(carModel);
        } else {
            throw new ManufacturerNotFoundException();
        }

    }

}
