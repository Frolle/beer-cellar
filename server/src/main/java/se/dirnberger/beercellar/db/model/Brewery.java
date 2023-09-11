package se.dirnberger.beercellar.db.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String country;

    @ManyToMany(mappedBy = "brewery_beers")
    private Set<Beer> beers;
}
