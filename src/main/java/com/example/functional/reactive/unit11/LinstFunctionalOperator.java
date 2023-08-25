package com.example.functional.reactive.unit11;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LinstFunctionalOperator {
    public static void main(String[] args){
        List<Movie> movies = Arrays.asList(
                new Movie("Spotlight",2015,"Hollywood"),
                new Movie("Avengers: Infinity War",2018,"Hollywood"),
                new Movie("Inception",2010,"Hollywood"),
                new Movie("Forest Gump",1994,"Hollywood"),
                new Movie("3 Idiots",2009,"Bollywood"),
                new Movie("Beauty and the beast",2017,"Hollywood"),
                new Movie("Slumdog Millionaire",2008,"Bollywood")
        );

        //Traverse
        System.out.println("Movies List");
        movies.forEach(System.out::println);


        //Sort
        movies.sort((movie1,movie2)->movie2.getReleaseYear()-movie1.getReleaseYear());
        System.out.println("Movies List Sorted");
        movies.forEach(System.out::println);


        //filter
       List<Movie> filtered = movies.stream()
                .filter(movie->movie.getIndustry().equalsIgnoreCase("Bollywood"))
                .collect(Collectors.toList());
        System.out.println("Movies Filtered");
        filtered.forEach(System.out::println);

        //mapping
        List<String>  movieNames = movies.stream()
                .map(movie->movie.getName())
                .collect(Collectors.toList());

        System.out.println("Movie Names::");
        movieNames.forEach(System.out::println);

        //reduce
        Optional<String> movieNameString = movies.stream()
                .map(movie->movie.getName())
                .reduce((movieName1,movieName2)->movieName1+"|"+movieName2);
        System.out.println("Movie Name String::"+movieNameString.orElse(""));

    }

}
