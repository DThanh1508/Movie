package test.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.demo.models.Movie;
import test.demo.repositories.MovieRepository;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
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
//
    @GetMapping(value = "")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieRepository.findById(id).get();
//        System.out.println();
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
    public void deleteMovie(
            @PathVariable("id") String id
    ){
        movieRepository.deleteById(id);
    }

}
