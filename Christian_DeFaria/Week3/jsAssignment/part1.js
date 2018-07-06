/* 1. Leap Year */
// Create a JavaScript function that takes a date parameter and returns
// true if the year is a leap year in the Gregorian calendar.
function leapYear(date){
	let yr = date.getFullYear();
	if((yr%4)==0 && (yr%400)!=0) {
		return true;
	}
	return false;
}

console.log("Question 1)");
console.log(leapYear(new Date()));
console.log(leapYear(new Date('December 17, 2008 03:24:00')));

/* 2. Email Validation */
// Create a function that checks for a valid email format.
function isEmail(string){
	if(string.length < 255) {
		let reg = /[0-9A-z\-\.]+@[0-9A-z\-\.]+\.[a-z]+/;
		if(string.search(reg) == 0) {
			return true;
		} else {
			return false;
		}
	} else {
		return false;
	}
}

console.log("Question 2)");
console.log(isEmail('test_test-test.test@tset.test.com'));

/* 3. Remove Character */
// Write a JavaScript function to remove a character at the specified
// position of a given string and return the new string.
function removeChar(string, position){
	return (string.substring(0, position) + string.substring(position+1));

}

console.log("Question 3)");
console.log(removeChar('Hello, World!', 5));

/* 4. Remove "Script" */
// Write a JavaScript function to check if a string "Script" is present in a
// given string. If "Script" is present in the string return the string
// without "Script" otherwise return the original one.
function removeScript(string){
	return string.replace('Script', '');
}

console.log("Question 4)");
console.log(removeScript('part1 JavaScript file'));

/* 5. Letter Shift */
// Write a JavaScript function to replace every character in a given string
// with the character following it in the alphabet.
function letterShift(string){
	let result = '';
	for(let i = 0; i < string.length; i++) {
		result += String.fromCharCode(string.charCodeAt(i)+1);
	}
	return result;
}

console.log("Question 5)");
console.log(letterShift('abc'));

/* 6. Vowel Count */
// Write a JavaScript function to count the number of vowels in a given string.
function vowelCount(string){
	let count = 0;
	for(let i = 0; i < string.length; i++) {
		if(string[i] == 'a' || string[i] == 'e' || string[i] == 'i' || string[i] == 'o' || string[i] == 'u' || string[i] == 'y') {
			count++;
		}
	}
	return count;
}

console.log("Question 6)");
console.log(vowelCount('abcdefghijklmnopqrstuvwxyz'));

/* 7. Reverse Array */
// Write a JavaScript function to reverse the elements of a given array.
function reverseArr(array){
	console.log('Before: ' + array);
	array.reverse();
	console.log('After: ' + array);
}

console.log("Question 7)");
reverseArr([1,2,3,4]);

/* 8. Add Array */
// Write  JavaScript function that adds the values of arrays, even if the
// arrays are different sizes.
    // addArr([1,2,3],[3,2,1]) = [4,4,4]
    // addArr([1,2,3,4,5],[1,2,3]) = [2,4,6,4,5]
function addArr(array1, array2){
	let len1 = array1.length;
	let len2 = array2.length;
	let newArr = [];
	if(len1>=len2) {
		for(let i = 0; i<len1; i++) {
			if(i<len2) {
				newArr[i] = array1[i] + array2[i];
			} else {
				newArr[i] = array1[i];
			}
		}
	} else {
		for(let i = 0; i<len2; i++) {
			if(i<len2) {
				newArr[i] = array1[i] + array2[i];
			} else {
				newArr[i] = array2[i];
			}
		}
	}
	return newArr;
}

console.log("Question 8)");
console.log(addArr([1,2,3],[3,2,1]));
console.log(addArr([1,2,3,4,5],[1,2,3]));

/* 9. Longest String */
// Write a JavaScript to find the longest string from an given array of
// strings and returns the string’s array index.
function longestStr(array){
	let longStr = 0;
	for(let i = 1; i < array.length; i++) {
		if(array[longStr].length < array[i].length) {
			longStr = i;
		}
	}
	return longStr;
}

console.log("Question 9)");
console.log(longestStr(['Hello', 'Good-bye', 'Testing']));

/* 10. Area of a Triangle */
// Write a JavaScript function which accepts three integers representing side
// lengths of a triangle. The function should validate that the integers make a
// geometrically accurate. If the three integers could not make a triangle,
// return undefined. Otherwise calculate and return the area of the triangle.
function area(side1, side2, side3){
	if(side1 == side2 && side2 == side3) {
		return (Math.sqrt(3)/4) * Math.pow(side1, 2);
	}
	let hypo = 0;
	let angle1 = 0;
	let angle2 = 0;
	let angle3 = 0;
	if(side1 > side2 && side1 > side3) {
		hypo = side1;
		angle1 = Math.PI/2;
		angle2 = Math.asin(side2/hypo);
		angle3 = Math.asin(side3/hypo);
		if((angle1+angle2+angle3) != Math.PI) {
			return undefined;
		}
	} else if(side2>side1 && side2>side3) {
		hypo = side2;
		angle1 = Math.asin(side1/hypo);
		angle2 = Math.PI/2;
		angle3 = Math.asin(side3/hypo);
		if((angle1+angle2+angle3) != Math.PI) {
			return undefined;
		}
	} else {
		hypo = side3;
		angle1 = Math.asin(side1/hypo);
		angle2 = Math.asin(side2/hypo);
		angle3 = Math.PI/2;
		if((angle1+angle2+angle3) != Math.PI) {
			return undefined;
		}
	}
	return (side3 * (side1*Math.sin(Math.acos(side3/(2*side1)))))/2;
}

console.log("Question 10)");
console.log(area(3,3,3));
console.log(area(3,3,4));
console.log(area(3,4,5));

/* 11. Similar Polygons */
// Write a JavaScript function which accepts two arrays, representing the side
// lengths of polygons. Return true if the polygons are similar, false if they
// are not.
function areSimilar(array1, array2){
	if(array1.length != array2.length) {
		return false;
	}
	let ratio = array1[0]/array2[0];
	for(let i = 0; i < array1.length; i++) {
		if(array1[i] != (array2[i]*ratio)) {
			return false;
		} else if(Math.atan(array1[i]/array1[(i+1)%len])!=Math.atan(array2[i]/array2[(i+1)%len])) {
			return false;
		}
	}
	return true;
}

console.log("Question 11)");
console.log("[3,4,5] is similar to [6,8,10]: " + areSimilar([3,4,5], [6,8,10]));
console.log("[7.3,7.6,10,10] is similar to [8, 8, 12, 12]: " + areSimilar([7.3,7.6,10,10], [8, 8, 12, 12]));

/* 12. Equivalent Arrays */
// Check if two arrays have the same size and contents (including if content
// order is not the same).
// equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
// equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
// equivArr([4,2,8,4],[7,5,4,2,8]) = false
function equivArr(array1, array2){
	let len  = array1.length;
	if(array1.length === array2.length) {
		array1.sort();
		array2.sort();
		for(let i = 0; i < array1.length; i++) {
			if(array1[i] !== array2[i]) {
				return false;
			}
		}
		return true;
	}
	return false;

}

console.log("Question 12)");
console.log(equivArr([4,2,8,4,7],[7,4,4,2,8]));
console.log(equivArr([4,2,8,4,7],[7,5,4,2,8]));
console.log(equivArr([4,2,8,4],[7,5,4,2,8]));

/* 13. Tic Tac Toe */
// Create a function which takes a 3x3 2D array. Validate that each array index
// holds only a value of “X”, “O”, or be empty. Have the function evaluate a
// game of tic tac toe represented by the 2D array.  Should have a result for
// a tie, each winner, or an invalid game.
//     tictactoe([[“X”, “X”, “X”],[“O”, “O”, “O”],[“X”, “O”, “X”]])
// prints “Invalid result”
// tictactoe([[“X”, “X”, “X”],[“X”, “X”, “X”],[“X”, “O”, “X”]])
// prints “Invalid result”
//         tictactoe([[“X”, “O”, “X”],[“O”, “X”, “O”],[“X”, “O”, “X”]])
// Prints “X is the winner”
// tictactoe([[empty, “O”, “X”],[“X”, “O”, empty],[empty, “O”, “X”]])
// Prints “O is the winner”
//         tictactoe([[“X”, empty, “X”],[“O”, empty, empty],[empty, “O”, empty]])
// Prints “No winner yet”
function tictactoe(array){
	let xCount = 0;
	let oCount = 0;
	let winner = '';
	//i = rows, j = columns
	for(let i = 0; i < array.length; i++) {
		for(let j = 0; j < array[i].length; j++) {
			if(array[i][j] == 'X') {
				xCount++;
				if(i==0) {
					if(array[1][j] == 'X' && array[2][j] == 'X') {
						if(winner=='' || winner=='X') {
							winner = 'X';
						} else {
							console.log('Invalid result');
							return;
						}
					}
					if(j==0) {
						if(array[1][1] == 'X' && array[2][2] == 'X') {
							if(winner=='' || winner=='X') {
								winner = 'X';
							} else {
								console.log('Invalid result');
								return;
							}
						}
					} else if(j==2) {
						if(array[1][1] == 'X' && array[2][0] == 'X') {
							if(winner=='' || winner=='X') {
								winner = 'X';
							} else {
								console.log('Invalid result');
								return;
							}
						}
					}
				}
				if(j==0) {
					if(array[i][1] == 'X' && array[i][2] == 'X') {
						if(winner=='' || winner=='X') {
							winner = 'X';
						} else {
							console.log('Invalid result');
							return;
						}
					}
				}
			} else if(array[i][j] == 'O') {
				oCount++;
				if(i==0) {
					if(array[1][j] == 'O' && array[2][j] == 'O') {
						if(winner=='' || winner=='O') {
							winner = 'O';
						} else {
							console.log('Invalid result');
							return;
						}
					}
					if(j==0) {
						if(array[1][1] == 'O' && array[2][2] == 'O') {
							if(winner=='' || winner=='O') {
								winner = 'O';
							} else {
								console.log('Invalid result');
								return;
							}
						}
					} else if(j==2) {
						if(array[1][1] == 'O' && array[2][0] == 'O') {
							if(winner=='' || winner=='O') {
								winner = 'O';
							} else {
								console.log('Invalid result');
								return;
							}
						}
					}
				}
				if(j==0) {
					if(array[i][1] == 'O' && array[i][2] == 'O') {
						if(winner=='' || winner=='O') {
							winner = 'O';
						} else {
							console.log('Invalid result');
							return;
						}
					}
				}
			} else if(array[i][j] == '') {
				continue;
			} else {
				console.log('Invalid result');
				return;
			}
		}
	}
	if(xCount<(oCount-1) || xCount>(oCount+1)) {
		console.log('Invalid result');
		return;
	} else if(winner == 'X') {
		console.log('X is the winner');
	} else if (winner == 'O') {
		console.log('O is the winner');
	} else {
		console.log('No winner yet');
	}
}

console.log("Question 13)");
tictactoe([['X', 'X', 'X'],['O', 'O', 'O'],['X', 'O', 'X']]);
tictactoe([['X', 'X', 'X'],['X', 'X', 'X'],['X', 'O', 'X']]);
tictactoe([['X', 'O', 'X'],['O', 'X', 'O'],['X', 'O', 'X']]);
tictactoe([['', 'O', 'X'],['X', 'O', ''],['', 'O', 'X']]);
tictactoe([['X', '', 'X'],['O', '', ''],['', 'O', '']]);
