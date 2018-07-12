/*
    Closures
        Closures are functions that are nested inside of other functions. Closures are
        an effective way of employing encapsulation in JS, as it can be used to hide
        variables so that they cannot be accessed directly, by other parts of the script.
*/
// var location = 'http://www.google.com'; // will direct to google instead
// Iniiate a counter
let counter = 0;

// Function to increment our coutner
function add(){
    return counter += 1
};

// Call add() 3times
add();
add();
add();

console.log(counter);

// Protecting the counter by including it in the function
function add_v2(){
    let counter = 0;
    counter += 1;
    return counter;
}

function myFunction(){
    let myParagraph = document.getElementById("myValue");
    myParagraph.innerHTML = add_v3();
}

// Protecting the counter by including it within a function that then calls another
let add_v3 = (function() {
    let counter = 0;
    return function() {
        counter += 1;
        return counter;
    }
}());