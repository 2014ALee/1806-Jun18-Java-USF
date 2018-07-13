export class LikeButton {
     // Only get number of likes in constructor. isLiked will default to false and be toggled
    constructor(private _numOfLikes: number, private _isLiked?: boolean){
        
    }

    onClick() {
        if(!this._isLiked){
            this._numOfLikes++;
            this._isLiked = true;
        } else {
            this._numOfLikes--;
            this._isLiked = false;
        }
    }
// Do we need setters since these values should only be set by the constructor then changed by the onClick method
    get numOfLikes() {
        return this._numOfLikes;
    }

    set numOfLikes(newValue: number) {
        this._numOfLikes = newValue;
    }

    get isLiked() {
        return this._isLiked;
    }

    set isLiked(newValue: boolean) {
        this._isLiked = newValue;
    }
}