package com.dsid.viagem.demo.DadosHotels.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Image {

    private String width;
    private String url;
    private String height;

    public Image(Map<String,String> map){
        if(map!=null) {
            this.width = map.get("width");
            this.url = map.get("url");
            this.height = map.get(height);
        }
    }
}
