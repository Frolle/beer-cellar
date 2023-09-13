import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BeerListComponent} from './components/beer-list/beer-list.component';
import {BeerListItemComponent} from './components/beer-list-item/beer-list-item.component';
import {MatTableModule} from "@angular/material/table";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent,
    BeerListComponent,
    BeerListItemComponent
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
