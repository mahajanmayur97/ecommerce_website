package dev.mayur.productcatalogue.repositories;

import dev.mayur.productcatalogue.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, UUID> {

    @Override
    void deleteById(UUID uuid);

    long countAllByPrice_Currency(String currency);

    List<Product> findAllByPrice_Currency(String currency);

    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String mayur);
}