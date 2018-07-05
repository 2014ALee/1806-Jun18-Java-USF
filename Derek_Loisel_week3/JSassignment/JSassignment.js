
/* 1. Leap Year */

function leapYear(year){   
    //for the function to be a leap year, it must either be divisible by 400, or not divisible by 4 and not divisible by 100.
    let leap = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    return leap;  
};
let year = 2016;
console.log("Leap year: " + leapYear(year));

/* 2. Email Validation */ 

let myEmail = 'dj+fghj@yahoo.com';
function isEmail(myEmail){
    //test the email using a regular expression
    let regularExpression = /^([a-zA-Z0-9_\.\-+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regularExpression.test(myEmail);
};
console.log("Valid email: " + isEmail(myEmail));

/* 3. Remove Character */

function removeChar(string, position){
//divide the string into 2 halves around the position of the char you want to remove
let firstHalf = string.substring(0, position);
let secondHalf = string.substring(position + 1, string.length);
//add the halves back together
let newString = firstHalf + secondHalf;
return newString;
}
let myString = 'whatsup bbud'
let myPosition = 8;
console.log(removeChar(myString, myPosition));
       
/* 4. Remove "Script" */

function removeScript(str){
    let subStr = "Script";
    //Check if the passed string contains script, return it if it doesnt
    if (!str.includes(subStr)){
        return str;
    }
    //get the index of Script in the string
    let index = str.indexOf(subStr);
    //split the string around the word Script and add it back together
    let firstHalf = str.substring(0, index);
    let secondHalf = str.substring(index + 6, str.length);
    let newString = firstHalf + secondHalf;
    return newString;
}
let yourString = 'SomethingScriptCool';
console.log(removeScript(yourString));


/* 5. Letter Shift */

function letterShift(string){
    let strArr = [];
    let newString = "";
    //turn each character into a unicode character, add 1 to it, then change it back to a letter in the new string
    for (var i = 0; i < string.length; i++){        
        strArr.push(string.charCodeAt(i) + 1);
        if(string.charCodeAt(i) == 122 || string.charCodeAt(i) == 90 ){
            newString += 'z'; // don't change the letter if its z because its the last letter
        }else{
            newString += String.fromCharCode(strArr[i]);
        }
    }
    return newString;
}
let stringy = 'starcraft'
console.log(letterShift(stringy));

/* 6. Vowel Count */

function vowelCount(string){  
    //create an array for each vowel that holds the amount of times that vowel was in the string
    aArray = string.match(/a/g);
    eArray = string.match(/e/g);
    iArray = string.match(/i/g);
    oArray = string.match(/o/g);
    uArray = string.match(/u/g);
    //create an array to hold all the vowel arrays
    let allArrays = [aArray, eArray, iArray, oArray, uArray];
    let vowelCount = 0;
    for (var i = 0; i < allArrays.length; i++){
        //check if each vowel array isnt null and add the length of each to the vowel counter
        if (allArrays[i]){
        vowelCount += allArrays[i].length ;
        }
    }  
    return vowelCount;
}
let searchMeForVowels = 'JavaScript';
console.log(vowelCount(searchMeForVowels));

/* 7. Reverse Array */

function reverseArr(array){
    let newArr = [];
    //loop backwards through the array and add each elemnt to a new array
    for (var i = array.length-1; i >= 0; i--){
        newArr.push(array[i]);
    }
    return newArr;
}
    let arr = [1,2,3];
    console.log(reverseArr(arr));

/* 8. Add Array */

function addArr(array1, array2){
    let biggerArr;
    let smallerArr;
    let newArr = [];
    //find which is the bigger array
    if (array1.length > array2.length){
        biggerArr = array1;
        smallerArr = array2;
    }else if (array1.length < array2.length){
        biggerArr = array2;
        smallerArr = array1;
    }else{
        //doesnt matter which is set to which
        biggerArr = array1;
        smallerArr = array2;
    }
   console.log(smallerArr[3]);
    for(var i = 0; i < smallerArr.length; i++){
            //add the elements together and push to the new array
            newArr.push(biggerArr[i] + smallerArr[i]);
    }
    //start looping after the length of the smaller array and add the rest of the bigger array
    for(var i = smallerArr.length; i<biggerArr.length; i++){
        newArr.push(biggerArr[i]);
    }
    return newArr;
}
let arr1 = [2,6,4]
let arr2 = [1,5,4,3]
console.log(addArr(arr1,arr2));

/* 9. Longest String */

function longestStr(array){

}

/* 10. Area of a Triangle */

function area(number, number, number){

}

/* 11. Similar Polygons */

function areSimilar(array, array){

}

/* 12. Equivalent Arrays */

function equvArr(array, array){

}

/* 13. Tic Tac Toe */

function tictactoe(array){

}
