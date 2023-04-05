package model;

import service.calculus.Sortable;

import java.util.Objects;

public class Film extends Title implements Sortable {

    private String director;

    public Film(String name, int releaseYear, int durationInMinutes, String director) {
        super(name, releaseYear, durationInMinutes);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRating() {
        return (int) getAverage() / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film film)) return false;
        return Objects.equals(getDirector(), film.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDirector());
    }

    @Override
    public String toString() {
        return "Film {" +
                super.toString() +
                "director=" + director + " }";
    }
}
