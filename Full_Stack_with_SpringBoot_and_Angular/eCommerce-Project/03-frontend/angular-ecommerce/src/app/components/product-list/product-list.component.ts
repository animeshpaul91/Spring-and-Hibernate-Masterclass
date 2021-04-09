import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: 'product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;
  currentCategoryName: string = "Books";
  searchMode: boolean = false;

  // new properties for pagination
  pageNumber: number = 1;
  pageSize: number = 5;
  totalElements: number = 0;  

  constructor(private productService: ProductService,
    private route: ActivatedRoute) { } // inject activated route
  // The current active route that loaded the component. Useful for accessing route parameters. 
  // Activated Route provides access to info about a route associated with a component that is loaded in an outlet.

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      // paramMap is an observable that contains a map of the required and optional parameters specific to each route. 
      // the map supports retrieving single and multiple values from the same parameter.
      // parammap.subscrbe is done to re render the component whenever there is a change in URL, even if from /category/1 to category/2
      // currently as per Router config, /category/1 or category/2 is generic as /category/:id so, both will return the same ProductList instance
      // alert("I am in ngOnInit");
      this.listProducts(); // this will help call listProducts() everytime there is a change in the routing URL.
    });

  }

  listProducts() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode)
      this.handleSearchProducts();
    else
      this.handleListProducts();
  }
  

  handleListProducts() {
    // alert("I am in listProducts()");
    // check if "id" paramter is available 
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id'); // the :id configigured in app.module.ts is the key
    // route is activated route
    // snapshot is state of route at this moment in time
    // param map is a map of all parameters

    if (hasCategoryId) {
      // get the "id" param string. convert string to a number using the + symbol. 
      this.currentCategoryId = + this.route.snapshot.paramMap.get('id'); // this id refers to the id (key) mentioned in app.module.ts
      this.currentCategoryName = this.route.snapshot.paramMap.get('name'); // this id refers to the name (key) mentioned in app.module.ts
    }

    else {
      // no category ID available. Default category ID to 1
      this.currentCategoryId = 1;
      this.currentCategoryName = 'Books';
    }


    // check if we have a different category than previous
    // Nott: Angular will reuse a component if its currently being viewed
    // if we havea different ctaegory id than previous, then set page Number to 1
    if (this.previousCategoryId != this.currentCategoryId) {
      this.pageNumber = 1;
    }

    this.previousCategoryId = this.currentCategoryId;
    console.log(`currentCategoryId=${this.currentCategoryId}, pageNumber=${this.pageNumber}`);


    // now get the products for the given category ID
    this.productService.getProductListPaginate(this.pageNumber - 1, this.pageSize, this.currentCategoryId).subscribe(this.processResult());
  }
  processResult() {
    return data => {
      this.products = data._embedded.products;
      this.pageNumber = data.page.number + 1; // spring data rest has pages zero based while angular has it 1-based
      this.pageSize = data.page.size;
      this.totalElements = data.page.totalElements;
    };
  }

  handleSearchProducts() {
    const theKeyword: string = this.route.snapshot.paramMap.get('keyword');
    // now search for Products using this given keyword
    this.productService.searchProducts(theKeyword).subscribe(
      data => {
          this.products = data;
      }
    );
  }

  updatePageSize(pageSize: number) {
    this.pageSize = pageSize;
    this.pageNumber = 1;
    this.listProducts();
  }
}
