import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductService } from './services/product.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule, 
    HttpClientModule // add Httpclient module for making API requests
  ],
  providers: [ProductService], // add Product Service to help this get injected in any part of the application
  bootstrap: [AppComponent]
})
export class AppModule { }
