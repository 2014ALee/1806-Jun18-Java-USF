import { Pipe, PipeTransform } from '@angular/core';
import { VideoGame } from '../models/video-game';

@Pipe({
  name: 'videoGameTitle'
})
export class VideoGamePipe implements PipeTransform {

  transform(value: VideoGame[], chars?: string): VideoGame[] {
    if(!chars) {
      return value;
    }

    return value.filter(videogame => {
      return videogame.title.includes(chars);
    });
  }

}
