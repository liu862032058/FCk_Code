package com.lyq.entry;

public class CityInfo {
    private String city;
    private Double longitude;
    private Double latitude;

    public CityInfo() {
    }

    public CityInfo(String city, Double longitude, Double latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "city='" + city + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
