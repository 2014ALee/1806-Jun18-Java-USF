import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  loggedIn: boolean = (localStorage.getItem('user') !== null) ? true : false;

  constructor(private router: Router) { }

  ngOnInit() {
    localStorage.clear();
    this.router.navigate(['login']);
  }

}
