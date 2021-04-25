import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { ListTodosComponent } from './list-todos/list-todos.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './services/route-guard.service';
import { TodoComponent } from './todo/todo.component';
import { WelcomeComponent } from './welcome/welcome.component';

// welcome
const routes: Routes = [
  { path: "", component: LoginComponent },  // can activate, RouteGuard Service
  { path: "login", component: LoginComponent },
  { path: "welcome/:name", component: WelcomeComponent, canActivate: [RouteGuardService] },
  { path: "todos", component: ListTodosComponent, canActivate: [RouteGuardService]},
  { path: "logout", component: LogoutComponent},
  { path: "todos/update/:id", component: TodoComponent, canActivate: [RouteGuardService]},
  { path: "**", component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
