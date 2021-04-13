import { FormControl, ValidationErrors } from "@angular/forms";

export class Luv2ShopValidators {
    // adding custom validator rule

    static notOnlyWhiteSpace(control: FormControl): ValidationErrors {
        // check if string only contains whitespace
        if (control.value != null && control.value.trim().length == 0) {
            // string contains only whitespaces
            return { 'notOnlyWhiteSpace': true }; // HTML template checks for error key
        }

        else {
            // valid, return null
            return null;
        }
    }
}
