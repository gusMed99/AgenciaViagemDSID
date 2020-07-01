package com.dsid.viagem.demo.restAPICall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TripAdvisorCallService extends RapidAPICallService {
    @Override
    public Object getMethod(Map<String, String> headers, String endpointPath, Map<String, String> urlParameters, Class responseClass) throws UnirestException, JsonProcessingException {
        urlParameters.put("currency","BRL");
        urlParameters.put("lang","pt_BR");
        headers.put("x-rapidapi-host","tripadvisor1.p.rapidapi.com");
        return super.getMethod(headers, endpointPath, urlParameters, responseClass);
    }
}
