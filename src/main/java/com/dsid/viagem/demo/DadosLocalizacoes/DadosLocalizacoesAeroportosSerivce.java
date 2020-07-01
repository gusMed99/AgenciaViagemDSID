package com.dsid.viagem.demo.DadosLocalizacoes;

import com.dsid.viagem.demo.restAPICall.RapidAPICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DadosLocalizacoesAeroportosSerivce {
    @Autowired
    private RapidAPICallService rapidAPICallService;

    private final String endpointUrl = "https://aerodatabox.p.rapidapi.com/airports/search/location";

    public Map<String,Object> getNearAirportsData(String lat,String lon,String radius, String limit) {
        Map<String,String> headers=new HashMap<>();
        Map<String,String> parameters=new HashMap<>();
        headers.put("x-rapidapi-host","aerodatabox.p.rapidapi.com");
        parameters.put("withFlightInfoOnly","false");
        String url= this.buildUrl(lat,lon,radius,limit);
        try{
            Map<String,Object> response= (Map<String,Object>)rapidAPICallService.getMethod(headers,url,parameters,Map.class);
            //this.filtrarResponse(response);
            return response;
        }
        catch (Exception e){
            return new HashMap<String, Object>();
        }
    }

    private String buildUrl(String lat,String lon, String radius,String limit){
        return this.endpointUrl+"/"+lat+"/"+lon+"/Km/"+radius+"/"+limit;
    }

    private void filtrarResponse(Map<String,Object> response){
        List<Map> data= (List<Map>)response.get("data");
        List<Map> dataResult=new ArrayList<>();
        for(Map o:data){
            String resultType= (String)o.get("result_type");
            if(resultType!=null && resultType.toLowerCase().equals("geos")){
                dataResult.add(o);
                break;
            }
        }
        response.put("data",dataResult);
    }
}
