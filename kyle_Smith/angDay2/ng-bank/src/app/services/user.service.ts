import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../node_modules/@angular/common/http';
import { BehaviorSubject } from '../../../node_modules/rxjs';
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

  subscribers: BehaviorSubject<User> = new BehaviorSubject<User>(null);


  // If a user JSON string alreayd exists in the localStorage, take the user out,
  // parse it inot an object, then put the user into a BehaviorSubject object
  constructor(private http: HttpClient) {
    const u = localStorage.getItem('user');
    if (u != '{}' && u != undefined) {
      this.subscribers.next(JSON.parse(u));
    }
  }

  /*
    The loginUser() method returns an Obseravable<User>. A user will be returned from the server
    asynchronously, so subscribing to this observable makes it possible to perform a function once
    a value is recieved.
  */

  public loginUser(user: User) {
    console.log(`Attempting to login user: ${user.username}`);
    const json = JSON.stringify(user);
    return this.http.post<User>(environment.apiUrl + 'login', json, HTTP_OPTIONS);
  }
}
