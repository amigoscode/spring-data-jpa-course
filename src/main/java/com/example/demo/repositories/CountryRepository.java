package com.example.demo.repositories;

import com.example.demo.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    public Country findByCountryId(Long countryId);
}
