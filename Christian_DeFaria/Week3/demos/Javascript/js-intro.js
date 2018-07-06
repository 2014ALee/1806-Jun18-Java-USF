// A single line comment in JavaScript

/*
	Multi-line
	comments
*/

// The browser represents each window or tab using a window object
window.onload = function() {
	console.log('The window has loaded!');
};

/*

*/

var color = 'color';			//string
var number = 123;				//number
var bool = 3 > 5;				//boolean
var dec = 2.11111;				//number
var arr = [1, 2, 3, 4];			//objects
var obj = { };					//objects
var func = function() {};		//function

console.log(typeof(color));
console.log(typeof(number));
console.log(typeof(bool));
console.log(typeof(dec));
console.log(typeof(arr));
console.log(typeof(obj));
console.log(typeof(func));

var today = new Date();
var currentHour = today.getHours();
var greeting;

if(currentHour > 18) {
	greeting = 'Good Evening!';
} else if(currentHour>12) {
	greeting = 'Good Afternoon!';
} else if(currentHour > 0) {
	greeting = 'Good Morning!';
} else {
	greeting = 'Welcome!';
}

//
document.write('<h3>'+greeting+'</h3>');

var myNumArr = [1,9,2,8,3,7,4,6,5];
for(var i=0; i<myNumArr.length; i++) {
	console.log(myNumArr[i]);
}

// var myCrazyArray = [1, 'no', 3.1415926, new Date(), f() {console.log('hi')}, false, 4*'hi', 5/0];
// for(var i = 0; i < myCrazyArray.length; i++) {
// 	console.log(myCrazyArray[i]);
// }

function getArea(width, height) {
	return width*height;
}

var myArea = getArea(5, 10);
console.log(myArea);

function getSize(width, height, depth) {
	let area = width*height;
	let volume = area*depth;
	let sizes = [area, volume];
	return sizes;
}

myArea = getSize(5, 7, 10)[0];
var myVolume = getSize(5, 7, 10)[1];
console.log('Area: ' + myArea + ', Volume: ' + myVolume);

/*

*/
// var area = funtion(width, height) {
// 	return width*height;
// };
//
// console.log('Function expression: ' area(3,5));

/*

*/
var someArea = (function() {
	console.log('Immediately invoked');
	let width = 4;
	let height = 6;
	return width*height;
}());

console.log(someArea);

/*

*/
var hotel = {
	name: 'Marriot',
	rooms: 180,
	booked: 162,
	available: function() {
		return this.rooms-this.booked;
	}
}

document.write('<h2>'+hotel.name+'</h2>');
document.write('<ul>' +
'<li>' + hotel.rooms + '</li>' +
'<li>' + hotel.booked + '</li>' +
'<li>' + hotel.available() + '</li>' +
'</ul>');

var newHotel = new Object();
newHotel.name = 'Ritz';
newHotel.rooms = 200;
newHotel.booked = 145;
newHotel.available = function() {
	return this.rooms-this.booked;
}

document.write('<h2>'+newHotel.name+'</h2>');
document.write('<ul>' +
'<li>' + newHotel.rooms + '</li>' +
'<li>' + newHotel.booked + '</li>' +
'<li>' + newHotel.available() + '</li>' +
'</ul>');

/*

*/

var message = 'hi';

score = 70;
if(score >= 70) {
	var pass = true;
	console.log(message);
	console.log('You passed');
} else {
	console.log('You failed, study harder...');
}

console.log(pass);

if(score >= 70) {
	let myValue = 93;
	console.log(myValue);
	console.log('You passed');
} else {
	console.log('You failed, study harder...');
}

// console.log(myValue);

const PI = 3.14159;
console.log(PI);

// PI = 3.14;
console.log(PI);

// if(score >= 70) {
// 	const someInt = 70;
// }
// console.log(someInt);

/*

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
	// console.log(x);
	let x = 6;
}

function hoistTest_6() {
	console.log(x);
	var x = 6;
}

function hoistTest_7() {
	// console.log(k);
	k = 6;
}

// console.log(k);

/*

*/

var a = '1' + 1 + 1;
console.log(a);

var b = 1 + 1 + '1';
console.log(b);

var c = 1 + '1' + 1;
console.log(c);

var d = (1 == '1');
console.log(d);

var e = (1 === '1')
console.log(e);

console.log(0 == '0');
console.log(0 == '');
console.log(0 == ' ');

/*
	Falsy values
		false
		0
		''
		NaN
		undeclared variable
		null
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

var wat = 10/'str';
console.log(wat==wat);
console.log(wat===wat);

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

myValue = function() {};
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

/*

*/

var theQuestion = 'What is the meaning of life?';
var theAnswer = 42;
console.log(`First, what is the question\n
${theQuestion}
The answer is: ${theAnswer}`);

/*

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

var abc;
let xyz;





























//
