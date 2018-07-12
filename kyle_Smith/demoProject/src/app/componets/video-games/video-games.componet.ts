import { Component } from '@angular/core';
import { VideoGame } from '../../models/video-game';

@Component({
    selector: 'app-video-games',
    templateUrl: './video-games.componet.html',
    styleUrls: ['./video-games.componet.css']
})
export class VideoGamesComponent {
    games: VideoGame[] = [
    {
        title: 'Fortnite',
        image: 'https://www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/'
                + 'article_images/2018/07/fortnite.jpg?itok=knahfpE6',
        description: 'Build things and destroy things'
    },
    {
        title: 'Beat Saber',
        image: 'https://roadtovrlive-5ea0.kxcdn.com/wp-content/uploads/2018/03/beat-saber-2.jpg',
        description: 'Slash blocks to the song'
    }
];
}
