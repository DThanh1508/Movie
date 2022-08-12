package test.demo.models;

import java.util.Date;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movie")
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    private String plot;
    private List<String> genres;
    private String title;
    private Date creationDate = new Date();

//    public Movie(String plot, List<String> genres, String title, Date creationDate) {
//        this.plot = plot;
//        this.genres = genres;
//        this.title = title;
//        this.creationDate = creationDate;
//    }
//    @Override
//    public String toString(){
//        return "Tutorial [Id: " + id + ", Plot: " + plot + ", Genres: " + genres + ", Title: " + title + ", Creation Date: "+ creationDate "]";
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
