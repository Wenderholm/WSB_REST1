package wsb.rest.movies;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    List<Movie> index() {
        return movieRepository.find();
    }

    @GetMapping("/{id}")
    Movie show(@PathVariable Long id) {
        return movieRepository.find(id);
    }

    @PutMapping("/")
    Movie update(@RequestBody Movie movie) {
        return movieRepository.update(movie);
    }

    @PostMapping("/")
    Movie save(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id) {
        movieRepository.delete(id);
        return "OK";
    }

}
