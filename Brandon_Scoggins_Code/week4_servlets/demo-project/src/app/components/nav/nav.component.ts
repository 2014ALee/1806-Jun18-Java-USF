import { Component } from '@angular/core';

// Decorator
@Component({
    selector: 'app-nav',
    templateUrl: './nav.component.html',
    styleUrls: ['./nav.component.css']
})
export class NavComponent {
    isCollapsed = true;
}
