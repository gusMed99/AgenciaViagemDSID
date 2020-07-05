package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.DadosVoos.DadosVoosService;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DadosVoosController {

    @Autowired
    private DadosVoosService dadosVoosService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping(path="/voos", produces = "application/json")
    public String getDadosVoos(
            @RequestParam(required = true) String d1,
            @RequestParam(required = true) String o1,
            @RequestParam(required = true) String dd1,
            @RequestParam(required = false) String dd2,
            @RequestParam(required = false) String o2,
            @RequestParam(required = false) String d2,
            @RequestParam(required = false) String ta,
            @RequestParam(required = false) String ts,
            @RequestParam(required = false) String tc,
            @RequestParam(required = false) String c) throws JsonProcessingException {
        Map<String,String> parameters= new HashMap<String, String>();
        parameters.put("d1",d1);
        parameters.put("o1",o1);
        parameters.put("dd1",dd1);
        if(dd2!=null)parameters.put("dd2",dd2);
        if(o2!=null)parameters.put("o2",o2);
        if(d2!=null)parameters.put("d2",d2);
        if(ta!=null)parameters.put("ta",ta);
        if(ts!=null)parameters.put("ts",ts);
        if(tc!=null)parameters.put("tc",tc);
        if(c!=null)parameters.put("c",c);
        List<Voo> response= this.dadosVoosService.getExternalFlighData(parameters);
        return mapper.writeValueAsString(response);
    }

}
