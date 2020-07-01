package com.dsid.viagem.demo.DadosLocalizacoes;

import com.dsid.viagem.demo.restAPICall.RapidAPICallService;
import com.dsid.viagem.demo.restAPICall.TripAdvisorCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DadosLocalizacoesService {

    @Autowired
    private TripAdvisorCallService tripAdvisorCallService;

    private final String endpointUrl = "https://tripadvisor1.p.rapidapi.com/locations/auto-complete";

    public Map<String,Object> getLocationsData(Map<String, String> parameters) {
        Map<String,String> headers=new HashMap<>();
        headers.put("x-rapidapi-host","tripadvisor1.p.rapidapi.com");
        try{
            Map<String,Object> response= (Map<String,Object>)tripAdvisorCallService.getMethod(headers,endpointUrl,parameters,Map.class);
            this.filtrarResponse(response);
            return response;
        }
        catch (Exception e){
            return new HashMap<String, Object>();
        }
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
