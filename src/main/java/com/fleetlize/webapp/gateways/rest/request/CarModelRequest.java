package com.fleetlize.webapp.gateways.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarModelRequest {

    private String model;
    private Integer modelYear;
    private Long manufacturerId;

}
