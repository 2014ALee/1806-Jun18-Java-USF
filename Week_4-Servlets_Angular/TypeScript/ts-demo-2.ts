/*
    Introduction to TypeScript
    Section 2: Object Oriented Features - Interfaces
*/

/*
    Let's see how we can use custom types in TS. The below function takes in two coordinates,
    and draws a point on the screen. We are not focused on the implementation of this function
    but instead the signature of the function.

*/
let drawPoint_1 = (x, y) => {
    // implementation goes here...
}

/*
    The above is not a complex function, as it only takes in two parameters. However, sometimes 
    we find ourselves working with more complex concepts we may end up with a function that 
    takes several parameters. In those situations, it is likely that a group of the parameters
    (or even all of them) belong to a single concept.

    For example, think of a car. A car has several properties, we don't want to pass all of
    those properties into a function like driveCar(). Instead, we want to encapsulate them
    in a single object that can be passed in.

    So, instead of passing 'x' and 'y' here, we can rewrite our function to take a Point
    object as its parameter.
*/
let drawPoint_2 = (point) => {
    // implementation goes here...
}

/*
    We can invoke our function and pass in an object containing an 'x' and a 'y' coordinate,
    as shown below:
*/
drawPoint_2({
    x: 1,
    y: 2
});

/*
    This will work, however there is a problem with this implementation. I can pass any object
    I please into this function, and it will not give me any compilation errors. This is because
    our application has no concept of what a 'point' object is. This code will break since our 
    function is expecting an object with properties of 'x' and 'y'.
*/
drawPoint_2({
    name: 'Wezley',
    age: 27,
    occupation: 'Full-Stack Software Developer'
});

/*
    We have two methods to solve this issue. The first is inline annotation. Below is an example of
    using inline annotation. The problem with this method is that it is a little verbose. In a
    simple example like this, it isn't so bad. If our object parameter is any more complex, this
    code will become unreadable pretty quickly.
*/
let drawPoint_3 = (point: {x: number, y: number}) => {
    // ...
}

/*
    Our other method of solving our issue is through the use of an interface. Which is no different
    than the concept of an interface in other programming languages such as Java and C#.

    With the interface below, we can rewrite our function and clean up its syntax to make it more
    readable. Not only is it cleaner, we can also reuse this interface in other places in our code
    as well.

    TS naming conventions are no different than other languages, so data structures such as interfaces,
    classes, enums, etc. are named using Pascal casing.
*/
interface Point {
    x: number,
    y: number
}

let drawPoint_4 = (point: Point) => {
    // ...
}