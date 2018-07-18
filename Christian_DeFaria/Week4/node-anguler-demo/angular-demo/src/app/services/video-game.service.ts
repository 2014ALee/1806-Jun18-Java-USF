import { Injectable } from '@angular/core';
import { VideoGame } from '../models/video-game';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VideoGameService {

  private gameStream = new BehaviorSubject<VideoGame[]>([]);
  games$ = this.gameStream.asObservable();

  constructor() {
    setTimeout(() => {
      this.gameStream.next([{
            title: 'Fortnite',
            image: 'https://blogs-images.forbes.com/erikkain/files/2018/05/Fortnite-solo.jpg',
            description: 'Build things and destroy things.'
        }, 
        {
            title: 'Beat Saber',
            image: 'https://i.ytimg.com/vi/RzVMKIHQht0/maxresdefault.jpg',
            description: 'Slash blocks to the song'
        }]);
    }, 2000);
  }

  publishGames(games: VideoGame[]) {
    this.gameStream.next(games);
  }
}
