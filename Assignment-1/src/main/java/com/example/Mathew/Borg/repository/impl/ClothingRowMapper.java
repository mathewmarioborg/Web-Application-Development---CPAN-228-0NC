package com.example.Mathew.Borg.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

import org.springframework.jdbc.core.RowMapper;

import com.example.Mathew.Borg.model.Clothing;


public class ClothingRowMapper implements RowMapper<Clothing>{

    @Override
    public Clothing mapRow(ResultSet rs, int row) throws SQLException{
        return Clothing.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .brandForm(Clothing.Brand.valueOf(rs.getString("brandForm")))
                .yearOfCreation(rs.getInt("yearOfCreation"))
                .price(rs.getDouble("price"))
                .build();
    }
}
