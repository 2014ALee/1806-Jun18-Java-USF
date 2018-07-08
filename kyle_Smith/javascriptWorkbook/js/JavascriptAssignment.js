// Part 2: Interacting with the DOM

// Working with the “js-part2.html” file, include solutions in an external JavaScript file named 
// “JavaScriptAssignment.js” for the following:
// Make each link direct the user to its respective website (see id)
let links = document.getElementsByTagName('a');
 links[0].setAttribute('href', 'http://www.google.com');
 links[1].setAttribute('href', 'http://www.twitter.com');
 links[2].setAttribute('href', 'http://www.slack.com');
 links[3].setAttribute('href', 'http://www.javadocs.com');

// Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
document.getElementById('planet').options[3].disabled = true;

// Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than 
//Earth is selected, execute this function.
function alienText(e){
    let val = e.target.value;
    let p = document.getElementsByTagName('p');
    console.log(val);
    if (e.target.value != 'Earth')
        p[5].hidden = false;
    else
        p[5].hidden = true;
}
document.getElementById('planet').addEventListener('change', alienText);

// When the submit button is pressed, get the values from all of the input into a new row in the table below.  
//Make sure no input is empty, check that first and last name are at least two letters each. 
//Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.
function isEmail(string){
    var VAL = string;
    let regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    if (regularExpression.test(VAL)) {
        return true;
    }else{
        return false;
    }
};
function isPhone(string){
    var VAL = string;
    let regularExpression = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/
    if (regularExpression.test(VAL)) {
        return true;
    }else{
        return false;
    }
};

$('#form-sub').click(getVals);
function getVals(event){
    let data = document.getElementsByTagName('input');
    if($('#firstname').val().length < 3 || $('#lastname').val().length < 3 || (!(isEmail($('#email').val()))) || $('#email').val().length < 1 || (!(isPhone($('#phone').val()))) || $('#phone').val().length < 1 || $('#bday').val()< 1){
        alert('Invalid fields please fix.');
    }else{
        var input = document.getElementsByTagName("input");
        var inputList = Array.prototype.slice.call(input);
        let tableRef = document.getElementsByTagName('table')[0].getElementsByTagName('tbody')[0]
        let newRow   = tableRef.insertRow(tableRef.rows.length);
        let name = newRow.insertCell(0).appendChild(document.createTextNode(inputList[0].value + ' '+ inputList[1].value));
        let email = newRow.insertCell(1).appendChild(document.createTextNode(inputList[2].value));
        let Phone = newRow.insertCell(2).appendChild(document.createTextNode(inputList[3].value));
        let birthdate = newRow.insertCell(3).appendChild(document.createTextNode(inputList[4].value));
        let favColor = newRow.insertCell(4).appendChild(document.createTextNode(inputList[8].value));
        let sex = document.createTextNode(inputList[7].value);
        if(inputList[5].checked){
            sex = document.createTextNode(inputList[5].value);
        }else if(inputList[6].checked){
            sex = document.createTextNode(inputList[6].value);
        }
        let gender = newRow.insertCell(5).appendChild(sex);
        let nodeUl = document.createElement("ul");
        
        if(inputList[9].checked){
            let nodeLi9 = document.createElement("li");
            nodeLi9.appendChild(document.createTextNode(inputList[9].value));
            nodeUl.appendChild(nodeLi9);
        }
        if(inputList[10].checked){
            let nodeLi10 = document.createElement("li");
            nodeLi10.appendChild(document.createTextNode(inputList[10].value));
            nodeUl.appendChild(nodeLi10);
        }
        if(inputList[11].checked){
            let nodeLi11 = document.createElement("li");
            nodeLi11.appendChild(document.createTextNode(inputList[11].value));
            nodeUl.appendChild(nodeLi11);
        }
        if(inputList[12].checked){
            let nodeLi12 = document.createElement("li");
            nodeLi12.appendChild(document.createTextNode(inputList[12].value));
            nodeUl.appendChild(nodeLi12);
        }
        newRow.insertCell(6).appendChild(nodeUl);
    }
}

// Create a function openDetails() which opens the details element. 
//Invoke this function when the details’ summary is moused over. 
//The details should be hidden when the mouse is removed from the summary.

document.getElementsByTagName('summary')[0].addEventListener('mouseover', openDetails);
document.getElementsByTagName('summary')[0].addEventListener('mouseout', () => document.getElementsByTagName('details')[0].open = false);
function openDetails(){
    document.getElementsByTagName('details')[0].open = true;
}



// Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.

function conCatSpan(){
    let spans = document.getElementsByTagName('span');
    let results ='';
    let spanList = Array.prototype.slice.call(spans);
    spanList.forEach((value, index, obj) => results+=value.innerHTML);
    console.log(results);
}
conCatSpan();


// Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when 
//“Earth time” button is clicked. 

$('#earth_time_check').click(earthTime);

function earthTime(){
    let currentDate = new Date(),
      hours = currentDate.getHours(),
      minutes = currentDate.getMinutes(),
      seconds = currentDate.getSeconds();
    document.getElementById('earth_time_check').innerHTML = (hours + ':' + minutes + '.' + seconds)
}



// Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri b if the onset of 
//January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. 
//An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri b. 
//(try http://www.astropical.space/astrodb/apiref.php) Provide an implementation for getting this value using both 
//AJAX and the fetch API.






// Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to 
//a random color. Make sure this color is never black so we can still read our black text! 
//(there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just 
//accomodate for a black background)
document.getElementsByTagName('h1')[0].addEventListener('click', randomBgNotBlack);
function randomBgNotBlack() {
    let r = Math.floor(Math.random() * 256);
    let g = Math.floor(Math.random() * 256);
    let b = Math.floor(Math.random() * 256);
    let notBlackBG = 'rgb(' + r + ',' + g + ',' + b + ')';
    if (r== 0 && g== 0 && b == 0)
        randomBgNotBlack();
    else{
        setTimeout(() => (document.body.style.background = notBlackBG), 3000);
    }
}

// When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. 
//Display the result in the element with id result.
document.getElementById('operation').addEventListener('change', operations);
function operations(){
    let result = 0;
    if($('#operation').val() == 'Add' && (!(isNaN($('#n1').val())))  && (!(isNaN($('#n2').val())))){
        result = parseInt($('#n1').val()) + parseInt($('#n2').val());
    }else if ($('#operation').val() == 'Subtract' && (!(isNaN($('#n1').val())))  && (!(isNaN($('#n2').val())))){
        result = parseInt($('#n1').val()) - parseInt($('#n2').val());
    }else if ($('#operation').val() == 'Divide' && (!(isNaN($('#n1').val())))  && (!(isNaN($('#n2').val())))){
        result = parseInt($('#n1').val()) / parseInt($('#n2').val());
    }else if ($('#operation').val() == 'Multiply' && (!(isNaN($('#n1').val())))  && (!(isNaN($('#n2').val())))){
        result = parseInt($('#n1').val()) * parseInt($('#n2').val());
    }
    document.getElementById('result').innerText = result;
}







// Define function walkTheDom(node, func)
// 	This function should traverse every node in the DOM. 
// 	Use recursion. On each node, calle func(node).
