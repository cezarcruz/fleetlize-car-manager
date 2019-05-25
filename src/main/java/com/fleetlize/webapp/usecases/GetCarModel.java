package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCarModel {

    private CarModelRepository carModelRepository;

    public List<CarModel> execute() {
        return carModelRepository.list();
    }

}
