package se.frolldevs.beercellar.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.frolldevs.beercellar.db.model.Beer;


@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {
}
