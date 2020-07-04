package com.dsid.viagem.demo.PackageBuilder.service;

import com.dsid.viagem.demo.DadosHotels.DadosHotelService;
import com.dsid.viagem.demo.DadosHotels.Models.HacOffers;
import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosHotels.Models.Offer;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesAeroportosSerivce;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesService;
import com.dsid.viagem.demo.PackageBuilder.models.Airport;
import com.dsid.viagem.demo.PackageBuilder.models.Package;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PackageBuilderService {

    @Autowired
    DadosLocalizacoesAeroportosSerivce dadosLocalizacoesAeroportosSerivce;

    @Autowired
    DadosLocalizacoesService dadosLocalizacoesService;

    @Autowired
    DadosHotelService dadosHotelService;


    public List<Package> getPackages(String origin, String destiny , String radius,Map<String,String> headersHotel ) throws JsonProcessingException {
        List<Airport> airportsOrigin=this.getNearAirportFromLocation(origin,radius);
        List<Airport> airportsDestiny=this.getNearAirportFromLocation(destiny,radius);
        return this.getHotelsDataByDestinyAirport(airportsOrigin.get(0),airportsDestiny,headersHotel);

    }

    private List<Package> getHotelsDataByDestinyAirport(Airport origin,List<Airport> aiportsDestiny, Map<String,String> headersHotel) throws JsonProcessingException {
        headersHotel.put("location_id",aiportsDestiny.get(0).getLocationId());
        List<Package> packageList=new ArrayList<>();
        for(Airport airport: aiportsDestiny){
            headersHotel.put("location_id",airport.getLocationId());
            List<Hotel> hotelList=dadosHotelService.getExternalHotelData(headersHotel);
            for(Hotel hotel:hotelList){

                List<Offer> offerList= hotel.getHacOffers().getOffers();
                int i=0;
                for(Offer offer:offerList){
                    if(i>5) break;
                    Hotel hotelPackage=hotel.getSimpleHotel();
                    List<Offer> offers= new ArrayList<>();
                    offers.add(offer);
                    HacOffers hacOffers=new HacOffers();
                    hacOffers.setOffers(offers);
                    hotelPackage.setHacOffers(hacOffers);
                    packageList.add(new Package(airport,origin,hotelPackage));
                    i++;
                }
            }
        }
        return packageList;
    }

    public  List<Airport> getNearAirportFromLocation(String locationQuery, String radius){

        Map<String,Object> dadosLocation=this.getLocationData(locationQuery);
        String latitude= this.getLatitude(dadosLocation);
        String longitude=this.getLongitude(dadosLocation);
        Map<String,Object> aeroportosProximos= this.dadosLocalizacoesAeroportosSerivce.getNearAirportsData(latitude,longitude,radius,"5");
        int size= ((List<Map>)(aeroportosProximos.get("items"))).size();
        List<Airport> airports=new ArrayList<>();
        for(int i=0;i<size && i<5;i++){
            airports.add(new Airport(aeroportosProximos,i,this.getLocationId(dadosLocation)));
        }
        return airports;
    }

    private String getLocationId(Map<String,Object> locationsResponse){
        List<Map> data= (List<Map>) locationsResponse.get("data");
        Map<String,Object> resultObject=(Map<String, Object>) (data.get(0).get("result_object"));
        return (String)resultObject.get("location_id");
    }

    private Map<String,Object> getLocationData(String locationQuery){
        Map<String,String> parameters= new HashMap<>();
        parameters.put("units","km");
        parameters.put("query",locationQuery);
        Map<String,Object> map= dadosLocalizacoesService.getLocationsData(parameters);
        return map;
    }

    private String getLatitude(Map<String,Object> locationsResponse){
        List<Map> data= (List<Map>) locationsResponse.get("data");
        Map<String,Object> resultObject=(Map<String, Object>) (data.get(0).get("result_object"));
        return (String)resultObject.get("latitude");

    }

    private String getLongitude(Map<String,Object> locationsResponse){
        List<Map> data= (List<Map>) locationsResponse.get("data");
        Map<String,Object> resultObject=(Map<String, Object>) (data.get(0).get("result_object"));
        return (String)resultObject.get("longitude");
    }


}
