package dev.gokhana.loops;

import java.util.List;

public class Country {
    private String name;
    private int population;

    public Country(String india, int population) {
        this.name = india;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public static List<Country> initCountries() {
        return List.of(
                new Country("India", 100),
                new Country("USA", 200),
                new Country("Canada", 300),
                new Country("Australia", 400),
                new Country("Brazil", 500),
                new Country("England", 600)
        );
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
