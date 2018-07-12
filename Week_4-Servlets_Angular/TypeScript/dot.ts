/*
    In order for this class to be used elsewhere in our application, we need to include
    the 'export' keyword. This makes the entire class visible for the rest of our application.
    From TS's point of view, this file is now considered to be a module.
*/
export class Dot {
    constructor(private _x?: number, private _y?: number) {
    }

    draw() {
        console.log('x: ' + this._x + ', y: ' + this._y);
    }
}