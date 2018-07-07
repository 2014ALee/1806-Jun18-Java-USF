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