package com.fleetlize.webapp.gateways.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {
    private String plate;
    private Integer mileage;
    private Long carModel;
}
