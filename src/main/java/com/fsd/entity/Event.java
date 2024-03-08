package com.fsd.entity;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String time;
    private double entryFee;
    private String lastRegistrationDate;
    private boolean foodIncluded;
    private double foodPriceAdult;
    private double foodPriceChild;

//    @JsonIgnore
//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//    private List<Registration> registrations;

    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodOption> foodOptions;

    public Event() {
    }

    public Event(Long id, String name, String description, LocalDate startDate, LocalDate endDate, String time, double entryFee, String lastRegistrationDate, boolean foodIncluded, double foodPriceAdult, double foodPriceChild, List<Registration> registrations, List<FoodOption> foodOptions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.entryFee = entryFee;
        this.lastRegistrationDate = lastRegistrationDate;
        this.foodIncluded = foodIncluded;
        this.foodPriceAdult = foodPriceAdult;
        this.foodPriceChild = foodPriceChild;
        
        this.foodOptions = foodOptions;
    }

    // Getters and Setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public String getLastRegistrationDate() {
        return lastRegistrationDate;
    }

    public void setLastRegistrationDate(String lastRegistrationDate) {
        this.lastRegistrationDate = lastRegistrationDate;
    }

    public boolean isFoodIncluded() {
        return foodIncluded;
    }

    public void setFoodIncluded(boolean foodIncluded) {
        this.foodIncluded = foodIncluded;
    }

    public double getFoodPriceAdult() {
        return foodPriceAdult;
    }

    public void setFoodPriceAdult(double foodPriceAdult) {
        this.foodPriceAdult = foodPriceAdult;
    }

    public double getFoodPriceChild() {
        return foodPriceChild;
    }

    public void setFoodPriceChild(double foodPriceChild) {
        this.foodPriceChild = foodPriceChild;
    }

    

    public List<FoodOption> getFoodOptions() {
        return foodOptions;
    }

    public void setFoodOptions(List<FoodOption> foodOptions) {
        this.foodOptions = foodOptions;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", time='" + time + '\'' +
                ", entryFee=" + entryFee +
                ", lastRegistrationDate='" + lastRegistrationDate + '\'' +
                ", foodIncluded=" + foodIncluded +
                ", foodPriceAdult=" + foodPriceAdult +
                ", foodPriceChild=" + foodPriceChild +
                
                ", foodOptions=" + foodOptions +
                '}';
    }
}
