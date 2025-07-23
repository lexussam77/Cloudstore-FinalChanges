package com.cloudstore.controller;

import com.cloudstore.dto.StoragePurchaseRequest;
import com.cloudstore.service.StorageUpgradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/storage")
public class StoragePurchaseController {
    private final StorageUpgradeService storageUpgradeService;

    public StoragePurchaseController(StorageUpgradeService storageUpgradeService) {
        this.storageUpgradeService = storageUpgradeService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseStorage(@RequestBody StoragePurchaseRequest request) {
        // Simulate payment always successful
        Long bonusBytes = request.getAmount() * 50_000_000L; // 1 GHS = 50MB
        boolean upgraded = storageUpgradeService.upgradeStorage(request.getUserEmail(), bonusBytes);
        if (upgraded) {
            return ResponseEntity.ok("✅ Storage upgraded by " + (bonusBytes / 1_000_000) + " MB.");
        } else {
            return ResponseEntity.badRequest().body("❌ User not found.");
        }
    }
}
