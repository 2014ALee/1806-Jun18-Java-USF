import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent {
  heroes = [{
    name: 'Mr. Incredible',
    power: 'Super strength'
  },
  {
    name: 'Elastigirl',
    power: 'Elastically stretchable body'
  },
  {
    name: 'Dash',
    power: 'Super speed'
  },{
    name: 'Violet',
    power: 'Invisibility; Forcefield generation'
  },
  {
    name: 'Jack-Jack',
    power: 'Everything'
  }];
}
