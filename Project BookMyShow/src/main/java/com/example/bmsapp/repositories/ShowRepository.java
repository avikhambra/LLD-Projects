package com.example.bmsapp.repositories;

import com.example.bmsapp.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
