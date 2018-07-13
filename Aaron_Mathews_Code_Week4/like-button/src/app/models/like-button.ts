export class LikeButton {
    constructor(private _numLikes: number, private _selected: boolean) {

    }

    onClick() {
        this._numLikes += this._selected ? -1 : 1;
        this._selected = !this._selected;
    }

    get numLikes() {
        return this._numLikes;
    }
    set numLikes(val: number) {
        this._numLikes = val;
    }

    get selected() {
        return this._selected;
    }
    set selected(val: boolean) {
        this._selected = val;
    }
}
