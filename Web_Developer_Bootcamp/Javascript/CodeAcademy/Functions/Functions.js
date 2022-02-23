function getReminder() {
    console.log('Water the plants.')
}

function greetInSpanish() {
    console.log('Buenas Tardes.')
}

function sayThanks() {
    console.log('Thank you for your purchase! We appreciate your business.')
}

sayThanks();
sayThanks();
sayThanks();

function sayThanks(name) {
    console.log('Thank you for your purchase ' + name + '! We appreciate your business.');
}

sayThanks('Cole');

function makeShoppingList(item1 = 'milk', item2 = 'bread', item3 = 'eggs') {
    console.log(`Remember to buy ${item1}`);
    console.log(`Remember to buy ${item2}`);
    console.log(`Remember to buy ${item3}`);
}

function monitorCount(rows, columns) {
    return rows * columns;
}

var numOfMonitors = monitorCount(5, 4);
console.log(numOfMonitors);

function monitorCount(rows, columns) {
    return rows * columns;
}

function costOfMonitors(rows, columns) {
    return 200 * monitorCount(rows, columns);
}

var totalCost = costOfMonitors(5, 4);
console.log(totalCost);

var plantNeedsWater = function (day) {
    if (day === 'Wednesday')
        return true;
    else
        return false;
};

console.log(plantNeedsWater('Tuesday'));

var plantNeedsWater = (day) => {
    if (day === 'Wednesday') {
        return true;
    } else {
        return false;
    }
}

var plantNeedsWater = day => day === 'Wednesday' ? true : false;