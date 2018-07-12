import { Component } from '../../../../node_modules/@angular/core';
import { VideoGame } from '../../models/video-game';

@Component({
    selector: 'app-video-games',
    templateUrl: './video-games.component.html',
    styleUrls: ['./video-games.component.css']
})
export class VideoGamesComponent {
    games: VideoGame[] = [
        {
            title: 'Fortnite',
            image: 'https://blogs-images.forbes.com/erikkain/files/2018/05/Fortnite-solo.jpg',
            description:  'Build things and destroy things'
        },
        {
            title: 'Beat Saber',
            image: 'https://venturebeat.com/wp-content/uploads/2018/06/Screen-Shot-2018-06-10-at-6.27.31-PM.png?fit=578%2C310&strip=all',
            description: 'Slash bricks to songs'
        }
    ];
}
