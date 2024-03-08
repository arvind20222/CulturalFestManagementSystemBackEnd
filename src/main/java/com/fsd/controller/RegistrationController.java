package com.fsd.controller;

import com.fsd.entity.Registration;
import com.fsd.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

	private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/create/{eventId}/{userId}")
    public ResponseEntity<Registration> createRegistration(
            @PathVariable Long eventId,
            @PathVariable Long userId,
            @RequestParam int numberOfAdults,
            @RequestParam int numberOfChildren) {
        try {
            Registration registration = registrationService.createRegistration(eventId, userId, numberOfAdults, numberOfChildren);
            return new ResponseEntity<>(registration, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Registration registration = registrationService.getRegistrationById(id);
        if (registration != null) {
            return new ResponseEntity<>(registration, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
