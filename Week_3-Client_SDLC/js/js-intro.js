// A single line comment in JavaScript

/*
    This is a multi-line
    comment in JavaScript
*/

// The browser represents each window or tab using a window object
window.onload = function() {
    // Think of console.log() as the System.out.println() of JS
    console.log('The window has loaded!');
};

/*
    JavaScript Basics

        - The language of the Internet
        - Interpreted language
        - Loosely-typed
        - Used to make web pages more interactive and dynamic
*/
var color = 'color';                // string data type
var num = 123;                      // number data type
var bool = 3 > 5;                   // boolean data type
var dec = 2.11111;                  // number data type
var numArr = [1, 2, 3, 4];          // object data type
var myObj = { };                    // object data type
var myFunction = function() { }     // function data type (which is a type of object)

console.log(typeof(color));
console.log(typeof(num));
console.log(typeof(bool));
console.log(typeof(dec));
console.log(typeof(numArr));
console.log(typeof(myObj));
console.log(typeof(myFunction));

var today = new Date();
var currentHour = today.getHours();
var greeting;

// if statements have the same syntax as Java
if (currentHour > 18) {
    greeting = 'Good evening!';
} else if (currentHour > 12) {
    greeting = 'Good afternoon!';
} else if (currentHour > 0) {
    greeting = 'Good morning!'
} else {
    greeting = 'Welcome!';
}

// we can use the document.write() to inject HTML into our web page (although, there is a better way)
document.write('<h3>' + greeting + '</h3>');

// Working with arrays in JS is not much different than Java
var myNumArray = [1, 9, 2, 8, 3, 7, 4, 6, 5];
for (var i = 0; i < myNumArray.length; i++) {
    console.log(myNumArray[i]);
}

// However, arrays can store values of varying data types
var myCrazyArray = [1, 'no', 3.14159, new Date(), function() { console.log('hi') }, false, 4/'hi', 5/0];
for (var i = 0; i < myCrazyArray.length; i++) {
    console.log(myCrazyArray[i]);
}

// Function declarations
function getArea(width, height) {
    return width + height;
}

var myArea = getArea(5, 10);    // this is an implicit (direct) function call
console.log(myArea);

// Getting multiple values from an function
function getSize(width, height, depth) {
    let area = width * height;
    let volume = area * depth;
    let sizes = [area, volume];
    return sizes;
}

myArea = getSize(5, 7, 10)[0];
var myVolume = getSize(5, 7, 10)[1];
console.log('Area: ' + myArea + ', Volume: ' + myVolume);

/*
    Anonymous Functions and Function Expressions

        Expressions produce a value. They can be used where values are expected. If a function is placed
        where the browser expects to see an expression, the function is treated as an expression. A function
        with no name is known as a anonymous function, since it cannot be called directly.
*/
var area = function(width, height) {
    return width * height;
}

console.log('Function expression - area: ' + area(3, 5));

/*
    Immediately Invoked Function Expression (IIFE)

        Anonymous functions that are executed as soon as the interpreter comes across them. IIFEs are used
        when some code only needs to run once within a task, rather than repeatedly being called by other
        parts of the script. For example:

            - As an argument when a function is called (to calculate some value for the function)
            - To assign the value of a property to an object
            - In event handlers and listeners, to perform a task when an event occurs
            - To prevent conflicts between scripts that might use the same variable names
*/
var someArea = (function() {
    console.log('Immediately invoked!');
    let width = 4;
    let height = 6;
    return width * height;
}());

console.log(someArea);

/*
    Objects

        Objects group together a set of variables and functions to create a model of a real world
        concept. In objects, variables become known as properties/fields, and functions become
        methods. There are a few ways that we can declare objects in JS:

            - Using object literals
            - Using constructor notation
*/
//Object Creation: Object Literal
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
    '<li>' + 'Total Rooms: ' + hotel.rooms + '</li>' +
    '<li>' + 'Booked Rooms: ' + hotel.booked + '</li>' +
    '<li>' + 'Available Rooms: ' + hotel.available() + '</li>' +
    '</ul>'
);


// Object Creation: Constructor Notation
var newHotel = new Object();
newHotel.name = 'Ritz';
newHotel.rooms = 200;
newHotel.booked = 145;
newHotel.available = function() {
    return this.rooms - this.booked;
}

document.write('<h2>' + newHotel.name + '</h2>');
document.write('<ul>' +
    '<li>' + 'Total Rooms: ' + newHotel.rooms + '</li>' +
    '<li>' + 'Booked Rooms: ' + newHotel.booked + '</li>' +
    '<li>' + 'Available Rooms: ' + newHotel.available() + '</li>' +
    '</ul>'
);

/*
    var vs. let vs. const

        var
            
            Before ES6, the var keyword was the primary way to declare a variable in JavaScript. Variables declared
            using var are allowed to be reassigned, and their scope can be either global or block (function) level.
            Variables declared using var are also subject to something known as 'variable hoisting', which we will
            cover later on.

        let

            Since ES6, the let keyword has been the preferred way to declare variables in JS. Variables declared using
            let are also able to be reassigned, however their scope is restricted to the block that they were declared 
            in.

        const

            This keyword may be obvious, but in case it isn't, its purpose is to declare a variable that cannot be
            reassigned after its initialization. Variables declared using const have a scope that is restricted to
            the scope that they were declared in.
*/
var message = 'hi';
console.log(message);

// Variables that do not use a variable declaration keyword (var, let, or const) will be given global scope
score = 70;

if (score >= 70) {
    var pass = true;
    console.log(message);           // the variable 'message' is visible here
    console.log('You passed!')      // semicolons are NOT required, but recommended
} else {
    console.log('You failed, study harder...');
}

console.log(pass);  // even though 'pass' was declared within the if statement, it is still visible because we declared it using var

if (score >= 70) {
    let myValue = 93;
    console.log('Inside of the if block: myValue = ' + myValue);           
    console.log('You passed!');
} else {
    console.log('You failed, study harder...');
}

// throws ReferenceError
//console.log(myValue); // 'myValue' is not visible outside of the block it was declared in

const PI = 3.14159;
console.log(PI);

// throws TypeError
//PI = 3.14;    // we cannot reassign variables declared using const
//console.log(PI);

// throws SyntaxError
//const myBoolean;    // variables declared using const must be initialized upon declaration

if (score >= 70) {
    const someInt = 9;
}

// throws ReferenceError
//console.log(someInt); // the scope of variables declared using const is restricted to the block they were declared in


/*
    Hoisting

        The JS interpreter does not execute scripts sequentially (line by line), but instead whenever a script
        enters into a new execution context, there are two phases of activity:

            1. Prepare
                - The new scope is created
                - Variables, functions, and arguments are created

            2. Execute
                - Assign values to variables
                - Reference functions and run their code.
                - Execute statements

        Understanding these two phases helps us to understand the concept of 'hoisting'. Because of this feature
        of JS, we can:

            - Call functions before they have been declared (if they were created using function declarations, not
                function declarations)
            
            - Assign a value to a variable that has not yet been declared
*/
hoistTest_1();
hoistTest_2();
hoistTest_3();
hoistTest_4();
hoistTest_5();
hoistTest_6();
hoistTest_7();

function hoistTest_1() {
    var x;
    x = 6;
    console.log(x);
}

function hoistTest_2() {
    var x;
    console.log(x);
    x = 6;
}

function hoistTest_3() {
    console.log(x);
    var x;
    x = 6;
}

function hoistTest_4() {
    x = 6;
    console.log(x);
    var x;
}

function hoistTest_5() {
    //console.log(x);
    let x = 6;
}

function hoistTest_6() {
    console.log(x);
    var x = 6;
}

function hoistTest_7() {
    //console.log(k);   // throws a ReferenceError...wat
    k = 5;
}

console.log(k); // wat

/*
    Type Coersion

        If you use a data type that the JS interpreter did not expect, it will try to make sense
        of the operation rather than report an error. JS can convert data types behind the scenes
        to complete an operation.
*/
var a = '1' + 1 + 1;
console.log(a);

var b = 1 + 1 + '1';
console.log(b);

var c = 1 + '1' + 1;
console.log(c);

var d = (1 == '1');     // double equals will perform type coersion
console.log(d);

var e = (1 === '1');    // triple equals will NOT perform type coersion (checks value and data type)
console.log(e);

console.log(0 == '0');  // true
console.log(0 == '');   // true
console.log(0 == ' ');  // wat

/*
    Truthy and Falsy

        Due to type coersion, every value in JS can be treated as if it were true or false; and this
        has some interesting side effects.

        Falsy values are treated as if the are false. There are very few inheritly falsy values in JS:

            let myValue = false;        ==  false is, clearly, falsy
            let myValue = 0;            ==  a value of 0 is treated as falsy
            let myValue = '';           ==  an empty string is falsy
            let myValue = 10/'score';   ==  NaN (Not a Number)
            let myValue;                ==  undeclared variables are falsy
            let myValue = null;         ==  null values are falsy

        Virtually, everything else in JS is truthy.
*/
var myValue;
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = false;
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = 0;
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = '';
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = 10/'string';
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = null;
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = '0';
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = 'false';
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = ' ';
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = 1;
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = {};
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = function() { };
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

myValue = [];
if(myValue) {
    console.log('truthy');
} else {
    console.log('falsy');
}

var wat = 10/'string';
console.log(wat === wat);   // i can't even...

/*
    Template Literals

        Template literals are enclosed by the back-tick (``) character instead of single quotes. Template
        literals can contain placeholders. These are indicated by the dollar sign and curly braces ${expression}
        Whitespace included in template literals affects the way that the text is displayed.
*/
var theQuestion = 'What is the meaning of life?';
var theAnswer = 42;

console.log(`First, what is the question?\n
${theQuestion}
The answer is: ${theAnswer}`);

/*
    Arrow Notation

        An arrow function expression has a shorter syntax than a standard function expression and does not
        have its own 'this', arguments, 'super', or new.target. These function expressions are best suited
        for non-method functions, and they cannot be used as constructors.
*/
var elements = [
    'Hydrogen',
    'Helium',
    'Lithium',
    'Beryllium'
];

var elementalLengths_1 = elements.map(function(element) {
    return element.length;
});

console.log(elementalLengths_1);

var elementalLengths_2 = elements.map(element => {
    return element.length;
});

console.log(elementalLengths_2);

var abc = 9;
let xyz = 10;

/*
    When variables are declared outside of the scope of any function, they are
    actually hoisted up to the global window object, making them properties of
    the window object. If the variable declared has the same name as an existing
    property of the window object, it will overwrite an inherit values. 
    
    For instance, the window object has a property called 'location', which when
    overriden can actually cause our page to immediately redirect to some other
    URL.
*/
//var location = 'http://www.google.com';
let location = 'http://www.google.com';