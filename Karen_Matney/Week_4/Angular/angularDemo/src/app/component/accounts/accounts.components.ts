import { Component } from '@angular/core';
import { Account } from '../../models/account';

@Component ({
    selector: 'app-accounts',
    templateUrl: './accounts.component.html',
    styleUrls: ['./accounts.component.css']
})
export class AccountsComponent {
    accounts: Account[] = [
        {
            owner: 'Jon Smith',
            type: 'Checking',
            amount: 600.23
        },
        {
            owner: 'Jon Smith',
            type: 'Savings',
            amount: 1923.4
        },
        {
            owner: 'Merced Atibs',
            type: 'Checking',
            amount: 752.3
        }
    ];
}
