package se.dirnberger.beercellar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.dirnberger.beercellar.db.model.Beer;
import se.dirnberger.beercellar.db.repository.BeerRepository;

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
}
