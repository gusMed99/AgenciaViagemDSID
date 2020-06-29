package com.dsid.viagem.demo.restAPICall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RapidAPICallService extends RestAPICallService {

    @Value("${rapid.api.key}")
    private String rapidApiKey;

    @Override
    public Object getMethod(Map<String, String> headers, String endpointPath, Map<String, String> urlParameters, Class responseClass) throws UnirestException, JsonProcessingException {
        headers.put("x-rapidapi-key", rapidApiKey);
        urlParameters.put("currency","BRL");
        urlParameters.put("lang","pt_BR");
        headers.put("x-rapidapi-host","tripadvisor1.p.rapidapi.com");
        return super.getMethod(headers, endpointPath, urlParameters, responseClass);
    }
}
