package test.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.demo.models.Movie;
import test.demo.repositories.MovieRepository;
import java.util.List;

@RestController
@RequestMapping(value = "/movie")
@CrossOrigin("http://localhost:8080/")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @PostMapping(value = "")
    public Movie createNewMovie(
            @RequestBody Movie movie
    ) {
        return movieRepository.save(movie);
    }
    @GetMapping(value = "")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieRepository.findById(id).get();
    }
    @PutMapping("/{id}")
    public Object updateMovie(
            @PathVariable("id") String id,
            @RequestBody Movie movie
    ) {
        Movie movieFromDB = movieRepository.findById(id).get();
//        Object use equals
        if (!movie.getId().equals(movieFromDB.getId())) {
            return movieRepository.save(movie);
        }
        return "No chang data";
    }
    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable("id") String id){
        Movie movieFromDB = movieRepository.findById(id).get();
//        Object use equals
        movieFromDB.setActive(false);
        return movieRepository.save(movieFromDB);
    }
    @GetMapping("/not-active")
    public ResponseEntity<List<Movie>> findByActiveDelete() {
        try {
            List<Movie> movie = movieRepository.findByActive(true);
            if (movie.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/active")
    public ResponseEntity<List<Movie>> findByActive() {
        try {
            List<Movie> movie = movieRepository.findByActive(false);
            if (movie.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
