/* 1. Leap Year */
function leapYear(date){
    let year = date.getFullYear();

    // Algorithm for finding the year
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

// console.log("1: leapYear(new Date('date string'))")
// console.log('Year divisible by 4, but not a leap year: 1900:');
// console.log(leapYear(new Date ('January 1, 1900 00:00:00')));  // false

// console.log('Year divisible by 4, but not by 100: 2008:');
// console.log(leapYear(new Date ('January 1, 2008 00:00:00')));  // true

// console.log('Year not divisible by 4: 1969:');
// console.log(leapYear(new Date ('January 1, 1969 00:00:00')));  // false

// console.log('Year divisble by 4 and 100, and is a leap year: 2000:');
// console.log(leapYear(new Date ('January 1, 2000 00:00:00')));  // true


/* 2. Email Validation */
function isEmail(string){
    let re;
    let matching;

    // Using regex for check
    // TODO: Get add in the missing characters/restrictions 
    re = new RegExp('^[\\w][\\w-_\\.]*@[a-z\\d]+\\.[a-z]+$');

    // finding if it matches
    matching = string.match(re)
    if (matching == null) {
        return false;
    } else {
        return true;
    }
}

// isEmail('msdfi@gmail.com');

/* 3. Remove Character */
function removeChar(string, position){
    return string.substring(0,position-1) + string.substring(position);
}

// console.log("3: removeChar('string',position)")
// console.log('first position removal:');
// console.log(removeChar('day',1));

// console.log('last position removal:');
// console.log(removeChar('day',3));

// console.log('Inside string removal:');
// console.log(removeChar('This is a test sentence.',10));


/* 4. Remove "Script" */
function removeScript(string){
   return string.replace('Script','');
}

// console.log("4: removeScript('string')")
// console.log("'JavaScript':");
// console.log(removeScript('JavaScript'));

// console.log("'C++':");
// console.log(removeScript('C++'));

// console.log("'JavaScript is a scripting language':");
// console.log(removeScript('JavaScript is a scripting language'));

// console.log("'No, Java is object-oriented':");
// console.log(removeScript('No, Java is object-oriented'));


/* 5. Letter Shift */
function letterShift(string){
    let charCode;
    let shift = '';

    // For character wrapping
    let ACode = 65;
    let ZCode = 90;
    let aCode = 97;
    let zCode = 122;

    for(let i = 0; i < string.length; i++) {
        charCode = string.charCodeAt(i);
        
        // Wrap around back to A/a if at the end, increment if not, leave non-alphabet characters alone
        if((charCode >= ACode && charCode <= ZCode) || (charCode >= aCode && charCode <= zCode)){
            if(charCode == ZCode){
                charCode = ACode;
            } else if(charCode == zCode){
                charCode = aCode;
            } else {
                charCode ++;
            }
        }

        shift = shift.concat(String.fromCharCode(charCode));
    }

    return shift;
}

// console.log("5: letterShift('string')");
// console.log("'ABC':");
// console.log(letterShift('ABC'));

// console.log("'XYZ':");
// console.log(letterShift('XYZ'));

// console.log("'abc':");
// console.log(letterShift('abc'));

// console.log("'xyz':");
// console.log(letterShift('xyz'));

// console.log("'A test sentence.':");
// console.log(letterShift('A test sentence.'));


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

// console.log("6: vowelCount('string')");
// console.log("String consists of all vowels: 'aeiouyAEIOUY':");
// console.log(vowelCount('aeiouyAEIOUY')); // 12

// console.log("String consists of no vowels: 'qwrtp':");
// console.log(vowelCount('aeiUOY')); //0

// console.log("String consists of some vowels: 'A test sentence'");
// console.log(vowelCount('A test sentence')); // 5


/* 7. Reverse Array */

function reverseArr(array){
    return array.reverse();
}

// console.log("7: reverseArr(array)");
// console.log('Number Array: [1,2,3,4,5,6,7,8,9,10]:');
// console.log(reverseArr([1,2,3,4,5,6,7,8,9,10]));

// console.log("String Array: ['one','two','three']:");
// console.log(reverseArr(['one','two','three']));

// console.log('Array Array: [[1,2,3],[4,5,6],[7,8,9]]:');
// console.log(reverseArr([[1,2,3],[4,5,6],[7,8,9]]));


/* 8. Add Array */
// Assuming arrays are numbers, due to exmples given for the question
function addArr(array1, array2) {
    let maxLength = Math.max(array1.length,array2.length);
    let paddingStart;
    let minArray = (array1.length > array2.length ? array2 : array1);
    let maxArray = (array2 === minArray ? array1 : array2);

    // Probably a way to make this one line
    // Map will stop at the length of the smaller array
    if(minArray.length != maxLength) {
        paddingStart = minArray.length;
        minArray.length = maxLength;
        minArray.fill(0,paddingStart,maxLength);
    }

    return maxArray.map( (a1Ati,i) => a1Ati + minArray[i]);
}

// console.log("8: addArr(array,array)");
// console.log('Same length: [1,2,3] [3,2,1]: ');
// console.log(addArr([1,2,3],[3,2,1]));

// console.log('Left side longer: [1,2,3,4,5] [2,3,4]: ');
// console.log(addArr([1,2,3,4,5],[1,2,3]));

// console.log('Right side longer: [1,2,3] [1,2,3,4,5]: ');
// console.log(addArr([1,2,3],[1,2,3,4,5]));

/* 9. Longest String */
// Returns all maximum length string indices.
function longestStr(array){
    let lengthArray = array.map(str => str.length);
    let maxLength = Math.max(...lengthArray);
    let longestArray;
    
    // Used reduce to find indices of longest string(s)
    longestArray = lengthArray.reduce(
        (arr,length,i) => (maxLength == length) ? arr.concat(i) : arr, []
    );

    // Returns a number instead of an array if there's only one index
    if(longestArray.length == 1) {
        return longestArray[0];
    } else {
        return longestArray;
    }
}

// console.log('9: longestStr([string array])');
// console.log("Longest at the end: ['one','two','three']:");
// console.log(longestStr(['one','two','three']));

// console.log("Longest at the end: ['one','three','two']:");
// console.log(longestStr(['one','three','two']));

// console.log("Longest at the end: ['three','two','one']:");
// console.log(longestStr(['three','two','one']));

// console.log("Multiple Longests: ['longest','one','longest','two','longest']:")
// console.log(longestStr(['longest','one','longest','two','longest']));

/* 10. Area of a Triangle */

function area(a,b,c){
    let triArea;

    // Checks to see if valid triangle
    // valid if all less than the other two added together
    if((a + b) > c) {
        if((a + c) > b) {
            if((b +c) > a) {

                // Calculating area
                let p = (a + b + c)/2;
                triArea = Math.sqrt(p * (p -a ) * (p - b) * (p - c));
                return triArea;
            }
        }
    }
    
    return undefined;
}

// console.log("10: area(number,number,number), number == length");
// console.log('Right triangle: (3,4,5)')
// console.log(area(3,4,5)); //  6

// console.log('Invalid triangle: (3,8,5)')
// console.log((area(3,8,5))); // invalid triangle

// console.log("Non-right triangle: (10,10,10)")
// console.log(area(10,10,10));  // 43.30127018922193 (checked with a different method)


/* 11. Similar Polygons */
// Assuming angles and orientation are the same if sides are proportional
function areSimilar(array1, array2){
    let proportion;
    let similar;

    if(array1.length == array2.length && array1.length != 0) {
        proportion = array1[0]/array2[0];

        similar = array1.map( (value,i) => (value == (proportion * array2[i])) ? true : false
            ).reduce( (check,value) => (value) ? check : false, true);

        return similar;
    }

    return false;
}

// console.log('13: areSimiliar(array,array)');
// console.log('Same: [1,2,3] [1,2,3]');
// console.log(areSimilar([1,2,3],[1,2,3]));

// console.log('Similar: [1,2,3,4] [2,4,6,8]');
// console.log(areSimilar([1,2,3,4],[2,4,6,8]));

// console.log('Reversed: [2,4,6,8] [1,2,3,4]');
// console.log(areSimilar([2,4,6,8],[1,2,3,4]));

// console.log('Not in same group of polygons: [1,2,3] [1,2,3,4]');
// console.log(areSimilar([1,2,3],[1,2,3,4]));

// console.log('Same group but not similiar: [1,2,3,4] [2,5,7,3]');
// console.log(areSimilar([1,2,3,4],[2,5,7,3]));


/* 12. Equivalent Arrays */
function equivArr(array1, array2){
    let reduction;

    // reduction will return true if array1 is shorter than array2
    // and values are the same until array 1 ends
    if(array1.length != array2.length) {
        return false;
    }

    // Sorts arrays in place.
    array1.sort();
    array2.sort();

    reduction = array1.reduce(
        (acc,value,i) => ((acc == true && value == array2[i]) ? true : false), true
    );

    return reduction;
}

// console.log('12: equivArr(array,array)');
// console.log('Equivalent Arrays: [4,2,8,4,7] [7,4,4,2,8]');
// console.log(equivArr([4,2,8,4,7],[7,4,4,2,8]));

// console.log('Non-equivalent Arrays (same lengths): [4,2,8,4,7] [7,5,4,2,8]');
// console.log(equivArr([4,2,8,4,7],[7,5,4,2,8]));

// console.log('Non-equivalent Arrays (different lengths): [4,2,8,4] [7,5,4,2,8]');
// console.log(equivArr([4,2,8,4],[7,5,4,2,8]));

// console.log('Non-equivalent Arrays (different lengths): equivArr([1,2,3,4],[1,2,3,4,5]);');
// console.log(equivArr([1,2,3,4],[1,2,3,4,5]));

// console.log('Non-equivalent Arrays (different lengths): equivArr([1,2,3,4,5],[1,2,3,4]);');
// console.log(equivArr([1,2,3,4,5],[1,2,3,4]));


/* 13. Tic Tac Toe */
function tictactoe(array) {
    let threeBy;
    let xWins;
    let oWins;
    let empties;
    let currentWins = 0;
    let wins;

    // Map and filter skip empty values
    // reduce returns the value without calling the callback function
    game = transformArr(array).map((a) => a.filter(TicTacValues));

    // To see if game is over yet
    empties = game.map(row => row.reduce(
        (count,empty) => (empty == 'E') ? count+1 : count,0)
    ).reduce((count,numEmpty) => count+numEmpty);

    if (game.length == 3) {
        threeBy = game.map(
            (a) => a.length
        ).reduce(
            (three, length) => ((length == 3) ? three : -1), 3
        );

        // If values and array lengths correct. Finding "wins"
        if (threeBy == 3) {

            // Across
            wins = game.reduce((arr, row) =>
                (row[0] == row[1] && row[1] == row[2]) ? arr.concat(row[0]) : arr, []
            );

            // Validity check
            if(wins.length > 1) {
                return 'Invalid result';
            } else {
                currentWins = wins.length;
            }

            // Down
            wins = wins.concat(game.reduce((arr, row, i) =>
                (game[0][i] == game[1][i] && game[1][i] == game[2][i]) ? arr.concat(row[i]) : arr, []
            ));

            // Validity Check
            if((currentWins == 0 && wins.length == 2)) {
                return 'Invalid result';            
            }

            // Diagonal
            if(game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
                wins = wins.concat(game[0][0]);
            } else if (game[0][2] == game[1][1] && game[1][1] == game[2][0]) {
                wins = wins.concat(game[0][2]);
            }

            // More than two and the number of 'X's:'O's is unbalanced
            if(wins.length > 2) {
                return 'Invalid result';
            }

            // Tallying up
            xWins = wins.reduce((count,xs) => (xs == 'X') ? count+1 : count,0);
            oWins = wins.reduce((count,xs) => (xs == 'O') ? count+1 : count,0);

            // Validity Check
            if(xWins == 1 && oWins == 1) {
                return 'Invalid result';
            }
            
            // Results
            if (xWins > 0) {
                return 'X is the winner';
            } else if (oWins > 0) {
                return 'O is the winner';
            } else if (empties == 0) {
                return 'X and O are tied';
            } else {
                return 'No winner yet'
            }
        }
    }

    return 'Invalid input';
}

// For first dimension
function transformArr(array) {
    let newArr = new Array();

    for (let i = 0; i < array.length; i++) {
        if (Array.isArray(array[i])) {
            newArr.push(transformation(array[i]));
        } else {
            // Will be invalid if not an array
            newArr.push(-1);
        }
    }

    return newArr;
}

// For the second dimension
function transformation(array) {
    let transformed = new Array();

    for (let i = 0; i < array.length; i++) {
        switch (array[i]) {
            case 'X':
                transformed.push('X');
                break;
            case 'O':
                transformed.push('O');
                break;
            case undefined:
                transformed.push('E');
                break;
            default:
                transformed.push(-1);
        }
    }

    return transformed;
}

const TicTacValues = function (value) {
    if( -1 == value) {
        return false;
    } else {
        return true;
    }
}

// console.log("13: tictactoe([[array(3)],[array(3)],[array(3)]])");
// console.log("tictactoe([['X','X','X'],['O','O','O'],['X','O','X']]);");
// console.log(tictactoe([['X','X','X'],['O','O','O'],['X','O','X']]));

// console.log("tictactoe([['X','X','X'],['X','X','X'],['X','O','X']])");
// console.log(tictactoe([['X','X','X'],['X','X','X'],['X','O','X']]));

// console.log("tictactoe([['X','O','X'],['O','X','O'],['X','O','X']]);");
// console.log(tictactoe([['X','O','X'],['O','X','O'],['X','O','X']]));

// console.log("tictactoe([[,'O','X'],['X','O',,],[,'O','X']]);");
// console.log(tictactoe([[,'O','X'],['X','O',,],[,'O','X']]));

// console.log("tictactoe([['X',,'X'],['O',,,],[,'O',,]]);");
// console.log(tictactoe([['X',,'X'],['O',,,],[,'O',,]]));

// console.log("A Tie: [['X','O','X'],['O','O','X'],['X','X','O']]")
// console.log(tictactoe([['X','O','X'],['O','O','X'],['X','X','O']]));