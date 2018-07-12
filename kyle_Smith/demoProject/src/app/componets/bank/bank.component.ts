import { Component } from '@angular/core';
import { BankAcc } from '../../models/bankAcc';

@Component({
    selector: 'app-bank',
    templateUrl: './bank.component.html',
    styleUrls: ['./bank.component.css']
})
export class BankComponent {
    accs: BankAcc[] = [
        {
            owner: 'bob',
            amount: 10.00,
            type: 'checking'
        },
        {
            owner: 'Ross',
            amount: 100.00,
            type: 'savings'
        },
        {
            owner: 'is',
            amount: 1000.00,
            type: 'checking'
        },
        {
            owner: 'god',
            amount: 10000.00,
            type: 'checking'
        }];
}
