package org.example.DTO;

public class CountryDTO {

    private Integer countryId;
    private String name;
    private String lastUpdate;

    public CountryDTO(Integer countryId, String name, String lastUpdate) {
        this.countryId = countryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
