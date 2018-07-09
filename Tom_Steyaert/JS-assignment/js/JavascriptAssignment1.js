
//1
//Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.

function isLeapYear(year){
    if(year % 4 != 0){
        console.log("STOPPED HERE")
        console.log(year%4);
        return  false;
    } 
    else if (year % 100 != 0){
        return true;
    }
    else if(year % 400 != 0){
                return false;
            } else{
                return true;    
            }        
        }        


//2
//Create a function that checks for a valid email format.
//I recieved help from Kyle on how to use regular expressions for truth evaluation
function isValidEmail (email){
    let regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let isValid = regularExpression.test(email);
    return isValid;

}
removeCharFromString("Andrew",2);

//3
//Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

function removeCharFromString(inputString, index){

    let input = new String(inputString);
    let firstHalf = input.substring(0,index);
    let secondHalf = input.substring(index+1);

    input = firstHalf + secondHalf;
    return input;
}

//4
//Write a JavaScript function to check if a string "Script" is present in a given string.
//If "Script" is present in the string return the string without "Script" otherwise return the original one.
removeScript("ScriptJavaScriptScript");

function removeScript(str){


    let noScript = str.replace("Script","");

    while(noScript != noScript.replace("Script","")){
        noScript = noScript.replace("Script","");
    }

    return noScript;
}



function returnNextChars(str3){
let returnString = "";

    for(let i = 0 ; i < str3.length ; i++){
    let number = str3.charCodeAt(i);
    let nextChar = String.fromCharCode(number+1);
    returnString = returnString + nextChar;
}

return returnString;
}

//6
//Write a JavaScript function to count the number of vowels in a given string.
function countVowels(str6){

str6 = str6.toLowerCase();

let vowels = new Array('a','e','i','o','u');
let numberOfVowels = 0;

for(let i = 0; i < str6.length; i++){
    for(let j = 0; j < vowels.length; j++){
        if(str6.charAt(i) == vowels[j]){
            numberOfVowels++;
        }
    }
}
return numberOfVowels

}


//7
//Write a JavaScript function to reverse the elements of a given array.
function reverseElements(array7){    

    return array7.reverse();
}

//8
//Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes. 

function addArrays(arr1, arr2){
    let additionalLength = 0;
    let maxLength = arr2.length;

    if(arr1.length > arr2.length){
        maxLength = arr1.length;

        additonalLength = arr1.length-arr2.length;
        
        for(let i = 0; i <= additionalLength; i++){
            arr2.push(0); 
        }
    } 
    
    else if(arr2.length > arr1.length){
        additonalLength = arr2.length-arr1.length;
        for(let i = 0; i <= additionalLength; i++){
            arr1.push(0); 
        }
    }

let arr3 = new Array;

for(let i = 0; i < maxLength; i++){
    arr3.push(arr1[i]+arr2[i]);
}

return arr3;
}

//9
//Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
function longestString(stringArr){
let longestStringIndex = 0;
let str1Length = 0;
let str2Length = 0;

    for(let i = 1; i < stringArr.length; i++){
        str1Length = stringArr[i - 1].length;
        str2Length = stringArr[i].length;

        if(str2Length > stringArr[longestStringIndex].length){
            longestStringIndex = i;         
        }
    }
return longestStringIndex;
}


//10
//Write a JavaScript function which accepts three integers representing side lengths of a triangle.
//The function should validate that the integers make a geometrically accurate.
//If the three integers could not make a triangle, return undefined.
//Otherwise calculate and return the area of the triangle.
let area = getTriangleArea(5,5,5);
console.log(area);

function getTriangleArea(a, b, c){
    if(a, b, c > 0){

        //below we use Heron's formula
        let p =(a+b+c)/2;
        let getRoot = p*(p-a)*(p-b)*(p-c);
            
        if(getRoot <= 0){
                return null;
            }

        return Math.sqrt(getRoot);  
    } else {
        return null;
    }
}

//11
//Write a JavaScript function which accepts two arrays, representing the side lengths of polygons. 
//Return true if the polygons are similar, false if they are not.

function areSimilar(arr1, arr2){
let currentRatio = 0;
let previousRatio = arr1[0]/arr2[0];

if(arr1.length != arr2.length){
    return false;
}

for(let i = 1; i < arr2.length; i++){
currentRatio = arr1[i]/arr2[i];

if(previousRatio!=currentRatio){
    return false;
}
}
return true;
}

//12
//Check if two arrays have the same size and contents (including if content order is not the same).
//equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
//equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
//equivArr([4,2,8,4],[7,5,4,2,8]) = false

function sameArrays(arr1, arr2){
arr1.sort(function(a,b){
    return b - a;
})

if(arr1.length!=arr2.length){
    return false;
}

for(let i = 0; i < arr1.length; i++){
    if(arr1[i]!=arr2[i]){
        return false;
    }
}

return true;
}


//13
//tic tac toe
let sampleBoard = new Array;
let row1 = ['O','X','O'];
let row2 = ['X','O','X'];
let row3 = ['X','O','X'];
sampleBoard.push(row1);
sampleBoard.push(row2);
sampleBoard.push(row3);

ticTacToe(sampleBoard);


function ticTacToe(board){

//first we check to see of O's outnumber X's illegaly
let xCount = 0;
let oCount = 0;

for(let i = 0; i < 3; i++){
    for(let j = 0; j < 3; j++){
        if(board[i][j]=='O'){
        oCount++;
    }else if(board[i][j]=='X'){
        xCount++;
    }
    }    
}

let countDifference = Math.abs(xCount-oCount);

if(countDifference > 1){
    console.log("Invalid result");
    return;
}

//the board shows the places
//1 2 3
//4 5 6
//7 8 9
//on the board

let one = board[0][0];
let two = board[1][0] 
let three = board[2][0];

let four = board[0][1];
let five = board[1][1];
let six = board[2][1];

let seven = board[0][2];
let eight = board[1][2];
let nine = board[2][2];

let oWinCount = 0;
let xWinCount = 0;

//in the following eight sets of nested if statements
//we determine the winner of every possible combination
//of X's and O's the board can have
if(rowWinner(one,two,three)=='O'){
    oWinCount++;
} else if(rowWinner(one,two,three)=='X'){
    xWinCount++;
}

if(rowWinner(one,four,seven)=='O'){
    oWinCount++;
} else if(rowWinner(one,four,seven)=='X'){
    xWinCount++;
}

if(rowWinner(one,five,nine)=='O'){
    oWinCount++;
} else if(rowWinner(one,five,nine)=='X'){
    xWinCount++;
}

if(rowWinner(three,five,seven)=='O'){
    oWinCount++;

} else if(rowWinner(three,five,seven)=='X'){
    xWinCount++;
}

if(rowWinner(three,six,nine)=='O'){
    oWinCount++;
} else if(rowWinner(three,six,nine)=='X'){
    xWinCount++;
}

if(rowWinner(nine,eight,seven)=='O'){
    oWinCount++;

} else if(rowWinner(nine,eight,seven)=='X'){
    xWinCount++;
}

if(rowWinner(four,five,six)=='O'){
    oWinCount++;

} else if(rowWinner(four,five,six)=='X'){
    xWinCount++;
}

if(rowWinner(two,five,eight)=='O'){
    oWinCount++;
} else if(rowWinner(two,five,eight)=='X'){
    xWinCount++;
}



//finally we return the winner depending on the win counts, or three in a row counts for each letter
if(xWinCount > 1 && oWinCount > 1){    
    console.log("invalid result");
    return;

} else if(xWinCount==oWinCount){
    console.log("no winner yet");
    return;
} else if(xWinCount > oWinCount){
    console.log("X wins!");
    return;
} else if(oWinCount > xWinCount){
    console.log("0 wins!");
    console.log(oWinCount);
    console.log(xWinCount);
    return;
} else{
    console.log("Tie!!");
    return;
}



}

function rowWinner(a ,b, c){

if(a=='O'&b=='O'&c=='O'){
return 'O';

} else if(a=='X'&b=='X'&c=='X')
return 'X';

else {
    return null;
}
}


