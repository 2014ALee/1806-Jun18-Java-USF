//Q1
setLinks();
function setLinks(){
    let gLink = document.getElementsByName('google')[0];
    let tLink = document.getElementsByName('twitter')[0];
    let sLink = document.getElementsByName('slack')[0];
    let jLink = document.getElementsByName('javadocs')[0];

    gLink.setAttribute('href','https://www.google.com');
    tLink.setAttribute('href', 'https://www.twitter.com');
    sLink.setAttribute('href', 'https://www.slack.com');
    jLink.setAttribute('href', 'https://www.javadocs.com');
}

//Q2
disablePluto();
function disablePluto(){
    let getList = document.getElementsByTagName('option');
    for(let i = 0; i < getList.length; i++){
        if(getList[i].innerText == 'Pluto'){
            getList[i].disabled = true;
        }
    }
    
}

//Q3
document.getElementById('planet').addEventListener('click',alienText);
function alienText(){
    let theSelection = document.getElementById('planet');
    if(theSelection.value != 'Earth'){
            let theText = document.getElementsByTagName('p');
    for(let i = 0; i < theText.length; i++){
        if(theText[i].hasAttribute('hidden')){
            theText[i].removeAttribute('hidden');
        }
        else{
            theText[i].setAttribute('hidden',true);
        }
    }
    }
   }

//Q4
document.getElementById('form-sub').addEventListener('click', submit) 
function submit(){
    let theGroup = document.getElementsByClassName('form-group')[0];
    let theInputs = theGroup.getElementsByTagName('input');
    let theFields = new Array;
    // let phoneRegex = /^\(?([0-9]{3})\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$/;
    // let emailRegex = /.@\w+\.\w+/;
    // if (!phoneRegex.test(theFields[2])||!emailRegex.test(theFields[3])){
    //     document.getElementById('form-sub').setAttribute('disabled', true);
    // }
    // else{
    //     document.getElementById('form-sub').removeAttribute('disabled');
    // }
    for(let i = 0; i < theInputs.length; i++){
        theFields.push(theInputs[i].value);
    }
    let selectedGender = document.getElementsByName('gender').value;
    for(let i = 5; i < 8; i++){
        console.log(theInputs[i].checked);
         if(theInputs[i].checked){
            selectedGender = theInputs[i].value;
         }
     }
     let selectedActivities = document.createElement('ul');
     for(let i = 9; i < theFields.length; i++){
         console.log(theInputs[i].checked);
         if(theInputs[i].checked){

            checkedActivity = document.createElement('li');
            let textNode = document.createTextNode(theFields[i].value);
            checkedActivity.appendChild(textNode);
             selectedActivities.appendChild(checkedActivity);
         }
     }
    let row = document.createElement('tr');
    let cell1 = document.createElement('td');
    let cell2 = document.createElement('td');
    let cell3 = document.createElement('td');
    let cell4 = document.createElement('td');
    let cell5 = document.createElement('td');
    let cell6 = document.createElement('td');
    let cell7 = document.createElement('td');
    document.getElementsByTagName('tbody')[0].appendChild(row);
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    console.log(theFields);
    cell1.innerText = theFields[0];
    cell2.innerText = theFields[2];
    cell3.innerText = theFields[3];
    cell4.innerText = theFields[4];
    cell5.innerText = theFields[8];
    cell6.innerText = selectedGender;
    cell7.innerHTML = selectedActivities.innerHTML;
}

//Q5
document.getElementsByTagName('summary')[0].addEventListener('mouseover',openDetails);
function openDetails(){
    document.getElementsByTagName('details')[0].setAttribute('open',true);
}
document.getElementsByTagName('summary')[0].addEventListener('mouseout',closeDetails);
function closeDetails(){
    document.getElementsByTagName('details')[0].removeAttribute('open');
}

//Q6
spanAdder();
function spanAdder(){
    let theSpans = document.getElementsByTagName('span');
    let concattedArray = '';
    for (let i = 0; i < theSpans.length; i++){
       concattedArray= concattedArray.concat(theSpans[i].innerHTML);
    }
    console.log(concattedArray);
}

//Q7
document.getElementById('earth_time_check').addEventListener('click',earthTimeButton);
function earthTimeButton(){
    let etCheck = new Date();

    document.getElementById('earth_time').innerHTML = etCheck;
}

//Q8
//Fetch
// function fetchAPI(){
// function fetchInfo() {
//     console.log('in fetchInfo');

//     let id = idField.value;
//     let category = selectField.value;
//     createResultsContainer(category);
// }
// fetch(`http://www.astropical.space/astrodb/apiref.php`).then((resp) => {
//     if(category == 'people') {
//         resp.json().then((jedi) => {
//             processPeopleFetch(jedi);
//         })
//     }
// }).catch(
//     $('#name').html('Invalid character id!')    
// );

// function getInfo() {
// console.log('in getInfo');

// // Get the value of the input field
// let id = idField.value;

// // Get the value of the select field
// let category = selectField.value;
// }
// }

// function AJAX(){
//     let xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         console.log(xhr.readyState);

//         if (xhr.readyState == 4 && xhr.status == 200) {
//             if (category == 'people') {
//                 processPeopleResponse(xhr);
//             } else if (category == 'planets') {
//                 processPlanetResponse(xhr);
//             } else if (category == 'starships') {
//                 processStarshipResponse(xhr);
//             }
//         }
//         xhr.open('GET', `http://www.astropical.space/astrodb/apiref.php`, true);
//         xhr.send();
//     }

    
// }

//Q9
document.getElementsByTagName('h1')[0].addEventListener('click',pause);
function pause(){
    setTimeout(changebackground, 3000);
}
function random(){
    return Math.floor((Math.random()*200+55));
}
function changebackground(){
    setTimeout(changebackground, 3000);
    let color = 'rgb(0,0,0)';
    color = color.replace('0',random());
    color = color.replace(',0,',','+random()+',');
    color = color.replace('(0)',random()+')');

    document.body.style.backgroundColor = color;
}

//Q10
document.getElementById('operation').addEventListener('blur',calculator)
//calculator();
function calculator(){
    let num1 = document.getElementById('n1').value;
    let num2 = document.getElementById('n2').value;
    if((num1 == '') && (num2 == '')){
        console.log('in the if statement');
        return 'Bad input'
    }
    else if(isNaN(num1) == false &&isNaN(num2)==false){
        console.log('in the else if statement');
        let operation = document.getElementById('operation').value;
        let result = 0;
        switch(operation){
            case 'Add':
            result = num1 + num2;
            break;
            case 'Subtract':
            result = num1 - num2;
            break;
            case 'Multiply':
            result = num1 * num2;
            break;
            case 'Divide':
            result = num1/num2;
            break;
            default:
            result = 'Invalid Operation'
        }
        document.getElementById('result').innerHTML = result;
    }
    else{
        return 'bad input';
    }
}

//Q11