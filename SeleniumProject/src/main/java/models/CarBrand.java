package models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarBrand {

    private String name;
    private String logoUrl;
    private int foundedYear;
    private String officialSite;
    private String headquarterCity;
    private String headquarterCountry;

    private CarBrand() {

    }

    public CarBrand(String name, String logoUrl, int foundedYear, String officialSite, String headquarterCity, String headquarterCountry) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.foundedYear = foundedYear;
        this.officialSite = officialSite;
        this.headquarterCity = headquarterCity;
        this.headquarterCountry = headquarterCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public String getHeadquarterCity() {
        return headquarterCity;
    }

    public void setHeadquarterCity(String headquarterCity) {
        this.headquarterCity = headquarterCity;
    }

    public String getHeadquarterCountry() {
        return headquarterCountry;
    }

    public void setHeadquarterCountry(String headquarterCountry) {
        this.headquarterCountry = headquarterCountry;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public String getHeadquarter() {
        return this.headquarterCity + ", " + this.headquarterCountry;
    }

    public static final class CarBrandBuilder {
        private String name;
        private String logoUrl;
        private int foundedYear;
        private String officialSite;
        private String headquarterCity;
        private String headquarterCountry;
        private List<String> logoUrls = Arrays.asList("http://foto-hosting.pl/img/2c/27/ec/2c27ec88beaf95ed9c03d0577e2206e65683b7dd.jpeg",
                "http://foto-hosting.pl/img/03/56/f0/0356f072e23c05815723a428fd0c7f5a596af99a.jpeg",
                "http://foto-hosting.pl/img/3a/ea/87/3aea87ae00f61bc2dd1e59c6ec749963faf5f1b2.jpeg",
                "http://foto-hosting.pl/img/25/4b/fe/254bfeadf464f028be8cc06fa440a0e762c28105.jpeg");

        public CarBrandBuilder() {
            Collections.shuffle(logoUrls);
            this.name = "Test " + RandomStringUtils.randomAlphabetic(10);
            this.logoUrl = logoUrls.get(0);
            this.foundedYear = Integer.parseInt(RandomStringUtils.randomNumeric(4));
            this.officialSite = "www." + RandomStringUtils.randomAlphabetic(10).toLowerCase() + ".com";
            this.headquarterCity = RandomStringUtils.randomAlphabetic(10);
            this.headquarterCountry = RandomStringUtils.randomAlphabetic(10);
        }

        public CarBrand build() {
            return new CarBrand(this.name, this.logoUrl, this.foundedYear, this.officialSite, this.headquarterCity, this.headquarterCountry);
        }
    }
}
