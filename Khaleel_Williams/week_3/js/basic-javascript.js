/*
   1.   Create a JavaScript function that takes a date parameter 
        and returns true if the year is a leap year in the Gregorian calendar.
*/
let year = 2012;
function isLeapYear(year) {
    if ((year % 4) != 0){
        return false;
    } else if ((year % 100) != 0){
        return true;
    } else if ((year % 400) == 0){
        return true;
    } else {return false;}
    
}

/*
    2. Create a function that checks for a valid email format.
*/
let email = "john@gmail.com";
function checkEmailForm(email){
    
    
    return (email);
}


/*
    3.  Write a JavaScript function to remove a character at the specified position
        of a given string and return the new string
*/

let str = "khaleel";
function removeCharacter(str, position){

    let gotChar = str.charAt(position);
    let newStr = str.replace(gotChar,'')

    return newStr; 
}
//console.log(removeCharacter(str, 0));


/*
    4.  Write a JavaScript function to check if a string "Script" is present in a given string. 
        If "Script" is present in the string return the string without "Script" otherwise return the 
        original one.
*/

let str2 = "My own Script is suspect";
function checkForScript(str){
    if (str.includes("Script")){
        return str.replace("Script", '')
    } else {return str;}
}
//console.log(checkForScript(str2));

/*
    5.  Write a JavaScript function to replace every character in a given string with the character 
        following it in the alphabet.
*/

function letterShift(string){
    let value = [];
    let charCode = "";
    

    for (i = 0; i < string.length; i++) {
        charCode = string.charCodeAt(i);
        if (((charCode > 67) && (charCode <90)) || ((charCode > 97) && (charCode < 122))){
            if (charCode == 122){
                value += String.fromCharCode('97')
             }else if(charCode == 90){
                value += String.fromCharCode('65')
            }else{
                value += String.fromCharCode(charCode+1);
            }
        } else {value += String.fromCharCode(charCode);}
    }
    return value;
}
//console.log(letterShift('Hello 8ik ; op'));

/*
    6.  Write a JavaScript function to count the number of vowels in a given string.
  
*/
function vowelCount(string){
    let counter = 0; 
    let vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];

    for (i = 0; i < vowels.length; i++){
        while(string.search(vowels[i]) != -1){
            string = string.replace(vowels[i], '')
            counter++;
        }
    }
    return counter;
}
//console.log(vowelCount(str2));

/*
    7.  Write a JavaScript function to reverse the elements of a given array.

*/

let arr = ['first', 'second', 'third', 'fourth', 'fifth'];

function reverseArr(array){

    //return array.reverse();

    let newArray = [];

    for (i = array.length ; i > 0; i--){
        newArray += array[i-1] + "\n";
    }
    return newArray
    

}
//console.log(reverseArr(arr));

/*
    8.  Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes. 
	    addArr([1,2,3],[3,2,1]) = [4,4,4]
	    addArr([1,2,3,4,5],[1,2,3]) = [2,4,6,4,5]

*/

arr1 = [2, 5, 1, 6];
arr2 = [4, 2, 9, 11, 4, 1];
function addArr(array, array2){

    if (array.length < array2.length){
        for (i = 0 ; i < array.length; i++){
            array2[i] = array2[i] + array[i];
        }
        return array2;
    } else{
        for (i = 0 ; i < array2.length; i++){
            array[i] = array2[i] + array[i];
        }
        return array;
    }
}
//console.log(addArr(arr1, arr2));

/*
    9.  Write a JavaScript to find the longest string from an given array of strings and returns 
        the string’s array index.
*/

stringArray = ['string', 'bob', 'arms', 'khaleel']
function longestStr(array){
    let longest = 0;
    let position = 0;

    for (i = 0; i < array.length; i++){
        if (array[i].length > longest)
        {
            longest = array[i].length;
            position = i;
        }
    }
    return position;
}
//console.log(longestStr(stringArray));

/*
    10. Write a JavaScript function which accepts three integers representing side lengths of a triangle. 
        The function should validate that the integers make a geometrically accurate. If the three 
        integers could not make a triangle, return undefined. Otherwise calculate and return the area 
        of the triangle.
*/

function area(number, number2, number3){
    if ((number < (number2 + number3)) && (number2 < (number + number3)) && (number3 < (number + number2))){
        return (number * number2 * number3);
    } else{
        return undefined;
    }
}
//console.log(area(5,3,7))

/*
    11. Write a JavaScript function which accepts two arrays, representing the side lengths of polygons. 
        Return true if the polygons are similar, false if they are not.
*/

function areSimilar(array, array2){
    if (array.length == array2.length){
        if (array[0] < array2[0]){
            let scaleFactor = array2[0]/array[0];

            for (i = 0; i < array.length; i++){
                if (scaleFactor == array2[i]/array[i]){continue;}
                else{return false}
            }
        } else {
            let scaleFactor = array[0]/array2[0];

            for (i = 0; i < array.length; i++){
                if (scaleFactor == array[i]/array2[i]){continue;}
                else{return false}
            }
        }
        return true;
    } else {
        return false;
    }
}
//console.log(areSimilar([2, 4, 6], [4, 8, 12]));


/*
    12. Check if two arrays have the same size and contents (including if content order is not the same).
	    equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
        equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
        equivArr([4,2,8,4],[7,5,4,2,8]) = false

*/

function equivArr(array, array2){
    if (array.length == array2.length){
        array.sort();
        array2.sort();
        for(i = 0 ; i < array.length; i++){
            if (array[i] == array2[i]){
                continue;
            } else{
                return false;
            }
        }
        return true;
    } else {
        return false;
    }
}
//console.log(equivArr([1,2,3,4],[4,3,2,1]))


/*
    13.     Create a function which takes a 3x3 2D array. Validate that each array index holds
            only a value of “X”, “O”, or be empty. Have the function evaluate a game of tic tac toe
            represented by the 2D array.  Should have a result for a tie, each winner, or an invalid game.

        tictactoe([[“X”, “X”, “X”],[“O”, “O”, “O”],[“X”, “O”, “X”]]) 
            -   prints “Invalid result”
        tictactoe([[“X”, “X”, “X”],[“X”, “X”, “X”],[“X”, “O”, “X”]]) 
            -   prints “Invalid result” 
            tictactoe([[“X”, “O”, “X”],[“O”, “X”, “O”],[“X”, “O”, “X”]]) 
            -   Prints “X is the winner”
        tictactoe([[empty, “O”, “X”],[“X”, “O”, empty],[empty, “O”, “X”]]) 
            -   Prints “O is the winner”
        tictactoe([[“X”, empty, “X”],[“O”, empty, empty],[empty, “O”, empty]]) 
            -   Prints “No winner yet”

*/

function tictactoe(array){

}
console.log(tictactoe([["X", "X", "X"],["O", "O", "O"],["X", "O", "X"]]));
