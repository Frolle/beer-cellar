package se.dirnberger.beercellar.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.dirnberger.beercellar.db.model.Beer;


@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {
}
