package com.example.Entites;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private String claimStatus;
    
    @ManyToOne
    private InsurancePolicy insurancePolicy;

	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimNumber=" + claimNumber + ", description=" + description + ", claimDate="
				+ claimDate + ", claimStatus=" + claimStatus + ", insurancePolicy=" + insurancePolicy + "]";
	}

	public Claim(Long id, String claimNumber, String description, LocalDate claimDate, String claimStatus,
			InsurancePolicy insurancePolicy) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.insurancePolicy = insurancePolicy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}
    
    // Constructor, getters and setters
}