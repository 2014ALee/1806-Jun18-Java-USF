/* 1. Leap Year 
Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
*/

$('#getDate').on('click', leapYear);
//$('#getDate').click([$('#newDate').val()], leapYear)

function leapYear(date){
    let year = date;
    let leap = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0 );
    return leap;
    $('#getDate').text('leap?:'+ leap);
    $('#newDate').val('');
};
console.log('#1 is 2016 a leap year? ',leapYear(2016))
/* 2. Email Validation */ 

function isEmail(string){
    var VAL = string;
    let regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    if (regularExpression.test(VAL)) {
        return VAL + ' is a valid email';
    }else{
        return VAL + ' is not a valid email';
    }
};
console.log('#2 is kyle@gmail.com a valid email:  ',isEmail('asdf@gamil.com'))

/* 3. Remove Character */
//Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
function removeChar(str, position){
    return str.slice(0, position) + str.slice(position+1);
}

console.log('#3 remove m: ', removeChar('remove', 2));

/* 4. Remove "Script"
Write a JavaScript function to check if a string "Script" is present in a given string. 
If "Script" is present in the string return the string without "Script" otherwise return the original one.
*/
function removeScript(string){
    return string.replace('Script','');
}
console.log('#4 Remove Script from String: '+ removeScript('Dog test method stuff Script Fill is here Script'));

/* 5. Letter Shift 
Write a JavaScript function to replace every character in a given string with the character following it in the alphabet.
*/
function letterShift(string){
    let newString = $.map((string + '').split(''), function(e) {
        if(e !== 'z')
            return  String.fromCharCode(e.charCodeAt(0) + 1);
        else
            return String.fromCharCode(e.charCodeAt(0));
    });
    console.log('new String Dog = ' + newString.join(''))
};
letterShift('Dog');

/* 6. Vowel Count 
Write a JavaScript function to count the number of vowels in a given string.
*/
function vowelCount(string){
    let count = $.map((string + '').split(''), function(e) {
        if(/[aeiou]/.test(e))
            return e;
    });
    console.log('#6 vowlCount ' + (count.join('')).length);
};
vowelCount('bobdogbillnye')

/* 7. Reverse Array 
Write a JavaScript function to reverse the elements of a given array.
*/
function reverseArr(array){
    return array.map((a,i) => array[array.length-1-i]); 
    // return array.reverse();
}
console.log(reverseArr([1,2,3,4,5]));
/* 8. Add Array 
Write  JavaScript function that adds the values of arrays, even if the arrays are different sizes. 
	addArr([1,2,3],[3,2,1]) = [4,4,4]
	addArr([1,2,3,4,5],[1,2,3]) = [2,4,6,4,5]
*/
function addArr(array1, array2){
    if(array1.length > array2.length){
         (((array1.slice(0)).map((a, i) => 0).slice(array2.length, array1.length+1)).map((a,i) => array2.push(0)));
         return array2.map((a,i) => a + array1[i]);
    }else if (array2.length > array1.length){
        (((array2.slice(0)).map((a, i) => 0).slice(array1.length, array2.length+1)).map((a,i) => array1.push(0)));
        return array2.map((a,i) => a + array2[i]);
    }
    return array2.map((a, i) => a + array1[i]);
}
console.log(addArr([1,2,3],[3,2,1]));
console.log(addArr([1,2,3,4,5],[1,2,3]));

/* 9. Longest String 
Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
*/
function longestStr(array){
    let maxVal = Math.max(...array.map((a,i) => a.length));
    let maxIndex
    array.map((a,i) => {
        if(a.length == maxVal)
        maxIndex = i;
    });
    return maxIndex;
}
console.log(longestStr(['d','df','asdfasdf','asdf','']));

/* 10. Area of a Triangle 
Write a JavaScript function which accepts three integers representing side lengths of a triangle. 
The function should validate that the integers make a geometrically accurate. 
If the three integers could not make a triangle, return undefined. Otherwise calculate and return the area of the triangle.
*/
function area(num1, num2, num3){
    if(num1 > 0 && num2 > 0 && num3 > 0){
        s = (num1+num2+num3)/2
        return Math.sqrt(s*(s-num1)*(s-num2)*(s-num3));
    }
    return undefined;
}

console.log(area(3,4,5))

/* 11. Similar Polygons 
Write a JavaScript function which accepts two arrays, representing the side lengths of polygons. 
Return true if the polygons are similar, false if they are not.
*/
function areSimilar(arr1, arr2){
    tempArr = arr1.map((a,i) => a/arr2[i]);
    areSim = true 
    tempArr.map((a, i) => {
        if(tempArr[0] != a)
            areSim = false;
    });
    return areSim;
}

/* 12. Equivalent Arrays 
Check if two arrays have the same size and contents (including if content order is not the same).
equivArr([4,2,8,4,7],[7,4,4,2,8]) = true
equivArr([4,2,8,4,7],[7,5,4,2,8]) = false
equivArr([4,2,8,4],[7,5,4,2,8]) = false

*/
function equivArr(array1, array2){
    if(array1.length != array2.length)
        return false;
    array1.sort((a, b) => {return a - b});
    array2.sort((a, b) => {return a - b});
    return array1.every((a,i) => a === array2[i]);
}
console.log(equivArr([4,2,8,4,7],[7,4,4,2,8]));
console.log(equivArr([4,2,8,4,7],[7,5,4,2,8]));
console.log(equivArr([4,2,8,4],[7,5,4,2,8])); 


/* 13. Tic Tac Toe 
Create a function which takes a 3x3 2D array. Validate that each array index holds only a value of “X”, “O”, or be empty. 
Have the function evaluate a game of tic tac toe represented by the 2D array.  
Should have a result for a tie, each winner, or an invalid game.
*/

function tictactoe(array){
    let countX = countO = countEmpty = countWinX = countWinO = 0;
    let str = 'No Winner Yet';    

    array.map((a,i) => a.map((a2,i2)=>  {
        if(a2 == 'X') {
            countX+=1;
            array[i][i2] = 5;
        }else if(a2 == 'O') {
            countO+=1;
            array[i][i2] = 1;
        }else if (a2 == ' ') {
            countEmpty+=1;
            array[i][i2] = 0;
        }
    }));

    if (countEmpty > 4){
        str = 'No winner yet';
    }else if(countO <= 5 && countX <= 5){ 
        for(let i =0; i < array.length; i++){
            if((array[i]).reduce((a,k) => a + k) == 15){
                str = 'X is the winner';
                countWinX+=1;
            }else if ((array[i]).reduce((a,k) => a + k) == 3){
                str = 'O is the winner'
                countWinO+=1;
            }
            for(let j = 0; j < array[i].length; j++){
                if(i == 1){
                    if((array[i][j] + array[i+1][j]+ array[i-1][j]) == 15){
                        str = 'X is the winner';
                        countWinX+=1;
                    }else if ((array[i][j] + array[i+1][j]+ array[i-1][j]) == 3){
                        str = 'O is the winner'
                        countWinO+=1;
                    }
                    if(j == 1){
                        if((array[i][j] + array[i+1][j+1]+ array[i-1][j-1]) == 15){
                            str = 'X is the winner';
                            countWinX+=1;
                        }else if ((array[i][j] + array[i+1][j+1]+ array[i-1][j-1]) == 3){
                            str = 'O is the winner'
                            countWinO+=1;
                        }
                        if((array[i][j] + array[i+1][j-1]+ array[i-1][j+1]) == 15){
                            str = 'X is the winner';
                            countWinX+=1;
                        }else if ((array[i][j] + array[i+1][j-1]+ array[i-1][j+1]) == 3){
                            str = 'O is the winner'
                            countWinO+=1;
                        }
                    }
                }
            }
        }
        if(countWinX >= 1 && countWinO >= 1)
            str = 'Invalid Results';
    }else{
        str = 'Invalid Results';
    }
return str;
}
console.log(tictactoe([['X', 'X', 'X'],['O', 'O', 'O'],['X', 'O', 'X']]));
console.log(tictactoe([['X', 'X', 'X'],['X', 'X', 'X'],['X', 'O', 'X']]));
console.log(tictactoe([['X', 'O', 'X'],['O', 'X', 'O'],['X', 'O', 'X']])); 
console.log(tictactoe([[' ', 'O', 'X'],['X', 'O', ' '],[' ', 'O', 'X']])); 
console.log(tictactoe([['X', ' ', 'X'],['O', ' ', ' '],[' ', 'O', 'X']]));




