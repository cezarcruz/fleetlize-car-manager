package com.fleetlize.webapp.gateways.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class ManufacturerRequest {

    @NotEmpty(message = "can't be null or empty")
    private String name;
}
