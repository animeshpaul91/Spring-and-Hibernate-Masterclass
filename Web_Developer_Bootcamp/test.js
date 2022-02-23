function test(num){
    console.log("This number is "+num);
}

myNums = []

for(let i=1; i < 11; i++)
    myNums.push(i);

console.log(myNums);
myNums.forEach(test);

myArray = [1,2,3,4];
myArray.pop();
myArray.length = 0;
myArray.push(0);
console.log(myArray);