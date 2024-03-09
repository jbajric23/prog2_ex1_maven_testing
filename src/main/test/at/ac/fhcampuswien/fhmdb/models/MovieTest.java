package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    FileReader productionMovieData = new FileReader ("src\\main\\resources\\at\\ac\\fhcampuswien\\fhmdb\\DummyMovies.txt");
    FileReader testMovieData = new FileReader ("src\\main\\test\\at\\ac\\fhcampuswien\\fhmdb\\models\\testingdata\\DummyMoviesTest.txt");

    MovieTest() throws FileNotFoundException {
    }

    @Test
    void initializeMovies_returns_correct_movieList_length_from_DummyMovies() {
        // Given
        int expectedSize = 15;

        // When
        List<Movie> movies = Movie.initializeMovies(productionMovieData);
        int actualSize = movies.size();

        // Then
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void initializeMovies_returns_correct_movieList_title_from_fourth_item() {
        // Given
        String expectedTitle = "Fight Club";

        // Then
        List<Movie> movies = Movie.initializeMovies(productionMovieData);
        String actualTitle = movies.get(4).getTitle();

        // When
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void initializeMovies_returns_correct_description_start_from_ninth_item() {
        // Given
        String expectedDescriptionStart = "In German-occupied Poland during World War II";

        // When
        List<Movie> movies = Movie.initializeMovies(productionMovieData);
        String actualDescriptionStart = movies.get(8).getDescription().substring(0, 45);

        // Then
        assertEquals(expectedDescriptionStart, actualDescriptionStart);
    }

    @Test
    void initializeMovies_returns_correct_movieList_genres_from_thirteenth_movie() {
        // Given
        List<Genre> expectedGenres = List.of(Genre.BIOGRAPHY, Genre.CRIME);

        // When
        List<Movie> movies = Movie.initializeMovies(productionMovieData);
        List<Genre> actualGenres = movies.get(12).getGenres();

        // Then
        assertEquals(expectedGenres, actualGenres);
    }
}