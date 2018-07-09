/* 1. Leap Year */
const Q1Date = new Date();
function Q1(date){
     let theYear = date.getFullYear();
    if(theYear % 4 == 0 && theYear % 100 ==0 && theYear % 400 ==0){
        return true;
    }else{
        return false;
    }
}
console.log('Is '+Q1Date.getFullYear()+' a leap year? '+Q1(Q1Date));



/* 2. Email Validation */
const Q2Email = 'testy@testmail.com';
const Q2FakeEmail = 'notanemail'; 
function Q2(string){
    let emailRegEx = /.@\w+\.\w+/;
    let isValidEmail = emailRegEx.test(string);

    if(isValidEmail){
        console.log(string + ' is a valid email.');
    }
    else{
        console.log(string + ' is not a valid email');
    }

}
Q2(Q2Email);
Q2(Q2FakeEmail);

/* 3. Remove Character */
const Q3Word = 'Tannuki';
const Q3Index = 3;
function Q3(string, position){
    let wordCount = string.length;
    let frontEnd = string.slice(0, Q3Index-1);
    let backEnd = string.slice(Q3Index);
    console.log(frontEnd + backEnd);

}
Q3(Q3Word);
        
/* 4. Remove "Script" */
const Q4String = 'This Script sentence fails and it\'s badly written.';
function Q4(string){
    return string.replace('Script ','');

}
console.log(Q4(Q4String));

/* 5. Letter Shift */
//Shout out to Aaron for helping me through this one
const Q5String = 'rghesdc';
function Q5(string){
    let returnedString ='';
    for (let i = 0; i < string.length; i++){
        let c = string.charAt(i);
        switch(c){
            case ' ':
            break;
            default:
            c =String.fromCharCode(1 + c.charCodeAt(c));
            returnedString += c;
        }
    }
    return returnedString;
}
console.log(Q5(Q5String));

/* 6. Vowel Count */
const Q6String = 'babadook';
function Q6(string){
    let vowelCount = 0;
    for (let i = 0; i < string.length; i++){
        let c = string.charAt(i);
        if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
            vowelCount++;
        }
    }
    return vowelCount;
}
console.log(Q6(Q6String));

/* 7. Reverse Array */
const Q7Array = [1,2,3,4,5]
function Q7(array){
    let reversedArray = array.reverse();
    return reversedArray;
}
console.log(Q7(Q7Array));

/* 8. Add Array */
const Q8Array1 = [3,4,3,7];
const Q8Array2 = [2,4,1];
function Q8(array, array2){
    let max = (array.length > array2.length ? array.length : array2.length);
    let sum = [];
    array2.length = max;
    // array.map((a,i)=> a+array2[i]);
        for(let i = 0; i < max; i++){
        if(array[i] == null){
            array[i]= 0;
            sum.push(array[i]+array2[i]);
        }
        else if(array2[i] == null){
            array2[i] = 0;
            sum.push(array[i]+array2[i]);
        }
        else if(i <array.length && i <array2.length){
            sum.push(array[i]+array2[i]);
        }
    }
    return sum;
}
console.log(Q8(Q8Array1, Q8Array2));

/* 9. Longest String */
const Q9StringArray = ['if', 'and', 'tanuki', 'or'];
function Q9(array){
    let longest = 0;
    let length = 0;
    for(let i=0; i<array.length;i++){
        if(array[i].length > length){
            length = array[i].length;
            longest = i;
        }
    }
    return longest;
}
console.log(Q9(Q9StringArray));

/* 10. Area of a Triangle */
const Q10sideA = 3
const Q10sideB = 4
const Q10sideC = 5
function Q10(number, number2, number3){
    let isTriangle = false;
    if(number + number2 > number3 && number2 + number3 > number && number + number3 > number2)
    {
        isTriangle = true;   
    }
    if(isTriangle)
    {
        let p = (number+number2+number3)/2;
        let a = Math.sqrt((p * (p - number)*(p - number2)*(p - number3)));
        return a;
    }
    else{
        return 'Not a triangle.';
    }
}
console.log(Q10(Q10sideA,Q10sideB,Q10sideC));

/* 11. Similar Polygons */
const Q11Array1= [4,5,4,5];
const Q11Array2= [2,2.5,2,2.5];
const Q11Array3= [45,10,16,20];
function Q11(array, array2){
    //Andrew and Tomas helped me out with coming up with the ratio array.
    let isSimilar = true;
    if(array.length != array2.length || array.length < 3 || array2.length < 3){
        return array+' and '+array2+' are not similar';
    }
    else{
        for(let i = 0; i < array.length; i++){
             if((array[0]/array2[0]) != (array[i]/array2[i])){
                isSimilar = false;
             }
        }
        if(isSimilar){
            return array+' and '+array2+' are similar';
        }
        else{
            return array+' and '+array2+' are not similar';
        }
    }
}
console.log(Q11(Q11Array1,Q11Array2));

/* 12. Equivalent Arrays */
const Q12ArraySet1=[4,2,8,4,7];
const Q12ArraySet2=[7,5,4,2,8];
const Q12ArraySet3=[4,2,8,4];
const Q12ArraySet4=[7,4,4,2,8];
function Q12(array, array2){
    // console.log('Initial Array 1: '+array);
    // console.log('Initial Array 2: '+array2);
    if(array.length == array2.length){
        for(let i = 0; i <= array.length;i++){
            // console.log('For counter: '+count);
            for(let j = 0; j < array2.length; j++){
                if(array2[j] == array[i]){
                    // console.log('Array 1: '+array);
                    // console.log('Array 2: '+array2);
                    // console.log('MATCH: '+array[i]+' = '+array2[j]+' at i= '+i+' and j= '+j);
                    array2.splice(j,1);
                    array.splice(i,1);
                    // console.log('Array 1: '+array);
                    // console.log('Array 2: '+array2);

                    break;
                }
                else{
                    i=0;
                    // console.log(array[i]+' is unequal to '+array2[j]);
                }
                // console.log('Array2 position: '+j);
                // console.log('Array1 position: '+i);
            }
        }
    }
    if(array.length == 1 && array2.length ==1){
        if(array[0] == array2[0]){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
}
console.log(Q12(Q12ArraySet1,Q12ArraySet4));

/* 13. Tic Tac Toe */
const Q13ArrayTable= [['X','O','X'],['O','X','O'],['O','O','O']];
function Q13(array){ //Shout out to Tom for helping me figure this one out.
    
    console.log(array);
    let x = 0;
    let o = 0;
    for(let a = 0; a < array.length; a++){
        // console.log('a Position: '+a+' a Value: '+array[a]);
        // console.log('Array length: '+array.length);
        let innerArray = array[a];
        for(let b = 0; b < innerArray.length; b++){
            // console.log('innerArray length: '+innerArray.length);
            // console.log('b Position: '+b+' b Value: '+innerArray[b]);
            if(innerArray[b] != 'empty'&& innerArray[b] != 'X' && innerArray[b] != 'O'){
                return 'Invalid board.';
            }
            else if(innerArray[b] == 'X'){
                x++;
            }
            else if(innerArray[b] == 'O'){
                o++;
            }
        }
    }
    let pOne = array[0][0];
    let pTwo = array[0][1];
    let pThree = array[0][2];
    let pFour = array[1][0];
    let pFive = array[1][1];
    let pSix = array[1][2];
    let pSeven = array[2][0];
    let pEight = array[2][1];
    let pNine = array[2][2];
    if(Math.abs(x-o) > 1 || x > 5 || o > 5){
        return 'Invalid board';
    }

    if(pOne == 'X' && pTwo == 'X' && pThree == 'X'){
        return 'X is the Winner!'
    }
    if(pOne == 'O' && pTwo == 'O' && pThree == 'O'){
        return 'O is the Winner!'
    }
    if(pFour == 'X' && pFive == 'X' && pSix == 'X'){
        return 'X is the Winner!'
    }
    if(pFour == 'O' && pFive == 'O' && pSix == 'O'){
        return 'O is the Winner!'
    }
    if(pSeven == 'X' && pEight == 'X' && pNine == 'X'){
        return 'X is the Winner!'
    }
    if(pSeven == 'O' && pEight == 'O' && pNine == 'O'){
        return 'O is the Winner!'
    }
    if(pOne == 'X' && pFour == 'X' && pSeven == 'X'){
        return 'X is the Winner!'
    }
    if(pOne == 'O' && pFour == 'O' && pSeven == 'O'){
        return 'O is the Winner!'
    }
    if(pOne == 'X' && pFive == 'X' && pNine == 'X'){
        return 'X is the Winner!'
    }
    if(pOne == 'O' && pFive == 'O' && pNine == 'O'){
        return 'O is the Winner!'
    }
    if(pThree == 'X' && pFive == 'X' && pSeven == 'X'){
        return 'X is the Winner!'
    }
    if(pThree == 'O' && pFive == 'O' && pSeven == 'O'){
        return 'O is the Winner!'
    }
    if(pThree == 'X' && pSix == 'X' && pNine == 'X'){
        return 'X is the Winner!'
    }
    if(pThree == 'O' && pSix == 'O' && pNine == 'O'){
        return 'O is the Winner!'
    }
    if(pTwo == 'X' && pFive == 'X' && pEight == 'X'){
        return 'X is the Winner!'
    }
    if(pTwo == 'O' && pFive == 'O' && pEight == 'O'){
        return 'O is the Winner!'
    }
    return 'No Winner Yet';
}
console.log(Q13(Q13ArrayTable));
