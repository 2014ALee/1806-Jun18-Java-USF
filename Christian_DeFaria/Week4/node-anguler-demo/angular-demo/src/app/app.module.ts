import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { VideoGamesComponent } from './components/video-games/video-games.component';
import { RouterModule } from '@angular/router';
import { appRoutes } from './routes';
import { NavComponent } from './components/nav/nav.component';
import { AccountsComponent } from './components/accounts/accountss.component';
import { VideoGameService } from './services/video-game.service';
import { FormsModule } from '@angular/forms';
import { VideoGamePipe } from './pipes/video-game.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    ClickerComponent,
    VideoGamesComponent,
    NavComponent,
    AccountsComponent,
    VideoGamePipe
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [
    VideoGameService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
