package com.fleetlize.webapp.gateways.rest.response;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class ManufacturerResponse {

    private Long id;
    private String name;
    private Date creationDate;
    private Date updateDate;

}
