package se.frolldevs.beercellar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.frolldevs.beercellar.bean.BeerCellarDbInitialization;

@SpringBootApplication
public class BeerCellarApplication implements CommandLineRunner{


	@Value("${shouldInitializeDb}")
	private boolean shouldInitializeDb;

	private final BeerCellarDbInitialization beerCellarDbInitialization;
	public static void main(String[] args) {
		SpringApplication.run(BeerCellarApplication.class, args);
	}

	@Autowired
	public BeerCellarApplication(BeerCellarDbInitialization beerCellarDbInitialization) {
		this.beerCellarDbInitialization = beerCellarDbInitialization;
	}


	@Override
	public void run(String... args) {
		if (shouldInitializeDb) {
			this.beerCellarDbInitialization.createDummyData();
		}
	}
}
