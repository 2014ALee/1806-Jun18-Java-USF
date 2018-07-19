import { Component} from '@angular/core';

@Component({
  selector: 'structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent {

  condition: boolean = true;

  changeCondition = () => {
    this.condition = !this.condition;
  }

  people: string[] = [
    'Wezley', 'Andrew', 'Karen', 'Brandon'
  ];

  monster: object[] = [
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

  time: string = 'day';

  changeDay = () => {
    this.time = 'day';
  }

  changeNight = () => {
    this.time = 'night';
  }
}
