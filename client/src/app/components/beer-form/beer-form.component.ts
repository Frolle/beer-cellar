import {Component} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {BeerService} from "../../shared/services/beer.service";
import {Beer} from "../../shared/models/beer.model";

@Component({
  selector: 'app-beer-form',
  templateUrl: './beer-form.component.html',
  styleUrls: ['./beer-form.component.scss']
})
export class BeerFormComponent {
  beerForm = new FormGroup({
    name: new FormControl(),
    style: new FormControl(),
    bottledDate: new FormControl(),
    storedDate: new FormControl(),
    rating: new FormControl()
  });


  constructor(private beerService: BeerService) {

  }

  onSubmit() {
    let newBeer = Object.assign(new Beer(), this.beerForm.value);
    this.beerService.addBeer(newBeer)
  }
}
