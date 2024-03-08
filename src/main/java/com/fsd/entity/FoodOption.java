package com.fsd.entity;
//import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class FoodOption {
    public FoodOption() {
		super();
	}

	public FoodOption(Long id, String name, double price, String description, Event event,
			List<Registration> registrations) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.event = event;
		this.registrations = registrations;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonIgnore
    @ManyToMany(mappedBy = "foodOptions")
    private List<Registration> registrations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "FoodOption [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", event=" + event + ", registrations=" + registrations + "]";
	}

    // Constructors, getters, and setters
}
