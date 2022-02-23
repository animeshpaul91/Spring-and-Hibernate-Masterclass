//An Important note about Javascript

var x = 99;
console.log(x == "99"); //returns True. Javascript performs type coercion
console.log(x === "99"); //returns False. The datatypes on both sides are checked. 

console.log(true == "1"); //true
console.log(true == "12"); //false
console.log(0 == false); //true
console.log(null == undefined); //true
console.log(null === undefined); //false
console.log(NaN == NaN); //false, weird.

//Always  use === and !==

//Truthy and Falsy Values
console.log(!"Hello"); //false
console.log(!""); //true
console.log(!null); //true
console.log(!0); //true
console.log(!-1); //false
console.log(!NaN); //true

//These are Falsy Values
false;
0;
"";
null;
undefined;
NaN;
//Others are all truthy.

//To find out the truthy/falsy value prefix by !!.