import { Component, OnInit } from '@angular/core';
import { VideoGame } from '../../models/video-game';
import { VideoGameService } from '../../services/video-game.service';

@Component({
    selector: 'app-video-games',
    templateUrl: './video-games.component.html',
    styleUrls: ['./video-games.component.css']
})
export class VideoGamesComponent implements OnInit {
    games: VideoGame[];
    game = new VideoGame();
    filterTitleString = '';

    constructor(private service: VideoGameService) {

    }

    ngOnInit() {
        this.service.games$.subscribe(
            succ => {
                this.games = succ;
            },
            err => {

            }
        );
    }

    submit() {
        // this.games.unshift(this.game);
        this.games = [this.game, ...this.games];
        // this.service.publishGames([this.game,...this.games]);
        this.game = new VideoGame();
    }
}