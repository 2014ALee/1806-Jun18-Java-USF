/*

*/

// var location = 'https://www.google.com';
// let location = 'https://www.google.com';

let counter = 0;

function add() {
	counter+=1;
}

add();
add();
add();

console.log(counter);

function add_v2() {
	let counter = 0;
	counter+=1;
	return counter;
}

function myFunction() {
	let myParagraph = document.getElementById("myValue");
	myParagraph.innerHTML = add_v3();
}

let add_v3 = (function() {
	let ctr = 0;
	return function() {
		ctr+=1;
		return ctr;
	}
}());

























//
