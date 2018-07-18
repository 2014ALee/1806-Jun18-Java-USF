import { Injectable } from '@angular/core';
import { BehaviorSubject } from '../../../node_modules/rxjs';
import { VideoGame } from '../models/video-game';

@Injectable({
  providedIn: 'root'
})
export class VideoGameService {
  private gamesStream = new BehaviorSubject<VideoGame[]>(null);
  games$ = this.gamesStream.asObservable(); // Restrics it from data freely
  
  constructor() {
    setTimeout(() => {
      this.gamesStream.next([
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
      ])}, 200);
    }

  publishGame(games: VideoGame[]) {
    this.gamesStream.next(games);
  }
}
