package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateModelCategory {

  private final CarModelRepository carModelRepository;

  public CarModel execute(final CarModel carModel) {
    return carModelRepository.updateCategory(carModel);
  }

}
