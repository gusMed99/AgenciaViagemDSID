package com.dsid.viagem.demo.PackageBuilder.models.entities;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosHotels.Models.Image;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
import com.dsid.viagem.demo.PackageBuilder.models.Airport;
import com.dsid.viagem.demo.PackageBuilder.models.Package;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "Package")
@Entity
@Getter
@NoArgsConstructor
@Setter
public class PackageEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String packageId;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.MERGE)
   private Airport airportDestiny;

    @OneToOne(cascade = CascadeType.MERGE)
   private Airport airportOrigin;


    @OneToOne(cascade = CascadeType.ALL)
    private HotelRoomEntity hotel;

    @OneToOne(cascade = CascadeType.ALL)
    private Voo voo;


    @Column(nullable = false)
    private Double packagePrice;

    @Column(nullable = false)
    private Date dataCompra;

    @Column(nullable = false)
    private Date dataCheckin;



    public PackageEntity(Package pacote, Cliente cliente,String checkin) throws ParseException {
        this.packagePrice=new Double(0);
       if(pacote.getVoo()!=null) {
           this.airportDestiny = pacote.getAirportDestiny();
           this.airportOrigin = pacote.getAirportOrigin();
           this.voo = pacote.getVoo();
           this.packagePrice+=pacote.getVoo().getPrice();
       }
        this.cliente=cliente;

        if(pacote.getHotel()!=null){
            this.hotel=new HotelRoomEntity(pacote.getHotel());
            this.packagePrice+=this.hotel.getPreco();
        }
        this.dataCompra=new Date();
        this.dataCheckin=new SimpleDateFormat("yyyy-mm-dd").parse(checkin);
    }

}
