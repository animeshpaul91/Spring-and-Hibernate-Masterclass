import { Shape } from "./Shape";

export class Circle extends Shape {
    constructor(_x: number, _y: number, private _radius:number) {
        super(_x, _y);
        this._radius = _radius;
    }

    // override getInfo()

    getInfo(): string {
        return super.getInfo() + `,  radius = ${this._radius}`;
    }
}