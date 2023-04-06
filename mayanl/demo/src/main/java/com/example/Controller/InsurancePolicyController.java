package com.example.Controller;

import java.util.List;
import java.util.Map;
 

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RestController;

import com.example.Entites.InsurancePolicy;
import com.example.Repository.InsurancePolicyRepository;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyRepository policyRepository;

    @GetMapping
    public List<InsurancePolicy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable(value = "id") Long policyId)
            throws AttributeNotFoundException {
        InsurancePolicy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new AttributeNotFoundException("Policy not found for this id :: " + policyId));
        return ResponseEntity.ok().body(policy);
    }

    @PostMapping
    public InsurancePolicy createPolicy(@Validated @RequestBody InsurancePolicy policy) {
        return policyRepository.save(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable(value = "id") Long policyId,
                                                         @Validated @RequestBody InsurancePolicy policyDetails) throws AttributeNotFoundException {
        InsurancePolicy policy = policyRepository.findById(policyId)
                .orElseThrow();

        policy.setPolicyNumber(policyDetails.getPolicyNumber());
        policy.setType(policyDetails.getType());
        policy.setCoverageAmount(policyDetails.getCoverageAmount());
        policy.setPremium(policyDetails.getPremium());
        policy.setStartDate(policyDetails.getStartDate());
        policy.setEndDate(policyDetails.getEndDate());
        policy.setClient(policyDetails.getClient());

        final InsurancePolicy updatedPolicy = policyRepository.save(policy);
        return ResponseEntity.ok(updatedPolicy);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePolicy(@PathVariable(value = "id") Long policyId)
            throws AttributeNotFoundException {
        InsurancePolicy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new AttributeNotFoundException("Policy not found for this id :: " + policyId));

        policyRepository.delete(policy);
		return null;
        
    }

    
}
