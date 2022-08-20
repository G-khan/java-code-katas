package dev.gokhana.loops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMapExamples {

    private static final List<Country> countries = Country.initCountries();

    List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

    List<Integer> listOfIntegers = listOfStrings.stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());


    public static List<String> getCountryNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }


    public static List<String> getCountryNamesUpperCase() {
        return countries.stream()
                .map(country -> country.getName().toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> getCountryPopulation() {
        return countries.stream()
                .map(Country::getPopulation).collect(Collectors.toList());
    }

    public static List<Integer> getCountryPopulation100() {
        return countries.stream()
                .map(x -> x.getPopulation() * 100).collect(Collectors.toList());
    }

    // map to int
    public static IntStream getCountryPopulationStream() {
        return countries.stream()
                .mapToInt(Country::getPopulation);
    }





}
