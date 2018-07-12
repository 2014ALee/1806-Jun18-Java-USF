import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { FirstComponent } from './componets/first/first.component';
import { SecondComponent } from './componets/second/second.componet';
import { ClickerComponent } from './componets/clicker/clicker.component';
import { VideoGamesComponent } from './componets/video-games/video-games.componet';
import { RouterModule } from '@angular/router';
import { appRoutes } from './routes';
import { NavComponent } from './componets/nav/nav.component';
import { BankComponent } from './componets/bank/bank.component';


@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    ClickerComponent,
    VideoGamesComponent,
    NavComponent,
    BankComponent
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
