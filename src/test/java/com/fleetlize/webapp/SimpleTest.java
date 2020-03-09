package com.fleetlize.webapp;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class SimpleTest {

  @Test
  public void shouldTest() {
    final BigDecimal value = BigDecimal.valueOf(100.23);

    final Integer newValue = value.multiply(BigDecimal.valueOf(100)).intValue();

    assertThat(newValue, is(10023));
    assertThat(BigDecimal.valueOf((double) newValue / 100), is(value));
  }
}
