package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.database.repositories.CarRepository;
import com.fleetlize.webapp.usecases.BasicCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
public class CreateCar implements BasicCreate<Car> {

    private CarRepository carRepository;

    public CreateCar(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car execute(final Car car) {
        log.info("executing create car");
        Assert.notNull(car, "car can't be null");
        return carRepository.insert(car);
    }

}
