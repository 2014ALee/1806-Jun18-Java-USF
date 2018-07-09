// 1. Make each link direct the user to its respective website (see id)
let google = document.getElementsByName('google');
google[0].innerHTML = 'Google';
google[0].href = 'http://www.google.com/';

let twitter = document.getElementsByName('twitter');
twitter[0].innerHTML = 'Twitter';
twitter[0].href = 'http://www.twitter.com/';

let slack = document.getElementsByName('slack');
slack[0].innerHTML = 'Slack';
slack[0].href = 'http://www.slack.com/';

let javadocs = document.getElementsByName('javadocs');
javadocs[0].innerHTML = 'JavaDocs';
javadocs[0].href = 'http://www.javadocs.com/';


// 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
let disablePluto = document.getElementById("planet");
disablePluto.options[3].disabled = true


// 3. Define a function alienText() which shows the hidden element displaying 
// an alien message. When any planet other than Earth is selected, execute this function.
function alienText(e){
    let val = e.target.value;
    let p = document.getElementsByTagName('p');
    if (e.target.value != 'Earth')
        p[5].hidden = false;
    else
        p[5].hidden = true;
}
document.getElementById('planet').addEventListener('change', alienText);

// 4. 
/*
When the submit button is pressed, get the values from all of the input 
into a new row in the table below.  Make sure no input is empty, check that first
 and last name are at least two letters each. Validate for valid phone number and email 
 structure. This should continue to work for multiple entries and rows.
*/

// Collaborated with Derek

let addRow = function(){

    
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let birthday = document.getElementById('bday').value;
    let favoriteColor = document.getElementById('color').value;
    let gender = document.getElementsByName('gender');
    let activities = document.getElementsByClassName('activity');

//validate input
    // validate email
    let validEmail = /^([a-zA-Z0-9_\.\-+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!validEmail.test(email)){
        alert('invalid email');
        return;
    }
    //test the phone format using a regular expression
    let validPhone = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    if(!validPhone.test(phone)){
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


// 5. Create a function openDetails() which opens the details element. Invoke this function when the 
// details’ summary is moused over. The details should be hidden when the mouse is removed from the
// summary.
let detailsTag = document.getElementById('detail');
let openDetails = function(){   
    detailsTag.open = true;
}
let closeDetails = function(){
    detailsTag.open = false;
}
detailsTag.addEventListener('mouseover', openDetails);
detailsTag.addEventListener('mouseout', closeDetails);


// 6. Create a function that concatenates the inner HTML of all of the span elements and 
// prints the results to the console.
let span = document.getElementsByTagName('span');
let str = '';

for (let i = 0; i < span.length; i++){
    str += span[i].innerHTML;
}
console.log(str);

//7. Create a function that displays the current time on earth in the span with id
//  “earth_time”. Invoke this function when “Earth time” button is clicked. 
earthDate = new Date();
let earthButton = document.getElementById('earth_time_check');
let earthHeader = document.getElementById('earth_time');

let displayEarthTime = function(){
    //toggle the earth time when button is clicked
    if(earthHeader.innerHTML == ''){
    earthHeader.innerHTML = earthDate;
    }else{
        earthHeader.innerHTML = '';
    }
}
earthButton.addEventListener('click', displayEarthTime);

// 8. 


// 9. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color 
// should change to a random color. Make sure this color is never black so we can still read our black 
//text! (there are other dark colors it could change to where we also couldn’t see the text but 
// it’s enough to just accomodate for a black background)

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
