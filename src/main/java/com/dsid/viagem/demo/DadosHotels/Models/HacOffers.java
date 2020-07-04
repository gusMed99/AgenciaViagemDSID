
package com.dsid.viagem.demo.DadosHotels.Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availability",
    "offers",
    "all_booking_offers",
    "confirmation_strikethrough_base_total_stay",
    "confirmation_strikethrough_base_total_stay_when_lte"
})
@Getter
@Setter
public class HacOffers implements Serializable
{

    @JsonProperty("availability")
    private String availability;
    @JsonProperty("offers")
    private List<Offer> offers = null;
    /*@JsonProperty("all_booking_offers")
    private List<AllBookingOffer> allBookingOffers = null;
    @JsonProperty("confirmation_strikethrough_base_total_stay")
    private String confirmationStrikethroughBaseTotalStay;
    @JsonProperty("confirmation_strikethrough_base_total_stay_when_lte")
    private String confirmationStrikethroughBaseTotalStayWhenLte;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5285746147578599044L;*/

    @JsonProperty("availability")
    public String getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @JsonProperty("offers")
    public List<Offer> getOffers() {
        return offers;
    }

    @JsonProperty("offers")
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    /*
    @JsonProperty("all_booking_offers")
    public List<AllBookingOffer> getAllBookingOffers() {
        return allBookingOffers;
    }

    @JsonProperty("all_booking_offers")
    public void setAllBookingOffers(List<AllBookingOffer> allBookingOffers) {
        this.allBookingOffers = allBookingOffers;
    }

    @JsonProperty("confirmation_strikethrough_base_total_stay")
    public String getConfirmationStrikethroughBaseTotalStay() {
        return confirmationStrikethroughBaseTotalStay;
    }

    @JsonProperty("confirmation_strikethrough_base_total_stay")
    public void setConfirmationStrikethroughBaseTotalStay(String confirmationStrikethroughBaseTotalStay) {
        this.confirmationStrikethroughBaseTotalStay = confirmationStrikethroughBaseTotalStay;
    }

    @JsonProperty("confirmation_strikethrough_base_total_stay_when_lte")
    public String getConfirmationStrikethroughBaseTotalStayWhenLte() {
        return confirmationStrikethroughBaseTotalStayWhenLte;
    }

    @JsonProperty("confirmation_strikethrough_base_total_stay_when_lte")
    public void setConfirmationStrikethroughBaseTotalStayWhenLte(String confirmationStrikethroughBaseTotalStayWhenLte) {
        this.confirmationStrikethroughBaseTotalStayWhenLte = confirmationStrikethroughBaseTotalStayWhenLte;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }*/

}
