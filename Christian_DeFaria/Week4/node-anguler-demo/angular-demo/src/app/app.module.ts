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

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    ClickerComponent,
    VideoGamesComponent,
    NavComponent,
    AccountsComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
