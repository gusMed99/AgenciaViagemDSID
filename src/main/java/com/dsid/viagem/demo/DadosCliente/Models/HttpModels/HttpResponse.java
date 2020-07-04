package com.dsid.viagem.demo.DadosCliente.Models.HttpModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HttpResponse {
    String success;
    ClienteHttp clienteHttp;
    String message;
    String authToken;

    public HttpResponse(String success, ClienteHttp clienteHttp, String message, String authToken) {
        this.success = success;
        this.clienteHttp = clienteHttp;
        this.message = message;
        this.authToken = authToken;
    }
}
