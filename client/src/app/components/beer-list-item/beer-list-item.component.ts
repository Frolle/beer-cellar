import {Component, Input} from '@angular/core';
import {Beer} from "../../shared/models/beer.model";

@Component({
  selector: 'app-beer-list-item',
  templateUrl: './beer-list-item.component.html',
  styleUrls: ['./beer-list-item.component.scss']
})
export class BeerListItemComponent {
  @Input()
  beer: Beer;
}
