/* 1 */
function directLinks() {
    let elements = document.getElementsByTagName('a');
    let name;

    for(let i = 0; i < elements.length; i++) {
        name = elements[i].getAttribute('name');
        elements[i].setAttribute('href',`https://www.${name}.com`);
        elements[i].innerHTML = `${name}`;
    }


}

directLinks();

/* 2 */
function disablePluto() {
    let planets = document.getElementById('planet').children;

    for(let i = 0; i < planets.length; i++) {
        if(planets[i].innerHTML == 'Pluto') {
            planets[i].disabled = true;
        }
    }
}

disablePluto();

/* 3 - alientText function */
function getHiddenText() {
    let paragraphs = document.getElementsByTagName('p');
    let hiddenText;

    for(let i = 0; i < paragraphs.length; i++) {
        if(paragraphs[i].innerHTML == 'Beep boop') {
            hiddenText = paragraphs[i];
            return hiddenText;
        }
    }
}

function alienText() {
    let planets = document.getElementById('planet');

    if(planets.selectedIndex != 0) {
        getHiddenText().hidden = false;
    } else {
        getHiddenText().hidden = true;
    }
}

let planets = document.getElementById('planet');
planets.addEventListener('click',alienText);

/* 4 */
window.onload = function () {
    firstnameField.addEventListener('blur',inputInFields);
    lastnameField.addEventListener('blur',inputInFields);
    emailField.addEventListener('blur',inputInFields);
    phoneField.addEventListener('blur',inputInFields);
    birthdayField.addEventListener('blur',inputInFields);
    planetSelect.addEventListener('blur',inputInFields);
    genderRadio.addEventListener('change',inputInFields);
    
    submitButton.setAttribute('disabled',true);

    // See 5
    details.addEventListener('mouseover',openDetails);
    details.addEventListener('mouseleave',closeDetails);

    // See 7
    earthTimeButton.addEventListener('click',earthTime);

    // See 8
    marstimeButton.addEventListener('click',marsTime);

    // See 9
    headerLocation.addEventListener('click',backgroundChange);

    // See 10
    n1Field.addEventListener('blur',calculator);
    n2Field.addEventListener('blur',calculator);
    operationSelect.addEventListener('blur',calculator);
}

function inputInFields()  {
    let firstname = firstnameField.value;
    let lastname = lastnameField.value;
    let email = emailField.value;
    let birthday = birthdayField.value;
    let planet = planetSelect.value;
    let gender = (document.querySelector('input[name=gender]:checked') || {}).value;
    console.log(gender);

    if(firstname == '' || lastname == '' || email == '' || birthday == '' || planet == '' || gender == '') {
        submitButton.setAttribute('disabled',true);
    } else {
        submitButton.removeAttribute('disabled');
    }
}

const formGroup = document.getElementsByClassName('form-group')[0];
const firstnameField = document.getElementById('firstname');
const lastnameField = document.getElementById('lastname');
const emailField = document.getElementById('email');
const phoneField = document.getElementById('phone');
const birthdayField = document.getElementById('bday');
const planetSelect = document.getElementById('planet');
const genderRadio = formGroup.querySelector('input[name=gender]:checked');
const submitButton = document.getElementById('form-sub');

/* 5 */
function openDetails(){ // Added to 4's window.onload
    details.setAttribute('open',true);
}

function closeDetails(){
    details.removeAttribute('open');
}

const details = document.getElementsByTagName('details')[0];

/* 6 */
function spanToConsole() {
    let spans = document.getElementsByTagName('span');
    let innerHTMLs = [];
    let alternate;

    // Not sure if as an array or as a string. Did both.
    for(let i = 0; i < spans.length; i++) {
        innerHTMLs = innerHTMLs.concat(spans[i].innerHTML);
    }

    innerHTMLs.forEach(function(inner) {
        console.log(inner);
    });

    alternate = innerHTMLs.reduce( (string,current) => string.concat(current), '');

    console.log(alternate);
}

spanToConsole();

/* 7 */
function earthTime() {  // added to 4's windows.onload
    let putTime = document.getElementById('earth_time');
    let currentTime = new Date();

    putTime.innerHTML = currentTime;
}

const earthTimeButton = document.getElementById('earth_time_check');

/* 8 */
function marsTime() { // added to 4's windows.onload
    let putTime = document.getElementById('mars_time');
    let currentTime = Date.now();
    let convertedTime = (currentTime * (1/31556926000) + 1970) * (365/687);

    putTime.innerHTML = convertedTime;
}

// TODO: Figureout API to get the correct in
// TODO: time based on distance
// function alphaCentTimeAJAX() {

// }

// function alphaCentTimeFETCH() {

// }

const marstimeButton = document.getElementById('mars_time_check');
const acbTimeButton = document.getElementById('acb_time_check');

/* 9 */
function backgroundChange(){
    setTimeout(backgroundChoosing,3000);
}

// generation from: https://www.paulirish.com/2009/random-hex-color-code-snippets/
// fourth generator is the inspriation behind my first part of the assignment being fill with maps, and Kyle
function backgroundChoosing(){
    let color = '#000000';

    while(color == '#000000') {
        color = '#'+Math.floor(Math.random()*16777215).toString(16);
    }

    document.body.style.backgroundColor = color;
}

const headerLocation = document.getElementsByTagName('h1')[0];

/* 10 */
function calculator() {  // in 4's window.onload
    let operation = operationSelect.value;
    let n1 = n1Field.value;
    let n2 = n2Field.value;
    let result = document.getElementById('result');

    if(n1 != '' && n2 != '') {
        if(validInputs(n1,n2)) {
            
            switch(operation) {
                case 'Subtract':
                    result.innerHTML = Number(n1) - Number(n2);
                    break;
                case 'Divide':
                    result.innerHTML = Number(n1) / Number(n2);
                    break;
                case 'Multiply':
                    result.innerHTML = Number(n1) * Number(n2);
                    break;
                default:
                    result.innerHTML = Number(n1) + Number(n2);
                    return;
            }
        }
    }
}

function validInputs (n1,n2) {
    let re = new RegExp('^\\d*.?\\d*$');
    let re2 = new RegExp('\\d');

    if(n1.match(re) && n2.match(re)) {
        if(n1.match(re2) && n2.match(re2)){
            return true;
        }
    }

    return false;
}

const operationSelect = document.getElementById('operation');
const n1Field = document.getElementById('n1');
const n2Field = document.getElementById('n2');

/* 11 */
function walkTheDom(node,func) {
    func(node);

    
    if(node.firstChild != null){
        walkTheDom(node.firstChild,func);
    } else if (node.nextSibling != null){
        walkTheDom(node.nextSibling,func);
    }
}

// This was a check to see if it worked.
// walkTheDom(document,(a) => console.log(a.outerHTML));