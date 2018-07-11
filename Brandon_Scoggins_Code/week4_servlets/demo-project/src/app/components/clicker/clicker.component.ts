import { Component } from "@angular/core";

//Decorator
@Component({
    selector: 'app-clicker',
    templateUrl: './clicker.component.html',
    styleUrls: ['./clicker.component.css']
})

export class ClickerComponent{
    clicks = 0;

    increment(amount: number) {
        this.clicks += amount;
    }
}