const capturing = true;
const bubbling = false;

// ALL BUBBLING
// Order of alerts =
document.getElementById('inner').addEventListener('click', function(event) {
	alert('INNER!!!');
	console.log('e.target is ' + event.target);
	console.log('e.currentTarget is ' + event.currentTarget);
}, bubbling);
document.getElementById('middle').addEventListener('click', function(event) {
	alert('MIDDLE!!!');
	console.log('e.target is ' + event.target);
	console.log('e.currentTarget is ' + event.currentTarget);
}, bubbling);

document.getElementById('outer').addEventListener('click', function(event) {
	alert('OUTER!!!');
	console.log('e.target is ' + event.target);
	console.log('e.currentTarget is ' + event.currentTarget);
}, bubbling);


document.getElementById('inner2').addEventListener('click', function(event) {
	alert('INNER!!!');
	console.log('e.target is ' + event.target);
	console.log('e.currentTarget is ' + event.currentTarget);
}, capturing);
document.getElementById('middle2').addEventListener('click', function(event) {
	alert('MIDDLE!!!');
	console.log('e.target is ' + event.target);
	console.log('e.currentTarget is ' + event.currentTarget);
}, bubbling);

document.getElementById('outer2').addEventListener('click', function(event) {
	alert('OUTER!!!');
	console.log('e.target is ' + event.target);
	console.log('e.currentTarget is ' + event.currentTarget);
}, capturing);


