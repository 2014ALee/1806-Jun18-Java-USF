import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent {

  condition = true;

  changeConiditon = () => {
    this.condition = !this.condition;
  }


}
