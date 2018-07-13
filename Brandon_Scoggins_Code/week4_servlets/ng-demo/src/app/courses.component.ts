import { Component } from '@angular/core';
import { CoursesService } from './courses.service';

@Component({
    selector: 'courses',
    template: `
        <h2>{{ title }}</h2>
        <ul>
            <li *ngFor="let course of courses">
                {{ course }}
            </li>
        <ul>

        <hr>

        {{ course.title | uppercase | lowercase }} <br>
        {{ course.students | number }} <br>
        {{ course.rating | number:'1.2-2' }} <br>
        {{ course.price | currency:'AUD':'symbol':'4.2-2' }} <br>
        {{ course.releaseDate | date:'shortDate' }} <br>
        `
})
export class CoursesComponent {
    title = 'List of courses';

//    courses = ['course1', 'course2', 'course3'];
    courses;

    course = {
        title: 'The Basics of Angular',
        rating: 4.78,
        students: 10015,
        price: 100,
        releaseDate: new Date(2018, 7, 12),
        summary: 'This course will teach your the basics of the Angular framework'
    }

    constructor(service: CoursesService) {
        this.courses = service.getCourses;
    }

    getTitle() {
        return this.title;
    }

}
