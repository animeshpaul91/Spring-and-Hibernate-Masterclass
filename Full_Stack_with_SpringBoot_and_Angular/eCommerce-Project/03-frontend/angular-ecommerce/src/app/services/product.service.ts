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
    return this.getProducts(searchURL);
  }

  getProductListPaginate(page: number, pageSize: number, categoryId: number): Observable<GetResponseProducts> { // this method maps type JSON data from the SpringBoot REST service to a product array
    // need to build the URL based on category ID, page and size
    const searchURL: string = `${this.baseUrl}/search/findByCategoryId?id=${categoryId}&page=${page}&size=${pageSize}`;
    return this.httpClient.get<GetResponseProducts>(searchURL);
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    const searchURL: string = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`;
    return this.getProducts(searchURL);
  }

  searchProductsPaginate(page: number, pageSize: number, theKeyword: string): Observable<GetResponseProducts> { // this method maps type JSON data from the SpringBoot REST service to a product array
    // need to build the URL based on keyword, page and size
    const searchURL: string = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}&page=${page}&size=${pageSize}`;
    return this.httpClient.get<GetResponseProducts>(searchURL);
  }

  private getProducts(searchURL: string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(searchURL).pipe(
      map(response => response._embedded.products)
    );
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );

  }

  getProduct(productId: number): Observable<Product> {
    const productUrl: string = `${this.baseUrl}/${productId}`;
    return this.httpClient.get<Product>(productUrl); // do not need to unwrap JSON to component object as this does not have embedded in it. 
  }

}

interface GetResponseProducts { // will help unwrap JSON data from REST API and make use of the _embedded entry that comes back from the API
  _embedded: {
    products: Product[]; // data gets binded to the Products Array defined in this project
  },
  page: { // refactoring interface to support pagination
    size: number,
    totalElements: number,
    totalPages: number,
    number: number
  }
}

interface GetResponseProductCategory { // will help unwrap JSON data from REST API and make use of the _embedded entry that comes back from the API
  _embedded: {
    productCategory: ProductCategory[]; // data gets binded to the Products Array defined in this project
  }
}