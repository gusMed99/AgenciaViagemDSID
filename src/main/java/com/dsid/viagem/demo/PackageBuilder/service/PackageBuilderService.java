package com.dsid.viagem.demo.PackageBuilder.service;

import com.dsid.viagem.demo.DadosHotels.DadosHotelService;
import com.dsid.viagem.demo.DadosHotels.Models.HacOffers;
import com.dsid.viagem.demo.DadosHotels.Models.Hotel;
import com.dsid.viagem.demo.DadosHotels.Models.Image;
import com.dsid.viagem.demo.DadosHotels.Models.Offer;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesAeroportosSerivce;
import com.dsid.viagem.demo.DadosLocalizacoes.DadosLocalizacoesService;
import com.dsid.viagem.demo.DadosVoos.DadosVoosService;
import com.dsid.viagem.demo.DadosVoos.model.Voo;
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

    @Autowired
    DadosVoosService dadosVoosService;


    public List<Package> getPackages(String origin, String destiny , String radius,Map<String,String> headersHotel ) throws Exception {
        List<Airport> airportsOrigin=this.getNearAirportFromLocation(origin,radius,new Image());
        Image imagemDestino=new Image();
        List<Airport> airportsDestiny=this.getNearAirportFromLocation(destiny,radius,imagemDestino);
        return this.getHotelsDataByDestinyAirport(airportsOrigin.get(0),airportsDestiny,headersHotel,imagemDestino);

    }

    private List<Package> getHotelsDataByDestinyAirport(Airport origin,List<Airport> aiportsDestiny, Map<String,String> headersHotel,Image image) throws Exception {
        headersHotel.put("location_id",aiportsDestiny.get(0).getLocationId());
        List<Package> packageList=new ArrayList<>();
        boolean voosEncontrados=false;
        boolean hoteisEncontrados=false;
        for(Airport airport: aiportsDestiny){
            headersHotel.put("location_id",airport.getLocationId());
            List<Voo> voosList=this.getFlightData(origin.getIataCode(),airport.getIataCode(),headersHotel.get("checkin"));
            if(voosList.size()==0) {
               continue;
            };
            voosEncontrados=true;
            List<Hotel> hotelList=dadosHotelService.getExternalHotelData(headersHotel);
            if(hotelList.size()==0)continue;
            hoteisEncontrados=true;
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
                    packageList.add(new Package(airport,origin,hotelPackage,voosList.get(0),image));
                    i++;
                }
            }
        }
        if(!voosEncontrados) throw new Exception("Voos nao encontrados");
        if(!hoteisEncontrados) throw new Exception("Hoteis nao encontrados");
        return packageList;
    }

    private List<Voo> getFlightData(String origin, String destiny, String date){
        Map<String,String> headers= new HashMap<>();
        headers.put("o1",origin);
        headers.put("d1",destiny);
        headers.put("dd1",date);
        return this.dadosVoosService.getExternalFlighData(headers);
    }

    public  List<Airport> getNearAirportFromLocation(String locationQuery, String radius, Image image){


        Map<String,Object> dadosLocation=this.getLocationData(locationQuery);
        String latitude= this.getLatitude(dadosLocation);
        String longitude=this.getLongitude(dadosLocation);
        image.alteraImagem(this.getImage(dadosLocation));
        List<Airport> airports=new ArrayList<>();
        String locationArrumada=locationQuery.trim().toLowerCase().replaceAll("_","").replaceAll("ã","a").replaceAll(" ","");
        if(locationArrumada.equals("saopaulo") || locationArrumada.equals("guarulhos")){
            airports.add( Airport.createGuarulhos());
            return airports;
        }
        Map<String,Object> aeroportosProximos= this.dadosLocalizacoesAeroportosSerivce.getNearAirportsData(latitude,longitude,radius,"2");
        int size= ((List<Map>)(aeroportosProximos.get("items"))).size();

        for(int i=0;i<size && i<5;i++){
            airports.add(new Airport(aeroportosProximos,i,this.getLocationId(dadosLocation)));
        }
        return airports;
    }

    private Image getImage(Map<String,Object> locationsResponse){
        List<Map> data= (List<Map>) locationsResponse.get("data");
        Map<String,Object> resultObject=(Map<String, Object>) (data.get(0).get("result_object"));
        Map<String,Object> photo= (Map<String, Object>) resultObject.get("photo");
        if(photo==null) return new Image();
        Map<String,Object> images= (Map<String, Object>) photo.get("images");
        if(images==null) return new Image();
        return new Image((Map<String, String>) images.get("large"));
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
