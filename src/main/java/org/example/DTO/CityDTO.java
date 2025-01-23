package org.example.DTO;

public class CityDTO {
    private Integer cityId;
    private String name;
    private Integer countryId;
    private String lastUpdate;

    public CityDTO(Integer cityId, String name, Integer countryId, String lastUpdate) {
        this.cityId = cityId;
        this.name = name;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
