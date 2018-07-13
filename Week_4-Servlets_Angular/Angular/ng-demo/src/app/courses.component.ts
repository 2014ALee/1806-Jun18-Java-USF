// The Component decorator is imported from the main nG library: '@angular/core'
import { Component } from '@angular/core';
import { CoursesService } from './courses.service';

/*
    Exported for global visiblity
    Pascal naming convention
    Suffix "Component" is included in the class name
    @Component decorator added to make the TS class a nG component
*/
@Component({
  /*
    The selector is used to identify the custom HTML we will use to generate this
    component:
        <courses>               = 'courses'
        <div class="courses">   = '.courses'
        <div id="courses">      = '#courses'
  */
  selector: 'courses',

  /*
    Defines the HTML markup that will be used to render our component to the view.
    In real-world applications, our HTML markup will be extensive, so writing it here
    will not be convienent. Instead we could use the 'templateUrl' property of the
    Component directive to keep our HTML markup separate from the component's 
    declaration.

    {{ }} indicates 'interpolation', a form of data-binding. We are binding our view
    to a field in our component. When the value of that field is changed, the view is
    automatically updated.

    The structural directive nGFor is used in the template below. Directives are used
    like attribute in HTML. Inside of the string is the expression "let course of courses",
    which sounds much like the syntax of a for loop. In fact, this is exactly what is
    happening. nG reads the <li>, sees the ngFor directive, and proceeds to create a 
    new <li> for each course in our array 'courses'.

    Note that there is an asterisk (*) included as a prefix to our ngFor directive. This
    is required for all structural directives, which are directives that manipulate the
    structure of the DOM. Other directives such as attribute directives do not need this
    prefix.
  */
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
                {{ course.releaseDate | date:'shortDate' }}
            `
})
export class CoursesComponent {

    title = "List of courses";
    
    /*
        Let's display a list of courses on the view. Declare an array of strings (in a 
        real-world application we would not use strings, but instead objects).
    */
    //courses = ["course1", "course2", "course3"];
    courses;

    /*
        Below we have a variable 'course' declared and initialized to an object literal.
        We can use nG's built-in pipes to format the way that these values are rendered
        in the view.
    */
    course = {
        title: "The Basics of Angular",
        rating: 4.78,
        students: 10015,
        price: 124.95,
        releaseDate: new Date(2018, 4, 18),
        summary: "The course will teach you basics of the Angular framework and help you to create single-page applications."
    }

    /* 
        Declare a field that is of type FavoriteComponent, so that we can use it
        within this component.
    */

    /*
        By including our CoursesService as a parameter in the constructor of this
        component, we are allowing the nG framework to handle the instantiation of
        this CoursesService object. This means that if the constructor for this
        service changes in the future, our code will not break. Additionally, it
        will make it much easier to perform unit tests on this component as well.
    */
    constructor(service: CoursesService) {
        /*
            The problem with this implementation is that by using the 'new' keyword
            we have tightly coupled our component to the service. If in the future, 
            we decide to add a parameter to our CoursesService, we will have to come
            back to every component that uses this service and update it so it does
            not break.
        */
        //let service = new CoursesService();
        
        this.courses = service.getCourses();
    }

    getTitle() {
        return this.title;
    }

}