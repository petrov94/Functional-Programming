package com.java.stream.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesExplorer {

    private String fileDir;
    private List<Movie> allMovies;

    public MoviesExplorer(String fileDir) {
        this.fileDir = fileDir;
        allMovies = new ArrayList<>();
    }

    public void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(this.fileDir));
        while (sc.hasNext()){
            allMovies.add(new Movie().createMovie(sc.nextLine()));
        }
    }

    public Collection<Movie> getMovies() {
        return this.allMovies;
    }

    public int countMoviesReleasedIn(int year){
        return (int)this.allMovies.stream().filter(movie -> movie.getDate()==year).count();
    }

    public Movie findFirstMovieWithTitle(String title){
        List<Movie> movieResult = this.allMovies.stream().filter(movie -> movie.getName().contains(title)).limit(1).collect(Collectors.toList());
        if(movieResult.size()==1){
            return movieResult.get(0);
        } else throw new IllegalArgumentException("There is no film with given name.");
    }

    public Collection<Actor> getAllActors(){
        return this.allMovies.stream().flatMap(e->e.getActors().stream()).collect(Collectors.toList());
    }

    public int getFirstYear(){
        return this.allMovies.stream().sorted((e,e1)-> e.getDate()-e1.getDate()).limit(1).mapToInt(e->e.getDate()).sum();
    }

    public Collection<Movie> getAllMoviesBy(Actor actor){
        return this.allMovies.stream().filter(e-> e.getActors().contains(actor)).collect(Collectors.toList());
    }

    public Collection<Movie> getMoviesSortedByReleaseYear(){
        return this.allMovies.stream().sorted((movie,movie1)->movie.getDate()-movie1.getDate()).collect(Collectors.toCollection(ArrayList::new));
    }

    public Movie findMovieWithGreatestNumberOfActors(){
        return this.allMovies.stream().sorted((movie,movie1)->movie.getActors().size()-movie1.getActors().size()).limit(1).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }


}
