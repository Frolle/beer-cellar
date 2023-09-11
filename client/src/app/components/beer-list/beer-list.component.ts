import {Component} from '@angular/core';
import {Beer} from "../../shared/models/beer.model";

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.scss']
})
export class BeerListComponent {
  beers: Beer[] = [];
  columnsToDisplay = ['beerName', 'brewery', 'style', 'bottledDate', 'storedDate', 'rating']

  constructor() {
    this.beers = [
      Object.assign(new Beer), {"name": "Grolsch", "style": "Lager", bottledDate: new Date(1253, 1, 31), rating: 2.53},
      Object.assign(new Beer), {
        "name": "max feta juice",
        "style": "fet Double IPA",
        bottledDate: new Date(1253, 1, 31),
        rating: 5.0
      },
      Object.assign(new Beer), {"name": "Heineken", "style": "Lager", bottledDate: new Date(1700, 1, 31), rating: 1.2},
      Object.assign(new Beer), {
        "name": "Stigbergets Big Bourbon",
        "style": "Barley Wine",
        bottledDate: new Date(1253, 1, 31),
        rating: 4.53
      },
    ];
  }
}
