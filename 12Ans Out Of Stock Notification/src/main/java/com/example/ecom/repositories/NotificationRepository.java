package com.example.ecom.repositories;

import com.example.ecom.models.Notification;
import com.example.ecom.models.Product;
import com.example.ecom.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Override
    Optional<Notification> findById(Integer notificationId);
  
    List<Notification> findByProduct(Product product);

    @Override
    Notification save(Notification notification);

    @Override
    void delete(Notification notification);
}
