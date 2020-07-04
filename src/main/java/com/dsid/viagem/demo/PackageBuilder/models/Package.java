package com.dsid.viagem.demo.PackageBuilder.models;

import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class Package {

    private Airport airportDestiny;
    private Airport airportOrigin;

    private Hotel hotel;
    private Voo voo;
    private Double packagePrice;


    public Package(Airport airportDestiny, Airport origin, Hotel hotel,Voo voo) {
        this.airportDestiny = airportDestiny;
        this.airportOrigin = origin;
        this.hotel = hotel;
        this.voo=voo;
        this.packagePrice=Double.parseDouble(hotel.getHacOffers().getOffers().get(0).getDisplayPriceInt());
        this.packagePrice+=voo.getPrice();
    }
}
