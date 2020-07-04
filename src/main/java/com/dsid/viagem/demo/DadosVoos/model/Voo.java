package com.dsid.viagem.demo.DadosVoos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Voo implements Serializable {
    String date;
    Double price;
    String Compania;
    String searchHash;
    String searchId;
    String flightId;

    public  Voo(Map<String,Object> map){

    }
}
