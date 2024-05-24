package com.example.pharmacy_spring_boot.service;

import com.example.pharmacy_spring_boot.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

}
