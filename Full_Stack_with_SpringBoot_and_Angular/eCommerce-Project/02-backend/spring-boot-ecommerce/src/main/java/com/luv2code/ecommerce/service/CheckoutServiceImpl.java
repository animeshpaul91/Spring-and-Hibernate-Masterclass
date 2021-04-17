package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CustomerRepository;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

        // populate order with billing Address and shipping address

        // populate customer with order

        // save to database

        // return response
        return null;
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID (UUID version-4) Universal Unique Identifier

    }
}
