package service;

import model.Episode;
import model.Film;
import model.Series;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadInFile {
    public List<Film> readFileMovies() {

        String path = "../cineshow/src/resources/files/input/entrada1.txt";
        List<Film> films = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null && !line.equalsIgnoreCase("")) {

                List<String> stringList = Arrays.stream(line.split(",")).toList();

                String nameMovie = stringList.get(0);
                int releaseYear = Integer.parseInt(stringList.get(1));
                int durationInMinutes = Integer.parseInt(stringList.get(2));
                String director = stringList.get(3);

                Film myMovie = new Film(nameMovie, releaseYear, durationInMinutes, director);
                films.add(myMovie);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return films;
    }

    public List<Series> readFileSeries() {

        String path = "../cineshow/src/resources/files/input/entrada1.txt";
        List<Series> series = new ArrayList<>();
        boolean flag = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {

                if (line.equalsIgnoreCase("Serie") || flag) {
                    flag = true;
                    List<String> stringList = Arrays.stream(line.split(",")).toList();

                    if (!stringList.get(0).equalsIgnoreCase("Serie")) {
                        String nameSerie = stringList.get(0);
                        int releaseYear = Integer.parseInt(stringList.get(1));
                        int durationInMinutes = Integer.parseInt(stringList.get(2));
                        int seasons = Integer.parseInt(stringList.get(3));
                        int episodesBySeason = Integer.parseInt(stringList.get(4));
                        int minutesPerEpisode = Integer.parseInt(stringList.get(5));

                        Series minhaSeries = new Series(nameSerie, releaseYear, durationInMinutes, seasons, episodesBySeason, minutesPerEpisode);
                        series.add(minhaSeries);
                    }
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return series;
    }

    public List<Episode> readArchiveEpisodes() {

        String path = "../cineshow/src/resources/files/input/entrada2.txt";
        List<Episode> episodes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {

                List<String> stringList = Arrays.stream(line.split(",")).toList();
                int number = Integer.parseInt(stringList.get(0));
                String name = stringList.get(1);
                Series series = new Series(stringList.get(2));
                int totalviews = Integer.parseInt(stringList.get(3));

                Episode episode = new Episode(number, name, series, totalviews);

                episodes.add(episode);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return episodes;
    }
}
