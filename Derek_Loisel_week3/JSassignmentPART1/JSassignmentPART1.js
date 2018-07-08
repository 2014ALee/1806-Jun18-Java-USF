
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
        //doesnt matter which is set to which if they're same size
        biggerArr = array1;
        smallerArr = array2;
    }
    for(var i = 0; i < smallerArr.length; i++){
            //looping through the length of the small array, add the elements together and push to the new array
            newArr.push(biggerArr[i] + smallerArr[i]);
    }
    //start looping after the length of the smaller array to add on the rest of the bigger array
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
    let numArray = [];
    for( var i = 0;i < myStrArray.length; i++) {
        //add the lengths of the strings to an array
        numArray.push(myStrArray[i].length);
    }
    //set the greatest length by finding the highest value in the array
    let maxStringLength = Math.max.apply(null, numArray); 
    for(var i = 0; i < numArray.length; i++){
        //find the index of the string that matches the max length
        if (maxStringLength == numArray[i]){
            //return the index of the string with the most characters
            return i;
        }        
    }
}
let myStrArray = ['hi','hello', 'hey', 'yo'];
console.log(longestStr(myStrArray));

/* 10. Area of a Triangle */
//If you take the 3 sides of a triangle and add them in pairs, 
//the sum should greater than the third side in all 3 cases in order to construct a triangle. 
//Can use Heron's formula to calculate the area of a triangle without knowing the height
//Heron's formula states that the area of a triangle whose sides have lengths a, b, and c is:
//A = sqrt{s(s-a)(s-b)(s-c)},
//where s is the semiperimeter of the triangle; that is,
//s=(a+b+c)/2
let result;
function area(number1, number2, number3){
    //leave result undefined if the 3 numbers can't form a triangle
    if(number1+number2 <= number3){
    }else if(number1+number3 <= number2){
    }else if(number2+number3 <= number1){
    }
    //set result equal to the area of the triangle
    else{
        let s = (number1 + number2 + number3)/2;
        let a = Math.sqrt(s*(s-number1)*(s-number2)*(s-number3));
        result = a;
    }  
    //return result as undefined or as the area of the triangle
    return result;
}
let numb1 = 10;
let numb2 = 6;
let numb3 = 7;
console.log(area(numb1, numb2, numb3));

/* 11. Similar Polygons */
//HELPED BY CHRISTAIN
//corresponding angles need to be the same
//corresponding sides need to be proportionately the same
function areSimilar(array1, array2){
    //get the ratio of one of the sides
    let ratio = array1[0]/array2[0]
    for(let i = 0; i < array1.length; i++){
        //check that the side length ratio is maintained throughout the rest of the sides
        if(array1[i] !== (array2[i]*ratio)){
            return false;
        }
        //check that all the angles are the same
        if(Math.atan(array1[i]/array1[(i+1)%length]) != Math.atan(array2[i]/array2[(i+1)%length])){
            return false;
        }
    }
    return true;
}

/* 12. Equivalent Arrays */

function equivArr(array1, array2){
    //return false if the arrays are not the same length
    if(array1.length !== array2.length)
    {
        return false;
    }
    //sort the arrays so the values will be at corresponding indexes if both arrays hold equal values
    let ar1 = array1.sort((a,b) => {return a-b});
    let ar2 = array2.sort((a,b) => {return a-b});
    console.log(ar1);
    //loop through the length of the arrays to see if each index is equal, return false if one isn't
    for (let i = 0; i < ar1.length; i++){
        if (ar1[i] !== ar2[i]){
            return false;
        }
    }
    //return true if all the elements were equal
    return true;
}
let arr11 = [1,100,12,10];
let arr22 = [3,3,9,1];
console.log(equivArr(arr11,arr22));

/* 13. Tic Tac Toe */

function tictactoe(array){
    let invalidResult = 'Invalid result';
    let xResult = '';
    let oResult = '';    
    let xCount = 0;
    let oCount = 0;
    let blankExists = false;
    for (let i = 0; i < array.length; i++){
        //count the amount of X's, O's, and blanks
        //X count
        if(array[i][0] == 'X'){
            xCount += 1;
        }
        if(array[i][1] == 'X'){
            xCount += 1;
        }
        if(array[i][2] == 'X'){
            xCount += 1;
        }
        //O count
        if (array[i][0] == 'O'){
            oCount += 1;
        }
        if(array[i][1] == 'O'){
            oCount += 1;
        }         
        if(array[i][2] == 'O'){
            oCount += 1;
        }
        //blanks
        if(array[i][0] == '' || array[i][1] == '' || array[i][2] == ''){
            blankExists = true;
        }                        
        //check that all input is either an X or an O or a blank string, return 'invalid result' if it isn't.
        if(array[i][0] != 'X' && array[i][0] != 'O' && array[i][0] != ''){           
            return invalidResult;
        }
        if(array[i][1] != 'X' && array[i][1] != 'O' && array[i][1] != ''){
            return invalidResult;
        }
        if(array[i][2] != 'X' && array[i][2] != 'O' && array[i][2] != ''){
            return invalidResult;
        }
    }
    //return invalid result if the xCount and oCount are not within 1 of each other
    if(xCount != oCount && xCount != oCount+1 && xCount != oCount-1){
        return invalidResult;
    }
    //check for each possible way to win
    //cross winners
    if ((array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X') || (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X')){
        xResult = 'X is the winner';
    }
    else if((array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O') || (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O')){
        oResult = 'O is the winner';
    }
    //column winner
    else if((array[0][0] == 'X' && array[1][0] == 'X' && array[2][0] == 'X') || (array[0][1] == 'X' && array[1][1] == 'X' && array[2][1] == 'X') || (array[0][2] == 'X' && array[1][2] == 'X' && array[2][2] == 'X')){
        xResult = 'X is the winner';
    }
    else if((array[0][0] == 'O' && array[1][0] == 'O' && array[2][0] == 'O') || (array[0][1] == 'O' && array[1][1] == 'O' && array[2][1] == 'O') || (array[0][2] == 'O' && array[1][2] == 'O' && array[2][2] == 'O')){
        oResult = 'O is the winner';
    }
    //row winner
    else if((array[0][0] == 'X' && array[0][1] == 'X' && array[0][2] == 'X') || (array[1][0] == 'X' && array[1][1] == 'X' && array[1][2] == 'X') || (array[2][0] == 'X' && array[2][1] == 'X' && array[2][2] == 'X')){
        xResult = 'X is the winner';
    }
    else if((array[0][0] == 'O' && array[0][1] == 'O' && array[0][2] == 'O') || (array[1][0] == 'O' && array[1][1] == 'O' && array[1][2] == 'O') || (array[2][0] == 'O' && array[2][1] == 'O' && array[2][2] == 'O')){
        oResult = 'O is the winner';
    }
    //make sure either X or O won, not both
    if(xResult !== ''){
        if(oResult !== ''){
            //return invalid result if both X and O were winners in the same game
            return invalidResult;
        }
    }
    //make sure the game is over
    if(blankExists == true){
        let blankResult = 'No winner yet';
        return blankResult;
    }
    //return the winner or tie
    if(xResult !== ''){
        return xResult;
    }else if(oResult !== ''){
        return oResult;
    }else{
        let tieResult = 'The game was a tie';
        return tieResult;
    }
}
var gameBoard = [
    ['X', 'O', 'O'],
    ['X', 'O', 'X'],
    ['X', 'X', 'O']
];
console.log(tictactoe(gameBoard));