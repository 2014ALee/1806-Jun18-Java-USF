/*
Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
*/

//year = window.prompt("Input a Year : ");


function leapyear(){
    //define variables
    var year;
    //get the entered year from text box 
    year = document.getElementById("enteryear").value;
    //three conditions to find out the leap year
    if( (0 == year % 4) && (0 != year % 100) || (0 == year % 400) )
    {
        document.getElementById("label").innerHTML = "<h4 style='color:green'>True</h4>"; 
    }
    else
    {
        document.getElementById("label").innerHTML = "<h4 style='color:red'>False</h4>"; 
    }
}

/*
    Create a function that checks for a valid email format.
*/

function validateEmail(){
    //define variables
    var email = document.getElementById("email");
    var mailformat = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(email.value ==0){
        document.getElementById("label").innerHTML ="<h4 style='color:black'>Please enter an email</h4>";
    }
    else if( mailformat.test(email.value))
    {
        document.getElementById("label").innerHTML ="<h4 style='color:green'>Valid Email</h4>"; 
        //alert("<h4 style='color:green'>Valid Email</h4>");
    }
    else
    {
        document.getElementById("label").innerHTML = "<h4 style='color:red'>Email NOT valid</h4>"; 
        //alert("<h4 style='color:red'>Email NOT valid</h4>");
    }
}

/*
    Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

*/

function trimString(){
    var mystring = document.getElementById("string").value;
    var newstring1 = mystring.substr(0, mystring.length -1);
    var newstring2 = newstring1.substr(1);
   document.getElementById("label").innerHTML = newstring2;
}

/*
    Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string 
    return the string without "Script" otherwise return the original one.

*/

function checkForString(){

    var str1 = document.getElementById("sentence").value;
    var str2 = document.getElementById("script").value;
    var n = str1.includes(str2);
    if(n){
         document.getElementById("foundScript").innerHTML = str2;
    	 document.getElementById("label").innerHTML = "<h3 style='color:green'>: exist</h3";
    }
    else{
        document.getElementById("foundScript").innerHTML = str2;
        document.getElementById("label").innerHTML = "<h3 style='color:red'>: does not exist</h3>";
    }

}

/*
    Write a JavaScript function to replace every character in a given string with the character following it in the alphabet.

*/

function switchToNextCharacter(){
    var str1 = document.getElementById("sentence").value;
    console.log(str1);
    var numArray = [];
    var strArray = [];
    for(var i = 0; i<= str1.length; i++){
        numArray.push(str1.charCodeAt(i)+1);
        strArray += String.fromCharCode(numArray[i]);
        console.log(strArray);
        document.getElementById("label").innerHTML = strArray;
    }
}

// for(var i=65;i<90;++i){
//     console.log(String.fromCharCode(i));
// } 

// console.log("-----------------------------")

// var x = 'abacdefghijklmabcd';

// for(var i = 0 ; i <= x.length; i++){
//     var y = [];
//     y = (x.charCodeAt(i)+1);
//     //console.log(y);
//     var my = [];
//     my = String.fromCharCode(y);

//     console.log(my);
// }

/*
     Write a JavaScript function to count the number of vowels in a given string.
*/

function countVowels(){
    var str1 = document.getElementById("sentence").value;
    var myVowels = /[aeiou]/gi;
    if(str1 == ' ' || !str1.match(/[aeiou]/gi)){
        document.getElementById("label").innerHTML = "<h4 style='color:red'>No vowels present</h4>";
    }else{
        var counter = str1.match(/[aeiou]/gi).length;
        document.getElementById("label").innerHTML = "Vowels count is: "+ counter;
    }
}

/*
    Write a JavaScript function to reverse the elements of a given array.
*/

function reverseArray(){
    var str1 = document.getElementById("sentence").value;
    console.log(str1);
    let str2 = '';
    for(var i = str1.length -1; i >=0; i--){
        console.log(str1[i]);
       str2 += str1[i];
    }
    document.getElementById("label").innerHTML = str2;
}

/*
    Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes. 
    addArr([1,2,3],[3,2,1]) = [4,4,4]
    addArr([1,2,3,4,5],[1,2,3]) = [2,4,6,4,5]

*/

function addValueToArray(){

    var fruit = ["apple", "banana", "orange"];
    var people = ["Lamine", "John", "bill"];
    var mix =  fruit.concat(people); 
    console.log(mix);
    document.write("Your mixed array is: " +mix);
    //document.write(mix);
}

/*
    Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.

*/
// First let find the longest word in the string

  function longestString(str)
{
  var longestWord = str.match(/\w[a-z]{0,}/gi);
  var result = longestWord[0];

  for(var i = 1 ; i < longestWord.length ; i++)
  {
    if(result.length < longestWord[i].length)
    {
    result = longestWord[i];
    } 
  }
  return result;
}

//lets find the index of the longest string in the array.

function longestStringIndex(){
    var mixObject = ["apple", "banana", "orange", "Lamine", "John", "bill"];
    //lets find the longest string
    var myLongestString = longestString(mixObject.toString());
    //lets fing the longest string index
    var strIndex = mixObject.indexOf(myLongestString);
    console.log(myLongestString);
    console.log(strIndex);

    //document.getElementById("labal2").innerHTML = myLongestString;
    document.getElementById("label").innerHTML ="Index " +strIndex;
}

/*
    Write a JavaScript function which accepts three integers representing side lengths of a triangle. The function should validate 
    that the integers make a geometrically accurate. If the three integers could not make a triangle, return undefined. Otherwise 
    calculate and return the area of the triangle.

*/

function myTriangle(a, b, c){
    if(a >0 && b>0 && c >0){
        var p = (a + b + c)/2
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }else{
        return undefined;
    }
}
console.log(myTriangle(10,23,31));

/*
    Write a JavaScript function which accepts two arrays, representing the side lengths of polygons. 
    Return true if the polygons are similar, false if they are not.

*/



/*
    Check if two arrays have the same size and contents (including if content order is not the same).
    equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
    equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
    equivArr([4,2,8,4],[7,5,4,2,8]) = false

*/

function checkArray(input1, input2){
    myArray1 = [];
    myArray2 = [];
    myArray1 = input1;
    myArray2 = input2;

    if(myArray1.length != myArray2.length){
        return false;
    }else{
        myArray1.sort(function(a, b){return a - b});
        myArray2.sort(function(a, b){return a - b});
        for(var i = 0; i < myArray1.length; i++){
            if(myArray1[i] != myArray2[i]){
                return false;
            }
            else{
                return true;
            }
        }
    }
}

console.log(checkArray([4,2,8,4,7,23], [23,7,4,4,2,8]));

/*
    Create a function which takes a 3x3 2D array. Validate that each array index holds only a value of “X”, “O”, or be empty. Have the function evaluate a game of tic tac toe represented by the 2D array.  Should have a result for a tie, each winner, or an invalid game.

    tictactoe([[“X”, “X”, “X”],[“O”, “O”, “O”],[“X”, “O”, “X”]]) 
prints “Invalid result”
tictactoe([[“X”, “X”, “X”],[“X”, “X”, “X”],[“X”, “O”, “X”]]) 
prints “Invalid result” 
    tictactoe([[“X”, “O”, “X”],[“O”, “X”, “O”],[“X”, “O”, “X”]]) 
Prints “X is the winner”
tictactoe([[empty, “O”, “X”],[“X”, “O”, empty],[empty, “O”, “X”]]) 
Prints “O is the winner”
        tictactoe([[“X”, empty, “X”],[“O”, empty, empty],[empty, “O”, empty]]) 
Prints “No winner yet”

*/

// Colaborate with Derek

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
    ['0', 'x', 'O'],
    ['X', 'x', 'X'],
    ['X', 'X', 'O']
];
console.log(tictactoe(gameBoard));


