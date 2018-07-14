import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { VideoGame } from '../models/video-game';

@Injectable({
  providedIn: 'root'
})
export class VideoGameService {

  private gameStream = new BehaviorSubject<VideoGame[]>([]);
  games$ = this.gameStream.asObservable();

  constructor() {
    setTimeout(() => {
      this.gameStream.next([
        {
          title: 'Fortnite',
          image: 'https://i.kym-cdn.com/entries/icons/mobile/000/024/820/maxresdefault.jpg',
          description: 'Build things and shoot peeps.'
        },
        {
          title: 'Beat Saber',
          image: 'https://assets.rockpapershotgun.com/images//2018/01/beat-saber-1-620x300.jpg',
          description: 'Slash blocks to the song'
       }
      ]);
    }, 2000);
   }

   publishGames(games: VideoGame[]) {
     this.gameStream.next(games);
   }
}
