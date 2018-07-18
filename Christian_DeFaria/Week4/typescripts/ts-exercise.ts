import { Component } from '@angular/core';

@Component({
    selector: 'app-like',
    templateUrl: './like.component.html',
    styleUrls: ['./like.component.css']
})
export class LikeComponent {
    likes = 0;
    state = false;

    liked() {
        if(this.state == false) {
            this.likes+=1;
            this.state = true;
            $('#likeButton').css('background-color', 'DodgerBlue');
        } else {
            this.state = false;
            $('#likeButton').css('background-color', 'Gray');
        }
    }

    // myCssClass = 'blue';
}