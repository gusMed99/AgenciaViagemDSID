package com.dsid.viagem.demo.restController;

import com.dsid.viagem.demo.Models.Entities.Cliente;
import com.dsid.viagem.demo.repository.PersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {

    @Autowired
    PersistenceRepository repository;



    @PostMapping(path= "/cadastro", consumes = "application/json", produces = "application/json")
    public String cadastraCliente(@RequestBody Cliente cliente){
            if (repository.insertData(cliente)) {
               return new  String("Cliente cadastrado com sucesso");
            } else {
                return new String("Cadastro invalido. Cliente já cadastrado");
            }
    }

    @GetMapping("/teste")
    public String test(){
        return "";
    }
}
