package com.dsid.viagem.demo.PackageBuilder;

import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesAeroportosSerivce;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PackageBuilderService {

    @Autowired
    DadosLocalizacoesAeroportosSerivce dadosLocalizacoesAeroportosSerivce;

    @Autowired
    DadosLocalizacoesService dadosLocalizacoesService;

    public void getPackages(String locationQuery, String radius){

        Map<String,Object> dadosLocation=this.getLocationData(locationQuery);
        String latitude= this.getLatitude(dadosLocation);
        String longitude=this.getLongitude(dadosLocation);
        Map<String,Object> aeroportosProximos= this.dadosLocalizacoesAeroportosSerivce.getNearAirportsData(latitude,longitude,radius,"5");
        //return  mapper.writeValueAsString(dadosLocalizacoesAeroportosSerivce.getNearAirportsData("-23.416700","-46.467940","10","10"));
    }

    private Map<String,Object> getLocationData(String locationQuery){
        Map<String,String> parameters= new HashMap<>();
        parameters.put("units","km");
        parameters.put("query",locationQuery);
        Map<String,Object> map= dadosLocalizacoesService.getLocationsData(parameters);
        return map;
    }

    private String getLatitude(Map<String,Object> locationsResponse){
        List<Map> data= (List<Map>) locationsResponse.get("data");
        Map<String,Object> resultObject=(Map<String, Object>) (data.get(0).get("result_object"));
        return (String)resultObject.get("latitude");

    }

    private String getLongitude(Map<String,Object> locationsResponse){
        List<Map> data= (List<Map>) locationsResponse.get("data");
        Map<String,Object> resultObject=(Map<String, Object>) (data.get(0).get("result_object"));
        return (String)resultObject.get("longitude");
    }
}
