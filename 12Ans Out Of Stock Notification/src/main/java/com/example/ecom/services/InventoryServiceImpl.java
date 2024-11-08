package com.example.ecom.services;

import com.example.ecom.exceptions.ProductNotFoundException;
import com.example.ecom.models.*;
import com.example.ecom.repositories.InventoryRepository;
import com.example.ecom.repositories.NotificationRepository;
import com.example.ecom.repositories.ProductRepository;
import com.example.ecom.services.emailAdapter.SendEmailAdapter;
import com.example.ecom.services.emailAdapter.SendGridAdapterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{

    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    private NotificationRepository notificationRepository;
    private SendEmailAdapter sendEmailAdapter;


    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository,
                                ProductRepository productRepository,
                                NotificationRepository notificationRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.notificationRepository = notificationRepository;
        sendEmailAdapter = new SendGridAdapterApi();

    }

    public Inventory updateInventory(int productId, int quantity) throws ProductNotFoundException {
        Product product = this.productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Optional<Inventory> inventoryOptional = this.inventoryRepository.findByProduct(product);
        Inventory inventory;
        if(inventoryOptional.isEmpty()){
            inventory = new Inventory();
            inventory.setProduct(product);
            inventory.setQuantity(quantity);
            return this.inventoryRepository.save(inventory);
        }
        inventory = inventoryOptional.get();
        inventory.setQuantity(inventory.getQuantity() + quantity);
        this.inventoryRepository.save(inventory);

        if(inventory.getQuantity() ==0){
            return inventory;
        }

        List<Notification> notifications = notificationRepository.findByProduct(product);


        for(Notification n: notifications){

            User registeredUser = n.getUser();
            String email = registeredUser.getEmail();
            String subject = product.getName() + " back in stock! ";
            String body = "Dear " + registeredUser.getName() + ", " + product.getName();

            sendEmailAdapter.sendEmailAsync(email, subject, body);
            n.setStatus(NotificationStatus.SENT);
            notificationRepository.save(n);

        }


        return inventory;
    }

}
