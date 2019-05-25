package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCarModel {

    private CarModelRepository carModelRepository;

    public CarModel execute(final CarModel carModel) {
        return carModelRepository.insert(carModel);
    }

}
