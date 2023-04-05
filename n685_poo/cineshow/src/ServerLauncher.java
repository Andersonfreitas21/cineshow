import model.Series;
import service.calculus.FilterRecommendation;
import model.Episode;
import model.Film;
import service.WriteToFile;
import service.ReadInFile;
import service.calculus.TimeCalculatorImpl;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ServerLauncher {

    public static void main(String[] args) throws IOException {

        ReadInFile c = new ReadInFile();

        List<Film> films = c.readFileMovies();
        List<Series> series = c.readFileSeries();
        List<Episode> episodes = c.readArchiveEpisodes();

        FilterRecommendation filter = new FilterRecommendation();


        WriteToFile g = new WriteToFile();


        films.forEach(
                film -> {
                    film.exibeFichaTecnica();
                    film.getDurationInMinutes();
                    film.value(new Random().doubles(0, 10).limit(1).findFirst().getAsDouble());
                    film.value(new Random().doubles(0, 10).limit(1).findFirst().getAsDouble());
                    film.value(new Random().doubles(0, 10).limit(1).findFirst().getAsDouble());
                    System.out.println("Average ratings: " + film.getAverage());
                    filter.filters(film);
                    System.out.println();
                }
        );

        series.forEach(
                serie -> {
                    serie.exibeFichaTecnica();
                    serie.getDurationInMinutes();
                    serie.value(new Random().doubles(0, 10).limit(1).findFirst().getAsDouble());
                    serie.value(new Random().doubles(0, 10).limit(1).findFirst().getAsDouble());
                    serie.value(new Random().doubles(0, 10).limit(1).findFirst().getAsDouble());
                    System.out.println("Average ratings: " + serie.getAverage());
                    System.out.println("Duration to marathon : " + serie.getDurationInMinutes());
                    filter.filters(serie);
                    System.out.println();
                }
        );

        episodes.forEach(
                episode -> {
                    System.out.println(episode.toString());
                    filter.filters(episode);
                    System.out.println();
                }
        );

        TimeCalculatorImpl calculator = new TimeCalculatorImpl();

        calculator.include(films.get(0));
        calculator.include(films.get(1));
        calculator.include(series.get(0));
        calculator.include(series.get(1));

        System.out.println("Total time of movies and series included : " + calculator.getTotalTime());

        g.WriteToFileFilms(films);
        g.gravarEmArquivoSerie(series);
        g.gravarEmArquivoEpisodio(episodes);

    }


}