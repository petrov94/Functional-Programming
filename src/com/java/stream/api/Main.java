package com.java.stream.api;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MoviesExplorer test = new MoviesExplorer("C:\\Users\\p.petrov\\Desktop\\movies1.txt");
        test.readFile();
//        List<Movie> list = (ArrayList)test.getMovies();
        System.out.println(test.countMoviesReleasedIn(1970));
        Stream.of(test.findFirstMovieWithTitle("...4 ...3 ...2 ...1 ...morte")).flatMap(e -> Stream.concat(Stream.of(e.getName(), e.getDate()),Stream.of(e.getActors().stream().flatMap(actor->Stream.of(actor.getFirstName(),actor.getLastName()))).forEach(el -> System.out.print(el)));
    }
}
