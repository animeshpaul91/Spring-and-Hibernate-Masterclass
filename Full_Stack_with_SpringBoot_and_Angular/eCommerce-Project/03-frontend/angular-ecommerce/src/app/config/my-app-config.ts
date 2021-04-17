export default { // We will do a default export of JSON
    oidc: {
        clientId: '0oalrn2f45oeBNyLt5d6',  // public identifier of client App
        issuer: 'https://dev-66217134.okta.com/oauth2/default',  // Issuer of tokens. This URL will be used when authorizing with Okta authorization server
        redirectUri: 'http://localhost:4200/login/callback', // this is where okta will send the user once logged in
        scopes: ['openid', 'profile', 'email'] 
        /* scopes provide access to information about a user
           openid: required for authentication requests
           profile: user's firstname, lastname and phone
           email: user's email address
        */
    }
}
