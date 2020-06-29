package com.dsid.viagem.demo.restAPICall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RestAPICallService {


    @Autowired
    private ObjectMapper mapper;

    public Object getMethod(Map<String,String> headers,String endpointPath,Map<String,String> urlParameters , Class responseClass) throws UnirestException, JsonProcessingException {

        HttpResponse<String> response =Unirest.get(this.buildUrlRequest(endpointPath,urlParameters))
                .headers(headers)
                .asString();
        return mapper.readValue(response.getBody(),responseClass);
    }

    private String buildUrlRequest(String endpointUrl,Map<String,String> parameters){
        String parametersString="";
        for(Map.Entry<String,String> parameter: parameters.entrySet()){
            parametersString+=parameter.getKey()+"="+parameter.getValue();
            parametersString+="&";
        }
        parametersString=parametersString.substring(0,parametersString.length()-2);
        if(parametersString.equals("")) return endpointUrl;
        return endpointUrl+"?"+parametersString;
    }
}
