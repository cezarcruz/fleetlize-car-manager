package com.fleetlize.webapp.exceptions;

public class CarModelNotFoundException extends RuntimeException {
  public CarModelNotFoundException() {
    super("car model not found");
  }
}
