package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.rest.request.ManufacturerRequest;
import org.springframework.util.Assert;

public class ManufacturerRequestToManufacturer {

    public static Manufacturer from(final ManufacturerRequest  manufacturerRequest) {

        Assert.notNull(manufacturerRequest, "Manufacturer request can't be null");

        return Manufacturer.builder()
                .name(manufacturerRequest.getName())
                .build();
    }

}
