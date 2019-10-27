package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.exceptions.CarModelNotFoundException;
import com.fleetlize.webapp.exceptions.ManufacturerNotFoundException;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import com.fleetlize.webapp.gateways.database.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UpdateCarModel {

    private CarModelRepository carModelRepository;
    private ManufacturerRepository manufacturerRepository;

    public CarModel execute(final CarModel carModel) {

        final CarModel carModelFounded = carModelRepository.findById(carModel.getId());

        if (carModelFounded == null) {
            throw new CarModelNotFoundException();
        }

        final Optional<Manufacturer> manufacturer = manufacturerRepository.findById(carModel.getManufacturer().getId());

        return manufacturer.map(m -> {
            carModelRepository.update(carModel);
            return carModelRepository.findById(carModel.getId());
        }).orElseThrow(ManufacturerNotFoundException::new);

    }

}
