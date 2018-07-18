import { Routes } from '@angular/router';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { VideoGamesComponent } from './components/video-games/video-games.component';
import { AccountsComponent } from './components/accounts/accountss.component';

export const appRoutes: Routes = [
    {
        path: 'first',
        component: FirstComponent
    },
    {
        path: 'second',
        component: SecondComponent
    },
    {
        path: 'clicker',
        component: ClickerComponent
    },
    {
        path: 'games',
        component: VideoGamesComponent
    },
    {
        path: 'accounts',
        component: AccountsComponent
    },
    {
        path: '**',
        pathMatch: 'full',
        redirectTo: 'first'
    }
];