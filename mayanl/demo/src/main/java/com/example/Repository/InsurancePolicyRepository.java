package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entites.InsurancePolicy;
 
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {

}
