package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.database.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateManufacturer {

    private ManufacturerRepository manufacturerRepository;

    public Manufacturer execute(final Manufacturer manufacturer) {
        return manufacturerRepository.create(manufacturer);
    }

}
