package com.fleetlize.webapp.gateways.database.repositories.converters;

import com.fleetlize.webapp.entities.Category;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryConverter {

  public static Category from(final ResultSet resultSet, final int row) throws SQLException {
    final int dailyPrice = resultSet.getInt("DAILY_PRICE");
    return Category.builder()
        .id(resultSet.getLong("CATEGORY_ID"))
        .name(resultSet.getString("CATEGORY_NAME"))
        .dailyPrice(BigDecimal.valueOf((double) dailyPrice / 100)) //FIXME - float problem ;)
        .build();
  }
}
