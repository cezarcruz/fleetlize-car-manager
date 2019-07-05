package com.fleetlize.webapp.gateways.notification;

import com.fleetlize.webapp.gateways.notification.request.NotifyRequest;
import com.fleetlize.webapp.gateways.notification.response.NotifyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-manager")
public interface NotificationClient {

    @PostMapping("/notify")
    NotifyResponse notify(final NotifyRequest notifyRequest);

}
