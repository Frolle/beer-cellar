package se.frolldevs.beercellar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.frolldevs.beercellar.db.model.Beer;
import se.frolldevs.beercellar.db.repository.BeerRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class BeerCellarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerCellarApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BeerRepository beerRepository) {
		return args -> {
			Stream.of("West Coast IPA", "Astra Urtyp (önskad av C0la_dragon)", "Ingen (önskad av BabyDragonling83)", "Eclipse", "Westvleteren 12 (önskad av C0la_dragon)").forEach(name -> {
				Beer beer = new Beer();
				beer.setName(name);
				beerRepository.save(beer);

			});
			beerRepository.findAll().forEach(System.out::println);
		};
	}
}
