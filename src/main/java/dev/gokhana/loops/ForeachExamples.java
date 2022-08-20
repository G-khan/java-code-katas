package dev.gokhana.loops;

import java.util.List;

public class ForeachExamples {

    // create a country array list
    private static final List<Country> countries = List.of(
            new Country("India", 100),
            new Country("USA", 200),
            new Country("Canada", 300),
            new Country("Australia", 400),
            new Country("Brazil", 500),
            new Country("England", 600)
    );

    public static void main(String[] args) {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

        for (Country country : countries) {
            System.out.println(country.getName());
        }

        countries.forEach(country -> System.out.println(country.getName()));
        countries.forEach(System.out::println);
    }
}
