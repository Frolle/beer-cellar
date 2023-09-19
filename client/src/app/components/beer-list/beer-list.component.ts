import {Component, OnInit} from '@angular/core';
import {Beer} from "../../shared/models/beer.model";
import {BeerService} from "../../shared/services/beer.service";
import {MatDialog} from "@angular/material/dialog";
import {BeerFormComponent} from "../beer-form/beer-form.component";


@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.scss']
})
export class BeerListComponent implements OnInit {
  beers: Beer[];
  columnsToDisplay = ['beerName', 'brewery', 'style', 'bottledDate', 'storedDate', 'rating']

  constructor(private beerService: BeerService, public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.beerService.findAll().subscribe(beers => this.beers = beers);
  }
  openDialog() {
    const dialogRef = this.dialog.open(BeerFormComponent, {
      disableClose: false, autoFocus: true, hasBackdrop: true
    })
  }
}
