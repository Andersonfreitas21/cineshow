package model;

import service.calculus.Sortable;

public class Series extends Title implements Sortable {
    private int seasons;
    private boolean active;
    private int episodesBySeason;
    private int minutesPerEpisode;

    public Series(String nome, int anoDeLancamento, int duracaoEmMinutos,
                  int seasons, int episodesBySeason, int minutesPerEpisode) {
        super(nome, anoDeLancamento, duracaoEmMinutos);
        this.seasons = seasons;
        this.episodesBySeason = episodesBySeason;
        this.minutesPerEpisode = minutesPerEpisode;
    }

    public Series(String nome) {
        super(nome);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesBySeason() {
        return episodesBySeason;
    }

    public void setEpisodesBySeason(int episodesBySeason) {
        this.episodesBySeason = episodesBySeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    public void exibeFichaTecnica(){
        System.out.println("Series name: " + super.getName());
        System.out.println("Release year: " + super.getReleaseYear());
    }

    @Override
    public String toString() {
        return "Series {" +
                super.toString() +
                "seasons=" + seasons +
                ", active=" + active +
                ", episodesBySeason=" + episodesBySeason +
                ", minutesPerEpisode=" + minutesPerEpisode + "}";
    }

    @Override
    public int getRating() {
        return (int) getAverage() / 2;
    }
}
