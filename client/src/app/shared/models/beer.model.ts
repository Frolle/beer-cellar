import {Brewery} from "./brewery.model";

export class Beer {
  id: number;
  name: string;
  breweries: Brewery[];
  style: string;
  bottledDate: Date;
  storedDate: Date;
  rating: number;
}
