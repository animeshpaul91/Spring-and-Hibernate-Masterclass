package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CustomerRepository;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service // Spring will pick this up during Component Scanning
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository; // this is our DAO Handle

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from the DTO
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item)); // add purchase.OrderItems to order so that we can insert order to db

        // populate order with billing Address and shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippedAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();

        // check to see if this is an existing customer
        String email = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(email);

        if (customerFromDB != null) {
            // existing customer. Assign them accordingly
            customer = customerFromDB;
        }

        customer.addOrder(order);

        // save to database
        customerRepository.save(customer);

        // return response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID (UUID version-4) Universal Unique Identifier
        return UUID.randomUUID().toString();
    }
}
