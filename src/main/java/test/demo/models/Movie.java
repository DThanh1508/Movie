package test.demo.models;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movie")
@Data
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    private String plot;
    private String img;
    private List<String> genres;
    private String title;
    private Date creationDate = new Date();
    private boolean active;
}
