package com.dsid.viagem.demo.PackageBuilder.models.entities;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosHotels.Models.Image;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
import com.dsid.viagem.demo.PackageBuilder.models.Airport;
import com.dsid.viagem.demo.PackageBuilder.models.Package;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "Package")
@Entity
@Getter
public class PackageEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String packageId;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
   private Airport airportDestiny;

    @OneToOne(cascade = CascadeType.ALL)
   private Airport airportOrigin;


    @OneToOne(cascade = CascadeType.ALL)
    private HotelRoomEntity hotel;

    @OneToOne(cascade = CascadeType.ALL)
    private Voo voo;


    @Column(nullable = false)
    private Double packagePrice;

    public PackageEntity(Package pacote, Cliente cliente){
        this.airportDestiny=pacote.getAirportDestiny();
        this.airportOrigin=pacote.getAirportOrigin();
        this.cliente=cliente;

        this.packagePrice=pacote.getPackagePrice();
        this.hotel=new HotelRoomEntity(pacote.getHotel());
        this.voo=pacote.getVoo();
    }

}
