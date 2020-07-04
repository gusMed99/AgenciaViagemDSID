package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.HttpResponse;
import com.dsid.viagem.demo.DadosCliente.exceptions.CampoInvalidoException;
import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.ClienteHttp;
import com.dsid.viagem.demo.DadosCliente.service.ClienteService;
import com.dsid.viagem.demo.DadosHotels.DadosHotelService;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesService;
import com.dsid.viagem.demo.restAPICall.RestAPICallService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DadosClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    DadosHotelService dadosHotelService;

    @Autowired
    DadosLocalizacoesService dadosLocalizacoesService;





    @PostMapping(path= "/cadastro", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> cadastraCliente(@RequestBody ClienteHttp clienteHttp) throws CampoInvalidoException {
            try{
                if (this.clienteService.cadastraCliente(clienteHttp)) {
                    return new ResponseEntity<String>("Cliente cadastrado com sucesso", HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<String>("Cadastro invalido. Cliente já cadastrado", HttpStatus.UNPROCESSABLE_ENTITY);
                }
            }
            catch (CampoInvalidoException e){
                return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }

    }

    @GetMapping(path="/login",consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpResponse> getDadosCliente(@RequestBody ClienteHttp request){
        ClienteHttp response= clienteService.loginCliente(request);
        if(response==null){
            return new ResponseEntity<HttpResponse>(new HttpResponse("false",null,"Credenciais inválidas",""),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<HttpResponse>(new HttpResponse("true",response,"Login realizado com sucesso",response.getCpf()),HttpStatus.OK);
    }

    @GetMapping(path="/teste",consumes = "application/json", produces = "application/json")
    public String testeCaller() throws JsonProcessingException, UnirestException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> parameters= new HashMap<String, String>();
        parameters.put("adults","1");
        parameters.put("nights","2");
        parameters.put("child_rm_ages","7%252C10");
        parameters.put("location_id","303611");
        parameters.put("checkin","2020-07-30");

        return  mapper.writeValueAsString(dadosHotelService.getExternalHotelData(parameters));
    }

    @GetMapping(path="/teste2",consumes = "application/json", produces = "application/json")
    public String testeCaller2() throws JsonProcessingException, UnirestException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> parameters= new HashMap<String, String>();
        parameters.put("query","Guarulhos");
        parameters.put("units","km");
        return  mapper.writeValueAsString(dadosLocalizacoesService.getLocationsData(parameters));
    }
}
