package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.ClienteHttp;
import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.HttpResponse;
import com.dsid.viagem.demo.DadosHotels.DadosHotelService;
import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DadosHotelController {

    @Autowired
    private DadosHotelService dadosHotelService;

    @GetMapping(path="/dadosHotel", produces = "application/json")
    public String getDadosHotel(@RequestParam(required = true) String location_id, @RequestParam(required = true) String adults, @RequestParam(required = true) String checkin, @RequestParam(required = true) String rooms, @RequestParam(required = true) String nights) throws JsonProcessingException {
        Map<String,String> parameters= new HashMap<>();
        parameters.put("location_id",location_id);
        parameters.put("adults",adults);
        parameters.put("checkin",checkin);
        parameters.put("rooms",rooms);
        parameters.put("nights",nights);
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(dadosHotelService.getExternalHotelData(parameters));

    }
}
