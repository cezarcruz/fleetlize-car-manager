package com.fleetlize.webapp.gateways.rest.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class CarRequest {

  @NotEmpty
  private String plate;

  @PositiveOrZero
  private Integer mileage;

  @NotNull
  private Long carModel;
}
