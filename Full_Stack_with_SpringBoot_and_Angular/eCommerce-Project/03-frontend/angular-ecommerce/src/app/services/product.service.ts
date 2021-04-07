import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';
import { ProductCategory } from '../common/product-category';

@Injectable({ // this enables the ProductService to be injected across the application
  providedIn: 'root'
})

export class ProductService {

  private baseUrl: string = "http://localhost:8080/api/products";

  private categoryUrl: string = "http://localhost:8080/api/product-category";

  constructor(private httpClient: HttpClient) { }

  getProductList(categoryId: number): Observable<Product[]> { // this method maps type JSON data from the SpringBoot REST service to a product array
    // need to build the URL based on category ID
    const searchURL: string = `${this.baseUrl}/search/findByCategoryId?id=${categoryId}`;

    return this.httpClient.get<GetResponseProducts>(searchURL).pipe(
      map(response => response._embedded.products)
    );
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    throw new Error('Method not implemented.');
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );

  }

}

interface GetResponseProducts { // will help unwrap JSON data from REST API and make use of the _embedded entry that comes back from the API
  _embedded: {
    products: Product[]; // data gets binded to the Products Array defined in this project
  }
}

interface GetResponseProductCategory { // will help unwrap JSON data from REST API and make use of the _embedded entry that comes back from the API
  _embedded: {
    productCategory: ProductCategory[]; // data gets binded to the Products Array defined in this project
  }
}