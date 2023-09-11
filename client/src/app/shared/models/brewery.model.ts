import {Beer} from "./beer.model";

export class Brewery {
  id: number;
  name: string;
  country: string;
  beers: Set<Beer>;
}
