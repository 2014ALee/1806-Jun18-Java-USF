// A single line comment

/*
    multi line comment
    in javascript
*/

// javascript is what we use to make our web pages more dynamic. 
// The browser represents each window or tab, using a window object
window.onload = function(){
    // console.log can be thought of as the sysout of JS
    console.log('The window has loaded!');
}

/*
    JavaScript basics:

        - The language of the internet
        - Interpreted language
        - Loosely typed
        - Used to make web pages more interactive and dynamic
*/

var color = 'color';            // string data type
var num = 123;                  // number
var bool = 3 > 5;               // boolean
var dec = 2.111;                // number
var numArr = [1, 2, 3, 4];      // object data types
var myObj = {};                 // object data type
var myFunction = function(){}   // function data type (which is a type of object)

console.log(typeof(color));
console.log(typeof(num));
console.log(typeof(bool));
console.log(typeof(dec));
console.log(typeof(numArr));
console.log(typeof(myObj));

var today = new Date();
var currentHour = today.getHours();
var greeting;

// if statements (same syntax as java)

if (currentHour > 18){
    greeting = "Good Evening!";
} else if (currentHour > 12){
    greeting = 'Good Afternoon!';
} else if (currentHour > 0){
    greeting = 'Good Morning';
} else{
    greting = 'Welcome';
}

// we can use document.write to inject html into our webpage (although there is a better way)
document.write('<h3>' + greeting + '</h3>');

var myNumArray = [1, 9, 2, 8, 3, 7, 4, 6, 5];
for(var i; i < myNumArray.length; i++){
    console.log(myNumArray[i]);
}

// However, arrays can store values of varying data types
var myCrazyArray = [1, 'no', 3.14159, new Date(), function() {consol.log('hi'), false, 4/'hi', 5/0}];
for(var i; i < myCrazyArray.length; i++){
    console.log(myCrazyArray[i]);
}

// function declaration
function getArea(width, height){
    return width * height;
}

var myArea = getArea(5, 10);    // implicit (direct) function called
console.log(myArea);

// getting multiple values from a function
function getSize(width, height, depth){
    let area = width * height;
    let volume = width * height * depth;
    let sizes = [are, volume];
    return sizes;
}

myArea = getSize(5, 7, 10)[0];
var myVolume = getSize(5, 7, 10)[1];
console.log('Area: ' + myArea + 'Volume: ' + myVolume);

/*
    Anonymous functions and function expressions

        Expressions produce a value. They can be used where values are expected.
        If a function is placed where the browser expects to see an expression, the function is treated as
        an expression. A function with no name is known as an anonymous function since it cannot be\
        called directly.
*/

// this function is anonymous
var area = function(width, height){
    return width * height;
}

console.log('Function expression - area: ' + area(3,5));

/*
    Immediately invoked Function Expression (IIFE)

        Anonymous functions that are executed as soon as the interpreter comes across them. IIFE's
        are used when some code only needs to run once whithin a task, rather than repeatedly being 
        called by other parts of the script.

*/

// this is called immediately, whereas the function above is only called when area is called
var someArea = (function(){
    console.log('Immediately Invoked!');
    let width = 4;
    let height = 6;
    return width * height;
}());

/*
    Objects

        Objects group together a set of variables and functions to create a model of a real-world 
        concept. In Objects, variables become known as properties/fields

*/

var hotel = {
    name: 'Marriot',
    rooms: 180,
    booked: 162,
    available: function(){
        return this.rooms - this.booked;
    }
}

document.write('<h2>' + hotel.name + '<h2>');
document.write('<ul>' + 
    '<li>' + 'Total Rooms: ' + hotel.rooms + '</li>' +
    '<li>' + 'Booked Rooms: ' + hotel.booked + '</li>' +
    '<li>' + 'Available Rooms: ' + hotel.available + '</li>' +
    '</ul>'
);

// Object creation: constructor notation
var newHotel = new Object();
newHotel.name = 'Ritz';
newHotel.rooms = 200;
newHotel.booked = 145;
newHotel.available = function(){
    return this.rooms - this.booked;
}

document.write('<h2>' + newHotel.name + '<h2>');
document.write('<ul>' + 
    '<li>' + 'Total Rooms: ' + newHotel.rooms + '</li>' +
    '<li>' + 'Booked Rooms: ' + newHotel.booked + '</li>' +
    '<li>' + 'Available Rooms: ' + newHotel.available() + '</li>' +
    '</ul>'
);

/*
    var vs. let vs. const


*/

var message = 'hi';
console.log(message);

// variables that do not use declaration keyword, will be goiven global scope
score = 70;

if (score >= 70){
    var pass = true;
    console.log(message);           // the variable 'message' is visible here, because var is global
    console.log('You passed!');
} else{
    console.log('You Failed, study harder...');
}

console.log(pass); // even though pass was declared within the if statement, we can still use it


