package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entites.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
