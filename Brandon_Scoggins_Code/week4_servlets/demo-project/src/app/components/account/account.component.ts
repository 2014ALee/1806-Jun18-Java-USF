import { Component } from '@angular/core';
import { Account } from '../../models/account';

// Decorator
@Component({
    selector: 'app-account',
    templateUrl: './account.component.html',
    styleUrls: ['./account.component.css']
})
export class AccountComponent {
    accounts: Account [] = [{
        amount: 75.00,
        type: 'Checking',
        owner: 'Will Smith'
    },
    {
        amount: 180.00,
        type: 'Savings',
        owner: 'Blake'
    },
    {
        amount: 1999999.99,
        type: 'Checking',
        owner: 'Future Me'
    }];
}
