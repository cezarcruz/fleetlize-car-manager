package com.fleetlize.webapp.gateways.database.repositories;

import com.fleetlize.webapp.entities.Manufacturer;
import com.fleetlize.webapp.gateways.database.repositories.converters.ManufacturerConverter;
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
public class ManufacturerRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public Manufacturer create(final Manufacturer manufacturer) {

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final Timestamp creationDate = new Timestamp(new Date().getTime());
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("NAME", manufacturer.getName());
        params.addValue("CREATION_DATE", creationDate);

        final String sql = "INSERT INTO MANUFACTURER (NAME, CREATION_DATE) VALUES (:NAME, :CREATION_DATE)";

        jdbcTemplate.update(sql, params, keyHolder);

        final Long id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

        return manufacturer.toBuilder().creationDate(creationDate).id(id).build();

    }

    public List<Manufacturer> list() {
        final String sql = "SELECT MANUFACTURER_ID, NAME, CREATION_DATE, UPDATE_DATE FROM MANUFACTURER";
        return jdbcTemplate.query(sql, ManufacturerConverter::convert);
    }
}
