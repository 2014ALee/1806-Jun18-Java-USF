function dynamicFib(num) {
	let myArr = [0, 1];

	for (let i = 2; i <= num; i++) {
		myArr[i] = myArr[i - 1] + myArr[i - 2];
	}
	 return myArr[num];
}

// Add event listener to our button
document.getElementById('doFib').addEventListener('click', runFib);

function runFib() {
	let inputValue = document.getElementById('fib').value;
	let display = document.getElementById('fibDisplay');

	if (inputValue == '') {
		prompt('No input given!!');
	}
	else {
		display.innerText = dynamicFib(inputValue);
	}
}

function imperativeFib(num) {
	let a = 1;
	let b = 1;
	let c;

	for (let i = 0; i = num - 2; i++) {
		c = a + b;
		a = b;
		b = c;
	}
}

const capturing = true;
let counter = 0;

function click(event) {
	console.log(event.currentTarget + ' ' + counter++);
	event.stopPropagation();
}

function allowDrag(event) {
	console.log('Dragging over element: ' + event.target.id);
	event.preventDefault();
}

function drag(event) {
	event.stopPropagation();
	console.log('Starting to drag element: ' + event.target.id);
	event.dataTransfer.setData('text', event.target.id);
}

function drop(event) {
	event.preventDefault();
	let data = event.dataTransfer.getData('text');
	event.target.insertBefore(document.getElementById(data), event.target.firstChild);
}

document.getElementById('outer').addEventListener('click', click, capturing);
document.getElementById('outer').addEventListener('dragstart', drag, capturing);
document.getElementById('outer').addEventListener('dragover', allowDrag, capturing);
document.getElementById('outer').addEventListener('drop', drop, capturing);

document.getElementById('middle').addEventListener('click', click, capturing);
document.getElementById('middle').addEventListener('dragstart', drag, capturing);
document.getElementById('middle').addEventListener('dragover', allowDrag, capturing);
document.getElementById('middle').addEventListener('drop', drop, capturing);

document.getElementById('inner').addEventListener('click', click, capturing);
document.getElementById('inner').addEventListener('dragstart', drag, capturing);
document.getElementById('inner').addEventListener('dragover', allowDrag, capturing);
document.getElementById('inner').addEventListener('drop', drop, capturing);