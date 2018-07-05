let counter = 0;

add = function add() {
	counter += 1;
}

add_v3 = (function() {
	let counter = 0;
	return function() {
		counter += 1;
		return counter;
	}
}());