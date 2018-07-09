/*
 *	1. Creating a JavaScript function that takes
 *  a date parameter and returns true if the year
 *  is a leap year in the Gregorian calendar.
 */
function leapYear(inputDate) {
	let year = inputDate.getFullYear();
	if (year % 4 != 0) {
		return false;
	} else if (year % 100 != 0) {
		return true;
	} else if (year % 400 != 0) {
		return false;
	}
	return true;
}


/*
 *	2. Creating a JavaScript function that checks
 *  for a valid email format.
 */
function isEmail(inputEmail) {
	let regexExp = '[A-Za-z][A-Za-z0-9]*'
		+ '([\\.\\-_.][A-Za-z.][A-Za-z0-9]*)*'
		+ '[@.][A-Za-z.][A-Za-z0-9]*'
		+ '([\\.\\-_.][A-Za-z.][A-Za-z0-9]*)*'
		+ '[\\..][A-Za-z.][A-Za-z0-9]*';
	let matches = inputEmail.match(regexExp);
	return matches != null && matches.length > 0;
}


/*
 *	3. Writing a JavaScript function that removes
 *  character at the specified position of a
 *  given string and return the new string.
 */
function removeChar(str, int) {
	if (typeof(str) == 'number' && typeof(int) == 'string') {
		let tempint = str;
		str = int;
		int = tempint;
	}
	if (int >= 0 && int < str.length) {
		return str.substring(0, int) + str.substring(++int, str.length);
	}
	return str;
}


/*
 *	4. Writing a JavaScript function that removes
 *  all instances of "Script" in a string.
 */
function removeScript(str) {
	while (str.indexOf('Script') >= 0) {
		str = str.replace('Script', '');
	}
	return str;
}


/*
 *	5. Writing a JavaScript function that replaces
 *  each letter with the next letter in the alphabet.
 */
function letterShift(str) {
	let returnStr = '';
	for (let i = 0; i < str.length; i++) {
		let charVal = str.charCodeAt(i);
		if ((charVal > 64 && charVal < 90) || (charVal > 96 && charVal < 122)) {
			charVal++;
		}
		returnStr += String.fromCharCode(charVal);
	}
	return returnStr;
}


/*
 *	6. Count the vowels in a string.
 */
function vowelCount(string) {
	let vowelCn = 0;
	for (let i = 0; i < string.length; i++) {
		switch (string.charAt(i)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
			case 'A': case 'E': case 'I': case 'O': case 'U':
			vowelCn++;
		}
	}
	return vowelCn;
}

/*
 *	7. Reverse array.
 */
 function reverseArr(array){
	reverseArray = [];
	for (let i = 0, j = array.length; i < array.length; i++) {
		reverseArray[i] = array[--j];
	}
	return reverseArray;
}

/* 8. Add Array */

function addArr(array1, array2){
	sumArray = [];
	for (let i = 0; i < array1.length; i++) {
		sumArray[i] = array1[i];
	}
	let arrayIndex = array1.length;
	for (let i = 0; i < array2.length; i++) {
		sumArray[arrayIndex++] = array2[i];
	}
	return sumArray;
}

/* 9. Longest String */

function longestStr(array) {
	let size = 0;
	let index = 0;
	for (let i = 0; i < array.length; i++) {
		if (array[i].length > size) {
			size = array[i].length;
			index = i;
		}
	}
	return index;
}

/* 10. Get the area of triangle given three sides. */

function area(s1, s2, s3) {
	// None of them should be 0 or less.
	/*
	 * Make sure the sum of any two sides is greater than the
	 * third side. Also, we don't have to worry about any negative
	 * values, as that would also result in failed cases.
	 * If s1 is 0 or less, s2Check or s3Check would be 0 or less.
	 * If s2 is 0 or less, s1Check or s3Check would be 0 or less.
	 * If s3 is 0 or less, s1Check or s2Check would be 0 or less.
	 */
	let s1Check = s2 + s3 - s1;
	let s2Check = s1 + s3 - s2;
	let s3Check = s1 + s2 - s3;
	if (s1Check <= 0 || s2Check <= 0 || s3Check <= 0 || s1 <= 0
			|| s2 <= 0 || s3 <= 0) {
		return undefined;
	}
	let halfPerimeter = s1 + s2 + s3
	halfPerimeter /= 2;
	let squared = halfPerimeter * (halfPerimeter - s1) * (halfPerimeter - s2) * (halfPerimeter - s3);
	return Math.pow(squared, 0.5)
}

/*
 * 11. Check if the polygons are similar.
 */

function areSimilar(polygon1, polygon2) {
	if (polygon1.length < 3 || polygon2.length < 3) {
		alert('Invalid polygons!!! Both must have at least '
			+ 'three sides!!');
		return false;
	}
	if (polygon1.length != polygon2.length) {
		console.log('Different number of sides...')
		return false;
	}
	for (let i = 0; i < polygon1.length; i++) {
		if (polygon1[i] <= 0 || polygon2[i] <= 0) {
			alert('Invalid: One of the polygons have a side '
				+ 'of 0 or less!');
			return false;
		}
	}

	let checkSimilarity = function(arr1, arr2, offset) {
		let ratios = [];

		for (let i = 0; i < arr1.length; i++) {
			let j = (i + offset) % arr2.length;
			ratios[i] = arr2[j] / arr1[i];
		}

		for (let i = 1; i < ratios.length; i++) {
			if (Math.abs(ratios[i] - ratios[i - 1]) > 0.001) {
				return false;
			}
		}

		return true;
	}
	for (let i = 0; i < polygon1.length; i++) {
		if (checkSimilarity(polygon1, polygon2, i)) {
			return true;
		}
	}
	return false;
}

/*
 * 12. Check to see if two arrays are equivalent..
 */

function equivArr(array1, array2){
	if (array1.length != array2.length) {
		return false;
	}
	let tempArray1 = [];
	let tempArray2 = [];
	for (let i = 0; i < array1.length; i++) {
		tempArray1[i] = array1[i];
	}
	for (let i = 0; i < array2.length; i++) {
		tempArray2[i] = array2[i];
	}
	tempArray1.sort((a, b) => a - b);
	tempArray2.sort((a, b) => a - b);
	for (let i = 0; i < tempArray2.length; i++) {
		if (tempArray1[i] != tempArray2[i]) {
			return false;
		}
	}
	return true;
}


/*
 * 13. Tic Tac Toe, determine winner.
 */
function tictactoe(array){
	let xCount = 0;
	let oCount = 0;
	let diag0022 = 0;
	let diag0220 = 0;
	let rows = [0, 0, 0];
	let cols = [0, 0, 0];

	for (let i = 0; i < array.length; i++) {
		for (let j = 0; j < array[i].length; j++) {
			let addValue = 0;
			let check = array[i][j].toLowerCase();
			switch (check) {
				case 'x':
				addValue = 4;
				xCount++;
				break;
				case 'o':
				addValue = 1;
				oCount++;
				break;
				case '': case undefined: case null: case 'empty':
				break;
				default:
				console.log('Invalid value in [' + i + '][' + j + ']');
				return 'Invalid value in [' + i + '][' + j + ']';
			}
			rows[i] += addValue;
			cols[j] += addValue;
			if (i == j) {
				diag0022 += addValue;
			}
			if (i + j == array.length - 1) {
				diag0220 += addValue;
			}
		}
	}
	let xWins = false;
	let oWins = false;
	for (let i = 0; i < rows.length; i++) {
		switch (rows[i]) {
			case 12:
			xWins = true;
			break;
			case 3:
			oWins = true;
			break;
		}
	}
	for (let i = 0; i < cols.length; i++) {
		switch (cols[i]) {
			case 12:
			xWins = true;
			break;
			case 3:
			oWins = true;
			break;
		}
	}
	switch (diag0220) {
		case 12:
		xWins = true;
		break;
		case 3:
		oWins = true;
		break;
	}
	switch (diag0022) {
		case 12:
		xWins = true;
		break;
		case 3:
		oWins = true;
		break;
	}
	if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
		console.log('Invalid result');
		return 'Invalid result';
	} else if (xWins) {
		console.log('X is the winner');
		return 'X is the winner';
	} else if (oWins) {
		console.log('O is the winner');
		return 'O is the winner';
	} else {
		console.log('No winner yet');
		return 'No winner yet';
	}
}
