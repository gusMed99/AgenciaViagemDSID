package com.dsid.viagem.demo.repository;

import com.dsid.viagem.demo.Models.Entities.Cliente;


public interface PersistenceRepository {
    public boolean insertData(Cliente cliente);
    public boolean deleteData(Cliente cliente);
    public Cliente getEntity(String email);
    public boolean updateEntity(Cliente cliente);
}
