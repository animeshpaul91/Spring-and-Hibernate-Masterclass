var artists = ['Picasso', 'Kahlo', 'Matisse', 'Utamaro'];

artists.forEach(artist => {
  console.log(artist + ' is one of my favorite artists.');
});

var numbers = [1, 2, 3, 4, 5];

var squareNumbers = numbers.map(number => {
  return number * number;
});

console.log(squareNumbers);

var things = ['desk', 'chair', 5, 'backpack', 3.14, 100];

var onlyNumbers = things.filter(thing => {
  return typeof thing === 'number';
});

console.log(onlyNumbers);

console.log("***************************");

var fruits = ['mango', 'papaya', 'pineapple', 'apple'];

// Iterate over fruits below
fruits.forEach(fruit => console.log('I want to eat a '+fruit));

console.log("***************************");

var animals = ['Hen', 'elephant', 'llama', 'leopard', 'ostrich', 'Whale', 'octopus', 'rabbit', 'lion', 'dog'];

// Create the secretMessage array below
var secretMessage = animals.map(animal => animal[0]);

console.log(secretMessage.join(''));

var bigNumbers = [100, 200, 300, 400, 500];

function divide(num){
  return num/100;
}
// Create the smallNumbers array below
var smallNumbers = bigNumbers.map(divide);
console.log(smallNumbers);

console.log("***************************");

var randomNumbers = [375, 200, 3.14, 7, 13, 852];

// Call .filter() on randomNumbers below
smallNumbers = randomNumbers.filter(number => number < 250);

var favoriteWords = ['nostalgia', 'hyperbole', 'fervent', 'esoteric', 'serene'];


// Call .filter() on favoriteWords below
var longFavoriteWords = favoriteWords.filter(word => word.length > 7);

console.log("***************************");

animals = ['hippo', 'tiger', 'lion', 'seal', 'cheetah', 'monkey', 'salamander', 'elephant'];

var foundAnimal = animals.findIndex(animal => animal === 'elephant');

var startsWithS = animals.findIndex(animal => animal[0] === 's');

console.log("***************************");

var newNumbers = [1, 3, 5, 7];

var newSum = newNumbers.reduce((accumulator, currentValue) => {
  console.log('The value of accumulator: ', accumulator);
  console.log('The value of currentValue: ', currentValue);
  return accumulator + currentValue;
}, 10);

console.log(newSum);


console.log("***************************");

var words = ['unique', 'uncanny', 'pique', 'oxymoron', 'guise'];

// Something is missing in the method call below

console.log(words.some(word => {
  return word.length < 6}));

// Use filter to create a new array
var interestingWords = words.filter(word => word.length > 5);


// Make sure to uncomment the code below and fix the incorrect code before running it

console.log(interestingWords.every(word => word.length > 5));

console.log("***************************");

var cities = ['Orlando', 'Dubai', 'Edinburgh', 'Chennai', 'Accra', 'Denver', 'Eskisehir', 'Medellin', 'Yokohama'];

var nums = [1, 50, 75, 200, 350, 525, 1000];

//  Choose a method that will return undefined
cities.forEach(city => console.log('Have you visited ' + city + '?'));

// Choose a method that will return a new array
var longCities = cities.filter(city => city.length > 7);

// Choose a method that will return a single value
var word = cities.reduce((acc, currVal) => {
  return acc + currVal[0]
}, "C");

console.log(word)

// Choose a method that will return a new array
var smallerNums = nums.map(num => num - 5);

// Choose a method that will return a boolean value
nums.some(num => num < 0);