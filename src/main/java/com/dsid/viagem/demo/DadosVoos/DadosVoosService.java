package com.dsid.viagem.demo.DadosVoos;

import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.restAPICall.TripAdvisorCallService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DadosVoosService {
    @Autowired
    private TripAdvisorCallService tripAdvisorCallService;

    private final String endpointUrl = "https://tripadvisor1.p.rapidapi.com/hotels/list";



    public Map<String,Object> getExternalFlighData(Map<String, String> parameters) {
        try{
            Map<String,Object> response= (Map<String,Object>)tripAdvisorCallService.getMethod(new HashMap<String, String>(),endpointUrl,parameters, Map.class);
            //this.filtrarResponse(response);
            //return this.convertToHotelList(response);
        }
        catch (Exception e){
            return new HashMap<>();
        }
        return null;
    }
}
