package com.fleetlize.webapp.gateways.rest.converter;

import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.rest.response.ManufacturerResponse;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ManufacturerToManufacturerResponse {

    public static ManufacturerResponse from(final Manufacturer manufacturerCreated) {

        Assert.notNull(manufacturerCreated, "Manufacturer can't be null");

        return ManufacturerResponse.builder()
                .name(manufacturerCreated.getName())
                .creationDate(manufacturerCreated.getCreationDate())
                .updateDate(manufacturerCreated.getUpdateDate())
                .id(manufacturerCreated.getId())
                .build();
    }

    public static List<ManufacturerResponse> from(final List<Manufacturer> manufacturerList) {

        Assert.notNull(manufacturerList, "manufacturer can't be null");

        if (isEmpty(manufacturerList)) {
            return Collections.emptyList();
        }

        return manufacturerList.parallelStream()
                .map(ManufacturerToManufacturerResponse::from)
                .collect(Collectors.toList());
    }
}
