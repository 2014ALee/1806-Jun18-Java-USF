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
  /*
    If a user Json string already exists in the localStorage, take the user our, parse it into an object, then puth the user
    into a BehaviorSubject object.

  */
  constructor(private http: HttpClient) {
    let u = localStorage.getItem('user');

    if (u !== '{}' && u !== undefined) {
      this.subscribers.next(JSON.parse(u));
    }
  }
/*
  The loginUser() method returns an Observable<User>. A user will be returned from the server asynch, so subscribing to this observable
  makes it possible to performs a function once a value is received.
*/
  loginUser(user: User) {
    console.log(`Attempting to login user: ${user.username}`);
    let json = JSON.stringify(user);
    return this.http.post<User>(environment.apiURL + 'login', json, HTTP_OPTIONS);
  }
}
