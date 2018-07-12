/*
    Introduction to TypeScript
    Section 1: TS vs JS (Transpilation & Data Types)
*/
function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
    //compilation error in TS, transpiles fine to JS ('i' is declared using 'var')
    console.log('Finally: ' + i);
}
/*
    TS looks at the first value given to the declared variable and associates it with
    that data type. If we try to assign the variable to a value of a different type
    we will see a compilation error. However, since this is valid JS code: the TS
    compiler will still transpile this into a JS file (although it prints an error on
    the console).
*/
var counter = 5; // hovering over the word 'count' will show the assigned data type: 'number' 
counter = 'a';
/*
    Declared variables that are not initialized upon declaration are given a data type of
    'any'. Variables declared this way will not generate any compilation errors when assigned
    to values of varying data types.
*/
var x; // hovering over 'a' we can see that uninitialized variables are of type 'any'
x = 9; // no compilation error
x = false; // no compilation error
x = 'Hello!'; // no compilation error
/*
    Using type annotations we can declare our variables and their types without having to
    initialize the with a value first. It is recommended that you use type assertions when
    you know that a variable will only be used for one data type. Otherwise, if the variable
    is uninitialized when declared, it will be of type 'any' and IntelliSense will not be as
    helpful when determining the properties and functions associated with a given variable.

    There is a way around this though, using type assertions we can essentially cast our
    variable as a specific type, allowing IntelliSense to give us appropriate properties and
    functions. There are two ways of asserting types: using angle brackets or the 'as' keyword.
    Both methods are shown below.

    It is important to note that using type assertions does not change the data type of the
    variable at run time, only at compile time so that we can make use of the extra tooling
    of IntelliSense.
*/
var myNum;
myNum = 1; // no compilation error
myNum = true; // compilation error!
myNum = 'a'; // compilation error!
var message;
message = 'abc';
var endsWithC = message.endsWith('c'); // type assertion (method 1)
var endsWithD = message.endsWith('d'); // type assertion (method 2)
/*
    TypeScript Data Types
*/
var m;
var n;
var o;
var p;
/*
    Symbols were introduced in ECMA2015. All symbols are created using the Symbol
    constructor (note that the 'new' keyword is not used). Symbols are unique and
    immutable. Just like strings, symbols can be used as keys for object properties.
    Symbols can also be combined with computed property declarations to declare
    object properties and class members.

    Resource: https://www.typescriptlang.org/docs/handbook/symbols.html
*/
var q = Symbol('key');
/*
    Functions that do not have a return value (meaning that the 'return' keyword is
    never used) are given a return type of 'void'.
*/
function myVoidFunction() {
    console.log('This function has a return type of "void"');
}
var r;
var s;
var t;
/*
    Below is an example of a function that never returns. The body of the function
    expression consists of an infinite loop that doesn't contain any break or return
    statements. There's no way to break out of the loop, given that console.log
    doesn't throw. Therefore, never is inferred for the function's return type.
*/
var RICK_ROLL = function () {
    while (true) {
        console.log("Never gonna give you up");
        console.log("Never gonna let you down");
        console.log("Never gonna run around and desert you");
        console.log("Never gonna make you cry");
        console.log("Never gonna say goodbye");
        console.log("Never gonna tell a lie and hurt you");
    }
};
/*
    Another case where the never type is inferred is within type guards that are
    never true. In the following example, we check whether the value parameter is
    both a string and a number, which is impossible:
*/
function neverTrue(value) {
    // the conditional here makes it impossible to enter this if block.
    if (typeof value === "string" && typeof value === "number") {
        value; // Type never
    }
}
/*
    We can also declare arrays of most of these types by including square brackets
    after the data type declaration.
*/
var u = [1, 2, 3, 4, 5];
var v = ['Hi', 'my', 'name', 'is', 'Slim', 'Shady'];
var w = [1, true, 'a', { name: 'John' }, [1, 2, 5], function () {
        console.log('A function in an array!');
    }
];
/*
    Another data type supported by TS is the Enum data type. This data type is helpful
    if you find yourself working with a related set of constants, such as colors.
*/
var Colors;
(function (Colors) {
    Colors[Colors["RED"] = 0] = "RED";
    Colors[Colors["GREEN"] = 1] = "GREEN";
    Colors[Colors["BLUE"] = 2] = "BLUE";
})(Colors || (Colors = {}));
;
var background = Colors.RED;
/*
    Another concept that is necessary to understand when using TS to write nG applications
    is arrow functions. In JS we can declare a function like this:
*/
var log = function (message) {
    console.log(message);
};
/*
    In TS, we can accomplish the same thing in a shorter syntax using arrow functions.
    This concept is the same as lambda functions in other languages such as Java and C#.
*/
var doLog = function (message) { return console.log(message); };
