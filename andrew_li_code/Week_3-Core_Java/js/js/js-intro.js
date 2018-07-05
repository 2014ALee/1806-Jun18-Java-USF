// The rowser represents each window or tab using the window object.
window.onload = function() {
	console.log('The window has loaded!!!');
};

var color = 'color';
var num = 123;
var bool = 3 > 5;
var double = 2.11111;
var numArr = [1,2,3,4];
var myObj = {};
var myfunction = function() {};

console.log(typeof(color));
console.log(typeof(num));
console.log(typeof(bool));
console.log(typeof(double));
console.log(typeof(numArr));
console.log(typeof(myObj));
console.log(typeof(myfunction));

var now = new Date();
var currentHour = now.getHours();
var greeting;

if (currentHour > 18) {
	greeting = 'Good evening!';
} else if (currentHour > 12) {
	greeting = 'Good afternoon!';
} else if (currentHour > 0) {
	greeting = 'Good morning!';
} else {
	greeting = 'Hello!';
}

document.write('<h3>' + greeting + '</h3> <br />');

// Objects
var hotel = {
	name: "Andrew",
	rooms: 180,
	bookedRooms: 175,
	available: function() { return this.rooms - this.bookedRooms; }
}

document.write(hotel.name + "<br />");
document.write(hotel.rooms + "<br />");
document.write(hotel.bookedRooms + "<br />");
document.write(hotel.available() + "<br />");

if (true) {
	const andrew = "andrew"
}
console.log(andrew);