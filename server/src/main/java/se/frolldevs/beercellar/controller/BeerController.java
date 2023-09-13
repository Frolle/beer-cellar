package se.frolldevs.beercellar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.frolldevs.beercellar.db.model.Beer;
import se.frolldevs.beercellar.db.repository.BeerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BeerController {
    private final BeerRepository beerRepository;

    public BeerController(@Autowired BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public Iterable<Beer> getBeers() {
        return beerRepository.findAll();
    }

    @PostMapping("/beers")
    public void addBeer(@RequestBody Beer beer) {
        beerRepository.save(beer);
    }
}
