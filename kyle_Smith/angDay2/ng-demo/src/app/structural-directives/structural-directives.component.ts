import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent {
  time = 'Day';
  people: string[] = [
    'Wezley', 'Andrew', 'Karen', 'Brandom'
  ];
  monsters: object[] = [
    {
      name: 'Nessie',
      location: 'Loch Ness, Scotland'
    },
    {
      name: 'Bigfoot',
      location: 'Pacific Northwest, USA'
    },
    {
      name: 'Godzilla',
      location: 'Tokyo, Japan'
    }
  ];
  condition = true;
  changeCondition = () => {
    this.condition = !this.condition;
  }

  // changeDay: () => {
  //   this.time = 'Day';
  // }

  // changeNight: () => {
  //   this.time = 'Night';
  // }


}
