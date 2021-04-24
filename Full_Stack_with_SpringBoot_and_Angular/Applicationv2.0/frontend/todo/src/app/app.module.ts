import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { ErrorComponent } from './error/error.component';
import { ListTodosComponent } from './list-todos/list-todos.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [ // Module is a collection of Components
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    ErrorComponent,
    ListTodosComponent,
    MenuComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule, // All components in App module require these modules
    AppRoutingModule, 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent] // dictates which component gets loaded when this module is loaded. App module gets bootstrapped in main.ts
})
export class AppModule { }

/* 
    Angular Modules are a Collection of related components, directives, services which are dedicated for a specific purpose.
    If you want to reuse a component, you need to import the corresponding angular module.
*/