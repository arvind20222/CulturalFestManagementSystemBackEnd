package com.fsd.service;

import com.fsd.entity.Event;
import com.fsd.entity.Payment;
import com.fsd.entity.Registration;
import com.fsd.entity.User;
import com.fsd.repository.EventRepository;
import com.fsd.repository.RegistrationRepository;
import com.fsd.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

	private final RegistrationRepository registrationRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.registrationRepository = registrationRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Registration createRegistration(Long eventId, Long userId, int numberOfAdults, int numberOfChildren) {
        // Retrieve the Event from the database
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Event not found with ID: " + eventId);
        }
        Event event = eventOptional.get();

        // Retrieve the User from the database
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        User user = userOptional.get();
        // Create a new Registration object
        Registration registration = new Registration();
        registration.setNumberOfAdults(numberOfAdults);
        registration.setNumberOfChildren(numberOfChildren);
        registration.setUser(user);
         registration.setEvent(event);

        // Save the Registration object to the database
        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }


     
    
}
