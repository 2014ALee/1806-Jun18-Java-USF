import { Component } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent {
  count = 0;

  incrementCount(value: number) {
    this.count += value;
  }
}
