 package com.example.Controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Entites.Claim;
import com.example.Entites.Client;
import com.example.Repository.ClaimRepository;
import com.example.Repository.ClientRepository;
@Controller
public class ClaimController {

	private ClientRepository clientRepository ;
	private ClaimRepository claimRepository;
	@GetMapping("/claims")
	public List<Claim> getAllClaims() {
	    return claimRepository.findAll();
	}
	@GetMapping("/claims/{id}")
	public String getClaimById(@PathVariable(value = "id") Long claimId)
	        {
	    return "claim";
	}
	@PostMapping("/claims")
	public Claim createClaim(@RequestBody Claim claim) {
	    return claimRepository.save(claim);
	}
	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable(value = "id") Long claimId,
	                                            @RequestBody Claim claimDetails) throws AttributeNotFoundException {
	    Claim claim = claimRepository.findById(claimId)
	            .orElseThrow();

	    claim.setDescription(claimDetails.getDescription());
	    claim.setClaimDate(claimDetails.getClaimDate());
	    claim.setClaimStatus(claimDetails.getClaimStatus());

	    final Claim updatedClaim = claimRepository.save(claim);
	    return ResponseEntity.ok(updatedClaim);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) throws AttributeNotFoundException {
	    Optional<Client> client = clientRepository.findById(id);
	    if (!client.isPresent()) {
	        throw new AttributeNotFoundException("Client not found with id " + id);
	    }
	    clientRepository.delete(client.get());
	    return ResponseEntity.ok().build();
	}

	 
}
