package com.fleetlize.webapp.gateways.database.repositories.converters;

import com.fleetlize.webapp.entities.Car;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CarConverter implements RowMapper<Car> {

  @Override
  public Car mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
    return Car.builder()
        .id(resultSet.getLong("CAR_ID"))
        .plate(resultSet.getString("PLATE"))
        .mileage(resultSet.getInt("MILEAGE"))
        .carModel(CarModelConverter.from(resultSet, rowNum))
        .build();
  }

}
