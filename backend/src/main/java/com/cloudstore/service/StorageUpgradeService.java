package com.cloudstore.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cloudstore.model.User;
import com.cloudstore.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class StorageUpgradeService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean upgradeStorage(String userEmail, long bonusBytes) {
        Optional<User> userOpt = userRepository.findByEmail(userEmail);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setStorageQuota(user.getStorageQuota() + bonusBytes);
            userRepository.save(user);
            return true;
        }
        return false;
    }
} 