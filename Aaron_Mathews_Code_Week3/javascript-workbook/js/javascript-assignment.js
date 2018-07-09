function leapYear(year) {
    if (year % 4 == 0 && year % 100 != 0) {
        return true;
    } else if (year % 400 == 0) {
        return true;
    }
    return false;
}

console.log("Is 2016 a leap year? " + leapYear(2016));
console.log("Is 2017 a leap year? " + leapYear(2017));

function validEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

console.log("Is aaron@gmail.com a valid email? " + validEmail("aaron@gmail.com"));
console.log("Is aaron a valid email? " + validEmail("aaron"));

function removeChar(str, num) {
    let sub1 = str.slice(0, num);
    let sub2 = str.slice(num + 1, str.length);
    return (sub1 + sub2);
}
console.log("Remove 'h' from hello: " + removeChar("Hello", 0))

function removeScript(str) {
    let scr = "Script";
    let pos = str.search(scr);
    let returnStr = str;

    if (pos >= 0) {
        returnStr = returnStr.replace(scr, "");
    }
    return returnStr;
}
console.log("Remove 'Script' from 'This is a Script' " + removeScript("This is a Script"));

function nextChar(str) {
    let returnStr = "";
    for (let i = 0; i < str.length; i++) {
        let c = str.charAt(i);
        let cVal = c.charCodeAt(i);
        if ((cVal < 90 && cVal > 64) || (cVal > 96 && cVal <122)) {
            c = String.fromCharCode(c.charCodeAt(i) + 1);
        } 
        returnStr += c;
    }
    return returnStr;
}
console.log(nextChar("abcdef"));

function numVowels(str) {
    let counter = 0;
    for (let i = 0; i < str.length; i++) {
        let c = str.charAt(i);
        if (/[aeiou]/.test(c)) {
            counter++;
        }
    }
    return counter;
}

console.log("Return 3 vowels: " + numVowels("abcdefi"));

function reverseArray(arr) {
    let newArr = [];

    for (let i = 0; i < arr.length; i++) {
        newArr[i] = arr[arr.length - i - 1];
    }

    return newArr;
}

console.log("Return [3, 2, 1]: " + reverseArray([1,2,3]));

function addArray(arr1, arr2) {
    let returnArr = [];
    let maxLength = (arr1.length > arr2.length) ? arr1.length : arr2.length;

    for (let i = 0; i < maxLength; i ++) {
        let val1 = arr1[i];
        let val2 = arr2[i];

        if (val1 == null) {
            returnArr[i] = val2;
        } else if (val2 == null) {
            returnArr[i] = val1;
        } else {
            returnArr[i] = val1 + val2;
        }
    }
    return returnArr;
}
console.log("Add [1,2,3] to [1,2]: " + addArray([1,2,3], [1,2]));

function longestString(strArr) {
    let length = 0;
    let index = 0;

    for (let i = 0; i < strArr.length; i++) {
        if (strArr[i].length > length) {
            length = strArr[i].length;
            index = i;
        }
    }
    return index;
}

console.log("Longest string is 'Hello' at index 0: " + longestString("Hello, world hi."))

function calculateArea(a, b, c) {
    let check1 = a + b > c;
    let check2 = a + c > b;
    let check3 = b + c > a;

    if (check1 && check2 && check3) {
        return (a + b + c)/2;
    }
    return undefined;
}

array1 = [1, 2, 3, 4];
array2 = [2, 4, 6, 8];

console.log(similarPoly(array1, array2));
function similarPoly(arr1, arr2) {
    if (arr1.length != arr2.length) {
        return false;
    }
    let proportion = arr1[0] / arr2[1];
    for (let i = 0; i < arr1.length; i++) {
        let ang1 = (Math.atan(arr1[i] / arr1[i + 1]) % length);
        let ang2 = (Math.atan(arr2[i] / arr2[i + 1]) % length);

        if (ang1 != ang2) {
            return false;
        }
        if (arr1[i] / arr2[i] != proportion) {
            return false;
        }
    }
    return true;
}

// tictactoe([["X", "X", "X"],
//           ["O", "O", "O"],
//           ["X", "O", "X"]]) 
// prints “Invalid result”

tictactoe([["X", "X", "X"],
          ["X", "X", "X"],
          ["X", "O", "X"]]) 
// // prints “Invalid result” 

// tictactoe([["X", "O", "X"],
//           ["O", "X", "O"],
//           ["X", "O", "X"]]); 
// Prints “X is the winner”

// tictactoe([["", "O", "X"],
//           ["X", "O", ""],
//           ["", "O", "X"]]) 
// // Prints “O is the winner”

// tictactoe([["X", "", "X"],
//           ["O", "", ""],
//           ["", "O", ""]]) 
// // Prints “No winner yet”


function tictactoe(arr) {
    let winnerNum = 0;
    let winnerLetter;
    if (validateArr(arr)) {
        console.log("invalid entry at entry " + validateArr(arr));
    } else if (!winnerLetter) {
        for(var i = 0; i < arr.length; i++){
            var rowSum = 0;
            for(var j = 0; j < arr[i].length; j++){
                //X is +1
                //O is -1
                if (arr[i][j] === "X") {
                    rowSum += 1;
                } else if (arr[i][j] === "O") {
                    rowSum -= 1;
                }
            }
            if (rowSum === 3){
                winnerLetter = "X";
                winnerNum++;
            } else if (rowSum === -3) {
                winnerLetter = "O";
                winnerNum++;
            }
        }
    
        for(var i = 0; i < arr.length; i++){
            var colSum = 0;
            for(var j = 0; j < arr[i].length; j++){
                //X is +1
                //O is -1
                if (arr[j][i] === "X") {
                    colSum += 1;
                } else if (arr[j][i] === "O") {
                    colSum -= 1;
                }
            }
            if(colSum === 3){
                winnerLetter = "X";
                winnerNum++;
            } else if(colSum === -3) {
                winnerLetter = "O";
                winnerNum++;
            }   
        }
    
        if(arr[0][0] === "X" && arr[1][1] === "X" && arr[2][2] === "X") {
            winnerLetter = "X";
            winnerNum++;
        } else if(arr[0][0] === "O" && arr[1][1] === "O" && arr[2][2] === "O"){
            winnerLetter = "O";
            winnerNum++;
        } else if(arr[2][0] === "X" && arr[1][1] === "X" && arr[0][2] === "X") {
            winnerLetter = "X";
            winnerNum++;
        } else if(arr[2][0] === "O" && arr[1][1] === "O" && arr[0][2] === "O"){
            winnerLetter = "O";
            winnerNum++;
        } else if (winnerNum > 2) {
            console.log("Invalid result")
        } else if (!winnerLetter && !winnerNum) {
            console.log("No winner yet")
        }
        else {
            console.log(winnerLetter + " is the winner");
        }
    } else {
        console.log("Invalid result")
    }
}

function validateArr(arr) {
    let squareNum = 0;
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            let entry = arr[i][j];
            switch (entry) {
            case "X":
                break;
            case "O":
                break;
            case "":
                break;
            default:
                squareNum = (i + j + 1);
                return squareNum;
            }
        }
    }
    return squareNum;
}