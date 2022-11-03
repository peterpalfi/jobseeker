package com.pp.jobseeker.controllers;

import com.pp.jobseeker.exceptions.ClientAlreadyExistsException;
import com.pp.jobseeker.models.dtos.RegisterClientDto;
import com.pp.jobseeker.repositories.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RequestMapping(value = "/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, UUID>> registerClient(@Valid @RequestBody RegisterClientDto registerClientDto)
            throws ClientAlreadyExistsException {
        if (clientService.clientAlreadyRegistered(registerClientDto.getEmail())) {
            throw new ClientAlreadyExistsException("Client already registered with email: " + registerClientDto.getEmail());
        }
        UUID registeredApiKey = clientService.registerClient(registerClientDto.toClient());
        return new ResponseEntity<>(Collections.singletonMap("API Key", registeredApiKey), HttpStatus.CREATED);
    }
}
