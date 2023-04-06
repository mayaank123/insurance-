package com.example.Entites;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Client {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Override
		public String toString() {
			return "Client [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
					+ ", contactInfo=" + contactInfo + "]";
		}
		public Client(Long id, String name, LocalDate dateOfBirth, String address, String contactInfo) {
			super();
			this.id = id;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.contactInfo = contactInfo;
		}
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
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getContactInfo() {
			return contactInfo;
		}
		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}
		private String name;
	    private LocalDate dateOfBirth;
	    private String address;
	    private String contactInfo;
	    
}
