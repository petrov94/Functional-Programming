package com.java.stream.api;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MoviesExplorer test = new MoviesExplorer("E:\\Repo\\Concurrency\\movies1.txt");
        test.readFile();
//        List<Movie> list = (ArrayList)test.getMovies();
//        System.out.println(test.countMoviesReleasedIn(1970));
//        Movie result = test.findFirstMovieWithTitle("...4 ...3 ...2 ...1 ...morte");
//        System.out.print("Movie " + result.getName() + "  was released at " + result.getDate() + " actors : \n");
//        result.getActors().stream().forEach(e->System.out.println(e.getFirstName() + "  " + e.getLastName()));
//        test.getAllActors().stream().forEach(e->System.out.println("First name ----" + e.getFirstName() + "---- Last name -----" + e.getLastName()));
//        System.out.println(test.getFirstYear());
//        System.out.println(test.getAllMoviesBy(new Actor("Sherri","Zak")).toString());
        System.out.println(test.getMoviesSortedByReleaseYear().toString());
    }
}
