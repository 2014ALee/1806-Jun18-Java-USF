import { Component} from '@angular/core';

@Component({
  selector: 'app-attribute-directives',
  templateUrl: './attribute-directives.component.html',
  styleUrls: ['./attribute-directives.component.css']
})
export class AttributeDirectivesComponent {
  colors: string[] = ['red', 'orange', 'yellow', 'green'];
  name: string;
  color = 'color';
  isDisabled = true;
  classes: string[] = ['bold', 'italic', 'highlight'];
  selectedClass: string[] = [];

  enabler() {
    this.isDisabled = !this.isDisabled;
  }

  addClass(event: any) {
    this.selectedClass = [];
    let values = event.target.options;
    let opt: any;

    for (let i = 0; i < values.length; i++) {
      opt = values[i];

      if (opt.selected) {
        this.selectedClass.push(opt.text);
      }
    }
  }
}
