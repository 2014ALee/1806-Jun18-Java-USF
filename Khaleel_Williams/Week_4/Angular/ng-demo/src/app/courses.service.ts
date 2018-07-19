import { Injectable } from '@angular/core';

// injectable decorator is needed if this service wants to use other services(dependency injection)
@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  getCourses() {
    return ['course1', 'course2', 'course3', 'course4'];
  }
}
