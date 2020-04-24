package com.fleetlize.webapp.gateways.database.repositories.converters;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.entities.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarModelConverter {

  public static CarModel from(final ResultSet resultSet, final int i) throws SQLException {

    final Manufacturer manufacturer = Manufacturer.builder()
        .id(resultSet.getLong("MANUFACTURER_ID"))
        .name(resultSet.getString("NAME"))
        .build();

    return CarModel.builder()
        .id(resultSet.getLong("CAR_MODEL_ID"))
        .model(resultSet.getString("MODEL_NAME"))
        .modelYear(resultSet.getInt("MODEL_YEAR"))
        .manufacturer(manufacturer)
        .category(CategoryConverter.from(resultSet, i))
        .build();

  }

}
