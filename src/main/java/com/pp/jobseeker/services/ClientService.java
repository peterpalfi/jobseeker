package com.pp.jobseeker.services;

import com.pp.jobseeker.models.Client;
import com.pp.jobseeker.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public UUID registerClient(Client client) {
        clientRepository.save(client);
        return client.getApiKey();
    }

    public boolean clientAlreadyRegistered(String email) {
        return clientRepository.findClientByEmail(email).isPresent();
    }
}
