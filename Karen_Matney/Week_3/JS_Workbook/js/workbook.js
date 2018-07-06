/* 1. Leap Year */
function leapYear(date){
    let year = date.getFullYear();
    console.log(year);
    if (year % 4 != 0) {
        return false;
    }
    else if (year % 100 != 0) {
        return true;
    }
    else if (year % 400 != 0) {
        return false;
    }
    else {
        return true;
    }
}

/* 2. Email Validation */ 

function isEmail(string){
    // Get add in the missing characters/restrictions 
    let re = new RegExp('^[\\w][\\w-_\\.]*@[a-z\\d]+\\.[a-z]+$');
    let matching = string.match(re)
    if (matching == null) {
        return false;
    } else {
        return true;
    }
}

/* 3. Remove Character */
function removeChar(string, position){
    let newString = string.substring(0,position) + string.substring(position+1);
    return newString;
}
        
/* 4. Remove "Script" */

function removeScript(string){
   return string.replace('Script','');
}

/* 5. Letter Shift */

function letterShift(string){
    let charCode;
    let shift = '';

    for(let i = 0; i < string.length; i++) {
        charCode = string.charCodeAt(i);
        charCode++;
        shift = shift.concat(String.fromCharCode(charCode));
    }

    return shift;
}

/* 6. Vowel Count */

function vowelCount(string){
    let vowels = 0;
    let re = new RegExp('[aeiouyAEIOUY]');

    for (let chara of string) {
        if(chara.match(re) != null) {
            vowels++;
        }
    }

    return vowels;
}

/* 7. Reverse Array */

function reverseArr(array){
    return array.reverse();
}

/* 8. Add Array */

function addArr(array1, array2){
    let minLength = Math.min([array1.length,array2.length]);
    let array = [];
    for(let i = 0; i < minLength; i++) {
        array.add(array1[i] + array2[i]);
    }
}

/* 9. Longest String */

function longestStr(array){

}

/* 10. Area of a Triangle */

function area(number, number, number){

}

/* 11. Similar Polygons */
// Christan soved this problem
function areSimilar(array, array){
/*
Math.atan(array1[i]/array1[(i+1)%length])
if(array1.length != array2.length) {
    return false;
}

let len = array1.length;
if(array1.length === array2.length) {
    array1.sort();
    array2.sort();
    for(let i = 0; i < array1.length; i++) {
        if(array1[i] !== array2[i]) {
            return false;
        } else if(Math.atan(array1[i]/array1[(i+1)%len])!=Math.atan(array2[i]/array2[(i+1)%len]))) {
            return false;
        }
        return true;
    }
    return false;
}
*/
}

/* 12. Equivalent Arrays */

function equvArr(array, array){

}

/* 13. Tic Tac Toe */

function tictactoe(array){

}