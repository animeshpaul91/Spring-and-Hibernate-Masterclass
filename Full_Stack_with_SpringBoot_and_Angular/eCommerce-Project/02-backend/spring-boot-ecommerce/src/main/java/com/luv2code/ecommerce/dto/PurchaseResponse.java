package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data // creates constructor for final fields
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
