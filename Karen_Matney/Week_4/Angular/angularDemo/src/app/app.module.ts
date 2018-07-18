import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { FirstComponent } from './component/first/first.components';
import { SecondComponent } from './component/second/second.components';
import { ClickerComponent } from './component/clicker/clicker.components';
import { VideoGamesComponent } from './component/video-games/video-games.components';
import { AccountsComponent } from './component/accounts/accounts.components';

import { NavComponent } from './component/nav/nav.components';

import { RouterModule } from '@angular/router';
import { appRoutes } from './routes';
import { VideoGameService } from './services/video-game.service';
import { VideoGamePipe } from './pipes/video-game.pipe';
import { FormsModule } from '../../node_modules/@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FirstComponent,
    SecondComponent,
    ClickerComponent,
    VideoGamesComponent,
    AccountsComponent,
    VideoGamePipe
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [VideoGameService],
  bootstrap: [AppComponent]
})
export class AppModule { }
