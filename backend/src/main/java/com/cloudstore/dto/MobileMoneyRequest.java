package com.cloudstore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MobileMoneyRequest {
    private String phoneNumber;
    private String amount;
    private String currency;
    private String network;
    private String email;
    private String txRef;
} 