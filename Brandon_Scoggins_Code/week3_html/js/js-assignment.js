/* 1. Leap Year */

document.getElementById('checkIsLeapYear').addEventListener('click', checkLeapYear);

function leapYear(year){
    if (year % 4 == 0){
        return true;
    } else if (year % 4 != 0) {
        return false;
    }    
}

function checkLeapYear () {
    let year = document.getElementById('leapYearInput').value;
    let display = document.getElementById('leapYearDisplay');

    if (year == ''){
        display.innerText = "Waiting for input...";
    } else if (leapYear(year)){
        display.innerText = "That's a leap year!";
    } else {
        display.innerText = "That's not a leap year.";
    }
}

/* 2. Email Validation */ 

// Found regex on StackOverflow
// https://stackoverflow.com/questions/46155/how-to-validate-an-email-address-in-javascript
function isEmail(email){
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);

}

document.getElementById('checkIsValidEmail').addEventListener('click', checkValidEmail);

function checkValidEmail () {
    let email = document.getElementById('emailInput').value;
    let display = document.getElementById('validEmailDisplay');

    if (!isEmail(email)){
        display.innerText = "That's not a valid email...";
    } else {
        display.innerText = "That email is valid!";
    }
}

/* 3. Remove Character */

function removeChar(string, position){

    return (string.substring(0, position - 1).concat(string.substring(position, string.length)));
}
  
function removeIndexFromString() {
    let string = document.getElementById('stringInput').value;
    let index = document.getElementById('position').value;
    
    let display = document.getElementById('newStringDisplay');

    if(string.length < index || index <= 0){
        display.innerText = "That index is out of bounds...";
    } else {
        display.innerText = removeChar(string, index);
    }
}

document.getElementById('removeCharacter').addEventListener('click', removeIndexFromString);

/* 4. Remove "Script" */

function removeScript(string){

    return string.replace('Script', '');
}
  
function checkForScript() {
    let string = document.getElementById('scriptInput').value;
    let display = document.getElementById('scriptDisplay');

    if(!string.includes('Script')){
        display.innerText = "That string does not contain 'Script'...";
    } else {
        display.innerText = removeScript(string);
    }
}

document.getElementById('checkForScript').addEventListener('click', checkForScript);

/* 5. Letter Shift */

function letterShift(string){
    let shiftedString = '';
    for(i = 0; i < string.length; i++){
        shiftedString += (String.fromCharCode(string.charCodeAt(i) + 1));
    }
    return shiftedString;
}
  
function shiftAlphabet() {
    let string = document.getElementById('stringAlphabetInput').value;
    let display = document.getElementById('shiftAlphabetDisplay');

    if(string.length == 0){
        display.innerText = "Waiting for input...";
    } else {
        display.innerText = letterShift(string);
    }
}

document.getElementById('shiftAlphabet').addEventListener('click', shiftAlphabet);

/* 6. Vowel Count */

function vowelCount(string){

//    let newString = '';
    let numOfVowels = 0;

    for(i = 0; i < string.length; i++){
        if(string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u' || string.charAt(i) == 'y' 
            || string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U' || string.charAt(i) == 'Y'){
                numOfVowels++;
//        } else {
//            newString += string.charAt(i);
        }
    }
    return numOfVowels;
}
  
function countVowels() {
    let string = document.getElementById('vowelCountingInput').value;
    let display = document.getElementById('vowelCountDisplay');

    if(string.length == 0){
        display.innerText = "Waiting for input...";
    } else {
        display.innerText = vowelCount(string);
    }
}

document.getElementById('countVowels').addEventListener('click', countVowels);

/* 7. Reverse Array */

function reverseArr(array){

     let newArray = [];

    for(i = array.length; i >= 0 ; i--){
        newArray.push(array.pop());
    }
    return newArray;
}
  
function reverseArray() {
    let display = document.getElementById('reversedArrayDisplay');

    display.innerText = reverseArr(originalArray);
}

    let originalArray = ["bananas", "hot pockets", "yogurt", 3, 2, 1];
document.getElementById('originalArray').innerText = originalArray;
document.getElementById('reverseArray').addEventListener('click', reverseArray);

/* 8. Add Array */

function addArr(array, array){

    let summedArray = [];
    
    for(i = 0; i < firstArray.length || i < secondArray.length; i++){
        if (firstArray.length > i && secondArray.length > i){
            summedArray.push(secondArray[i] + firstArray[i]);
        } else if (firstArray.length > i) {
            summedArray.push(firstArray[i]);
        } else {
            summedArray.push(secondArray[i]);
        }
    }

    return summedArray;
}
  
function addArrays() {
    let display = document.getElementById('summedArrayDisplay');

    display.innerText = addArr(firstArray, secondArray);
}

let firstArray = [3, 2, 1];
let secondArray = [1, 2, 3, 2, 1];
document.getElementById('firstArray').innerText = firstArray;
document.getElementById('secondArray').innerText = secondArray;
document.getElementById('addArrays').addEventListener('click', addArrays);

/* 9. Longest String */

function longestStr(array){

    let longestString = "";
    let longestStringArray = [];

   for(i = 0; i < array.length; i++){
       if (array[i].length > longestString.length) {
           longestStringArray = [" " + array[i] + " at index: " + i];
           longestString = array[i];
       } else if (array[i].length == longestString.length) {
           longestStringArray.push(" " + array[i] + " at index: " + i);
       }
   }
   return longestStringArray;
}
  
function findLongestString() {
    let display = document.getElementById('longestStringDisplay');

    display.innerText = longestStr(stringArray);
}

    let stringArray = ["bananas", "hot pockets", "yogurt", "tupac", "muse", "1", "elevenchars"];
document.getElementById('stringArray').innerText = stringArray;
document.getElementById('findLongestStringArray').addEventListener('click', findLongestString);

/* 10. Area of a Triangle */

function area(side1, side2, side3){

    let p = ((+side1 + +side2 + +side3) / 2);
    return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
}
  
function findTriangleArea() {
    let side1 = document.getElementById('side1').value;
    let side2 = document.getElementById('side2').value;
    let side3 = document.getElementById('side3').value;
    
    let display = document.getElementById('areaDisplay');

    if (side1 < 0 || side2 < 0 || side3 < 0){
        display.innerText = "Can't have a negative side length";
    } else if (side1 == 0 || side2 == 0 || side3 == 0) {
        display.innerText = "Can't have a side length of '0'";
    } else if(side1 + side2 > side3 && side2 + side3 > side1 && side3 + side1 > side2){
        display.innerText = area(side1, side2, side3);
    } else {
        display.innerText = "Those lengths can't make a triangle.";
    }
}

document.getElementById('findArea').addEventListener('click', findTriangleArea);

/* 11. Similar Polygons */

function areSimilar(firstPolygonArray, secondPolygonArray){

    if (firstPolygonArray.length != secondPolygonArray.length) {
        return "Both arrays must have the same number of sides."
    }

    for (i = 0; i < firstPolygonArray.length; i++) {
        if (firstPolygonArray[i] == 0) {
            return "Can not have a side length of '0'.";
        }

        let sumOfOtherSides = 0;
        for (j = 0; j < firstPolygonArray.length; j++) {
            if (j != i) {
                sumOfOtherSides += firstPolygonArray[j];
            }
        }
        if (sumOfOtherSides < firstPolygonArray[i]) {
            return "The first set of lengths does not make a polygon.";
        }
    }

    for (i = 0; i < secondPolygonArray.length; i++) {
        if (secondPolygonArray[i] == 0) {
            return "Can not have a side length of '0'.";
        }
        
        let sumOfOtherSides = 0;
        for (j = 0; j < secondPolygonArray.length; j++) {
            if (j != i) {
                sumOfOtherSides += secondPolygonArray[j];
            }
        }
        if (sumOfOtherSides < secondPolygonArray[i]) {
            return "The second set of lengths does not make a polygon.";
        }
    }

    let scaleFactor = 0;

    for (i = 0; i < secondPolygonArray.length; i++) {
        scaleFactor = secondPolygonArray[i] / firstPolygonArray[0];
        
        let scaledFirstArray = [];

        for (j = 0; j < firstPolygonArray.length; j++) {
            scaledFirstArray.push(firstPolygonArray[j] * scaleFactor);
        }

        for (k = 0; k < secondPolygonArray.length; k++) {
            for (j = 0; j < scaledFirstArray.length; j++) {
                if (secondPolygonArray[k] == scaledFirstArray[j]) {
                    scaledFirstArray.splice(j, 1);
                    break;
                }
            }
        }

        if (scaledFirstArray.length == 0) {
            return "These polygons can be similar with a scale factor of " + scaleFactor + "!";
        }
    }

    return "These polygons are not similar.";
}
  
function checkSimilarPolygons() {
    let display = document.getElementById('polygonAnswerDisplay');

    display.innerText = areSimilar(firstPolygonArray, secondPolygonArray);
}

let firstPolygonArray = [1, 2, 3, 2, 7];
let secondPolygonArray = [21, 3, 6, 6, 9];
document.getElementById('firstPolygonArray').innerText = firstPolygonArray;
document.getElementById('secondPolygonArray').innerText = secondPolygonArray;
document.getElementById('checkSimilarPolygons').addEventListener('click', checkSimilarPolygons);

/* 12. Equivalent Arrays */

function equvArr(firstArrayContents, secondArrayContents){

    if (firstArrayContents.length != secondArrayContents.length) {
        return "Both arrays must have the same number of elements.";
    }

    for (i = 0; i < firstArrayContents.length; i++) {
        for (j = 0; j < secondArrayContents.length; j++) {
            if (firstArrayContents[i] == secondArrayContents[j]) {
                secondArrayContents.splice(j, 1);
            }
        }
    }
    
    if (secondArrayContents.length == 0) {
        return "The array contents are the same!";
    } else {
        return "The array contents are not the same.";
    }
}
  
function checkArrayContents() {
    let display = document.getElementById('arrayContentsDisplay');

    display.innerText = equvArr(firstArrayContents, secondArrayContents);
}

let firstArrayContents = [1, 2, 3, 2, 7];
let secondArrayContents = [2, 1, 2, 3, 7];
document.getElementById('firstArrayContents').innerText = firstArrayContents;
document.getElementById('secondArrayContents').innerText = secondArrayContents;
document.getElementById('checkArrayContents').addEventListener('click', checkArrayContents);

/* 13. Tic Tac Toe */

function tictactoe(gameBoard){

    let winner = [];
    let X = 0;
    let O = 0;
    let XTotal = 0;
    let OTotal = 0;

    for (i = 0; i < gameBoard.length; i++) {
        X = 0;
        O = 0;
        for (j = 0; j < gameBoard[i].length; j++) {
            if (gameBoard[i][j] == "X"){
                X++;
                XTotal++;
            } else if (gameBoard[i][j] == "O") {
                O++;
                OTotal++;
            }
        }
        if (X == 3){
            winner.push("X");
        } else if(O == 3){
            winner.push("O");
        }
    }

    for (i = 0; i < gameBoard.length; i++) {
        X = 0;
        O = 0;
        for (j = 0; j < gameBoard[i].length; j++) {
            if (gameBoard[j][i] == "X"){
                X++;
            } else if (gameBoard[j][i] == "O") {
                O++;
            }
        }
        if (X == 3){
            winner.push("X");
        } else if(O == 3){
            winner.push("O");
        }
    }

    if ((gameBoard[0][0] == gameBoard[1][1] && gameBoard[2][2] == gameBoard[1][1]) && (gameBoard[0][0] == "X" || gameBoard[0][0] == "O")){
        winner.push(gameBoard[1][1]);
    }

    if ((gameBoard[0][2] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[1][1]) && (gameBoard[0][2] == "X" || gameBoard[0][2] == "O")){
        winner.push(gameBoard[1][1]);
    }

    if (winner.length > 2){
        return "Invalid game.";
    } else if (Math.abs(XTotal - OTotal) > 1){
        return "Invalid game. One player has too many plays."
    }else if (winner.length == 1){
        return winner[0] + " is the winner!";
    } else if (winner.length == 2){
        if (winner[0] == winner[1]){
            return winner[0] + " is the winner!";
        } else{
            return "Invalid game.";
        }
    } else {
        if ((XTotal + OTotal) == 9){
            return "There is no winner.";
        } else {
            return "Incomplete game.";
        }
    }
}

function evaluateBoard() {

    let display = document.getElementById('winnerDisplay');

    display.innerText = tictactoe(gameBoard);
}

function displayFirstRow () {
    for (i = 0; i < gameBoard.length; i++){
        if (gameBoard[0][i] != "X" && gameBoard[0][i] != "O"){
            gameBoard[0].splice(i, 1, "_");
        }
    }
    return gameBoard[0];
}

function displaySecondRow () {
    for (i = 0; i < gameBoard.length; i++){
        if (gameBoard[1][i] != "X" && gameBoard[1][i] != "O"){
            gameBoard[1].splice(i, 1, "_");
        }
    }
    return gameBoard[1];
}

function displayThirdRow () {
    for (i = 0; i < gameBoard.length; i++){
        if (gameBoard[2][i] != "X" && gameBoard[2][i] != "O"){
            gameBoard[2].splice(i, 1, "_");
        }
    }
    return gameBoard[2];
}

let gameBoard = [["X","O","X"],["O","X",],["X","O","X"]];

document.getElementById('firstRow').innerText = displayFirstRow();
document.getElementById('secondRow').innerText = displaySecondRow();
document.getElementById('thirdRow').innerText = displayThirdRow();
document.getElementById('evaluateBoard').addEventListener('click', evaluateBoard);
