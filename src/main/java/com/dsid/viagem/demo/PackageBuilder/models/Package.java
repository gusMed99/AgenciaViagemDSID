package com.dsid.viagem.demo.PackageBuilder.models;

import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosHotels.Models.Image;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter

public class Package {


    private Airport airportDestiny;


    private Airport airportOrigin;


    private Hotel hotel;


    private Voo voo;


    private Double packagePrice;


    private Image destinyImage;


    public Package(Airport airportDestiny, Airport origin, Hotel hotel,Voo voo,Image destinyImage) {
        this.destinyImage=destinyImage;
        this.airportDestiny = airportDestiny;
        this.airportOrigin = origin;
        this.hotel = hotel;
        this.voo=voo;
        this.packagePrice=Double.parseDouble(hotel.getHacOffers().getOffers().get(0).getDisplayPriceInt());
        this.packagePrice+=voo.getPrice();
    }


}
