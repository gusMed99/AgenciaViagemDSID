package com.dsid.viagem.demo.DadosCliente.repository;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface JpaInterface extends JpaRepository<Cliente,String> {

    @Query(value = "SELECT * FROM cliente WHERE email = :email", nativeQuery = true)
    List<Cliente> clientsByEmail(@Param("email") String email);


 }
