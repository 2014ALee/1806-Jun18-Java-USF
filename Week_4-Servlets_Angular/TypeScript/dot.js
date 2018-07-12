"use strict";
exports.__esModule = true;
/*
    In order for this class to be used elsewhere in our application, we need to include
    the 'export' keyword. This makes the entire class visible for the rest of our application.
    From TS's point of view, this file is now considered to be a module.
*/
var Dot = /** @class */ (function () {
    function Dot(_x, _y) {
        this._x = _x;
        this._y = _y;
    }
    Dot.prototype.draw = function () {
        console.log('x: ' + this._x + ', y: ' + this._y);
    };
    return Dot;
}());
exports.Dot = Dot;
