package com.cloudstore.dto;

import lombok.Data;

@Data
public class StoragePurchaseRequest {
    private String userEmail;
    private String phoneNumber;
    private int amount; // Amount in GHS
    private String network; // e.g., "MTN", "AirtelTigo"
    private String txRef; // Transaction reference
} 