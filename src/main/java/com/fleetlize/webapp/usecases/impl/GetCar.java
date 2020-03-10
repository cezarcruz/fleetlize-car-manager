package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.database.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCar {

  private final CarRepository carRepository;

  public Car execute(final Long id) {
    return carRepository.findById(id);
  }
}
