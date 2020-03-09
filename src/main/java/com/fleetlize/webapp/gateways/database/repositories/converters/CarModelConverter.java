package com.fleetlize.webapp.gateways.database.repositories.converters;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.entities.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarModelConverter {

  private CarModelConverter() {
  }

  public static CarModel from(final ResultSet resultSet, final int i) throws SQLException {

    final Manufacturer manufacturer = Manufacturer.builder()
        .id(resultSet.getLong("MANUFACTURER_ID"))
        .name(resultSet.getString("NAME"))
        .creationDate(resultSet.getObject("MA_CREATION_DATE") != null ? resultSet.getTimestamp("MA_CREATION_DATE") : null)
        .updateDate(resultSet.getObject("MA_UPDATE_DATE") != null ? resultSet.getTimestamp("MA_UPDATE_DATE") : null)
        .build();

    return CarModel.builder()
        .id(resultSet.getLong("MODEL_ID"))
        .model(resultSet.getString("MODEL_NAME"))
        .modelYear(resultSet.getInt("MODEL_YEAR"))
        .creationDate(resultSet.getObject("CREATION_DATE") != null ? resultSet.getTimestamp("CREATION_DATE") : null)
        .updateDate(resultSet.getObject("UPDATE_DATE") != null ? resultSet.getTimestamp("UPDATE_DATE") : null)
        .manufacturer(manufacturer)
        .build();


  }

}
