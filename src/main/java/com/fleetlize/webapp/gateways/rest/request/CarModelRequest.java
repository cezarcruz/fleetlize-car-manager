package com.fleetlize.webapp.gateways.rest.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarModelRequest {

    @NotEmpty(message = "model can't be null")
    private String model;

    @NotNull(message = "model year can't be null")
    private Integer modelYear;

    @NotNull(message = "manufacturer can't be null")
    private Long manufacturerId;

}
