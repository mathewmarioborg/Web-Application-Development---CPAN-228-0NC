package com.example.Mathew.Borg.repository.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.example.Mathew.Borg.model.Clothing;
import com.example.Mathew.Borg.repository.ClothingRepository;

import java.time.Year;

@Repository
public class JdbcClothingRepository implements ClothingRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcClothingRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Iterable<Clothing> findAll(){
        return jdbcTemplate.query("SELECT * FROM clothing", new ClothingRowMapper());
    }

    @Override
    public Optional<Clothing> findById(Long id) {
        Clothing fighter = jdbcTemplate.queryForObject("SELECT * FROM clothing WHERE id = ?", new ClothingRowMapper(), id);
        return Optional.ofNullable(fighter);
    }

    @Override
    public void save(Clothing clothing){
        var insertClothing = "INSERT INTO clothing (name, brandForm, yearOfCreation, price) VALUES (?, ?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(insertClothing);
            ps.setString(1, clothing.getName());
            ps.setString(2, clothing.getBrandForm().name());
            ps.setInt(3, clothing.getYearOfCreation());
            ps.setDouble(4, clothing.getPrice());
            return ps;
        }, keyHolder);
    }
}
