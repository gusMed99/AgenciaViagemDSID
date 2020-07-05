package com.dsid.viagem.demo.PackageBuilder.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Getter
@Entity
@Table(name = "airport")
@Setter
@NoArgsConstructor
public class Airport {

    @Column
    private String icaoCode;
    @Id
    @Column
    private String iataCode;
    @Column
    private String name;
    @Column
    private String cityName;
    @Column
    private double latitude;

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    private double longitude;
    private String countryCode;
    private String locationId;

    public Airport(Map<String,Object> map, int index, String locationId){
        List<Map> items= (List<Map>) map.get("items");
        Map<String,Object> itemsMap=items.get(index);
        this.iataCode=(String) itemsMap.get("iata");
        this.icaoCode=(String)itemsMap.get("icao");
        this.name=(String)itemsMap.get("name");
        this.cityName=(String)itemsMap.get("municipalityName");
        Map<String,Double> locationMap=(Map<String, Double>) itemsMap.get("location");
        this.latitude=locationMap.get("lat");
        this.longitude=locationMap.get("lon");
        this.countryCode=(String)itemsMap.get("countryCode");
        this.locationId=locationId;
    }
}
