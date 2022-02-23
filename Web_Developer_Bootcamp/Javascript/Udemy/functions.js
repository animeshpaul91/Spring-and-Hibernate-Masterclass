function isEven(num) {
    return num % 2 === 0;
}

function factorial(num) {
    if (num < 2)
        return 1;
    return num * factorial(num - 1);
} 

function kebabToSnake(str) {
    return str.replace("/-/g", "_");
}

console.log(isEven(68));
console.log(isEven(17));
console.log(factorial(6));
console.log(kebabToSnake("hello-world-again"));