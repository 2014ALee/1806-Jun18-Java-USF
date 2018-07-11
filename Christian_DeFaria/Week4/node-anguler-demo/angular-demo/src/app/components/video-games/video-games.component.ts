import { Component } from '@angular/core';
import { VideoGame } from '../../models/video-game';

@Component({
    selector: 'app-video-games',
    templateUrl: './video-games.component.html',
    styleUrls: ['./video-games.component.css']
})
export class VideoGamesComponent {
    games: VideoGame[] = [{
        title: 'Fortnite',
        image: 'https://blogs-images.forbes.com/erikkain/files/2018/05/Fortnite-solo.jpg',
        description: 'Build things and destroy things.'
    }, 
    {
        title: 'Beat Saber',
        image: 'https://i.ytimg.com/vi/RzVMKIHQht0/maxresdefault.jpg',
        description: 'Slash blocks to the song'
    }];
}