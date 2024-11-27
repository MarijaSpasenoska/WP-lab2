package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter
public class Song {
    //primaren kluc za entitetot vo JPA
    @Id
    //ovozmozuva bazata na podatoci avtomatski da ja generira vrednosta na ovoj atribut
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    String title;
    String genre;
    Integer releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;

    public Song(String title, String genre, Integer releaseYear, Album album) {
        //уникатно ID за секоја песна
        this.trackId = (long) (Math.random()*1000);

        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers = new ArrayList<>();
        this.album = album;
        //add albums maybe
    }

    public void addArtist(Artist performer){
        performers.add(performer);
    }
}
