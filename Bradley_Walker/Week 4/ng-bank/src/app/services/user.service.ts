import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user';
import { environment } from '../../environments/environment';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  /*
    If a user json string already exists in the local storage, take the user out, parse
    it into an object, then put the user into a BehaviorSubject
  */

  subscribers: BehaviorSubject<User> = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) {
    let u = localStorage.getItem('user');
    if(u !== '{}' && u !== undefined){
      this.subscribers.next(JSON.parse(u));
    }
  }

  /*
    The loginUser method returns an observable of type User. A user will be returne from the server
    asynchronously, so subscribing to this observable makes it possible to perform a function
    once a value is received.
  */

  loginUser(user: User){
    console.log(`Attempting to login user: ${user.username}`);
    let json = JSON.stringify(user);
    return this.http.post<User>(environment.apiUrl + 'login', json, HTTP_OPTIONS);
  }
}
