import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BeerListComponent} from './components/beer-list/beer-list.component';
import {MatTableModule} from "@angular/material/table";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {BeerFormComponent} from './components/beer-form/beer-form.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    BeerListComponent,
    BeerFormComponent
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
