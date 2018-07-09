// Basic Java assignment
// John Beineke

/*                               1. Leap Year */
// Create a JavaScript function that takes a date parameter and 
// returns true if the year is a leap year in the Gregorian calendar.

function leapYear(dateInput){
        let year = dateInput.getFullYear();
        if ((year % 4 === 0) && (year % 100 === 0) && (year % 400 === 0) ){
           return console.log(dateInput + ' is a leap year!');
        }else{
           return console.log(dateInput + ' is not a leap year.');
        }   
    }

/*                          2. Email Validation */ 
// Create a function that checks for a valid email format.
let string = "hello@gmail.com"
function isEmail(string){
    // regex from w3 schools for email format.
    // .test tests to see if our string matches our format
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string))
  {
    return (true)
  }
    console.log("You have entered an invalid email address!")
    return (false)   
}

console.log(isEmail(string));


/* 3. Remove Character 
    Write a JavaScript function to remove a character at the specified position of a 
    given string and return the new string.
*/
let str = "hello";
let position = 3;
function removeChar(string, position){
    console.log(str.charAt([position]));
}
removeChar(str, position);


/*                                   4. Remove "Script" 
Write a JavaScript function to check if a string "Script" is present
in a given string. If "Script" is present in the string return the string without "Script"
otherwise return the original one.
  */
let s = "helloscripthithere";
let script = 'script';
function removeScript(string){
    if(string.includes(script)){
    let h = string.replace(script, '');
    console.log(h);
    }else{
        console.log(string);
    }

}
removeScript(s);


/* 5. Letter Shift 
    Write a JavaScript function to replace every character 
    in a given string with the character following it in the alphabet.
*/
let shift = 'abcd';
function letterShift(string){
    for(i = 0; i < string.length; i++){
        let u = string.charCodeAt(i);
        u++;
        var shifted = '' + String.fromCharCode(u);
        console.log(shifted);
    }
}

letterShift(shift);


/* 6. Vowel Count
    Write a JavaScript function to count the number of vowels in a given string.
*/
let vowelString = "My name Is jOhn";
function vowelCount(vowelString){
    let vowelList = 'aeiouAEIOU';
    let count = 0;
    // Based off of solution from w3resorces
    // vowel list uses indexOf at index i of vowelString, if the letter at position i
    // of vowelString is a vowel, it will increment count. indexOf returns -1 if there is no match
    for(let i = 0; i < vowelString.length; i++){
        if(vowelList.indexOf(vowelString[i]) !== -1){
            count++;
        }
    }
    console.log(count);
}
vowelCount(vowelString);


/* 7. Reverse Array
    Write a JavaScript function to reverse the elements of a given array.
*/
let forwardString = ['what', 'is', 'up'];
function reverseArr(array){
    let reversedString = forwardString.reverse();
    console.log(reversedString);
}
reverseArr(forwardString);


/* 8. Add Array
    Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes.
*/
let arr1 = [1,2,3];
let arr2 = [4,5,6,7];
let maxLength = Math.max(arr1.length, arr2.length);
function addArr(array1, array2){
    let arr3 = [];
    let val = 0;
    for (let i = 0; i < maxLength; i++){
        val = array1[i] + array2[i];
        arr3 += val;
    }
    console.log(arr3);
}

addArr(arr1, arr2);

/* 9. Longest String
    Write a JavaScript to find the longest string from an given array
     of strings and returns the string’s array index.
*/
let stringArr = ['hello', 'hi', 'mynameisjohn', 'yo'];
function longestStr(array){
    let maxString;
    let length = 0;

    for(let i = 0; i < array.length; i++){
        if (array[i].length > length){
            length = array[i].length;
            maxString = array[i];
        }
    }
    console.log(array.indexOf(maxString));
}

longestStr(stringArr);

/* 10. Area of a Triangle */
// Write a JavaScript function which accepts three integers representing side
// lengths of a triangle. The function should validate that the integers make a
// geometrically accurate. If the three integers could not make a triangle,
// return undefined. Otherwise calculate and return the area of the triangle.

// Using Christian's solution
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

console.log(area(3,3,3));
console.log(area(3,3,4));
console.log(area(3,4,5));


/* 11. Similar Polygons 
    Write a JavaScript function which accepts two arrays, representing the side
    lengths of polygons. Return true if the polygons are similar, false if they are not.
*/
// Using Christian's solution from Friday!
function areSimilar(array, array){
    function areSimilar(array1, array2){
        if(array1.length != array2.length) {
            return false;
        }
        let len  = array1.length;
        let ratio = array1[0]/array2[0];
        for(let i = 0; i < len; i++) {
            if(array1[i] != (array2[i]*ratio)) {
                return false;
            } else if(Math.atan(array1[i]/array1[(i+1)%len]) != Math.atan(array2[i]/array2[(i+1)%len])) {
                return false;
            }
        }
        return true;
    }

}


/* 12. Equivalent Arrays 
    Check if two arrays have the same size and contents (including if content order is not the same).
*/
arr1 = [4,2,8,4,11];
arr2 = [7,4,4,2,8];
function equivArr(array1, array2){
        array1.sort();
        array2.sort();
        if(array1.length == array2.length){
            for(let i = 0; i < arr2.length; i++){
                if(array1[i] === array2[i]){
                    continue;
                }else if(array1[i] !== array2[i]){
                    console.log('The two arrays are not the same.');
                    break;
                }
                console.log('The two arrays are the same.')
            }
        
    }else{
        console.log('The arrays are not equivalent.')
    }
}
equivArr(arr1, arr2);
