import {Shape} from './Shape';
import {Circle} from './Circle';
import {Rectangle} from './Rectangle';


let myCircle = new Circle(10, 15, 20);

let myRectangle = new Rectangle(0, 0, 3, 7);

// declare an array of shapes
let shapes: Shape[] = [];

shapes.push(myCircle);
shapes.push(myRectangle);

for(let shape of shapes) {
    console.log(shape.getInfo());
}