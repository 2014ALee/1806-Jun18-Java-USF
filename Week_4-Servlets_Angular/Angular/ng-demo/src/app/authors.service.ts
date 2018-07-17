<<<<<<< HEAD
import { Injectable } from "../../node_modules/@angular/core";

// @Injectable({
    
// })
=======
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorsService {

  getAuthors() {
    return ['Charles Dickens', 'Stephen King', 'Mary Shelley', 'Aldous Huxley'];
  }
  
}
>>>>>>> 5717e2f2f24bdb0c3e20692b4502664434d443e0
