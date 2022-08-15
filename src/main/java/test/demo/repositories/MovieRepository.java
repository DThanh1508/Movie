package test.demo.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import test.demo.models.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
//    List<Movie> findByTitle(String title);

    List<Movie> findByActive(boolean b);
}
