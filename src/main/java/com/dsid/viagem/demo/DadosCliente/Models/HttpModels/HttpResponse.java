package com.dsid.viagem.demo.DadosCliente.Models.HttpModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class HttpResponse {
    String message;
    ClienteHttp clienteHttp;
}
