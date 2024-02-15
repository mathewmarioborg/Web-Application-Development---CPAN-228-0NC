package com.example.Mathew.Borg.repository;

import java.util.Iterator;
import java.util.Optional;

import com.example.Mathew.Borg.model.Clothing;

public interface ClothingRepository {
    Iterable<Clothing> findAll();

    Optional<Clothing> findById(Long id);

    void save(Clothing clothing);
}
