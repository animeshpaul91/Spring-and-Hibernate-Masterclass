import {Shape} from './Shape';
import {Circle} from './Circle';
import {Rectangle} from './Rectangle';



let myCircle = new Circle(10, 15, 20);
console.log(myCircle.getInfo());

let myRectangle = new Rectangle(0, 0, 3, 7);
console.log(myRectangle.getInfo());