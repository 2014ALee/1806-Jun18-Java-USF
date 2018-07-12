"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var LikeComponent = /** @class */ (function () {
    /*
        These declarations are unnecessary if we declare them using access modifiers in the
        constructor
    */
    //likesCount: number;
    //isSelected: boolean;
    function LikeComponent(_likesCount, _isSelected) {
        this._likesCount = _likesCount;
        this._isSelected = _isSelected;
    }
    LikeComponent.prototype.onClick = function () {
        /*
            This large if-else block can be replaced with code that is much
            more concise (ternary operator);
        */
        /*
        if(this.isSelected) {
            this.likesCount--;
            //this.isSelected = false;  // This statement and its counterpart in the else
                                        // can be replaced by a single statement
        } else {
            this.likesCount++;
            //this.isSelected = true;
        }
        */
        this._likesCount += (this._isSelected) ? -1 : 1;
        this._isSelected = !this._isSelected;
    };
    Object.defineProperty(LikeComponent.prototype, "likesCount", {
        /*
            Include getters and setter properties to allow access to the component
            fields
        */
        get: function () {
            return this._likesCount;
        },
        set: function (value) {
            this._likesCount = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(LikeComponent.prototype, "isSelected", {
        get: function () {
            return this._isSelected;
        },
        set: function (value) {
            this._isSelected = value;
        },
        enumerable: true,
        configurable: true
    });
    return LikeComponent;
}());
exports.LikeComponent = LikeComponent;
