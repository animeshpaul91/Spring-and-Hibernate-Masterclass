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

  constructor(private productService: ProductService,
    private route: ActivatedRoute) { } // inject activated route
  // The current active route that loaded the component. Useful for accessing route parameters. 
  // Activated Route provides access to info about a route associated with a component that is loaded in an outlet.

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      // paramMap is an observable that contains a map of the required and optional parameters specific to each route. 
      // the map supports retrieving single and multiple values from the same parameter.
      this.listProducts(); // this will help call listProducts() everytime there is a change in the routing URL.
    });

  }

  listProducts() {
    // check if "id" paramter is available 
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id'); // the :id configigured in app.module.ts is the key
    // route is activated route
    // snapshot is state of route at this moment in time
    // param map is a map of all parameters

    if (hasCategoryId) {
      // get the "id" param string. convert string to a number using the + symbol. 
      this.currentCategoryId = + this.route.snapshot.paramMap.get('id');
    }

    else {
      // not category ID available. Default category ID to 1
      this.currentCategoryId = 1;
    }

    // now get the products for the given category ID
    this.productService.getProductList(this.currentCategoryId).subscribe( // getProductList() method is invoked once you subscribe
      data => {
        this.products = data; // assign results to the Product Array 
      }
    )
  }
}
