package test.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import test.demo.models.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
