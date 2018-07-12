import { Routes } from '@angular/router';
import { FirstComponent } from './component/first/first.components';
import { SecondComponent } from './component/second/second.components';
import { VideoGamesComponent } from './component/video-games/video-games.components';
import { ClickerComponent } from './component/clicker/clicker.components';
import { AccountsComponent } from './component/accounts/accounts.components';

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
