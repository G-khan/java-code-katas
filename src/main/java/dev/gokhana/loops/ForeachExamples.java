package dev.gokhana.loops;

import java.util.List;

public class ForeachExamples {

    // create a country array list
    static List<Country> countries = Country.initCountries();

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
