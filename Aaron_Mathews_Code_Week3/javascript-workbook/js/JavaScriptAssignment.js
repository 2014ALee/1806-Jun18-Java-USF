//set hyperlinks
document.getElementsByName('google')[0].setAttribute('href', 'https://google.com');
document.getElementsByName('twitter')[0].setAttribute('href', 'https://twitter.com');
document.getElementsByName('slack')[0].setAttribute('href', 'https://slack.com');
document.getElementsByName('javadocs')[0].setAttribute('href', 'https://docs.oracle.com/javase/10/');


//disable pluto
let planetSelect = document.getElementById('planet');
disablePlanet(planetSelect);

function disablePlanet(op) {
    for (let i = 0; i < op.length; i++) {
        if (op[i].value === 'Pluto') {
            op[i].disabled = true;
        }
    }
}

function alienText(e) {
    if (e.target.value != 'Earth'){
        document.getElementsByTagName('p')[5].removeAttribute('hidden');
    }
}
//document.getElementById('planet').setAttribute('onchange', 'if (this.selectedIndex != 0) alienText()');
document.getElementById('planet').addEventListener('change', alienText);

//Add table entry on submit
document.getElementById('form-sub').addEventListener('click', addEntry);

function addEntry() {
    let fname = document.getElementById('firstname').value;
    let lname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let bday = document.getElementById('bday').value;
    let gender = checkedGender(document.getElementsByName('gender'));
    let fcolor = document.getElementById('color').value;
    let factivity = checkedAct(document.getElementsByClassName('activity'));

    if (!checkName(fname)) {
        alert("First name must be at least 2 letters.");
        return;
    }else if (!checkName(lname)) {
        alert("Last name must be at least 2 letters.");
        return;
    }else if (checkedGender === '') {
        alert("Please select a gender.");
        return;
    }else if (!validEmail(email)) {
        alert('Please enter valid email');
        return;
    }else if (!validPhone(phone)) {
        alert('Please enter valid phone number. ###-###-####');
        return;
    }else if (!bday) {
        alert('Please enter birthday.')
        return;
    }else {
        let entryTable = document.getElementsByClassName('table')[0];

        let row = document.createElement('tr');
        row.setAttribute('scope', 'row');

        let nameCell = document.createElement('td');
        nameCell.innerText = fname;
        row.appendChild(nameCell);

        let emailCell = document.createElement('td');
        emailCell.innerText = email;
        row.appendChild(emailCell);

        let phoneCell = document.createElement('td');
        phoneCell.innerText = phone;
        row.appendChild(phoneCell);

        let bdayCell = document.createElement('td');
        bdayCell.innerText = bday;
        row.appendChild(bdayCell);

        let colorCell = document.createElement('td');
        colorCell.innerText = fcolor;
        row.appendChild(colorCell);

        let genderCell = document.createElement('td');
        genderCell.innerText = gender;
        row.appendChild(genderCell);

        let activityCell = document.createElement('td');
 
        let ul = document.createElement('ul');
        activityCell.appendChild(ul)
        for (let i = 0; i < factivity.length; i++) {
            let actList = document.createElement('li')
            actList.innerText = factivity[i].value;
            ul.appendChild(actList);
        }
        row.appendChild(activityCell)

        entryTable.appendChild(row);
    } 
}

function checkedGender(choice) {
    let gender = '';
    for (let i = 0; i < choice.length; i++) {
        if (choice[i].checked) {
            gender = choice[i].value;
        }
    }
    return gender;
}

function checkedAct(activities) {
    let checked = [];
    for (let i = 0; i < activities.length; i++) {
        if (activities[i].checked) {
            checked.push(activities[i]);
        }
    }
    return checked;
}

function validEmail(email) {
    let regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (regularExpression.test(email)) {
        return true;
    }
    return false;
}

function validPhone(phone) {
    let regularExpression = /^\d{3}-\d{3}-\d{4}$/
    if (regularExpression.test(phone)) {
        return true;
    }
    return false;
}

function checkName(name) {
    if (name.length < 2) {
        return false;
    }
    return true;
}

//Open details when mouse is over
let details = document.getElementsByTagName('details')[0];
details.addEventListener('mouseover', function (e) {
    details.setAttribute('open', 'true');
});

details.addEventListener('mouseout', function (e) {
    details.removeAttribute('open');
});

let spans = document.getElementsByTagName('span');
console.log(concatSpans(spans));

function concatSpans(spans) {
    let spanString = '';
    for (let i = 0; i < spans.length; i++) {
        let thisSpan = spans[i].innerHTML;
        spanString += thisSpan;
    }
    return spanString;
}

//Display earth time
document.getElementById('earth_time_check').addEventListener('click', function() {
    let timestamp = new Date();
    document.getElementById('earth_time').innerHTML = timestamp;
})

//Mars time with time difference
document.getElementById('mars_time_check').addEventListener('click', function () {
    let timeDifference = new Date() / 1.88219178082;
    let timestamp = new Date(timeDifference);
    document.getElementById('mars_time').innerHTML = timestamp;
})

//Alpha Centauri b time
document.getElementById('acb_time_check').addEventListener('click', function () {
    let acburl = 'http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json';
    fetch(acburl).then((resp) => {
        return resp.json();}).then((data) => {
        let period;
        let exoArr = data.exoplanets;
        for (let i = 0; i < exoArr.length; i++) {
            var obj = exoArr[i];
            for (let key in obj) {
                if (key === 'per')
                period = obj[key]; 
            }
        }
        let prop = period / 365;
        let timeDifference = new Date() / prop;
        let timestamp = new Date(timeDifference);
        document.getElementById('acb_time').innerHTML = timestamp;
    })
});

//Change background color

function randomColor() {
    return "#"+((1<<24)*Math.random()|0).toString(16);
}
function waitthreeseconds() {
    return new Promise(resolve => setTimeout(resolve, 3000));
}
document.getElementsByTagName('span')[0].addEventListener('click', async function () {
    let color = randomColor();
    await waitthreeseconds();
    if (color != '#000000') {
        document.body.style.backgroundColor = color;
    }
});

//Display operation
document.getElementById('n2').addEventListener('change', function () {
    let num1 = parseFloat(document.getElementById('n1').value);
    let num2 = parseFloat(document.getElementById('n2').value);
    let operation = document.getElementById('operation');
    console.log(operation.value);
    console.log(num1);
    console.log(num2);
    let result;

    if (isNaN(num1) || isNaN(num2)) {
        return;
    }

    if (operation.value == 'Add') {
        result = num1 + num2;
    } else if (operation.value == 'Subtract') {
        result = num1 - num2;
    } else if (operation.value == 'Divide') {
        result = num1 / num2;
    } else if (operation.value == 'Multiply') {
        result = num1 * num2;
    }
    document.getElementById('result').innerHTML = result;
});

function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
 }

 walkTheDOM(document.body, function (node) {
//    console.log(node.nodeType);
 });

