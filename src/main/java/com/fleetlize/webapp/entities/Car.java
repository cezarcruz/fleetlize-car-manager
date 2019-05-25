package com.fleetlize.webapp.entities;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Car {

    private Long id;
    private String plate;
    private Integer mileage;
    private CarModel carModel;

}
