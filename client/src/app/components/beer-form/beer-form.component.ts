import {Component} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

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
}
