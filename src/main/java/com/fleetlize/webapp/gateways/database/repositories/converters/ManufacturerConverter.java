package com.fleetlize.webapp.gateways.database.repositories.converters;

import com.fleetlize.webapp.entities.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerConverter {

    public static Manufacturer convert(final ResultSet resultSet, final int row) throws SQLException {

        return Manufacturer.builder()
                .id(resultSet.getLong("MANUFACTURER_ID"))
                .name(resultSet.getString("NAME"))
                .creationDate(resultSet.getTimestamp("CREATION_DATE"))
                .updateDate(resultSet.getTimestamp("UPDATE_DATE"))
                .build();

    }

}
