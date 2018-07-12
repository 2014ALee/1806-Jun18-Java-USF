
export class LikeComponent {
    /*
        These declarations are unnecessary if we declare them using access modifiers in the
        constructor
    */
    //likesCount: number;
    //isSelected: boolean;

    constructor(private _likesCount: number, private _isSelected: boolean) {
    }

    onClick() {
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

    }

    /*
        Include getters and setter properties to allow access to the component
        fields
    */
   get likesCount() {
       return this._likesCount;
   }

   set likesCount(value: number) {
       this._likesCount = value;
   }

   get isSelected() {
       return this._isSelected;
   }

   set isSelected(value: boolean) {
       this._isSelected = value;
   }
}