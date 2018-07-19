import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'attribute-directives',
  templateUrl: './attribute-directives.component.html',
  styleUrls: ['./attribute-directives.component.css']
})
export class AttributeDirectivesComponent implements OnInit {

  colors: string[] = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
  name: string;
  color: string = 'color';
  isDisabled: boolean = true;
  classes: string[] = ['bold', 'italic', 'highlight'];
  selectedClass: string[] = [];

  enabler() {
     this.isDisabled = !this.isDisabled;
  }

  addClass(event: any) {
    this.selectClass = [];
    let values = event.target.options;
    let opt: any;

    for(let i = 0; i < values.length; i++) {
      opt = valuengs[i];

      if(opt.selected) {
        this.selectedClass.push(opt.text);
      }
    }
  }

}
