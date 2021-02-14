package wsb.rest.movies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wsb.rest.person.Person;

@Getter
@Setter
@NoArgsConstructor
public class Movie {

    Long id;
    String title;
    Person director;
    String year;

    public Movie(Long id, String title, Person director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }
}
