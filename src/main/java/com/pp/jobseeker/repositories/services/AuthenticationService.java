package com.pp.jobseeker.repositories.services;

import com.pp.jobseeker.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {

    @Autowired
    ClientRepository clientRepository;

    public boolean validApiKey(String apiKey) {
        return clientRepository.findClientByApiKey(UUID.fromString(apiKey)).isPresent();
    }
}
