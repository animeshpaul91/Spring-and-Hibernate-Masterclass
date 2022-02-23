var city = 'New York City';

function logCitySkyline() {
    var skyscraper = 'Empire State Building';
    return 'The stars over the ' + skyscraper + ' in ' + city;
}

console.log(logCitySkyline());

var satellite = 'The Moon';
var galaxy = 'The Milky Way';
var stars = 'North Star';

function callMyNightSky() {
    return 'Night Sky: ' + satellite + ', ' + stars + ', and ' + galaxy;
}

console.log(callMyNightSky());

function logVisibleLightWaves() {
    var lightWaves = 'Moonlight';
    console.log(lightWaves);
}

logVisibleLightWaves();
// console.log(lightWaves); Not allowed. lightWaves is block scoped.

var satellite = 'The Moon';
var galaxy = 'The Milky Way';
var stars = 'North Star';

var callMyNightSky = () => {
    stars = 'Sirius';
    return 'Night Sky: ' + satellite + ', ' + stars + ', ' + galaxy;
};

console.log(callMyNightSky());
console.log(stars);

// Practice Good Scoping
var logVisibleLightWaves = () => {
    var lightWaves = 'Moonlight';
    var region = 'The Arctic';
    if (region === 'The Arctic') {
        var lightWaves = 'Northern Lights';
        console.log(lightWaves);
    }

    console.log(lightWaves);
};

logVisibleLightWaves();