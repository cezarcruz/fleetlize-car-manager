package com.fleetlize.webapp.gateways.database.repositories.converters;

import com.fleetlize.webapp.entities.Car;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarConverter {

  public static Car from(final ResultSet resultSet, final int i) throws SQLException {

    return Car.builder()
        .id(resultSet.getLong("CAR_ID"))
        .plate(resultSet.getString("PLATE"))
        .mileage(resultSet.getInt("MILEAGE"))
        .carModel(CarModelConverter.from(resultSet, i))
        .category(CategoryConverter.from(resultSet, i))
        .build();

  }
}
