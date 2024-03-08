package com.fsd.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="payments")
public class Payment {
    public Payment(Long id, double amount, LocalDateTime paymentDate, String paymentMethod, Registration registration) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.registration = registration;
	}

	public Payment() {
		super();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime localDateTime) {
		this.paymentDate = localDateTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", paymentDate=" + paymentDate + ", paymentMethod="
				+ paymentMethod + ", registration=" + registration + "]";
	}

    
}
