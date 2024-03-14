package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class HomeControllerTest {
    // TODO implement unittests for the HomeController class -> TDD

    @Test
    public void filterMovies() throws FileNotFoundException {
        // Create a list of movies
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Movie 1", "Description 1", Arrays.asList(Genre.ACTION, Genre.DRAMA)));
        allMovies.add(new Movie("Movie 2", "Description 2", Arrays.asList(Genre.COMEDY, Genre.DRAMA)));
        allMovies.add(new Movie("Movie 3", "Description 3", Arrays.asList(Genre.ACTION, Genre.COMEDY)));

        // Create HomeController and set allMovies
        HomeController homeController = new HomeController();
        homeController.setAllMovies(allMovies);

        // Call filterMovies with query and genre
        List<Movie> filteredMovies = homeController.filterMovies("1", Genre.ACTION);

        // Check if the filtered list contains the correct movies
        assertEquals(1, filteredMovies.size());
        assertEquals("Movie 1", filteredMovies.get(0).getTitle());
    }
}