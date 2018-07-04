// a single line comment

/*
    Multi-line comments
*/

// The browser represent each window or tab using a window object
window.onload = function(){
    console.log('The window has loaded');
};

var color = 'color';            // String
var num = 123;                  // Number
var bool = true;                // Boolean
var dec = 3.14;                 // Number
var arry = [1, 2, 3, 4];        // Object
var obj = {};                   // Object
var func = function(){};        // Function data type(Which is a type of object)

console.log(typeof(color));
console.log(typeof(num));
console.log(typeof(bool));
console.log(typeof(dec));
console.log(typeof(arry));
console.log(typeof(obj));
console.log(typeof(func));

var today = new Date();
var currentHour = today.getHours();
var greeting;

// if statements
if (currentHour > 18){
    greeting = 'Good evening';
} else if (currentHour > 12){
    greeting = 'Good afternoon';
} else if (currentHour > 0){
    greeting = 'Good morning';
} else {
    greeting = 'Welcome';
}

document.write('<h3>' + greeting + '</h3>');

for(var i = 0; i < arry.length; i++){
    console.log(arry[i]);
}

var crazyArray = [1, '2', 3.0, new Date(), function(){console.log('hello')}, false]

for(var i = 0; i < crazyArray.length; i++){
    console.log(crazyArray[i]);
}


function getArea(width, height){
    return width * height;
}

var area = getArea(5, 10);
console.log(area);

// Getting multiple values from a function
function getSize(width, height, depth){
    let area = width * height;
    let volume = area * depth;
    let sizes = [area, volume];
    return sizes;
}

var area = getSize(5, 7, 10)[0];
var volume = getSize(5, 7, 10)[1];
console.log('Area: ' + area + ', Volume: ' + volume);


/*
    Ananymous Functions and Function Expressions
    
    functions can be used wherever a value is expected. If a function is placed
    where the browser expects to see an expression, the function is treated as an expression.
*/

var area = function(width, height){
    return width * height;
}

console.log('Ananymous function: ' + area(3, 5));

/*
    Immediately Invoked Function Expression
        
        Ananymous functions that are executed as soon as the interpreter comes across them.
        
        - Can be used as an argument when a function is called
        - Assign the value of a property to an object
        - In event handlers and listeners, to perform a task when an event occurs
        - Prevent conflicts between scripts that might use the same variable names
*/

var someArea = (function() {
    console.log('Immediately invoked');
    let width = 4;
    let height = 6;
    return width * height;
}());

console.log(someArea);


/*
    Objects
        
        Group together a set of variables and functions to create a model of a real-world concept.
        In objects, variables are properties or fields, and functions are methods.
        
        Declaring an object
        
        - Using object literals
        - Constructor Notation
*/

// Object Literal
var hotel = {
    name: 'Marriot',
    rooms: 180,
    booked: 162,
    available: function(){
        return this.rooms - this.booked;
    }
};

document.write('<h2>' + hotel.name + '</h2>');
document.write('<ul>' + 
'<li>Total Rooms: ' + hotel.rooms + '</li>' +
'<li>Booked Rooms: ' + hotel.booked + '</li>' +
'<li>Available Rooms: ' + hotel.available() + '</li>' +
'</ul>');


// Constructor Notation
var newHotel = new Object();
newHotel.name = 'Ritz';
newHotel.rooms = 250;
newHotel.booked = 145;
newHotel.available = function(){
    return this.rooms - this.booked;
};

document.write('<h2>' + newHotel.name + '</h2>');
document.write('<ul>' + 
'<li>Total Rooms: ' + newHotel.rooms + '</li>' +
'<li>Booked Rooms: ' + newHotel.booked + '</li>' +
'<li>Available Rooms: ' + newHotel.available() + '</li>' +
'</ul>');

/*
    var vs. let vs. const
*/
var message = 'hi';
console.log(message);

// Variables that don't use a declaration keyword will be given global scope
score = 70;
if(score >= 70){
     var pass = true;
     console.log(message);
     console.log('You passed');
}

console.log(true);

if(score >= 70){
     let val = 93;
     console.log(val);
}

//console.log(val); // val is not visible outside the block it was declared in

const PI = 3.14;
//Pi = 5; // TypeError


// Hoisting only occurs with var








