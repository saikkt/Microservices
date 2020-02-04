package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.ShippingRates;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ShippingRatesRowMapper implements RowMapper<ShippingRates> {

    @Override
    public ShippingRates mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShippingRates shippingRates = new ShippingRates(rs.getLong("ShippingRateID"));

        //shippingRates.setId(rs.getLong("ShippingRateID"));
        shippingRates.setCountry(rs.getString("Country"));
        shippingRates.setFlatRate(rs.getLong("FlatRate"));
        shippingRates.setVersion(rs.getLong("Version"));

        return shippingRates;
    }
}
