import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})

export class RouteGuardService implements CanActivate {

  constructor(private router: Router, private hardcodedAuthenticationService: HardcodedAuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.hardcodedAuthenticationService.isUserLoggedIn()) return true;

    this.router.navigate(['login']);
    return false;
  }
}
