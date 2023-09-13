package se.frolldevs.beercellar.bean;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.frolldevs.beercellar.db.model.Beer;
import se.frolldevs.beercellar.db.model.Brewery;
import se.frolldevs.beercellar.db.repository.BeerRepository;
import se.frolldevs.beercellar.db.repository.BreweryRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

@Component
public class BeerCellarDbInitialization {

    private static final Logger log = LoggerFactory.getLogger(BeerCellarDbInitialization.class);
    private final BeerRepository beerRepository;
    private final BreweryRepository breweryRepository;

    public BeerCellarDbInitialization(@Autowired BeerRepository beerRepository, @Autowired BreweryRepository breweryRepository) {
        this.beerRepository = beerRepository;
        this.breweryRepository = breweryRepository;
    }

    @Transactional
    public void createDummyData() {
        if (beerRepository.count() <= 0L) {
            log.info("No beers found, adding beers and breweries!");
            var listOfCoolBreweries = createCoolBreweries();
            breweryRepository.saveAll(listOfCoolBreweries);

            var listOfCoolBeers = createCoolBeers();
            var index = 0;

            for (var brewery : listOfCoolBreweries) {
                listOfCoolBeers.get(index).setBreweries(Set.of(brewery));
                index++;
            }

            listOfCoolBeers.get(1).setBreweries(Set.of(listOfCoolBreweries.get(0), listOfCoolBreweries.get(1)));

            beerRepository.saveAll(listOfCoolBeers);
        } else {
            log.info("Beers already added, nothing to do!");
        }
    }

    private List<Beer> createCoolBeers() {
        var stigbergetsBeer = new Beer();
        stigbergetsBeer.setName("Big Bourbon Barrel Aged Stout");
        stigbergetsBeer.setRating(4.5);
        stigbergetsBeer.setStyle("Imperial Stout");
        stigbergetsBeer.setBottledDate(LocalDate.of(2021, Month.FEBRUARY, 2));
        stigbergetsBeer.setStoredDate(LocalDate.of(2021, Month.MARCH, 2));

        var ooBeer = new Beer();
        ooBeer.setName("Katten");
        ooBeer.setRating(4.5);
        ooBeer.setStyle("DIPA");
        ooBeer.setBottledDate(LocalDate.of(2023, Month.JULY, 2));
        ooBeer.setStoredDate(LocalDate.of(2023, Month.JULY, 3));

        var otherHalfBeer = new Beer();
        otherHalfBeer.setName("Golden Kooks");
        otherHalfBeer.setRating(4.2);
        otherHalfBeer.setStyle("Barley Wine");
        otherHalfBeer.setBottledDate(LocalDate.of(2021, Month.FEBRUARY, 2));
        otherHalfBeer.setStoredDate(LocalDate.of(2021, Month.MARCH, 2));

        return List.of(stigbergetsBeer, ooBeer, otherHalfBeer);

    }

    private List<Brewery> createCoolBreweries() {
        var stigbergetsBrewery = new Brewery();
        stigbergetsBrewery.setName("Stigbergets");
        stigbergetsBrewery.setCountry("Sweden");

        var ooBrewery = new Brewery();
        ooBrewery.setName("O/O");
        ooBrewery.setCountry("Sweden");

        var otherHalfBrewery = new Brewery();
        otherHalfBrewery.setName("Other Half");
        otherHalfBrewery.setCountry("USA");

        return List.of(stigbergetsBrewery, ooBrewery, otherHalfBrewery);
    }
}
