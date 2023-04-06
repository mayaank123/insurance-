package com.example.Entites;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", policyNumber=" + policyNumber + ", type=" + type + ", coverageAmount="
				+ coverageAmount + ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", client=" + client + "]";
	}

	public InsurancePolicy(Long id, String policyNumber, String type, BigDecimal coverageAmount, BigDecimal premium,
			LocalDate startDate, LocalDate endDate, Client client) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(BigDecimal coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private String policyNumber;
    private String type;
    private BigDecimal coverageAmount;
    private BigDecimal premium;
    private LocalDate startDate;
    private LocalDate endDate;
    
    @ManyToOne
    private Client client;
}
    