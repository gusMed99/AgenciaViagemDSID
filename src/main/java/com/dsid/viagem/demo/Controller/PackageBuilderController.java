package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.PackageBuilder.models.Package;
import com.dsid.viagem.demo.PackageBuilder.service.PackageBuilderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PackageBuilderController {

    @Autowired
   private PackageBuilderService packageBuilderService;

   private static List<Package> packagesHome;

    @GetMapping(path="/pacotes", produces = "application/json")
    public List<Package> getPackages(
            @RequestParam(required = true) String origin,
            @RequestParam(required = true) String destiny,
            @RequestParam(required = true) String checkin,
            @RequestParam(required = true) String adults,
            @RequestParam(required = true) String rooms,
            @RequestParam(required = true) String nights,
            @RequestParam(required = false) String hotel_class,
            @RequestParam(required = false) String pricesmax
    ) throws Exception {

        Map<String,String> parametSers=new HashMap<>();
        parametSers.put("checkin",checkin);
        parametSers.put("adults",adults);
        parametSers.put("nights",nights);
        parametSers.put("sort","recommended");
        parametSers.put("rooms",rooms);
        parametSers.put("offset","0");
        parametSers.put("order","asc");
        parametSers.put("limit","30");
        parametSers.put("hotel_class",hotel_class);
        parametSers.put("pricesmax",pricesmax);
        ObjectMapper mapper=new ObjectMapper();
        String json="{}";
        List<Package> response=new ArrayList<>();
        for(int i=0;i<3;i++) {
            try {
              response= (packageBuilderService.getPackages(origin, destiny, "20", parametSers));
              break;
            } catch (Exception e) {
                continue;
            }
        }
       return response;
    }

    @GetMapping(path="/pacotesHome", produces = "application/json")
    public List<Package> getPacotesHome() throws Exception {
        if(PackageBuilderController.packagesHome!=null) return PackageBuilderController.packagesHome;
        String orgin="Guarulhos";
        String destiny1="Maceio";
        String destiny2="Florianopolis";
        String destiny3="NovaYork";
        String adults="1";
        String nights="2";
        String rooms="1";
        SimpleDateFormat simpleDateFormatComHora = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat= DateFormat.getDateInstance();


        Date date= new Date();
        date.setDate(date.getDate()+4);

        String checkin=simpleDateFormatComHora.format(date);

        List<Package> responseList=new ArrayList<>();
        try {
            List<Package> pacotes1 = this.getPackages(orgin, destiny1, checkin, adults, rooms, nights, "", "");
            this.addPackagesToList(pacotes1,responseList,5);
            List<Package> pacotes2 = this.getPackages(orgin, destiny2, checkin, adults, rooms, nights, "", "");
            this.addPackagesToList(pacotes2,responseList,5);
            List<Package> pacotes3 = this.getPackages(orgin, destiny3, checkin, adults, rooms, nights, "", "");
            this.addPackagesToList(pacotes3,responseList,5);
        }
        catch (Exception e){ }
        PackageBuilderController.packagesHome=responseList;
        return responseList;
    }

    private void addPackagesToList(List<Package> list, List<Package> response,int limit){
        int i=0;
        for(Package p: list){
            if(i>limit) break;
            response.add(p);
            i++;
        }
    }
}
