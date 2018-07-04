// A single line comment in JavaScript

/*
    This is a multiline comment
    in JavaScript
*/

// The browser represents each window or tab using a window object
window.onload = function() {
    console.log('The window has loaded!');       // console.log is like the syso of javaScript
};

/*
    JavaScript Basics
        - the language of the Internet
        - interpreted language
        - loosley typed
        - used to make web pages more interactive and dynamic
*/

var color = 'color';                // string data type
var num = 123;                      // number data type
var bool = 3 > 5;                   // boolean
var dec = 2.111;                    // number
var numArr = [1, 2, 3, 4];          // object data type
var myObj = { };                    // object data type
var myFunction = function() { }     // function data type (like a sub data type of object)

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
if(currentHour > 18) {
    greeting = 'Good Evening';
}else if(currentHour > 12){
    greeting = 'Good Afternoon';
}else if(currentHour > 0){
    greeting = 'Good Morning';
}else{
    greeting = 'Welcome';
}

// we can use document.write() to inject html into our webpage although there is a better way
document.write('<h3>' + greeting + '</h3>');

// Working with arrays in JS is not much different than Jaa
var myNumArray = [1, 2, 3, 4, 5, 6, 7, 8, 9];

for(var i = 0; i < myNumArray.length; i++){
    console.log(myNumArray[i]);
}

// However, arrays can store values of varying data types
myCrazyArray = [1, 'no', 3.1415, new Date(), function() { console.log('hi')}, false, 4/'hi', 5/0];
for(var i = 0; i < myCrazyArray.length; i++){
    console.log(myCrazyArray[i]);
}

// Funciton declarations
function getArea(width, height){
    return width * height;
}

var myArea = getArea(5, 10);        // this is an implicit (direct) function call
console.log(myArea);

// Getting multiple values from a function
function getSize(width, height, length){
    let area = width * height;
    let volume = area * length;
    let sizes = [area, volume];
    return sizes;
}

myArea = getSize(5, 7, 10)[0];
var myVolume = getSize(5, 7, 10)[1];
console.log('Area: ' + myArea + ', Volume: ' + myVolume);

/*
    Anonymous Funcitons and Funciton Expressions
        Expresssions produce a value. They can be used where values are expected. If a function is placed
        where the browser expects to see an expression, the function is treated as an expression. A function
        with no name is known as an anonymous funcitno, since it cannot be called directly.
*/
// this function as no name but can be called by the var name
var area = function(width, height){
    return width * height;
}

console.log('Function expression - area: ' + area(3, 5));

/*
    Immediately Invoked Fucntion Expressions (IIFE)
        Anonymous funciont that are executed as soon as the intrepreter comes across them. IIFEs are used
        when some code only needs to run once withina task, rather than repreatedly being called by other 
        parts of the script. For example:

        - As an argument when a function is called
        - to assign the value of a porperty to an object
        - In event handlers and listners, to perform a task when an event occurs
        - To prevent conflicts between scripts that might use the same variable names
*/

var someArea = (function(){
    console.log('Immediately Invoked');
    let width = 4;
    let height = 6;
    return width * height;
}());

console.log(someArea);

/*
    Objects
        object group together a set of variables and functions to create a model of a real world concept. In objects, 
        variables become known as propertis/fields, and functions become methods. There are a few ways that 
        we can declare objects in JS:

            - Using object literals
            - Using constructor notation
*/
// Object Creation: Object Literal
var hotel = {
    name: 'Marriot', 
    rooms: 180,
    booked: 162,
    available: function() {
        return this.rooms - this.booked;
    }
}

document.write('<h2>' + hotel.name + '</h2>');
document.write('<ul>' +
    '<li>' + 'Total Rooms: ' + hotel.rooms + '</li>' +    
    '<li>' + 'Booked Rooms: ' + hotel.booked + '</li>' +
    '<li>' + 'Available Rooms: ' + hotel.available() + '</li>' +
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
document.write('<h2>' + newHotel.name + '</h2>');
document.write('<ul>' +
    '<li>' + 'Total Rooms: ' + newHotel.rooms + '</li>' +    
    '<li>' + 'Booked Rooms: ' + newHotel.booked + '</li>' +
    '<li>' + 'Available Rooms: ' + newHotel.available() + '</li>' +
    '</ul>'
);

/*
    var vs let vs const

    let and const are block scope

    var can be used globaly
*/

var message = 'hi';
console.log(message);

// variables that do not use a variable declaration keyword (var, let, or const) are given global scope

score = 70;

if (score >= 70){
    var pass = true;
    console.log(message);
    console.log('You passed')
}else{
    console.log('You failed. Study harder');
}

console.log(pass);      // even though pass was declared within the if statement, it is still visible b/c we declared it using var

if (score >= 70){
    let myValue = 93;
    console.log('Inside of the if block, myValue = ' + myValue);
    console.log('You passed')
}else{
    console.log('You failed. Study harder');
}

//console.log(myValue);       // myValue is not visible outside of the block it was declared in (throws reference area)

const PI = 3.1415;
console.log(PI);

// Throws type error
//PI = 3.14;            // cannot reassign const
//console.log(PI);

//throws Syntax error
//const myBoolean;      // const variables must be initiallized upon declaration



/*

    Hoisting Notes

    hoisting does not work with let and const, only with var
*/


hoistTest_1();
hoistTest_2();
hoistTest_3();
hoistTest_4();
hoistTest_5();
hoistTest_6();
hoistTest_7();

function hoistTest_1(){
    var x;
    x = 6;
    console.log(x);
}

function hoistTest_2(){
    var x;
    console.log(x);
    x = 6;
}

function hoistTest_3(){
    console.log(x);
    var x;
    x = 6;
}

function hoistTest_4(){
    x = 6;
    console.log(x);
    var x;
}

function hoistTest_5(){
//    console.log(x);
    let x = 6;
}

function hoistTest_6(){
    console.log(x);
    var x = 6;
}

function hoistTest_7(){
//    console.log(k);
    k = 6;
}


/*
    Type Coersion
        notes here


        like auto casting
*/

var a = '1' + 1 + 1;
console.log(a);

var b = 1 + 1 + '1';
console.log(b);

var c = 1 + '1' + 1;
console.log(c);

var d = (1 == '1');         // == will perform type coersion
console.log(d);

var e = (1 === '1');        // === checks for value and data type
console.log(e);

console.log(0 == '0');      // true     - type coersion
console.log(0 == '');       // true     - both 0 and an empthy string are falsy
console.log(0 == ' ');      // false    - a blank space is type coersed to 0

/*
    Truthy and Falsy

        Due to type coersion, every value in JS can be treated as if it were true or false; and this
        has some interesting side effects.

        Falsy values are treated as if they are false. There are very few inheritly falsy values in JS:

            let myValue = false;        ==  false is, clearly, falsy
            let myValue = 0;            ==  a value of 0 is treated as falsy
            let myValue = '';           ==  an empty string is falsy
            let myValue = 10/'score';   ==  NaN (Not a Number)
            let myValue;                ==  undeclared variables are falsy
            let myValue = null;         ==  null values are falsy

        Virtually, everything else in JS is truthy.
*/

var myValue;
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = false;
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = 0;
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = '';
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = 10/'string';
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = null;
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = '0';
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = 'false';
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = ' ';
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = 4;
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = {};
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = function() {};
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

myValue = [];
if(myValue){
    console.log('truthy');
}else{
    console.log('falsy');
}

var wat = 10/'string';
console.log(wat == wat);


/*
    Template Literals

        Template literals are enclosed by the back-tick (tilde key  ````) character instead of single quotes. Template
        literals can contain placehlders. Thse are indicated yby teh dollar sign and curly braces ${express}
        Whitespace included in template literals affects the waty that the text is displayed. 
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
        for non-method functions, and they cannot be uesd as constructors.
*/

var elements = [
        'Hydrogen', 
        'Helium',
        'Lithium',
        'Beryllium'
];

var elementalLenghts_1 = elements.map(function(element) {
    return element.length;
});

console.log(elementalLenghts_1);

var elementalLenghts_2 = elements.map(element => {
    return element.length;
});

console.log(elementalLenghts_2);