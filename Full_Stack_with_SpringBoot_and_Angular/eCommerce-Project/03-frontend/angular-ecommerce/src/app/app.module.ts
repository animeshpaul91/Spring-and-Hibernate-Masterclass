import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductService } from './services/product.service';
import { Routes, RouterModule } from '@angular/router';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';


const routes: Routes = [
    {path: 'search/:keyword', component: ProductListComponent}, // route will be handled by Product List Component
    {path: 'category/:id/:name', component: ProductListComponent}, // when path matches its going to create a new instance of ProductListComponent
    {path: 'category', component: ProductListComponent},
    {path: 'products', component: ProductListComponent},
    {path: '', redirectTo: '/products', pathMatch: 'full'},
    {path: '**', redirectTo: '/products', pathMatch: 'full'} // generic wildcard

    // The order of the routes is important. The order has to be starting from the most specific to generic. 
]

@NgModule({
  declarations: [ // list of all components in this application
    AppComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent
  ],
  imports: [
    RouterModule.forRoot(routes), // this functions as the root Router. These set of routes are available to the entire application
    BrowserModule, 
    HttpClientModule // add Httpclient module for making API requests. This module becomes available to the application and can be injected 
    // across the application
  ],
  providers: [ProductService], // add Product Service to help this get injected in any part of the application
  bootstrap: [AppComponent]
})
export class AppModule { }
