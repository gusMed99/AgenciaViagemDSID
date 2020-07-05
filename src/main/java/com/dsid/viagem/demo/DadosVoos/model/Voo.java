package com.dsid.viagem.demo.DadosVoos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

//@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name="voos")
public class Voo implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;
    String date;
    Double price;
    String origin;
    String destiny;
    String Compania;
    String searchHash;
    String searchId;
    String flightId;

    public Voo(String date, Double price, String origin, String destiny, String compania, String searchHash, String searchId, String flightId){

        this.date=date;
        this.price=price;
        this.origin=origin;
        this.destiny=destiny;
        this.Compania=compania;
        this.searchHash=searchHash;
        this.searchId=searchId;
        this.flightId=flightId;
    }
}
