
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "location_id",
    "name",
    "latitude",
    "longitude",
    "num_reviews",
    "timezone",
    "location_string",
    "photo",
    "awards",
    "preferred_map_engine",
    "raw_ranking",
    "ranking_geo",
    "ranking_geo_id",
    "ranking_position",
    "ranking_denominator",
    "ranking_category",
    "ranking",
    "subcategory_type",
    "subcategory_type_label",
    "distance",
    "distance_string",
    "bearing",
    "rating",
    "is_closed",
    "is_long_closed",
    "price_level",
    "price",
    "neighborhood_info",
    "hac_offers",
    "hotel_class",
    "hotel_class_attribution",
    "business_listings",
    "special_offers",
    "listing_key",
    "description",
    "web_url",
    "write_review",
    "ancestors",
    "category",
    "subcategory",
    "parent_display_name",
    "guide_count",
    "is_jfy_enabled",
    "nearest_metro_station",
    "phone",
    "website",
    "email",
    "address_obj",
    "address",
    "local_name",
    "local_address",
    "local_lang_code",
    "is_candidate_for_contact_info_suppression",
    "amenities",
    "photo_count",
    "has_review_draft",
    "has_panoramic_photos",
    "rating_histogram",
    "room_tips"
})*/
@Getter
@Setter
public class Hotel implements Serializable
{

    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("num_reviews")
    private String numReviews;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("location_string")
    private String locationString;
    @JsonProperty("preferred_map_engine")
    private String preferredMapEngine;
    @JsonProperty("raw_ranking")
    private String rawRanking;
    @JsonProperty("ranking_geo")
    private String rankingGeo;
    @JsonProperty("ranking_geo_id")
    private String rankingGeoId;
    @JsonProperty("ranking_position")
    private String rankingPosition;
    @JsonProperty("ranking_denominator")
    private String rankingDenominator;
    @JsonProperty("ranking_category")
    private String rankingCategory;
    @JsonProperty("ranking")
    private String ranking;
    @JsonProperty("subcategory_type")
    private String subcategoryType;
    @JsonProperty("subcategory_type_label")
    private String subcategoryTypeLabel;
    @JsonProperty("distance")
    private String distance;
    @JsonProperty("distance_string")
    private Object distanceString;
    @JsonProperty("bearing")
    private String bearing;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("is_closed")
    private Boolean isClosed;
    @JsonProperty("is_long_closed")
    private Boolean isLongClosed;
    @JsonProperty("price_level")
    private String priceLevel;
    @JsonProperty("price")
    private String price;
    @JsonProperty("hac_offers")
    private HacOffers hacOffers;
    @JsonProperty("hotel_class")
    private String hotelClass;
    @JsonProperty("hotel_class_attribution")
    private String hotelClassAttribution;
    @JsonProperty("description")
    private String description;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("write_review")
    private String writeReview;
    @JsonProperty("parent_display_name")
    private String parentDisplayName;
    @JsonProperty("guide_count")
    private String guideCount;
    @JsonProperty("is_jfy_enabled")
    private Boolean isJfyEnabled;

    @JsonIgnore
    private List<Object> nearestMetroStation = null;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address_obj")
    private AddressObj addressObj;
    @JsonProperty("address")
    private String address;
    @JsonProperty("local_name")
    private String localName;
    @JsonProperty("local_address")
    private String localAddress;
    @JsonProperty("local_lang_code")
    private String localLangCode;
    @JsonProperty("is_candidate_for_contact_info_suppression")
    private Boolean isCandidateForContactInfoSuppression;
    @JsonProperty("photo_count")
    private String photoCount;
    @JsonProperty("has_review_draft")
    private Boolean hasReviewDraft;
    @JsonProperty("has_panoramic_photos")
    private Boolean hasPanoramicPhotos;

    @JsonIgnore
    public Hotel getSimpleHotel() throws JsonProcessingException {
        Hotel hotel= new Hotel();
        hotel.setLocationId(this.locationId);
        hotel.setName(this.name);
        hotel.setLatitude(this.latitude);
        hotel.setLongitude(this.longitude);
        hotel.setAddress(this.address);
        hotel.setTimezone(this.timezone);
        hotel.setPhone(this.phone);
        hotel.setWebUrl(this.webUrl);
        hotel.setHacOffers(null);
        return hotel;

    }


    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(String numReviews) {
        this.numReviews = numReviews;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLocationString() {
        return locationString;
    }

    public void setLocationString(String locationString) {
        this.locationString = locationString;
    }

    public String getPreferredMapEngine() {
        return preferredMapEngine;
    }

    public void setPreferredMapEngine(String preferredMapEngine) {
        this.preferredMapEngine = preferredMapEngine;
    }

    public String getRawRanking() {
        return rawRanking;
    }

    public void setRawRanking(String rawRanking) {
        this.rawRanking = rawRanking;
    }

    public String getRankingGeo() {
        return rankingGeo;
    }

    public void setRankingGeo(String rankingGeo) {
        this.rankingGeo = rankingGeo;
    }

    public String getRankingGeoId() {
        return rankingGeoId;
    }

    public void setRankingGeoId(String rankingGeoId) {
        this.rankingGeoId = rankingGeoId;
    }

    public String getRankingPosition() {
        return rankingPosition;
    }

    public void setRankingPosition(String rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public String getRankingDenominator() {
        return rankingDenominator;
    }

    public void setRankingDenominator(String rankingDenominator) {
        this.rankingDenominator = rankingDenominator;
    }

    public String getRankingCategory() {
        return rankingCategory;
    }

    public void setRankingCategory(String rankingCategory) {
        this.rankingCategory = rankingCategory;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getSubcategoryType() {
        return subcategoryType;
    }

    public void setSubcategoryType(String subcategoryType) {
        this.subcategoryType = subcategoryType;
    }

    public String getSubcategoryTypeLabel() {
        return subcategoryTypeLabel;
    }

    public void setSubcategoryTypeLabel(String subcategoryTypeLabel) {
        this.subcategoryTypeLabel = subcategoryTypeLabel;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Object getDistanceString() {
        return distanceString;
    }

    public void setDistanceString(Object distanceString) {
        this.distanceString = distanceString;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public Boolean getLongClosed() {
        return isLongClosed;
    }

    public void setLongClosed(Boolean longClosed) {
        isLongClosed = longClosed;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public HacOffers getHacOffers() {
        return hacOffers;
    }

    public void setHacOffers(HacOffers hacOffers) {
        this.hacOffers = hacOffers;
    }

    public String getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(String hotelClass) {
        this.hotelClass = hotelClass;
    }

    public String getHotelClassAttribution() {
        return hotelClassAttribution;
    }

    public void setHotelClassAttribution(String hotelClassAttribution) {
        this.hotelClassAttribution = hotelClassAttribution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWriteReview() {
        return writeReview;
    }

    public void setWriteReview(String writeReview) {
        this.writeReview = writeReview;
    }

    public String getParentDisplayName() {
        return parentDisplayName;
    }

    public void setParentDisplayName(String parentDisplayName) {
        this.parentDisplayName = parentDisplayName;
    }

    public String getGuideCount() {
        return guideCount;
    }

    public void setGuideCount(String guideCount) {
        this.guideCount = guideCount;
    }

    public Boolean getJfyEnabled() {
        return isJfyEnabled;
    }

    public void setJfyEnabled(Boolean jfyEnabled) {
        isJfyEnabled = jfyEnabled;
    }

    public List<Object> getNearestMetroStation() {
        return nearestMetroStation;
    }

    public void setNearestMetroStation(List<Object> nearestMetroStation) {
        this.nearestMetroStation = nearestMetroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressObj getAddressObj() {
        return addressObj;
    }

    public void setAddressObj(AddressObj addressObj) {
        this.addressObj = addressObj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getLocalLangCode() {
        return localLangCode;
    }

    public void setLocalLangCode(String localLangCode) {
        this.localLangCode = localLangCode;
    }

    public Boolean getCandidateForContactInfoSuppression() {
        return isCandidateForContactInfoSuppression;
    }

    public void setCandidateForContactInfoSuppression(Boolean candidateForContactInfoSuppression) {
        isCandidateForContactInfoSuppression = candidateForContactInfoSuppression;
    }

    public String getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(String photoCount) {
        this.photoCount = photoCount;
    }

    public Boolean getHasReviewDraft() {
        return hasReviewDraft;
    }

    public void setHasReviewDraft(Boolean hasReviewDraft) {
        this.hasReviewDraft = hasReviewDraft;
    }

    public Boolean getHasPanoramicPhotos() {
        return hasPanoramicPhotos;
    }

    public void setHasPanoramicPhotos(Boolean hasPanoramicPhotos) {
        this.hasPanoramicPhotos = hasPanoramicPhotos;
    }
}
