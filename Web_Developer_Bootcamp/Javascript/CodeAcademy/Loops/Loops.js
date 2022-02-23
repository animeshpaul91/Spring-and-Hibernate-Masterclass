// Write your code below
let vacationSpots = ['Hawaii', 'SF', 'Canada'];
console.log(vacationSpots[0]);
console.log(vacationSpots[1]);
console.log(vacationSpots[2]);

// Write your code below
for(let c=5; c < 11; c++)
    console.log(c);

// The loop below loops from 0 to 3. Edit it to loop backwards from 3 to 0
for (let counter = 3; counter >= 0; counter--){
    console.log(counter);
}

vacationSpots = ['Bali', 'Paris', 'Tulum'];

// Write your code below
for(let i = 0; i < vacationSpots.length; i++){
    console.log('I would love to visit '+vacationSpots[i]);
}

// Write your code below
const bobsFollowers = ['Mike', 'Tim', 'Mary', 'Ashley'];
const tinasFollowers = ['Ashley', 'Mike', 'Mark'];

mutualFollowers = []

for(let b = 0; b < bobsFollowers.length; b++){
    for(let t = 0; t < tinasFollowers.length; t++){
        if (bobsFollowers[b] === tinasFollowers[t])
            mutualFollowers.push(bobsFollowers[b]);
    }
}

console.log(mutualFollowers);

const cards = ['diamond', 'spade', 'heart', 'club'];

// Write your code below
let currentCard;

while(currentCard !== 'spade'){
    currentCard = cards[Math.floor(Math.random() * 4)];
    console.log(currentCard);
}

// Write your code below

const cupsOfSugarNeeded = 4;
let cupsAdded = 0;

do
{
    cupsAdded++;
} while (cupsAdded < cupsOfSugarNeeded);


const rapperArray = ["Lil' Kim", "Jay-Z", "Notorious B.I.G.", "Tupac"];

// Write your code below
for(let i = 0; i < rapperArray.length; i++){
    console.log(rapperArray[i]);
    if (rapperArray[i] === 'Notorious B.I.G.')
        break;
}

console.log('And if you don\'t know, now you know.');
