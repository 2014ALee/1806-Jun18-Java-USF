import { Component } from '@angular/core';
import { Account } from '../../models/account';

@Component({
    selector: 'app-accounts',
    templateUrl: './accounts.component.html',
    styleUrls: ['./accounts.component.css']
})
export class AccountsComponent {
    accounts: Account[] = [{
        amount: 1000,
        type: 'Checking',
        owner: 'Christian'
    }, 
    {
        amount: 5000,
        type: 'Savings',
        owner: 'Christian'
    }];
}