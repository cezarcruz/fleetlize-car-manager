package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.database.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetManufacturer {

    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> execute() {
        return manufacturerRepository.list();
    }


}
