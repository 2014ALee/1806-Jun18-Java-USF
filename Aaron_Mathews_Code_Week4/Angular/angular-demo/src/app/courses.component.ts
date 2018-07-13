import { Component } from '../../node_modules/@angular/core';

@Component({
    selector: 'courses',
    template: `<h2>{{ title }}</h2>
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
    {{ course.releaseDate | date:'shortDate' }} <br>`
})
export class CoursesComponent {
    title = 'List of courses';
    courses = ['course1', 'course2', 'course3'];
    course = {
        title: 'The Basics of Angular',
        rating: 4.78,
        students: 12444,
        price: 1.00,
        releaseDate: new Date(2018, 7, 12),
        summary: 'This course will teach you basics of the Angular framework, and help you create single-page applications.'
    };

    constructor() {

    }

    getTitle() {
        return this.title;
    }
}
