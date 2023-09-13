package se.frolldevs.beercellar.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.frolldevs.beercellar.db.model.Brewery;


@Repository
public interface BreweryRepository extends CrudRepository<Brewery, Long> {
}
