package com.pp.jobseeker.controllers;

import com.pp.jobseeker.models.Position;
import com.pp.jobseeker.models.dtos.CreatePositionDto;
import com.pp.jobseeker.models.dtos.SearchPositionDto;
import com.pp.jobseeker.repositories.services.AuthenticationService;
import com.pp.jobseeker.repositories.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.*;

@RequestMapping(value = "/position")
@RestController
public class PositionController {

    @Autowired
    PositionService positionService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> createPosition(@Valid @RequestBody CreatePositionDto createPositionDto)
            throws AuthenticationException {
        if (!authenticationService.validApiKey(createPositionDto.getApiKey())) {
            throw new AuthenticationException("Invalid API Key: " + createPositionDto.getApiKey());
        }
        Position createdPosition = positionService.createPosition(createPositionDto.toPosition());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPosition.getId())
                .toUri();
        return new ResponseEntity<>(Collections.singletonMap("URL", uri.toString()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<URI>>> searchPosition(@Valid @RequestBody SearchPositionDto searchPositionDto)
            throws AuthenticationException {
        if (!authenticationService.validApiKey(searchPositionDto.getApiKey())) {
            throw new AuthenticationException("Invalid API Key: " + searchPositionDto.getApiKey());
        }
        List<Long> searchResult = positionService.findPosition(
                searchPositionDto.getKeyword(),
                searchPositionDto.getLocation());

        List<URI> uriList = new ArrayList<>();
        searchResult.forEach(id -> {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/position/{id}")
                    .buildAndExpand(id)
                    .toUri();
            uriList.add(uri);
        });

        return new ResponseEntity<>(Collections.singletonMap("searchResults", uriList), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Position> getPosition(@PathVariable @NotNull @DecimalMin("0") Long id) {
        if (positionService.getPosition(id).isPresent()) {
            return new ResponseEntity<>(positionService.getPosition(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
