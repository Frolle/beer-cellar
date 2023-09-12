package se.dirnberger.beercellar.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "brewery_beers",
            joinColumns = @JoinColumn(name = "brewery_id"),
            inverseJoinColumns = @JoinColumn(name = "beer_id"))
    private Set<Brewery> breweries;

    private String style;
    private LocalDate bottledDate;
    private LocalDate storedDate;
    private Double rating;

}
