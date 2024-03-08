package com.fsd.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Registration {
    public Registration() {
		super();
	}

	public Registration(Long id, int numberOfAdults, int numberOfChildren, User user, Event event, 
			List<FoodOption> foodOptions, Payment payment) {
		super();
		this.id = id;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.user = user;
		this.event = event;
		
		this.foodOptions = foodOptions;
		this.payment = payment;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfAdults;
    private int numberOfChildren;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    
//    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
//    private QRCode qrCode;


    @ManyToMany
    @JoinTable(name = "registration_food_option",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "food_option_id"))
    private List<FoodOption> foodOptions;

    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    private Payment payment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

//	public QRCode getQrCode() {
//		return qrCode;
//	}
//
//	public void setQrCode(QRCode qrCode) {
//		this.qrCode = qrCode;
//	}

	public List<FoodOption> getFoodOptions() {
		return foodOptions;
	}

	public void setFoodOptions(List<FoodOption> foodOptions) {
		this.foodOptions = foodOptions;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", numberOfAdults=" + numberOfAdults + ", numberOfChildren="
				+ numberOfChildren + ", user=" + user + ", event=" + event  + ", foodOptions="
				+ foodOptions + ", payment=" + payment + "]";
	}

    
}
