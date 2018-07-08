function leapYear(date){
    let year = date.getFullYear();
    
    if(year % 100 == 0){
        if(year % 400 == 0){
            return true;
        }
    } else if(year % 4 == 0) {
        return true;
    }
    
    return false;
}

let date = new Date(2004, 1, 1, 1, 1, 1, 1);
console.log('' + date.getFullYear() + ' ' + (leapYear(date) ? 'is' : 'is not') + ' a leap year.');



function isEmail(email){
    let pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return pattern.test(email);
}

let email = 'bwalker@revature.com';
console.log(email + ' ' + (isEmail(email) ? 'is' : 'is not') + ' a valid email address.');



function removeChar(string, index){
    return string.substring(0, index) + string.substring(index+1, string.length);
}

console.log(removeChar('test', 1));



function removeScript(string){
    while(string.indexOf('Script') != -1){
        string = string.replace('Script', '');
    }
    return string;
}

console.log(removeScript('This should remove the word Script from Script this Script string.'));



function letterShift(string){
    let alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
    
    let result = '';
    for(let i = 0; i < string.length; i++){
        if(string[i] == ' ') continue;
        result = result + alphabet[alphabet.indexOf(string[i].toLowerCase()) + 1];
    }
    
    return result;
}

console.log(letterShift('This is going to be gibberish'));



function vowelCount(string){
    let vowels = ['a','e','i','o','u'];
    let count = 0;
    
    for(let i = 0; i < string.length; i++){
        if(vowels.indexOf(string[i].toLowerCase()) != -1){
            count++;
        }
    }
    
    return count;
}

let testVowels = 'This is a string that contains some vowels.';
console.log('Given string: ' + testVowels);
console.log('Number of vowels: ' + vowelCount(testVowels));



function reverseArr(array){
    let result = [];
    
    for(let i = 0; i < array.length; i++){
        result[i] = array[array.length-1-i];
    }
    
    return result;
}

console.log(reverseArr([0,1,2,3,4,5,6,7,8,9]));



function addArr(array1, array2){
    result = [];
    for(let i = 0; i < Math.max(array1.length, array2.length); i++){
        result[i] = ((array1[i]) ? array1[i] : 0) + ((array2[i]) ? array2[i] : 0);
    }
    
    return result;
}

console.log(addArr([1,2,3], [4,5,6,7]));



function longestStr(array){
    let longest = 0;
    let index = 0;
    
    for(let i = 0; i < array.length; i++){
        if(array[i].length > longest){
            longest = array[i].length
            index = i;
        }
    }
    
    return index;
}

console.log(longestStr(['0','1','2','34','5']));



function area(array){
    let a = array[0];
    let b = array[1];
    let c = array[2];
    let area;
    
    if(a+b > c && b+c > a && c+a > b){
        let s = (a+b+c) / 2;
        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    
    return area;
}

console.log(area([1,2,2]));



// Christian figured this part out
function areSimilar(array1, array2){
    if(array1.length != array2.length) return false;
    
    let ratio = array1[0] / array2[0];
    for(let i = 0; i < array1.length; i++){
        if(array1[i] != array2[i] * ratio) return false;
        if(Math.atan(array1[i] / array1[(i+1)%array1.length]) !=
            Math.atan(array2[i] / array2[(i+1)%array2.length]))
            return false;
    }
    
    return true;
}



function equivArr(array1, array2){
    if(array1.length != array2.length) return false;
    
    for(let i = 0; i < array1.length; i++)
        if(typeof array1[i] != typeof array2[i] || array1[i] != array2[i]) return false;
    
    return true;
}

console.log(equivArr([1,'2',3], [1,'2',3]));



/* 13. Tic Tac Toe */

function tictactoe(array){
    let invalid = 'Invalid Game';
    let winner = '';
    let result = '';
    let countX = 0;
    let countY = 0;
    
    // Check if it can possibly be a valid game
    for(let row in array)
        for(let token in row)
            if(token == 'X') countX++;
            else if(token == 'Y') countY++;
    
    if(countX > 5 || countY > 5) return invalid;
    else if(countX > countY + 1) return invalid;
    else if(countY > countX + 1) return invalid;
    
    // Check if someone has all positions on a row
    for(let row in array)
        if(row[0] == row[1] && row[1] == row[2]) winner += row[0];
    
    // Check if someone has all positions in a column
    for(let i = 0; i < array[0].length; i++)
        if(array[0][i] == array[1][i] && array[1][i] == array[2][i]) winner += array[0][i];
    
    // Check both diagonals
    if(array[0][0] == array[1][1] && array[1][1] == array[2][2]) winner += array[1][1];
    if(array[0][2] == array[1][1] && array[1][1] == array[2][0]) winner += array[1][1];
    
    if(winner.length > 1) result = invalid;
    else if(winner.length < 1) result = 'No winner';
    else result = winner + ' is the winner';
    
    return result;
}

console.log(tictactoe([['X','X','X'],['O','O','O'],['X','O','X']]));
let arr = [[0,0,0],[0,0,0],[0,0,0]];

for(row in arr){
    console.log(row);
}


