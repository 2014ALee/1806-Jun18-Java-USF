import { VideoGamePipe } from './video-game.pipe';

describe('VideoGamePipe', () => {
  it('create an instance', () => {
    const pipe = new VideoGamePipe();
    expect(pipe).toBeTruthy();
  });
});
