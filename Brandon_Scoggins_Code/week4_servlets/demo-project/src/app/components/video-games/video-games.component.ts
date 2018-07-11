import { Component } from '@angular/core';
import { VideoGame } from '../../models/video-game';

// Decorator
@Component({
    selector: 'app-video-games',
    templateUrl: './video-games.component.html',
    styleUrls: ['./video-games.component.css']
})
export class VideoGamesComponent {
    games: VideoGame[] = [{
        title: 'Fortnite',
        image: 'https://i.kym-cdn.com/entries/icons/mobile/000/024/820/maxresdefault.jpg',
        description: 'Build things and shoot peeps.'
    },
    {
        title: 'Beat Saber',
        image: 'https://assets.rockpapershotgun.com/images//2018/01/beat-saber-1-620x300.jpg',
        description: 'Slash blocks to the song'
    }];
}
