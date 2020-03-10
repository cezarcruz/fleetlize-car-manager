package com.fleetlize.webapp.gateways.rest.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

  @NotNull
  @Size(max = 50)
  private String name;

  @Positive
  private BigDecimal dailyPrice;
}
