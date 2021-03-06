# Full-Stack e-Commerce Application

<p> This project is centered around building a full-stack e-Commerce online shopping website with the main features as mentioned under: </p>

1. Display Product (Inventory) data in grid layout
2. Search for Products by Category
3. Search for Products by Keyword
4. Product Master-Detail View
5. Display data in Pages (Added support for Pagination)
6. Shopping items in Shopping Cart
7. Checkout Shopping items in cart
8. Form Validationin checkout
9. View Order History


<p> These are security/access-control features in the application. </p>
1. User Registration
2. Login/Logout
3. VIP Member Access

<p> Security features were built by leveraging OpenID Connect(OIDC) on top on OAuth2.0 </p>

<p> Brief Description of Application: </p>

<p> This project centered around developing a simple e-Commerce online shopping website as a full-stack web application by exposing inventory data from RDBMS through REST APIs using a SpringBoot backend application which gets consumed by a frontend Angular application. Implemented features to display product data, search for products, add to shopping cart, checkout cart and form validation. In addition, security features were built by leveraging Okta with OAuth2.0. </p>

<p> The RESTful services were exposed directly from the MySQL database using Spring DATA JPA REST. The client (Angular App) consumes this data to display and populate the shopping items in its components. </p>


### Technologies Used: 
#### Backend Components: 
1. SpringBoot
2. Hibernate
3. Maven
4. Tomcat
5. MySQL
6. Okta (for security features).

#### Frontend Components
1. Angular 11
2. Typescript
3. Bootstrap.
4. HTML5
5. CSS3

### A few snippets of the application: 

#### Home Page
![Home_Page](https://github.com/animeshpaul91/Spring-and-Hibernate-Masterclass/blob/main/Full_Stack_with_SpringBoot_and_Angular/eCommerce-Project/snaps/sample-1.png?raw=true)

#### Login Page
![Login_Page](https://github.com/animeshpaul91/Spring-and-Hibernate-Masterclass/blob/main/Full_Stack_with_SpringBoot_and_Angular/eCommerce-Project/snaps/sample-2.png?raw=true)

#### Checkout Cart
![Checkout_Cart](https://github.com/animeshpaul91/Spring-and-Hibernate-Masterclass/blob/main/Full_Stack_with_SpringBoot_and_Angular/eCommerce-Project/snaps/sample-3.png?raw=true)
