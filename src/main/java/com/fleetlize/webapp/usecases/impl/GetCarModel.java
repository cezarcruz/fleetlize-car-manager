package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.exceptions.CarModelNotFoundException;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class GetCarModel {

  private CarModelRepository carModelRepository;

  public List<CarModel> execute() {

    log.info("executing get car model");

    return carModelRepository.list();
  }

  public CarModel execute(final Long id) {

    Assert.notNull(id, "car model id can't be null");

    log.info("executing get car model by id = {}", id);

    final var carModel = carModelRepository.findById(id);

    return carModel.orElseThrow(CarModelNotFoundException::new);
  }

}
