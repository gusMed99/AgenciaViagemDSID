package com.dsid.viagem.demo.DadosCliente.repository;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JpaInterface extends JpaRepository<Cliente,String> {
}
