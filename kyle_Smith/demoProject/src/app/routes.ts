import { Routes } from '@angular/router';
import { SecondComponent } from './componets/second/second.componet';
import { ClickerComponent } from './componets/clicker/clicker.component';
import { FirstComponent } from './componets/first/first.component';
import { VideoGamesComponent } from './componets/video-games/video-games.componet';
import { BankComponent } from './componets/bank/bank.component';

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
        path: 'bank',
        component: BankComponent
    },
    {
        path: '**',
        pathMatch: 'full',
        redirectTo: 'frist'
    }
];
