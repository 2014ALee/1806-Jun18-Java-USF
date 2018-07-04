/*
    Closures
        Functions that are nested inside of other functions. Closures are
        an effective way of eplying encapsulation in JS, as is tacan ve sued to hide 
        variables so that they  cannot be accessed directly, by other parts of the script.
*/

let counter = 0;

// Function to increment our counter
function add(){
    counter += 1;
    return counter;
};

// Call add() 3 times
add();
add();
add();

console.log(counter);

// protect the counter by including it in the function
function add_v2(){
    let counter = 0;
    counter += 1;
    return counter;
};

function myFunction(){
    let myParagraph = document.getElementById("myValue");
    myParagraph.innerHTML = add_v3();
}

// Protect the variable by including it within a function that then calls another
let add_v3 = (function(){
    let counter = 0;
    return function(){
        counter += 1;
        return counter;
    }
}());