package com.example.ecom.repositories;


import com.example.ecom.models.Inventory;
import com.example.ecom.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    Optional<Inventory> findByProduct(Product product);

    @Override
     Inventory  save(Inventory entity);
}
