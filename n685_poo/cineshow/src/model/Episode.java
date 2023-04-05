package model;

import service.calculus.Sortable;

import java.util.Objects;

public class Episode implements Sortable {

    private int number;
    private String name;
    private Series series;
    private int totalviews;


    public Episode(int number, String name, Series series, int totalviews) {
        this.number = number;
        this.name = name;
        this.series = series;
        this.totalviews = totalviews;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSerie() {
        return series;
    }

    public void setSerie(Series series) {
        this.series = series;
    }

    public int getTotalviews() {
        return totalviews;
    }

    public void setTotalviews(int totalviews) {
        this.totalviews = totalviews;
    }


    @Override
    public int getRating() {
        if (totalviews > 100) {
            return 4;
        } else {
            return 2;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode episode)) return false;
        return getNumber() == episode.getNumber() && getTotalviews() == episode.getTotalviews() && Objects.equals(getName(), episode.getName()) && Objects.equals(getSerie(), episode.getSerie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getName(), getSerie(), getTotalviews());
    }

    @Override
    public String toString() {
        return "Episode {" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", series=" + series +
                ", totalviews=" + totalviews +
                '}';
    }
}
