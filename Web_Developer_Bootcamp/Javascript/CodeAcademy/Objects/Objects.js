// Write your fasterShip object literal below

let fasterShip = {color: 'silver', 'Fuel Type': 'Turbo Fuel'};

let spaceship = {
    homePlanet: 'Earth',
    color: 'silver',
    'Fuel Type': 'Turbo Fuel',
    numCrew: 5,
    flightPath: ['Venus', 'Mars', 'Saturn']
};

// Write your code below
const crewCount = spaceship.numCrew;
const planetArray = spaceship.flightPath;
console.log(crewCount);
console.log(planetArray);

spaceship = {
    'Fuel Type' : 'Turbo Fuel',
    'Active Mission' : true,
    homePlanet : 'Earth',
    numCrew: 5
};

let propName =  'Active Mission';

// Write your code below
const isActive = spaceship[propName];
console.log(isActive);

spaceship = {
    'Fuel Type' : 'Turbo Fuel',
    homePlanet : 'Earth',
    color: 'silver',
    'Secret Mission' : 'Discover life outside of Earth.'
};

// Write your code below
spaceship.color = 'glorious gold';
spaceship.numEngines = 5;
delete spaceship['Secret Mission'];

// Add Methods to Objects
let retreatMessage = 'We no longer wish to conquer your planet. It is full of dogs, which we do not care for.';

// Write your code below
const alienShip = {
    retreat(){
        console.log(retreatMessage);
    },
    takeOff(){
        console.log('Spim... Borp... Glix... Blastoff!');
    }
};

alienShip.retreat();
alienShip.takeOff();

// Nested Objects
spaceship = {
    passengers: null,
    telescope: {
        yearBuilt: 2018,
        model: "91031-XLT",
        focalLength: 2032
    },
    crew: {
        captain: {
            name: 'Sandra',
            degree: 'Computer Engineering',
            encourageTeam() { console.log('We got this!') },
            'favorite foods': ['cookies', 'cakes', 'candy', 'spinach'] }
    },
    engine: {
        model: "Nimbus2000"
    },
    nanoelectronics: {
        computer: {
            terabytes: 100,
            monitors: "HD"
        },
        'back-up': {
            battery: "Lithium",
            terabytes: 50
        }
    }
};

const capFave = spaceship.crew.captain['favorite foods'][0];
console.log(capFave);
spaceship.passengers = [{'name': 'Animesh Paul', 'age': 28, 'sex': "M"}, {'name': 'Ashley Saraf', 'age': 32, 'sex': "F"}];
const firstPassenger = spaceship.passengers[0];

spaceship = {
    'Fuel Type' : 'Turbo Fuel',
    homePlanet : 'Earth'
};

// Write your code below
// '=' instantiates a variable with new memory. Behaves like malloc in C

let greenEnergy = obj => obj['Fuel Type'] = 'avocado oil';

let remotelyDisable = obj => obj.disabled = true;

greenEnergy(spaceship);
remotelyDisable(spaceship);
console.log(spaceship);

spaceship = {
    crew: {
        captain: {
            name: 'Lily',
            degree: 'Computer Engineering',
            cheerTeam() { console.log('You got this!') }
        },
        'chief officer': {
            name: 'Dan',
            degree: 'Aerospace Engineering',
            agree() { console.log('I agree, captain!') }
        },
        medic: {
            name: 'Clementine',
            degree: 'Physics',
            announce() { console.log(`Jets on!`) } },
        translator: {
            name: 'Shauna',
            degree: 'Conservation Science',
            powerFuel() { console.log('The tank is full!') }
        }
    }
};

// Write your code below
for (let crewMember in spaceship.crew){
    console.log(`${crewMember}: ${spaceship['crew'][crewMember]['name']}`);
}

for (let crewMember in spaceship.crew){
    console.log(`${spaceship['crew'][crewMember]['name']}: ${spaceship['crew'][crewMember]['degree']}`);
}