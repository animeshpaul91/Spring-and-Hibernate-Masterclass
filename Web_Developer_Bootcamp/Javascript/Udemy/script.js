var firstName = prompt("What is your First Name?");
var lastName = prompt("What is your Last Name?");
var age = Number(prompt("What is your age?"));
var fullName = firstName + " " + lastName;
console.log("The user's Full name is " + fullName);
console.log("The user is " + age + " years old");

//Age Calculator Exercise

var days = age * 365;
var numOfLeapYears = Math.floor(age / 4);
days += numOfLeapYears;
alert("You have lived " + days + " days");

if (age % Math.sqrt(age) === 0)
    console.log("You age " + age + " is a perfect square");

if (age % 2 !== 0)
    console.log("Your age is odd");
else 
    console.log("Your age is even");