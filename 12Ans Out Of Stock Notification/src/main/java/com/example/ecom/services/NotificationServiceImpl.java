package com.example.ecom.services;

import com.example.ecom.exceptions.*;

import com.example.ecom.services.emailAdapter.SendGridAdapterApi;
import com.example.ecom.models.*;
import com.example.ecom.repositories.InventoryRepository;
import com.example.ecom.repositories.NotificationRepository;
import com.example.ecom.repositories.ProductRepository;
import com.example.ecom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService{
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private InventoryRepository inventoryRepository;
    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(UserRepository userRepository,
                                   ProductRepository productRepository,
                                   InventoryRepository inventoryRepository,
                                   NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
        this.notificationRepository = notificationRepository;

    }

    @Override
    public Notification registerUser(int userId, int productId) throws UserNotFoundException, ProductNotFoundException, ProductInStockException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!!");
        }

        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw  new ProductInStockException("Product not found!!");
        }

        Optional<Inventory> inventoryOptional = this.inventoryRepository.findByProduct(productOptional.get());
        if(inventoryOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found!!");
        }

        if(inventoryOptional.get().getQuantity()!=0){
            throw new ProductInStockException("Product is in stock..!");
        }

        //If quantity out of stock, create notification for registration
        Notification notification = new Notification();
        notification.setUser(userOptional.get());
        notification.setProduct(productOptional.get());
        notification.setStatus(NotificationStatus.PENDING);
        return notificationRepository.save(notification);
    }

    @Override
    public void deregisterUser(int userId, int notificationId) throws UserNotFoundException, NotificationNotFoundException, UnAuthorizedException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!!");
        }

        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
        if(notificationOptional.isEmpty()){
            throw new NotificationNotFoundException("Notification not found!!");
        }

        if(notificationOptional.get().getUser().getId()==userId){
            notificationRepository.delete(notificationOptional.get());
        }else{
            throw new UserNotFoundException("User not found!!");
        }

        return;
    }


}
