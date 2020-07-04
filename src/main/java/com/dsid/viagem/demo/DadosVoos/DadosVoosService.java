package com.dsid.viagem.demo.DadosVoos;

import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
import com.dsid.viagem.demo.restAPICall.TripAdvisorCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DadosVoosService {
    @Autowired
    private TripAdvisorCallService tripAdvisorCallService;

    private final String endpointUrlCreateSession = "https://tripadvisor1.p.rapidapi.com/flights/create-session";
    private final String endpointUrlPool = "https://tripadvisor1.p.rapidapi.com/flights/poll";
    private final String endpointUrlCreateBooking = "https://tripadvisor1.p.rapidapi.com/hotels/list";



    public List<Voo> getExternalFlighData(Map<String, String> parameters) {
        try{
            Map<String,Object> createSeesionResponse= (Map<String,Object>)tripAdvisorCallService.getMethod(new HashMap<String, String>(),endpointUrlCreateSession,parameters, Map.class);
            String seachId=this.getSearchId(createSeesionResponse);
            String searchHash=this.getSearchHash(createSeesionResponse);
            Map<String,String> poolParameter=this.createFlihtPoolHeaders(seachId);
            Map<String,Object> flightPoolResponse=(Map<String,Object>)tripAdvisorCallService.getMethod(new HashMap<String, String>(),endpointUrlPool,poolParameter, Map.class);
            List<Voo> list=this.createFlighList(searchHash,seachId,parameters.get("dd1"),flightPoolResponse);
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    private Map<String,String> createFlihtPoolHeaders(String searchId){
        Map<String,String> parameters= new HashMap<>();
        parameters.put("sid",searchId);
        parameters.put("n","15");
        parameters.put("so","PRICE");
        return parameters;
    }

    private List<Voo> createFlighList(String searchHash, String searchId,String date, Map<String,Object> map){
        List<Map> itineraries= (List<Map>) map.get("itineraries");
        List<Voo> flightsList=new ArrayList<>();
        for(Map itinerary: itineraries){
            List<Map> itinerariesOptions= (List<Map>) itinerary.get("l");
            String compania=(String) itinerary.get("od");
            for(Map option:itinerariesOptions){
                String id= (String)option.get("id");
                Map<String,Object> priceObject=(Map<String, Object>) option.get("pr");
                Double price= (Double) priceObject.get("p");
                flightsList.add(new Voo(date,price,compania,searchHash,searchId,id));
            }
        }
        return flightsList;
    }

    private String getSearchHash(Map<String,Object> map){
        Map<String,Object> summary=(Map<String, Object>) map.get("summary");
        return (String) summary.get("sh");
    }

    private String getSearchId(Map<String,Object> map){
        Map<String,Object> searchData=(Map<String, Object>) map.get("search_params");
        return (String) searchData.get("sid");
    }
}
