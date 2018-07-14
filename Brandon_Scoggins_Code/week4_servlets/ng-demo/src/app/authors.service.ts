import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorsService {

  getAuthors() {
    return ['Charles Dickens', 'Stephen King', 'Mary Shelley', 'Aldous Huxley'];
  }
  
}
