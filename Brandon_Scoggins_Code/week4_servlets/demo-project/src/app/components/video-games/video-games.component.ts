import { Component, OnInit } from '@angular/core';
import { VideoGame } from '../../models/video-game';
import { VideoGameService } from '../../services/video-game.service';

// Decorator
@Component({
    selector: 'app-video-games',
    templateUrl: './video-games.component.html',
    styleUrls: ['./video-games.component.css']
})
export class VideoGamesComponent implements OnInit {
    games: VideoGame[];
    game = new VideoGame();
    filterTitleString: '';

    constructor(private videoGameService: VideoGameService) {

    }

    ngOnInit() {
        this.videoGameService.games$.subscribe(
            succ => {
                console.log(succ);
                this.games = succ;
            },
            err => {
                console.log(err);
            }
        );
    }

    submit() {
        //this.games.unshift(this.game);
        this.videoGameService.publishGames([this.game, ...this.games]);
        this.game = new VideoGame();
    }
}
