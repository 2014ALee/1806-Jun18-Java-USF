import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorsService {

  getAuthors() {
    return ['Charles Dickens', 'Steven King', 'Mary Shelly', 'Aldous Huxley'];
  }
}
