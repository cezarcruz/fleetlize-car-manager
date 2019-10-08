package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.exceptions.CarModelNotFoundException;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteCarModel {

    private CarModelRepository carModelRepository;

    public void execute(final Long id) {

        final CarModel carModel = carModelRepository.findById(id);

        if (carModel == null) {
            throw new CarModelNotFoundException();
        }

        carModelRepository.delete(id);
    }

}
