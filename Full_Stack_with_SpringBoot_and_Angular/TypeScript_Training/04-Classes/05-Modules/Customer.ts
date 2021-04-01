export class Customer {

    // parameter properties create properties and assign them on the fly together
    // defines and assigns in the same place
    constructor(private _firstName: string, private _lastName: string) {

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