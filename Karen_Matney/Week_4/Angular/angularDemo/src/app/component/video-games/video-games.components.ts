import { Component, OnInit } from '../../../../node_modules/@angular/core';
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

    constructor(private videoGameService: VideoGameService) {
    }

    ngOnInit () {
        this.videoGameService.games$.subscribe(
            succ => {
                this.games = succ;
            },
            err => {
            })
    }

    submit() {
        this.videoGameService.publishGame([this.game, ...this.games,]);
        this.game = new VideoGame();
    }
}