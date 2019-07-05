package com.fleetlize.webapp.gateways.notification.request;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NotifyRequest {

    private String from;
    private String to;
    private String title;
    private String message;

}
