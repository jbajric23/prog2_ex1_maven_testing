package at.ac.fhcampuswien.fhmdb.models;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Movie {
    private String title;
    private String description;

    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies(){

        List<Movie> movies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\at\\ac\\fhcampuswien\\fhmdb\\DummyMovies.txt")))
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";"); // Assuming ';' separates different parts of movie data
                String title = parts[0];
                String description = parts[1];
                String[] genreNames = parts[2].split(","); // Assuming ',' separates different genres
                List<Genre> genres = new ArrayList<>();
                for (String genreName : genreNames) {
                    Genre genre = Genre.valueOf(genreName);
                    genres.add(genre);
                }
                movies.add(new Movie(title, description, genres));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Handle file not found exception
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file reading exception
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions
        }

        return movies;
    }
}
