package models;

import models.enums.CarModelClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarModel {
    private CarBrand carBrand;
    private String name;
    private CarModelClass carModelClass;
    private int numberOfGenerations;

    private CarModel() {

    }

    public CarModel(CarBrand carBrand, String name, CarModelClass carModelClass, int numberOfGenerations) {
        this.carBrand = carBrand;
        this.name = name;
        this.carModelClass = carModelClass;
        this.numberOfGenerations = numberOfGenerations;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarModelClass getCarModelClass() {
        return carModelClass;
    }

    public void setCarModelClass(CarModelClass carModelClass) {
        this.carModelClass = carModelClass;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public void setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }

    public static final class CarModelBuilder {
        private CarBrand carBrand;
        private String name;
        private CarModelClass carModelClass;
        private int numberOfGenerations;

        public CarModelBuilder() {
            List<CarModelClass> classes = Arrays.asList(CarModelClass.values());
            Collections.shuffle(classes);
            this.carBrand = new CarBrand.CarBrandBuilder().build();
            this.name = RandomStringUtils.randomAlphabetic(10);
            this.carModelClass = classes.get(0);
            this.numberOfGenerations = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        }

        public CarModelBuilder withCarBrand(CarBrand carBrand) {
            this.carBrand = carBrand;
            return this;
        }

        public CarModel build() {
            return new CarModel(this.carBrand, this.name, this.carModelClass, this.numberOfGenerations);
        }
    }
}
