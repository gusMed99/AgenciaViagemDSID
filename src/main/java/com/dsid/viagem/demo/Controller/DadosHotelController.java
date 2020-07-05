package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.ClienteHttp;
import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.HttpResponse;
import com.dsid.viagem.demo.DadosHotels.DadosHotelService;
import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DadosHotelController {

    @Autowired
    private DadosHotelService dadosHotelService;

    @Autowired
    private DadosLocalizacoesService dadosLocalizacoesService;

    @GetMapping(path="/dadosHotel", produces = "application/json")
    public String getDadosHotel(@RequestParam(required = true) String placeQuery, @RequestParam(required = true) String adults, @RequestParam(required = true) String checkin, @RequestParam(required = true) String rooms, @RequestParam(required = true) String nights) throws JsonProcessingException {
        Map<String,String> parametersLocation=new HashMap<>();
        parametersLocation.put("query",placeQuery);
        parametersLocation.put("limit","30");
        String location_id= this.dadosLocalizacoesService.getLocationId(parametersLocation);
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
