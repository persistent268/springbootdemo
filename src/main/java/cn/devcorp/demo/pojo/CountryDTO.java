package cn.devcorp.demo.pojo;

public class CountryDTO {
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public Boolean isChinaName() {
        return this.country.equals("中国");
    }
}