package com.dsid.viagem.demo.DadosCliente.service;

import com.dsid.viagem.demo.DadosCliente.repository.PersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbstractService {
    @Autowired
    PersistenceRepository repository;
}
