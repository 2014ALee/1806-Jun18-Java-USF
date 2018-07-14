import { TestBed, inject } from '@angular/core/testing';

import { VideoGameService } from './video-game.service';

describe('VideoGameService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VideoGameService]
    });
  });

  it('should be created', inject([VideoGameService], (service: VideoGameService) => {
    expect(service).toBeTruthy();
  }));
});
