package com.dsid.viagem.demo.PackageBuilder.models;

import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosHotels.Models.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class Package {

    private Airport airportDestiny;
    private Airport origin;

    private Hotel hotel;
    private Double packagePrice;

    public Package(Airport airportDestiny, Airport origin, Hotel hotel) {
        this.airportDestiny = airportDestiny;
        this.origin = origin;
        this.hotel = hotel;
        this.packagePrice=Double.parseDouble(hotel.getHacOffers().getOffers().get(0).getDisplayPriceInt());
    }
}
