// let <var>: <type>: <value>
let found: boolean = true;
let grade: number = 88.6;
let firstname: string = "Animesh";
let lastname: string = "Paul";

// reassignment
found = false;
grade = 99;

// any 
let myData: any = 50.0;
myData = false;
myData = "Eric";
myData = 19;

console.log(found);
console.log("The grade is: " + grade);
console.log("Hi " + firstname + " " + lastname);

// template strings
console.log(`Hi ${firstname} ${lastname}`);