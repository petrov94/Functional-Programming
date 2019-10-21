package com.java.stream.api;

import java.util.HashSet;
import java.util.Optional;

public final class Movie {

    private String name;
    private int date;
    private HashSet<Actor> actors;

    public Movie() {
        actors = new HashSet<>();
    }

    public Movie createMovie(String line) {
        String[] splitBySlashes = line.split("/");
        for (int i = 0; i < splitBySlashes.length; i++) {
            if (i == 0) {
                int lastSpace = splitBySlashes[0].lastIndexOf("(");
                this.name = splitBySlashes[0].substring(0, lastSpace);
                String date = splitBySlashes[0].substring(lastSpace);
                date = date.substring(date.indexOf('(')+1, date.lastIndexOf(')'));
                this.date = date.contains(",") ? Integer.valueOf(date.substring(date.indexOf(","))) : Integer.valueOf(date);
            } else {
                createActor(splitBySlashes[i]);
            }
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public HashSet<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", actors=" + actors +
                '}';
    }

    public void createActor(String actor) {
        Actor nactor;
        if (actor.contains(",")) {
            nactor = new Actor(actor.substring(actor.indexOf(",")+2),actor.substring(0, actor.indexOf(",")));
        } else {
            nactor = new Actor(actor, null);
        }
        Optional.of(nactor).ifPresent((nact) -> this.actors.add(nact));
    }

}