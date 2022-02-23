const colors = ["red", "orange", "green", "violet"];

// for (let i = 0; i < colors.length; i++)
//     console.log(colors[i]);

function printColor(color, index, arrayName) {
    console.log("Iterating over element: " + color + " at index: " + index + " in array: " + arrayName);
}

colors.forEach(printColor);

/* 
foreach takes 3 arguments: 
firstArgument - the element that is being currently iterated on
secondArgument - the firstArgument's index
thirdArgument - the contents of the array itself (This is same on all iterations).
*/

function printReverse(colors) {
    for (var i = colors.length - 1; i > -1; i--)
        console.log(colors[i]);
}

function isUniform(colors) {
    var firstElement = colors[0];
    for(var i = 1; i < colors.length; i++)
        if (colors[i] !== firstElement)
            return false;
    return true;
}

function sumArray(colors) {
    var sum = 0;
    colors.forEach(function(element) {
        sum += element;
    });
    return sum;
}

function getMax(colors) {
    var max = colors[0];
    colors.forEach(function(element) {
        if (element > max)
            max = element;
    });
    return max;
}

printReverse(colors);
console.log(isUniform([1, 2, 1, 1]));
console.log(sumArray([1, 2, 1, 1]));
console.log(getMax([1, 2, 4, -991]));