var Customer = /** @class */ (function () {
    // by default all properties are public
    function Customer(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    return Customer;
}());
var myCustomer = new Customer("Animesh", "Paul");
console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
