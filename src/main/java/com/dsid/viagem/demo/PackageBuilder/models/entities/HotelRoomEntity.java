package com.dsid.viagem.demo.PackageBuilder.models.entities;

import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Quarto_hotel")
@Entity
@Getter
@Setter

@NoArgsConstructor
public class HotelRoomEntity {

    @Id
    private String contentId;

    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("location_string")
    private String locationString;

    @JsonIgnore
    private Double preco;

    @JsonIgnore
    @Column(length = 10000)
    private String linkOferta;


    public HotelRoomEntity(Hotel hotel){
        this.latitude=hotel.getLatitude();
        this.longitude=hotel.getLongitude();
        this.name=hotel.getName();
        this.locationString=hotel.getLocationString();
        this.timezone=hotel.getTimezone();
        this.linkOferta=hotel.getHacOffers().getOffers().get(0).getLink();
        this.preco=Double.parseDouble(hotel.getHacOffers().getOffers().get(0).getDisplayPriceInt());
        this.contentId=hotel.getHacOffers().getOffers().get(0).getContentId();
    }
}
