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

  products: Product[];
  currentCategoryId: number;
  currentCategoryName: string;

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
      // not category ID available. Default category ID to 1
      this.currentCategoryId = 1;
      this.currentCategoryName = 'Books';
    }

    // now get the products for the given category ID
    this.productService.getProductList(this.currentCategoryId).subscribe( // getProductList() method is invoked once you subscribe
      data => {  // 
        this.products = data; // assign results to the Product Array 
      },
      err => console.error("Observer got error: " + err),
      () => console.error("Observer got complete notification")
    )
  }
}
