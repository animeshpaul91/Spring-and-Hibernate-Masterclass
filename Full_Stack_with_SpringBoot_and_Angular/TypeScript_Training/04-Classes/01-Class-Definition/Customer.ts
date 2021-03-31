class Customer {
    firstName: string;
    lastName: string;

    // by default all properties are public

    constructor(firstName: string, lastName:string) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

let myCustomer: Customer = new Customer("Animesh", "Paul");


console.log(myCustomer.firstName);
console.log(myCustomer.lastName);