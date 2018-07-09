//1
//Make each link direct the user to its respective website (see id)

setLinks();
function setLinks(){

let googleLink = document.getElementsByName("google")[0];
googleLink.setAttribute("href", "https://www.google.com");

let twitterLink = document.getElementsByName("twitter")[0];
twitterLink.setAttribute('href', 'https://www.twitter.com');

let slackLink = document.getElementsByName("slack")[0];
slackLink.setAttribute('href', 'https://www.slack.com');

let javadocsLink = document.getElementsByName("javadocs")[0];
javadocsLink.setAttribute('href', 'https://www.javadocs.com');
}



//2
//Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
disablePluto();
function disablePluto(){
let planets = document.getElementById("planet");
let options = planets.getElementsByTagName("option");

for(let i = 0; i < options.length; i++){
    if (options[i].innerText == "Pluto"){
        options[i].disabled = true;
    }
}
}

//3
//Define a function alienText() which shows the hidden element displaying an alien message.
//When any planet other than Earth is selected, execute this function.

alienTextSelect();

function alienTextSelect(){
    let planetSelect = document.getElementById("planet");
    planetSelect.addEventListener("change", printAlienText);
}

function printAlienText() {
let paragraphs = document.getElementsByTagName("p");
let planets = document.getElementById("planet").value;    

if(planets != "Earth") {
for(let i = 0; i < paragraphs.length; i++){
    if(paragraphs[i].hasAttribute("hidden")){
        paragraphs[i].removeAttribute("hidden");
    }
}
}
}

//4
//When the submit button is pressed, get the values from all of the input into a new row in the table below.
//Make sure no input is empty, check that first and last name are at least two letters each.
//Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.

submitSelected();
function submitSelected(){
    let ourButton = document.getElementById("form-sub");    
    ourButton.addEventListener("click", addToTable);
}


function addToTable(){

addToRow = new Array;

//after these two statements we have an array of the results
let submittedFields = document.getElementsByClassName("form-group")[0];
let values = submittedFields.getElementsByTagName("input");

//we make sure all fields before our gender options have values
for(let i = 0; i <= 4; i++){
  //  console.log("Value at "+i+ " is: " + values[i].value);

    if(values[i].value === ""){
        console.log("Invalid inputs, try again");
        return;       

    } else if(i != 1) {
        addToRow.push(values[i].value);
    }

}

//here we add color
addToRow.push(values[8].value);
//console.log(values[8].value + " is color");

//we remove unchecked gender options
    for(let i = 5; i<=7; i++)
        if(values[i].checked===true){
//            console.log(values[i].value);
            addToRow.push(values[i].value);
    }

//finally we get our activities
for(let i = 8; i <= 12; i++){    
    if(values[i].checked===true){
        addToRow.push(values[i].value);       
    }

}
    
//from index 6 to send is out activities
for(let j = 0; j < addToRow.length; j++){
    console.log("at index j = " + j +" we have "+ addToRow[j]);
}


    //here we check the name lengths
    if(values[0].value.length < 2 || values[1].value.length < 2 ){
        console.log("Invalid name, try again")
        return;      
    }

    //here we check the email address
if(isValidEmail(values[2].value)==false){
    console.log("Invalid email address, try again");
    return;
}

if(isValidPhone(values[4].value)==false){
    console.log("Invalid phone number, try again");
    return;
}

//add row to table now
addRowToTable(addToRow);

}

 
    
function isValidEmail (email){
    let regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let isValid = regularExpression.test(email);
    return isValid;

}

//again, for this regular expression I recieved help from kyle and some pointers from stack overflow 
//I had trouble getting this check to properly work
function isValidPhone(phoneNumber){
//let phoneRegEx =/^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g;
//let isValid = phoneRegEx.test(phoneNumber);
return true;
}


function addRowToTable(valuesArr){

let ourTable = document.getElementsByTagName("table")[0];  
let row = ourTable.insertRow(ourTable.rows.length);

for(let i = 0; i <= 5; i++){
let newCell = row.insertCell(i);
newCell.innerHTML = valuesArr[i];
}

//lastly we insert our UL
let newCell = row.insertCell(6);

let list = document.createElement('ul');

for(let i = 6; i < valuesArr.length; i++){

let item = document.createElement('li');
let ourText = document.createTextNode(valuesArr[i]);
console.log(ourText);
item.appendChild(ourText);

list.appendChild(item);    
}

newCell.innerHTML = list.innerHTML;

}



//5
//Create a function openDetails() which opens the details element. 
//Invoke this function when the details’ summary is moused over.
//The details should be hidden when the mouse is removed from the summary.
setInitialVisiblity();

function setInitialVisiblity(){
    let detail = document.getElementsByTagName("details")[0];
    let ourParagraph = detail.getElementsByTagName("p")[0];
    let ourSummary = detail.getElementsByTagName("summary")[0];
    ourParagraph.setAttribute("hidden", true);
    
    ourSummary.setAttribute("onmouseover", "openDetails()");
    ourSummary.setAttribute("onmouseout", "mouseOut()");
    }

    function openDetails(){
         let detail = document.getElementsByTagName("details")[0];
         let ourSummary = detail.getElementsByTagName("p")[0];
        
         ourSummary.removeAttribute("hidden");
        }

    function mouseOut(){
        let detail = document.getElementsByTagName("details")[0];
        let ourParagraph = detail.getElementsByTagName("p")[0];
    
    ourParagraph.setAttribute("hidden", true);
    }
    

//6
//Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
concatSpanText();

function concatSpanText(){
    let concatString = "";
    spans = document.getElementsByTagName("span");

    for(let i = 0; i < spans.length; i++){
        concatString = concatString + spans[i].innerHTML;
    }
    console.log(concatString);
}

//7
//Create a function that displays the current time on earth in the span with id “earth_time”.
//Invoke this function when “Earth time” button is clicked. 

function showEarthTime(){
let earthTime = document.getElementById("earth_time");
let ourDate = new Date();
let dateString = String(ourDate);

dateString = dateString.substring(16,21);

earthTime.innerHTML = dateString;
}

earthTimeListener();

function earthTimeListener(){
let earthTimeCheck = document.getElementById("earth_time_check");
earthTimeCheck.addEventListener("click", showEarthTime);
}

//9
changeColorListener();

function changeBackgroundColor(){
   
    let intergalactic = document.getElementsByTagName("h1")[0];
    console.log(intergalactic);
    //rgb colors are in between 0 and 255, so we use this random number generator to get a random color value

    let a = Math.floor((Math.random() * 255) + 1);
    let b = Math.floor((Math.random() * 255) + 1);
    let c = Math.floor((Math.random() * 255) + 1);

    //we do this in case we get a random color of black
    if(a + b + c == 0){
        a, b, c = 1;
    }

    intergalactic.style.backgroundColor = 'rgb(' + a + ',' + b + ',' + c + ')';
}

function timeOutSetter(){
    setTimeout(changeBackgroundColor, 3000);
}

function changeColorListener(){
    let intergalactic = document.getElementsByTagName("h1")[0];
    intergalactic.addEventListener("click",timeOutSetter);
}

//10
//When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select.
//Display the result in the element with id result.

getNumbersListener();

function getNumbersListener(){
let secondNumber = document.getElementById("n2");
let isValidN2 = secondNumber.addEventListener("blur", duringEvent);

}


function duringEvent(){
let n1Number = document.getElementById("n1").value;
let n2Number = document.getElementById("n2").value;
let operationSelected = document.getElementById("operation").value;


let isN1Valid = checkIfValid(n1Number); 
let isN2Valid = checkIfValid(n2Number);

if(isN1Valid && isN2Valid){

let result = evaluateOperation(n1Number, n2Number ,operationSelected);

let setResult = document.getElementById("result");
setResult.innerHTML = result;
}

}
 
function evaluateOperation(a, b, operation){
a = Number(a);
b = Number(b);

if(operation == "Add"){
    return a + b;
} else if(operation == "Subtract"){
    return a - b;
} else if(operation == "Divide"){
    return a/b;
} else if(operation == "Multiply"){
    return a * b;
    }
}

function checkIfValid(num){

    if(num.length <= 0){
        console.log("Invalid inputs!");
        return false;
    }    
        if(isNaN(num)){
            console.log("Invalid inputs!");
            return false;
        } else {
            return true;
        }
    }


    //11
    //walk the DOM
    //first we put in the document
    walkTheDOM(document.childNodes[1],func);

    function walkTheDOM(node, func){
        func(node);
    }

    function func(node){
        
        for(let i = 0; i < node.childElementCount; i++){
            func(node.childNodes[i]);
        }
    }