package com.dsid.viagem.demo.DadosHotels;

import com.dsid.viagem.demo.DadosHotels.Models.HotelModel;
import com.dsid.viagem.demo.restAPICall.RapidAPICallService;
import com.dsid.viagem.demo.restAPICall.TripAdvisorCallService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DadosHotelService {

    @Autowired
    private TripAdvisorCallService tripAdvisorCallService;

    private final String endpointUrl = "https://tripadvisor1.p.rapidapi.com/hotels/get-details";



    public Map<String,Object> getExternalHotelData(Map<String, String> parameters) {
       try{
           Map<String,Object> response= (Map<String,Object>)tripAdvisorCallService.getMethod(new HashMap<String, String>(),endpointUrl,parameters,Map.class);
           this.filtrarResponse(response);
           return response;
       }
       catch (Exception e){
           return new HashMap<String, Object>();
       }
    }

    /**
     * Retorna infos de quartos de hoteis persistidos no Banco de dados
     * @return
     */
    public HotelModel getHotelinDB(String hotelId){
        return null;
    }

    private Map<String,Object> filtrarResponse(Map<String,Object> response){
        Map<String,Object> filteredResponse= new HashMap<String, Object>();
        List<Map> data= (List<Map>)response.get("data");
        List<Map> dataResult=new ArrayList<>();
        for(Map o:data){
                List<Map> offers=(List<Map>)(((Map<String, Object>) o.get("hac_offers"))).get("offers");
                List<Map> offersResult= new ArrayList<>();
                for(Map offersEntry: offers){
                    if((offersEntry.get("availability").equals("available"))){
                        offersResult.add(offersEntry);
                    }
                }
            ((Map<String, Object>) o.get("hac_offers")).put("offers",offersResult);
            if(offersResult.size()>0) dataResult.add(o);

        }

        response.put("data",dataResult);
        return null;
    }
}
