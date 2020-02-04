package com.northwind.shippingservice.repositories.impl;

import com.northwind.shippingservice.api.ShippingRatesRowMapper;
import com.northwind.shippingservice.domain.ShippingRates;
import com.northwind.shippingservice.repositories.ShippingRatesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class ShippingRatesRepositoryImpl implements ShippingRatesRepository {

    private final DataSource dataSource;
    private ShippingRatesRowMapper shippingRatesRowMapper;

    public ShippingRatesRepositoryImpl(DataSource dataSource,ShippingRatesRowMapper shippingRatesRowMapper) {
        this.dataSource = dataSource;
        this.shippingRatesRowMapper = shippingRatesRowMapper;
    }


    @Override
    public List<ShippingRates> getByCountry(String country) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String sql =  "SELECT `ShippingRates`.`ShippingRateID`,\n" +
                "    `ShippingRates`.`Country`,\n" +
                "    `ShippingRates`.`FlatRate`,\n" +
                "    `ShippingRates`.`Version`,\n" +
                "    `ShippingRates`.`ObjectID`\n" +
                "FROM `shipping-db`.`ShippingRates`\n" +
                "WHERE Country LIKE :country";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("country",country+"%");

        List<ShippingRates> shippingRates = template.query(sql,parameterSource,shippingRatesRowMapper);

        return shippingRates;

    }

    @Override
    public ShippingRates getById(long id) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String sql =  "SELECT `ShippingRates`.`ShippingRateID`,\n" +
                "    `ShippingRates`.`Country`,\n" +
                "    `ShippingRates`.`FlatRate`,\n" +
                "    `ShippingRates`.`Version`,\n" +
                "    `ShippingRates`.`ObjectID`\n" +
                "FROM `shipping-db`.`ShippingRates`\n" +
                "WHERE ShippingRateID = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id",id);

        ShippingRates shippingRates = template.queryForObject(sql,parameterSource,shippingRatesRowMapper);

        return shippingRates;
    }

    @Override
    public List<ShippingRates> getAll(int offSet, int limit) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String sql = "SELECT `ShippingRates`.`ShippingRateID`,\n" +
                "    `ShippingRates`.`Country`,\n" +
                "    `ShippingRates`.`FlatRate`,\n" +
                "    `ShippingRates`.`Version`,\n" +
                "    `ShippingRates`.`ObjectID`\n" +
                "FROM `shipping-db`.`ShippingRates`\n" +
                "LIMIT :offset, :limit";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("offset",offSet)
                .addValue("limit",limit);
        List<ShippingRates> shippingRates = template.query(sql,parameterSource,shippingRatesRowMapper);
        return shippingRates;
    }

    @Override
    public ShippingRates save(ShippingRates entity) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
        //        .addValue("id",entity.getId())
                .addValue("country",entity.getCountry())
                .addValue("flatRate",entity.getFlatRate());

        if(entity.getId()==0){
        String sql = "INSERT INTO `shipping-db`.`ShippingRates`\n" +
                "(`Country`,`FlatRate`) VALUES" +
                "(:country,:flatRate)" ;
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(sql,parameterSource,keyHolder);
            return getById(keyHolder.getKey().longValue());
        }
        else{
            String sql = "UPDATE `shipping-db`.`ShippingRates`\n" +
                    "SET\n" +
                    "`ShippingRateID` = :id,\n" +
                    "`Country` = :country,\n" +
                    "`FlatRate` = :flatRate,\n" +
                    "`Version` = Version + 1\n" +
                    "WHERE `ShippingRateID` = :id AND `Version` = :version;";

            parameterSource.addValue("id",entity.getId()).addValue("version",entity.getVersion());

            int rowsAffected = template.update(sql,parameterSource);
            if(rowsAffected == 0){
                throw new IllegalArgumentException("Concurrent Modification Exception");
            }
            return getById(entity.getId());
        }

    }

    @Override
    public void delete(long id) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id",id);
        template.update("delete from `shipping-db`.`ShippingRates` where `ShippingRateID` = :id",parameterSource);
    }
}
