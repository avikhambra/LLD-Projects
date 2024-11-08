package com.example.ecom.services;

import com.example.ecom.exceptions.OrderCannotBeCancelledException;
import com.example.ecom.exceptions.OrderDoesNotBelongToUserException;
import com.example.ecom.exceptions.OrderNotFoundException;
import com.example.ecom.exceptions.UserNotFoundException;
import com.example.ecom.models.*;
import com.example.ecom.repositories.InventoryRepository;
import com.example.ecom.repositories.OrderDetailRepository;
import com.example.ecom.repositories.OrderRepository;
import com.example.ecom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements  OrderService{
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private InventoryRepository inventoryRepository;

    @Autowired
    public OrderServiceImpl(UserRepository userRepository,
                            OrderRepository orderRepository,
                            OrderDetailRepository orderDetailRepository,
                            InventoryRepository inventoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.inventoryRepository = inventoryRepository;
    }



    @Override
    public Order cancelOrder(int orderId, int userId) throws UserNotFoundException, OrderNotFoundException, OrderDoesNotBelongToUserException, OrderCannotBeCancelledException {

        Optional<User> userOptional =userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }

        Optional<Order> orderOptional =orderRepository.findById(orderId);
        if(orderOptional.isEmpty()){
            throw new OrderNotFoundException("Order not found!");
        }

        Order userOrder =  orderOptional.get();
        //Check if order belongs to particular user or not
        if(userOrder.getUser().getId() !=userId ){
            throw new OrderDoesNotBelongToUserException("Order does not belong to user!");
        }


        //An order cannot be cancelled if its in SHIPPED or DELIVERED or CANCELLED state.

            List<OrderDetail> orderDetails = orderDetailRepository.findByOrder(userOrder);
            if(orderDetails == null || orderDetails.size()==0 ){
                throw new OrderNotFoundException("Order details not found!");
            }

            if( userOrder.getOrderStatus().equals(OrderStatus.SHIPPED) ||
                    userOrder.getOrderStatus().equals(OrderStatus.DELIVERED )||
                    userOrder.getOrderStatus().equals(OrderStatus.CANCELLED) ){
                throw new OrderCannotBeCancelledException("Order can not be cancelled!");
            }

            try{
                Order cancelledOrder = cancellingOrder(orderDetails, userOrder);
                return cancelledOrder;
            }catch (OrderNotFoundException orderNotFoundException){
                System.out.println("While cancelling, order not found!!");
            }

            return userOrder;
        }


    public Order cancellingOrder(List<OrderDetail> orderDetails, Order userOrder) throws OrderNotFoundException {

        for (OrderDetail od : orderDetails) {

            Product cancelledProduct = od.getProduct();
            int cancelledQuantity = od.getQuantity();

            synchronized(cancelledProduct){

               Optional<Inventory> inventoryOptional = inventoryRepository.findByProduct(cancelledProduct);

               Inventory updatedInventory = inventoryOptional.get();
               updatedInventory.setQuantity(updatedInventory.getQuantity() + cancelledQuantity);
               inventoryRepository.save(updatedInventory);

            }

            //orderDetailRepository.delete(od);

        }

        //Marking order status as cancelled
        userOrder.setOrderStatus(OrderStatus.CANCELLED);

        return orderRepository.save(userOrder);

    }
}
