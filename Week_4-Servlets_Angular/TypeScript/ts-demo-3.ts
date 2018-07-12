/*
    Introduction to TypeScript
    Section 3: Object Oriented Features - Classes, Constructors, & Objects
*/

/*
    In the last demo, we used an interface to define a Point object. There is a problem
    with this implementation. In OOP languages, there is a concept known as 'cohesion'.
    Cohesion is the idea that things that are related, should be part of a single unit.

    In our previous demo, we had an interface defining the Point object, and a separate,
    stand-alone function 'drawPoint'. The fact that our function is separate from our 
    Point object violates the concept of cohesion. Instead, we should use a class to
    encapsulate the properties of a point, as well as all functions related to points.

    A class is used to group properties and methods that are highly related to one another.
    Our interface from before could have included the function declarations related to points,
    but could not include any implementations.
*/
class Point {
    /*
        If we have constructor that takes in our fields as parameters, we do not need
        to declare them elsewhere in our class.
    */
    //x: number;
    //y: number;
    

    /*
        The concept of a constructor in TS is no different than the same concept in other
        OOP languages such as Java and C#. However, unlike those languages, in TS you can
        only have a single constructor. To get around this, we simply make our parameters
        optional, by including a question mark (?) after the parameter declarations. If we
        are not making all of the parameters optional, then the optional ones should be to
        the right of the declaration.
    */
    constructor(x?: number, y?: number) {
        this.x = x;
        this.y = y;
    }

    drawPoint = () => {
        console.log('x: ' + this.x + ', y: ' + this.y);
    } 

    getDistance = (otherPoint: Point) => {
        return Math.sqrt(Math.pow(this.x - this.y, 2) + Math.pow(otherPoint.x - otherPoint.y, 2));
    }
}

// create a Point object by using the default constructor
let myPoint: Point = new Point();

// since we used the default constructor, the fields 'x' and 'y' are undefined
myPoint.drawPoint();

// assign values to 'x' and 'y'
myPoint.x = 1;
myPoint.y = 2;
myPoint.drawPoint();

let myOtherPoint: Point = new Point(5, 6);
let distanceBetween = myPoint.getDistance(myOtherPoint);
console.log('Distance between myPoint and myOtherPoint: ' + distanceBetween + ' units');