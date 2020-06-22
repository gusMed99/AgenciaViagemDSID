package com.dsid.viagem.demo.DadosCliente.restController;

import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.HttpResponse;
import com.dsid.viagem.demo.DadosCliente.exceptions.CampoInvalidoException;
import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.ClienteHttp;
import com.dsid.viagem.demo.DadosCliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosClienteController {

    @Autowired
    ClienteService clienteService;




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
            return new ResponseEntity<HttpResponse>(new HttpResponse("Email ou senha invalidos",null),HttpStatus.OK);
        }

        return new ResponseEntity<HttpResponse>(new HttpResponse("Login efetuado com sucesso",response),HttpStatus.OK);
    }
}
