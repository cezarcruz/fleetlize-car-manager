package com.fleetlize.webapp.gateways.database.repositories;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.database.Queries;
import com.fleetlize.webapp.gateways.database.repositories.converters.CarModelConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class CarModelRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CarModel insert(final CarModel carModel) {

        log.debug("inserting new car model {}", carModel);

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final Timestamp creationDate = new Timestamp(new Date().getTime());
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("MODEL_NAME", carModel.getModel());
        params.addValue("MANUFACTURER_ID", carModel.getManufacturer().getId());
        params.addValue("CREATION_DATE", creationDate);
        params.addValue("MODEL_YEAR", carModel.getModelYear());

        jdbcTemplate.update(Queries.INSERT_CAR_MODEL, params, keyHolder);

        final Long id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

        log.debug("car model insert successfully with id {}", id);

        return carModel.toBuilder().id(id).creationDate(creationDate).build();
    }

    public List<CarModel> list() {
        log.debug("listing all car model");
        return jdbcTemplate.query(Queries.FIND_CAR_MODEL, new MapSqlParameterSource(), CarModelConverter::from);
    }

    public Optional<CarModel> findById(final Long id) {

        log.debug("finding car model by id = {}", id);

        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID", id);

        //TODO: may change this ofNullable
        return Optional.ofNullable(jdbcTemplate.queryForObject(Queries.FIND_CAR_MODEL_BY_ID, params, CarModelConverter::from));
    }

    public void delete(final Long id) {

        log.debug("deleting car model = {}", id);

        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID", id);

        jdbcTemplate.update(Queries.DELETE_CAR_MODEL_BY_ID, params);

    }

    public void update(final CarModel carModel) {

        log.debug("updating car model id = {}", carModel.getId());

        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID", carModel.getId());
        params.addValue("MANUFACTURER_ID", carModel.getManufacturer().getId());
        params.addValue("MODEL_NAME", carModel.getModel());
        params.addValue("MODEL_YEAR", carModel.getModelYear());
        params.addValue("UPDATE_DATE", new Timestamp(new Date().getTime()));

        jdbcTemplate.update(Queries.UPDATE_CAR_MODEL, params);

    }
}
