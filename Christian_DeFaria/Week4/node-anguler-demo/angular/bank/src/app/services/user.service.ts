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

  subscribers: BehaviorSubject<User> = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) {
    let u = localStorage.getItem('user');
    if(u != '{}' && u != undefined) {
      this.subscribers.next(JSON.parse(u));
    }
  }

  public loginUser(user: User) {
    console.log(`Attempting to login in user: ${user.username}`);
    let json = JSON.stringify(user);
    return this.http.post<User>(environment.apiUrl + 'login', json, HTTP_OPTIONS);
  }
}
