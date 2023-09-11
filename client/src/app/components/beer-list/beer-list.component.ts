import { Component } from '@angular/core';
import {Beer} from "../../shared/models/beer.model";

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.scss']
})
export class BeerListComponent {

  beers: Beer[];
}
