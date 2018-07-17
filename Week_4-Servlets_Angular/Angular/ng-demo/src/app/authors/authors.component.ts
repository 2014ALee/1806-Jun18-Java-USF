import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent {

  authors: string[];
  constructor() {   }
=======
import { AuthorsService } from '../authors.service';

@Component({
  selector: 'authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {

  authors: string[];

  constructor(service: AuthorsService) {
    this.authors = service.getAuthors();
  }
>>>>>>> 5717e2f2f24bdb0c3e20692b4502664434d443e0

  ngOnInit() {
  }

}
