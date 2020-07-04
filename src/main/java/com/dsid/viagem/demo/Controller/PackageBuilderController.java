package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.PackageBuilder.service.PackageBuilderService;
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
        String destino= "Goiania";
        Map<String,String> parametSers=new HashMap<>();
        parametSers.put("checkin","2020-07-30");
        parametSers.put("adults","1");
        parametSers.put("nights","1");
        parametSers.put("sort","recommended");
        parametSers.put("rooms","1");
        parametSers.put("offset","0");
        parametSers.put("order","asc");
        parametSers.put("limit","30");
        ObjectMapper mapper=new ObjectMapper();
        String json =mapper.writeValueAsString(packageBuilderService.getPackages(query,destino,"10",parametSers));
        return json;
    }
}
