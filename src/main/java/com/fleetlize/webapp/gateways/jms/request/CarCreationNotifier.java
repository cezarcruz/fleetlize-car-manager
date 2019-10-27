package com.fleetlize.webapp.gateways.jms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class CarCreationNotifier implements Serializable {
    private String plate;
}
