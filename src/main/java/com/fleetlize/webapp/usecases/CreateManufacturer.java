package com.fleetlize.webapp.usecases;

import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.database.repositories.ManufacturerRepository;
import com.fleetlize.webapp.gateways.notification.NotificationClient;
import com.fleetlize.webapp.gateways.notification.request.NotifyRequest;
import com.fleetlize.webapp.gateways.notification.response.NotifyResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateManufacturer {

    private ManufacturerRepository manufacturerRepository;
    private NotificationClient notificationClient;

    public Manufacturer execute(final Manufacturer manufacturer) {

        log.info("creating new manufacturer");

        final Manufacturer manufacturerCreated = manufacturerRepository.create(manufacturer);

        final NotifyRequest notifyRequest
                = NotifyRequest.builder().from("cezarcruz@outlook.com").build();

        final NotifyResponse notify = notificationClient.notify(notifyRequest);

        log.info(notify.getUuid());

        return manufacturerCreated;
    }

}
