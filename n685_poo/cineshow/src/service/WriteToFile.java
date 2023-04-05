package service;

import model.Episode;
import model.Film;
import model.Series;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public void WriteToFileFilms(List<Film> films) throws IOException {

        String path = "../cineshow/src/resources/files/result/resultado1.txt";

        FileWriter file = new FileWriter(path);
        BufferedWriter output = new BufferedWriter(file);
        System.out.println("Starting recording in movies category files.");
        films.forEach(film -> {
            try {
                output.write(film.toString() + "\n");
            } catch (Exception e) {
                e.getStackTrace();
            }
        });
        System.out.println("Ending recording.");
        output.close();
    }

    public void gravarEmArquivoSerie(List<Series> series) throws IOException {

        String path = "../cineshow/src/resources/files/result/resultado1.txt";

        FileWriter file = new FileWriter(path,true);
        BufferedWriter output = new BufferedWriter(file);
        System.out.println("Starting recording in series category files.");
        series.forEach(serie -> {
            try {
                output.write(serie.toString() + "\n");
            } catch (Exception e) {
                e.getStackTrace();
            }
        });
        System.out.println("Ending recording.");
        output.close();
    }

    public void gravarEmArquivoEpisodio(List<Episode> episodes) throws IOException {

        String path = "../cineshow/src/resources/files/result/resultado2.txt";

        FileWriter file = new FileWriter(path);
        BufferedWriter output = new BufferedWriter(file);
        System.out.println("Starting recording in episodes category files.");
        episodes.forEach(episode -> {
            try {
                output.write(episode.toString() + "\n");
            } catch (Exception e) {
                e.getStackTrace();
            }
        });
        System.out.println("Ending recording.");
        output.close();
    }
}
