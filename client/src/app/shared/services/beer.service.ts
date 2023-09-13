import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Beer} from "../models/beer.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BeerService {
  private readonly beersUrl: string;

  constructor(private client: HttpClient) {
    this.beersUrl = 'http://localhost:8080/beers';
  }

  public findAll(): Observable<Beer[]> {
    return this.client.get<Beer[]>(this.beersUrl);
  }

  public addBeer(beer: Beer) {
    this.client.post(this.beersUrl, beer).subscribe({
      error: (e) => console.error('failed when adding beer', e),
      complete: () => console.info('Successfully added your beer!')
    });

  }
}
