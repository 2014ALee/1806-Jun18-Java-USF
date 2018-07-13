import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Router } from '../../../../node_modules/@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  loggedUser = localStorage.getItem('user');
  isValid = true;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    if (this.loggedUser != null) {
      this.router.navigate(['dashboard']);
    }
  }

  login() {
    this.userService.loginUser(this.user).subscribe(users => {
      if (users == null) {
        this.isValid = !this.isValid;
      } else {
        this.userService.subscribers.next(users);
        localStorage.setItem('user', JSON.stringify(users));
        console.log(`User, ${this.user.username}, successfully loggin in!`);
        console.log(localStorage.getItem('user'));
        this.router.navigate(['dashboard']);
      }
    });
  }
}

