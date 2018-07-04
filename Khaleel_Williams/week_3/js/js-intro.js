// A single line comment in JavaScript

/*
    This is a multi-line
    comment in JavaScript
*/

// The browser represents each window or tab using a window object
window.onload = function(){
    //Think of console.log() as the System.out.prinln() of JS
    console.log('The window has loaded!');
};


/*
    JavaScript Basics

        - The language of the Internet
        - Interpreted language
        - loosely-typed
        - Used to make web pages more interactive and dynamic

*/

var color = 'color';                // string data type
var num = 123;                      // number data type
var bool = 3 > 5;                   // boolean data type
var dec = 2.11111;                  //number data type
var numArr = [1, 2, 3, 4];          //object data type
var myObj = {};                     //object data type
var myFunction = function() {}      // function data type (which is a type of object)

console.log(typeof(color));
console.log(typeof(number));
console.log(typeof(bool));
console.log(typeof(dec));
console.log(typeof(numArr));
console.log(typeof(myObj));
console.log(typeof(myFunction));