package com.fleetlize.webapp.gateways.database.repositories;

import com.fleetlize.webapp.entities.CarModel;
import com.fleetlize.webapp.gateways.database.repositories.converters.CarModelConverter;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
@AllArgsConstructor
public class CarModelRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CarModel insert(final CarModel carModel) {

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final Timestamp creationDate = new Timestamp(new Date().getTime());
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("MODEL_NAME", carModel.getModel());
        params.addValue("MANUFACTURER_ID", carModel.getManufacturer().getId());
        params.addValue("CREATION_DATE", creationDate);
        params.addValue("MODEL_YEAR", carModel.getModelYear());

        final String sql = "INSERT INTO CAR_MODEL (MANUFACTURER_ID, MODEL_NAME, CREATION_DATE, MODEL_YEAR) " +
                            "VALUES (:MANUFACTURER_ID, :MODEL_NAME, :CREATION_DATE, :MODEL_YEAR)";

        jdbcTemplate.update(sql, params, keyHolder);

        final Long id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

        return carModel.toBuilder().id(id).creationDate(creationDate).build();
    }

    public List<CarModel> list() {
        final String sql = "SELECT CM.ID AS MODEL_ID, CM.MANUFACTURER_ID, MA.NAME, CM.MODEL_NAME, CM.MODEL_YEAR, CM.CREATION_DATE, CM.UPDATE_DATE FROM CAR_MODEL CM " +
                "INNER JOIN MANUFACTURER MA ON MA.MANUFACTURER_ID = CM.MANUFACTURER_ID ";

        final List<CarModel> query = jdbcTemplate.query(sql, new MapSqlParameterSource(), CarModelConverter::from);

        return query;
    }
}
