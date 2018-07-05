//The browser represents each window or tab using a window object

window.onload = function () {
    console.log("The window has loaded.");
};

/*
    JavaScript Basics

        The language of the internet
        Interpreted language
        Loosely-typed
        Used to make web pages more interactive and dynamic
*/

var color = 'color';
var num = 123;
var bool = 3>5;
var dec = 3.2222;
var numArry = [1, 2, 3];
var myObj = { };
var myFunc = function() { };

console.log(typeof(color));
console.log(typeof(num));
console.log(typeof(bool));
console.log(typeof(dec));
console.log(typeof(numArry));

var today = new Date();
var currentHour = today.getHours();
var greeting;

if (currentHour > 18) {
    greeting = 'Good evening';
} else if (currentHour > 12) {
    greeting = 'Good afternoon';
} else if (currentHour > 0) {
    greeting = 'Good morning';
} else {
    greeting = 'Welcome';
}

document.write('<h3>' + greeting + '</h3>');

//Function Declaration
function getArea(width, height) {
    return width * height;
}

var myArea = getArea(3, 4);
console.log(myArea);

/*
    Anonymous Functions and Function Expressions

        Expressions produce a value. The can be used where values are expected. If a function is placed where the browser expects to see an expression, the function is treated as an expression.
        A function with no name  is known as anonynous since it can't be called directly.
*/


/*
    Immediately Invoked Function Expressions (IIFEs)

        An anonymous function that are executed as soon as the interpreter comes across them. Used when some code only needs to run once within a task rather than repeatedly being called by other parts of the scripts

        Use them as an argument when a function is called (to calculate arg for the function call)
        Assign the value of a property to an object
        Event handlers and listeners, perform task when event occurs
        Prevent conflicts between different scripts that might have the same variable names
*/

var someArea = (function () {
    console.log('Immediately Invoked');
    let width = 5;
    let height = 2;
    return width * height;
}());

console.log(someArea);

/*

    Objects

        Group together a set of variables and function to create a model of a real world concept
        Variables are known as props (fields) and functions are methods.
        There are a few ways that we can declare objs in js

            Obj literal
            Constructor notation

        Obj literal

*/

var hotel = {
    name: 'Marriot',
    rooms: 180,
    booked: 162,
    available: function() {
        return this.rooms - this.booked;
    }
};

document.write('<h2>' + hotel.name + '</h2>');
document.write('<ul>' +
    '<li>' + 'Total Rooms'  + hotel.rooms + '</li>' +
    '<li>' + 'Total Booked'  + hotel.booked + '</li>' +
    '<li>' + 'Total available'  + hotel.available() + '</li>' +
    '</ul>');

var newHotel = new Object();
newHotel.name = 'Ritz';
newHotel.rooms = 200;
newHotel.booked = 134;
newHotel.available = function() {
    return this.rooms - this.booked;
}

document.write('<h2>' + newHotel.name + '</h2>');
document.write('<ul>' +
    '<li>' + 'Total Rooms '  + newHotel.rooms + '</li>' +
    '<li>' + 'Total Booked '  + newHotel.booked + '</li>' +
    '<li>' + 'Total available '  + newHotel.available() + '</li>' +
    '</ul>');

/*
    var vs let vs const


*/

var message = 'hi';
console.log(message);

//Variable that do not use var let or const, will be given global scope

score = 70;

if (score >= 70) {
    var pass = true;
    console.log(message);
    console.log("you passed");
} else {
    console.log('You failed');
}

console.log(pass);

if (score >= 70) {
    let myVal = true;
    console.log(message);
}
//console.log(myVal);

/*
    Hoisting

        The interpreter does not execute scripts sequentially but instead whenever a script enters int a new execution context, there are two phases
            Prepare
                The new scope is created
                Variables, fucntions, and arguments are created

            Execute
                Assign values to variable
                Reference functions and run thier code
                Execute statements

        Understanding these two phases helps us to understand the concept of hoisting
        We can
            Call functions before they have been declared
            Assign a value to a variable that has not yet been declared
*/

hoistTest1();
hoistTest2();
hoistTest3()
hoistTest4();
hoistTest5();

function hoistTest1() {
    var x;
    x = 6;
    console.log(x);
}
function hoistTest2() { //undefined
    var x;
    console.log(x);
    x = 6;
}

function hoistTest3() { //undefined
    console.log(x);
    var x;
    x = 6;
}

function hoistTest4() {
    x = 6;
    console.log(x);
    var x;
}

function hoistTest5() { //Doesn't work for let and const
    // x = 6;
    // console.log(x);
    // let x;
}

