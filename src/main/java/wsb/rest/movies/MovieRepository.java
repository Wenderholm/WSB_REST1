package wsb.rest.movies;

import org.springframework.stereotype.Repository;
import wsb.rest.person.Person;

import java.util.*;

@Repository
public class MovieRepository {

    static Long currentId = 4L;

    static final List<Movie> movies = new LinkedList<>(Arrays.asList(
            new Movie(1L, "Pulp Fiction", new Person("Quentin", "Tarantino"), "1994"),
            new Movie(2L, "Proces Siódemki z Chicago", new Person("Aaron", "Sorkin"), "2020"),
            new Movie(3L, "Fight Club", new Person("David", "Fincher"), "1999")
    ));

    List<Movie> find() {
        return movies;
    }

    Movie find(Long id) {
        return movies.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    Movie save(Movie movie) {
        movie.id = currentId++;
        movies.add(movie);
        return movie;
    }

    Movie update(Movie movie) {
        Movie movieToUpdate = find(movie.getId());

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDirector(movie.getDirector());
        movieToUpdate.setYear(movie.getYear());

        return movieToUpdate;
    }

    void delete(Long id) {
        Movie movie = find(id);
        movies.remove(movie);
    }


}
