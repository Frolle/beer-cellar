import {Component, OnInit} from '@angular/core';
import {Beer} from "../../shared/models/beer.model";
import {BeerService} from "../../shared/services/beer.service";


@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.scss']
})
export class BeerListComponent implements OnInit {
  beers: Beer[];
  columnsToDisplay = ['beerName', 'brewery', 'style', 'bottledDate', 'storedDate', 'rating']

  constructor(private beerService: BeerService) {
  }

  ngOnInit(): void {
    this.beerService.findAll().subscribe(beers => this.beers = beers);
  }

  addBeer() {
    //TODO: Make this actually take input from the user in the form of a form.
    var beer = new Beer();
    beer.rating = 2.5;
    beer.style = 'Lager';
    beer.bottledDate = new Date();
    beer.storedDate = new Date();

    beer.name = 'Heineken';
    this.beerService.addBeer(beer);
  }
}
