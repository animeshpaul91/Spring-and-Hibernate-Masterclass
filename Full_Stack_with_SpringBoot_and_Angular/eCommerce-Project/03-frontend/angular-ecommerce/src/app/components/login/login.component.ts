import { Component, OnInit } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import myAppConfig from '../../config/my-app-config'; // to interface with Okta App
import * as OktaSignIn from '@okta/okta-signin-widget'; // access to entities in okta sign in widget module

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  oktaSignin: any;
  constructor(private oktaAuthService: OktaAuthService) {
    this.oktaSignin = new OktaSignIn({
      logo: 'assets/images/logo.png',
      baseUrl: myAppConfig.oidc.issuer.split('/oauth2')[0],
      clientId: myAppConfig.oidc.clientId,
      redirectUri: myAppConfig.oidc.redirectUri,
      authParams: {
        pkce: true, // proof key for code exchange. We will make use of dynamic secrets for passing information between our app and okta authorization server.
        issuer: myAppConfig.oidc.issuer,
        scopes: myAppConfig.oidc.scopes
      }
    }
    );

  }

  ngOnInit(): void {
    this.oktaSignin.remove();

    // render sign in widget
    this.oktaSignin.renderEl({
      el: '#okta-sign-in-widget'
    }, // render the element with the id specified in login.component.html (name should be same as the div tage in HTML)
      (response) => {
        if (response.status === 'SUCCESS') {
          this.oktaAuthService.signInWithRedirect(); // this will help user sign in and redirect using reidirect URI
        }
      },

      (error) => {
        throw error;
      }
    );
  }
}
