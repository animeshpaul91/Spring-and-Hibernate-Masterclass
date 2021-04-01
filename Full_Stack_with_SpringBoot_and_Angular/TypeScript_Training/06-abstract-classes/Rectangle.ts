import { Shape } from './Shape';

export class Rectangle extends Shape {
    
    constructor(x: number, y: number, private _width: number, private _length: number) {
        super(x, y);
    }

    public get width(): number {
        return this._width;
    }

    public get length(): number {
        return this._length;
    }

    public set width(value: number) {
        this._width = value;
    }

    public set length(value: number) {
        this._length = value;
    }

    getInfo(): string {
        return super.getInfo() + `,  Length = ${this._length}, Width = ${this._width}`;
    }

    calculateArea(): number {
        return this._width * this._length;
    }

}