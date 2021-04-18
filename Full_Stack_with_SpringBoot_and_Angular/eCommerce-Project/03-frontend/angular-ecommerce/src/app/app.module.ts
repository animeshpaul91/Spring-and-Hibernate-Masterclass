import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductService } from './services/product.service';
import { Routes, RouterModule, Router } from '@angular/router';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { LoginStatusComponent } from './components/login-status/login-status.component';

import {
  OKTA_CONFIG, 
  OktaAuthModule, 
  OktaCallbackComponent,
  OktaAuthGuard
} from '@okta/okta-angular';

import myAppConfig from './config/my-app-config';
import { MembersPageComponent } from './components/members-page/members-page.component';
import { OrderHistoryComponent } from './components/order-history/order-history.component';

const oktaConfig = Object.assign(
  {
    onAuthRequired: (oktaAuth, injector) => {
      const router = injector.get(Router);

      // Redirect the user to your custom login page
      router.navigate(['/login']); // route a user to login page if they are not authenticated
    }
  }, myAppConfig.oidc);

const routes: Routes = [
  {path: "order-history", component: OrderHistoryComponent, canActivate: [ OktaAuthGuard ]},
  {path: "members", component: MembersPageComponent, canActivate: [ OktaAuthGuard ]}, // OktaAuthGuard - if authenticated, gives access to route else sends back to login page
  {path: "login/callback", component: OktaCallbackComponent}, // once user is authenticated, they are redirected to your app. Okta does all token parsing
  {path: "login", component: LoginComponent},
  {path: "checkout", component: CheckoutComponent},
  {path: "cart-details", component: CartDetailsComponent},
  {path: 'products/:id', component: ProductDetailsComponent}, 
  {path: 'search/:keyword', component: ProductListComponent}, 
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
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    LoginComponent,
    LoginStatusComponent,
    MembersPageComponent,
    OrderHistoryComponent
  ],
  imports: [
    RouterModule.forRoot(routes), // this functions as the root Router. These set of routes are available to the entire application
    BrowserModule, 
    HttpClientModule, // add Httpclient module for making API requests. This module becomes available to the application and can be injected across the application
    NgbModule,         // exposes the exported declarations (classes, interfaces and constraints) and makes them available in the current module
    ReactiveFormsModule, 
    OktaAuthModule
  ],
  providers: [ProductService, { provide: OKTA_CONFIG, useValue: oktaConfig}], // add Product Service to help this get injected in any part of the application
  bootstrap: [AppComponent]
})
export class AppModule { }
