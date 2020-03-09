package com.fleetlize.webapp.gateways.database.repositories;

import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.database.Queries;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@Repository
public class CarRepository {

  private NamedParameterJdbcTemplate jdbcTemplate;

  public CarRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Car insert(final Car car) {

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final Timestamp creationDate = new Timestamp(new Date().getTime());
    final MapSqlParameterSource params = new MapSqlParameterSource();

    params.addValue("MILEAGE", car.getMileage());
    params.addValue("PLATE", car.getPlate());
    params.addValue("CAR_MODEL", car.getCarModel().getId());
    params.addValue("CREATION_DATE", creationDate);

    jdbcTemplate.update(Queries.INSERT_CAR, params, keyHolder);

    final Long id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
    log.debug("car insert successfully with id {}", id);

    return car.toBuilder().creationDate(creationDate).id(id).build();

  }
}
