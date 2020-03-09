package com.fleetlize.webapp.gateways.rest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CarModelResponse {

  private Long id;
  private String model;
  private ManufacturerResponse manufacturer;
  private Date creationDate;
  private Date updateDate;

}
