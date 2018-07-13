class likeButton {
    currentLikes: number;
    buttonOn: boolean;

    constructor(buttonOn){
        this.currentLikes = getCurrentLikes();
    }

    // updates the values together
    updateButton(state) {
        
    }

    // supposedly from a database 
    // just returns 12 for the purpose of this exercise
    getCurrentLikes() {
        return 12;
    }
}