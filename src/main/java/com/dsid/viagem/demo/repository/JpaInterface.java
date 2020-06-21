package com.dsid.viagem.demo.repository;

import com.dsid.viagem.demo.Models.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JpaInterface extends JpaRepository<Cliente,String> {
}
