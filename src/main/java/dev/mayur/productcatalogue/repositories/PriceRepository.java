package dev.mayur.productcatalogue.repositories;


import dev.mayur.productcatalogue.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository
        extends JpaRepository<Price, Long> {
}
