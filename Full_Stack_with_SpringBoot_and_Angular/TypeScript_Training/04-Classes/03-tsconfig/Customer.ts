class Customer {
    private _firstName: string; // nothing special about _
    private _lastName: string;

    // by default all properties are public

    constructor(firstName: string, lastName: string) {
        this._firstName = firstName;
        this._lastName = lastName;
    }

    public get firstName(): string {
        return this._firstName;
    }

    public set firstName(value: string) {
        this.firstName = value;
    }

    public get lastName(): string {
        return this._lastName;
    }
    public set lastName(value: string) {
        this._lastName = value;
    }

}

let myCustomer: Customer = new Customer("Animesh", "Paul");


console.log(myCustomer.firstName); // getters called
console.log(myCustomer.lastName); // getters called