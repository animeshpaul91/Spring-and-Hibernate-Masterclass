const inventory = {
    sunglasses: 1900,
    pants: 1088,
    bags: 1344
};

// Write your code below:
const myExecutor = (resolve, reject) => {
    if (inventory.sunglasses > 0){
        resolve('Sunglasses order processed.');
    }
    else {
        reject('That item is sold out.');
    }
}

function orderSunglasses() {
    return new Promise(myExecutor);
}

const orderPromise = orderSunglasses();

console.log(orderPromise);

// set Timeout

console.log("This is the first line of code in app.js.");
// Keep the line above as the first line of code
// Write your code here:
const usingSTO = () => {
    console.log("Hello World!");
}

setTimeout(usingSTO, 100);


// Keep the line below as the last line of code:
console.log("This is the last line of code in app.js.");

// Consuming Promises

const {checkInventory} = require('./library.js');

const order = [['sunglasses', 1], ['bags', 2]];

// Write your code below:

const handleSuccess = (resolvedValue) => {
    console.log(resolvedValue);
}

const handleFailure = (resolvedValue) => {
    console.log(resolvedValue);
}

checkInventory(order).then(handleSuccess, handleFailure);