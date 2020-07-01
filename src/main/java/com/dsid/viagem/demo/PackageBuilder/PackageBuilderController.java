package com.dsid.viagem.demo.PackageBuilder;

import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesAeroportosSerivce;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PackageBuilderController {

    @Autowired
   private PackageBuilderService packageBuilderService;

    @GetMapping(path="/teste3",consumes = "application/json", produces = "application/json")
    public String testeCaller2() throws JsonProcessingException, UnirestException {
        String query="Guarulhos";
        packageBuilderService.getPackages(query,"10");
       return null;
    }
}
