import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';

@Injectable({ // this enables the ProductService to be injected across the application
  providedIn: 'root'
})

export class ProductService {

  private baseUrl: string = "http://localhost:8080/api/products";
  constructor(private httpClient: HttpClient) { }

  getProductList(): Observable<Product[]> { // this method maps type JSON data from the SpringBoot REST service to a product array
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.products)
    );
  }
}

interface GetResponse { // will help unwrap JSON data from REST API and make use of the _embedded entry that comes back from the API
  _embedded: {
    products: Product[]; // data gets binded to the Products Array defined in this project
  }
}