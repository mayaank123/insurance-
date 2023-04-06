package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Entites.Client;
import com.example.Repository.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    
    @Autowired
    private ClientRepository clientRepository;
    
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }
    
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientRequest) {
        return clientRepository.findById(id).map(client -> {
            client.setName(clientRequest.getName());
            client.setDateOfBirth(clientRequest.getDateOfBirth());
            client.setAddress(clientRequest.getAddress());
            client.setContactInfo(clientRequest.getContactInfo());
            return clientRepository.save(client);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }
    
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}