package com.fleetlize.webapp.gateways.rest.mappers;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.rest.request.CarRequest;
import com.fleetlize.webapp.gateways.rest.response.CarResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
  @Mapping(source = "carModel", target = "carModel.id")
  Car from(final CarRequest carRequest);

  CarResponse from(final Car car);
}
