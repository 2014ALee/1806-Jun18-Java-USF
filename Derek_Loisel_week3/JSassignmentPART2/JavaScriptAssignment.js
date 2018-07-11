//QUESTION 1: Make each link direct the user to its respective website.

let googleLink = document.getElementsByName('google');
googleLink[0].innerHTML = 'Google';
googleLink[0].href = 'http://www.google.com/';

let twitterLink = document.getElementsByName('twitter');
twitterLink[0].innerHTML = 'Twitter';
twitterLink[0].href = 'http://www.twitter.com/';

let slackLink = document.getElementsByName('slack');
slackLink[0].innerHTML = 'Slack';
slackLink[0].href = 'http://www.slack.com/';

let javadocsLink = document.getElementsByName('javadocs');
javadocsLink[0].innerHTML = 'JavaDocs';
javadocsLink[0].href = 'http://www.javadocs.com/';


//QUESTION 2: Disable the Pluto Planet of Residency option.

let planetSelect = document.getElementById('planet');
planetSelect.options[3].disabled = true;


//QUESTION 3: Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.
let hiddenTag = document.getElementById('alienmessage');

let alienText = function(){
    if(planetSelect.options[ planetSelect.selectedIndex ].innerHTML == 'Earth'){
        hiddenTag.hidden = true;
    }else{
        hiddenTag.hidden = false;
    }
}

planetSelect.addEventListener('change', alienText);


//QUESTION 4: When the submit button is pressed, get the values from all of the input into a new row in the table below.  
//Make sure no input is empty, check that first and last name are at least two letters each. 
//Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.

let addRow = function(){

    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let birthday = document.getElementById('bday').value;
    let favoriteColor = document.getElementById('color').value;
    let gender = document.getElementsByName('gender');
    let activities = document.getElementsByClassName('activity');

//validate input
    //first and last name greater than 2 characters
    if(firstname.length < 2 || lastname.length < 2){
        alert('name must be atleast 2 characters long');
        return;
    }
    //test the email using a regular expression
    let regularEmailExpression = /^([a-zA-Z0-9_\.\-+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!regularEmailExpression.test(email)){
        alert('invalid email');
        return;
    }
    //test the phone format using a regular expression
    let regularPhoneExpression = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    if(!regularPhoneExpression.test(phone)){
        alert('invalid phone number');
        return;
    }
    //test for empty birthday input
    if (birthday == ''){
        alert('please enter a value in the empty field');
        return;
    }
    //make sure a gender radio is selected
    let genderSelected = false;
    for(let i = 0; i < gender.length; i++){
        if(gender[i].checked == true){
        genderSelected = true;
        }
    }
    if(!genderSelected){
        alert('please select a gender type');
        return;
    }
    //make sure an activity checkbox is checked
    let activitySelected = false;
    for(let i = 0; i < activities.length; i++){
        if(activities[i].checked == true){
        activitySelected = true;
        }
    }
    if(!activitySelected){
        alert('please select atleast 1 activity');
        return;
    }

//create new row
    let row = document.createElement('tr');
    //create cells for row
    let cell1 = document.createElement('td');
    let cell2 = document.createElement('td');
    let cell3 = document.createElement('td');
    let cell4 = document.createElement('td');
    let cell5 = document.createElement('td');
    let cell6 = document.createElement('td');
    let cell7 = document.createElement('td');

    //create a ul for the activities.  Only add list items if and when the activity is chosen
    let actList = document.createElement('ul');
    //append the list to the cell
    cell7.appendChild(actList);

    //append cells to row
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);

    // append the row to the table
    document.getElementById('table1').appendChild(row);

 // add info to the new cells
    cell1.innerText = firstname;
    cell2.innerText = email;
    cell3.innerText = phone;
    cell4.innerText = birthday;
    cell5.innerText = favoriteColor;
    //loop through the node object to check each gender radio
    for(let i = 0; i < gender.length; i++){
        if(gender[i].checked == true){
            cell6.innerText = gender[i].value;
        }
    }
    //i need to create a ul and an li and append it to the ul for every activity that exists
    if(activities[0].checked == true){
        //create and append li for the list
        let item1 = document.createElement('li');
        actList.appendChild(item1);
        item1.innerText = activities[0].value;
    }
    if(activities[1].checked == true){
        //create and append li for the list
        let item2 = document.createElement('li');
        actList.appendChild(item2);
        item2.innerText = activities[1].value;
    }
    if(activities[2].checked == true){
        //create and append li for the list
        let item3 = document.createElement('li');
        actList.appendChild(item3);
        item3.innerText = activities[2].value;
    }
    if(activities[3].checked == true){
        //create and append li for the list
        let item4 = document.createElement('li');
        actList.appendChild(item4);
        item4.innerText = activities[3].value;
    }

    //clear input fields
    document.getElementById('firstname').value = '';
    document.getElementById('lastname').value = '';
    document.getElementById('email').value = '';
    document.getElementById('phone').value = '';
    document.getElementById('bday').value = '';  
    document.getElementById('color').value = '#000000';
    for(let i = 0; i < gender.length; i++){
        if(gender[i].checked == true){
        gender[i].checked = false;
        }
    }
    for(let i = 0; i < activities.length; i++){
        if(activities[i].checked == true){
        activities[i].checked = false;
        }
    }
}
let submitButton = document.getElementById('form-sub');
submitButton.addEventListener('click', addRow);


//QUESTION 5:	Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. 
//The details should be hidden when the mouse is removed from the summary.

let detailsTag = document.getElementById('detail');

let openDetails = function(){   
    detailsTag.open = true;
}
let closeDetails = function(){
    detailsTag.open = false;
}
detailsTag.addEventListener('mouseover', openDetails);
detailsTag.addEventListener('mouseout', closeDetails);


//QUESTION 6: Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.

let spans = document.getElementsByTagName('span');
let str = '';

for (let i = 0; i < spans.length; i++){
    str += spans[i].innerHTML;
}
str += '..lol';
console.log(str);


//QUESTION 7: Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked. 
earthDate = new Date();
let earthTimeButton = document.getElementById('earth_time_check');
let earthTimeHeader = document.getElementById('earth_time');

let displayEarthTime = function(){
    //toggle the earth time when button is clicked
    if(earthTimeHeader.innerHTML == ''){
    earthTimeHeader.innerHTML = earthDate;
    }else{
        earthTimeHeader.innerHTML = '';
    }
}
earthTimeButton.addEventListener('click', displayEarthTime);


//QUESTION 8: Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri b if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri b. (try 15.	http15.	://15.	www15.	.15.	astropical15.	.15.	space15.	/15.	astrodb15.	/15.	apiref15.	.15.	php) Provide an implementation for getting this value using both AJAX and the fetch API.

let currentDate = new Date();
let currentYear = currentDate.getFullYear();
let currentMonth = currentDate.getMonth();
let currentDay = currentDate.getDate();

let startYear = 1970;
let startMonth = 0;
let startDay = 0;
//get the amount of time since jan 1970 to now
let yearsFromStartToNow = (currentYear - startYear)+ ((currentMonth + 1)/12) + (currentDay/365);

//set the date on mars
let martsTimeHeader = document.getElementById('mars_time');

let marsDate = function(){
    //(365/orbital period) * time passed from now till jan 1 1970 --- mars = 91 years and 4 months --- jan 1970 + 91 years and 4 months = april 2061
    let orbitalPeriod = 687;
    let marsYearsFromStart = (365/orbitalperiod) * yearsFromStartToNow;
    
    //convert the full years decimal into years, months, and days (gross, could have just used getTime and setTime to get miliseconds and convert back to date)
    let yearsDecimalAsString = (1970 + marsYearsFromStart).toString();
    let dateSplit = yearsDecimalAsString.split('.');
    let marsYear = dateSplit[0];

    let daysOutOfYear = ("." + dateSplit[1]) * 365;
    let monthsDecimal = (daysOutOfYear / 30).toString().split('.');
    let marsMonth = monthsDecimal[0];
    let marsDay = ('.' +monthsDecimal[1]) * 30;

    let fullMarsDate = new Date();
    fullMarsDate.setFullYear(marsYear, marsMonth-1, marsDay);

    if(martsTimeHeader.innerHTML == ''){
        martsTimeHeader.innerHTML = fullMarsDate;
    }else{
        martsTimeHeader.innerHTML = '';
    }
}
document.getElementById('mars_time_check').addEventListener('click', marsDate);


//AJAX
let acbTimeHeader = document.getElementById('acb_time');

let getAcbOrbitalPeriod = function(){

    const acbUrl = 'http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B&format=json'; 
    sendAjaxRequest(acbUrl, displayAlphaCentauribTime);
}

let xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest');

let sendAjaxRequest = function(url, funct){

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            funct(xhr);
        }
    }

    xhr.open('GET', url, true);
    xhr.send();

}

let displayAlphaCentauribTime = function(){

    let acb = JSON.parse(xhr.response);

    let date = new Date();
    let time = date.getTime();

    //calculate date
    let acbOrbitalPeriod = (acb['exoplanets'][0]['per']);
    let acbTimeCalculation = acbOrbitalPeriod * time; 
    date.setTime(acbTimeCalculation);
    
    //display date
    if(acbTimeHeader.innerHTML == ''){
        acbTimeHeader.innerHTML = date;//insert date here
    }else{
        acbTimeHeader.innerHTML = '';
    }
}

let acbButton = document.getElementById('acb_time_check');
acbButton.addEventListener('click', getAcbOrbitalPeriod);

//Fetch //HELPED BY KYLE
let acbDateFromFetch = function(){
    
    fetch('http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B&format=json').then((resp) => {      
            resp.json().then((planet) => {
                
                let date = new Date();
                let time = date.getTime();

                let acbPeriod = (planet['exoplanets'][0]['per']);
                let acbTimeCalculation = acbPeriod * time;
                date.setTime(acbTimeCalculation);
                alert('The Alpha Centauri b time from Fetch is: ' + date);
            })       
    }).catch();
}
acbButton.addEventListener('click', acbDateFromFetch);

//QUESTION 9:	Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color. 
//Make sure this color is never black so we can still read our black text! 
//(there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)
let mainHeading = document.getElementsByTagName('h1');

let randomColor = function() {
    //create a random rgb color string to change background color
    var x = Math.floor(Math.random() * 256);
    var y = Math.floor(Math.random() * 256);
    var z = Math.floor(Math.random() * 256);
    var bgColor = "rgb(" + x + "," + y + "," + z + ")";
    //make sure the color isn't black
    if(bgColor != 'rgb(0,0,0)'){
        document.body.style.background = bgColor;
    }else{
        //get new color if black was chosen
        randomColor();
    }
}

let changeBackground = function(){
    //set a 3 second timer before calling the random color function to change background
    setTimeout ( randomColor, 3000 );
}

mainHeading[0].addEventListener('click', changeBackground);


//QUESTION 10: When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.

//when the mouse moves out of either numerical input field, or a new option is chosen, perform the calculation specified in the select, as long as they have valid numerical inputs
let calculationSelect = document.getElementById('operation');
let inputOne = document.getElementById('n1');
let inputTwo = document.getElementById('n2');
let calculationResult = document.getElementById('result');

let calculate = function(){

    if(calculationSelect.options[ calculationSelect.selectedIndex ].innerHTML == 'Add'){
        //make sure both inputs have a value
        if(inputOne.value !== '' && inputTwo.value !== ''){
        calculationResult.innerHTML = parseInt(inputOne.value) + parseInt(inputTwo.value);
        }
        
    }
    if(calculationSelect.options[ calculationSelect.selectedIndex ].innerHTML == 'Subtract'){
        //make sure both inputs have a value
        if(inputOne.value !== '' && inputTwo.value !== ''){
            calculationResult.innerHTML = parseInt(inputOne.value) - parseInt(inputTwo.value);
        }
    }
    if(calculationSelect.options[ calculationSelect.selectedIndex ].innerHTML == 'Multiply'){
        //make sure both inputs have a value
        if(inputOne.value !== '' && inputTwo.value !== ''){
            calculationResult.innerHTML = parseInt(inputOne.value) * parseInt(inputTwo.value);
        }
    }
    if(calculationSelect.options[ calculationSelect.selectedIndex ].innerHTML == 'Divide'){
        //make sure both inputs have a value
        if(inputOne.value !== '' && inputTwo.value !== ''){
            calculationResult.innerHTML = parseInt(inputOne.value) / parseInt(inputTwo.value);
        }
    }
    //validate that the input has numbers
    if (inputOne.value !== '' && inputTwo.value !== ''){
        if(calculationResult.innerHTML == 'NaN'){
            inputOne.value = '';
            inputTwo.value = '';
            alert('Please enter a valid number');
        }
    } 
}

calculationSelect.addEventListener('mouseout', calculate);
inputOne.addEventListener('mouseout', calculate);
inputTwo.addEventListener('mouseout', calculate);


//QUESTION 11: Define function walkTheDom(node, func)
//This function should traverse every node in the DOM. 
//Use recursion. On each node, calle func(node).

//Code Credit to Douglas Crockford - https://www.youtube.com/watch?v=Y2Y0U-2qJMs&feature=youtu.be&t=
//commented by myself from his explanation
//example usage extended by myself

//we pass in the node that we want to start walking at, and a function to call on every node
function walkTheDOM(node, func) {
    //we start by calling our function on the first node
    func(node);
    //then we look to see if the node has a first child
    node = node.firstChild;
    //if it does, then we call walk the dom on that node
    while (node) {
        walkTheDOM(node, func);
        //then we look to see if we have a next sibling, and we keep doing this until 
        //it has gone through them all and we have called the function on all the nodes.
        node = node.nextSibling;
    }
}

// Ex:  log all the node types on the page to the console
//      log each element-type node's tag name, and log each text-type node's text
walkTheDOM(document.body, function (node) {

    nodeType = node.nodeType;
    
    if (nodeType == 1){
        nodeTagName = node.tagName;
        console.log('This is an Element node, tag name: ' + nodeTagName);
    }
    if (nodeType == 2){
        console.log('This is an Attr node');
    }
    if (nodeType == 3){
        nodeInfo = node.data.trim();
        if(nodeInfo.length > 0){
            console.log('This is Text node with text: ' + nodeInfo);
        }else{
            console.log('This is Text node without any text');
        }       
    }
    if (nodeType == 4){
        console.log('This is a CDATASection node');
    }
    if (nodeType == 5){
        console.log('This is an EntityReference node');
    }
    if (nodeType == 6){
        console.log('This is an Entity node');
    }
    if (nodeType == 7){
        console.log('This is a ProcessingInstruction node');
    }
    if (nodeType == 8){
        console.log('This is a Comment node');
    }
    if (nodeType == 9){
        console.log('This is a Document node');
    }
    if (nodeType == 10){
        console.log('This is a DocumentType node');
    }
    if (nodeType == 11){
        console.log('This is a DocumentFragment node');
    }
    if (nodeType == 12){
        console.log('This is a Notation node');
    }
});