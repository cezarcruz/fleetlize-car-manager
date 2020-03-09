package com.fleetlize.webapp.usecases.impl;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.database.repositories.CarModelRepository;
import com.fleetlize.webapp.gateways.database.repositories.CarRepository;
import com.fleetlize.webapp.gateways.jms.CarCreationNotifier;
import com.fleetlize.webapp.usecases.BasicCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateCar implements BasicCreate<Car> {

  private CarRepository carRepository;
  private CarModelRepository carModelRepository;
  private CarCreationNotifier carCreationNotifier;

  public CreateCar(final CarRepository carRepository,
      final CarModelRepository carModelRepository,
      final CarCreationNotifier carCreationNotifier) {
    this.carRepository = carRepository;
    this.carModelRepository = carModelRepository;
    this.carCreationNotifier = carCreationNotifier;
  }

  public Car execute(final Car car) {
    log.info("executing create car");

    final var carModel = carModelRepository.findById(car.getCarModel().getId());

    return carModel.map(c -> {
      final var carInserted = carRepository.insert(car);
      carCreationNotifier.notify(carInserted);
      return carInserted.toBuilder().carModel(c).build();
    }).orElseThrow(RuntimeException::new);//FIXME - create busines ex.


  }

}
