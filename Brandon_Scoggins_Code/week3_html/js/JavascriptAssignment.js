// Part 3
function alienText() {
    if (document.getElementById('Mars').selected || document.getElementById('ProximaB').selected){
        document.getElementById('alienMessage').removeAttribute('hidden');
    }else {
        document.getElementById('alienMessage').setAttribute('hidden', true);
    }
}

document.getElementById('planet').addEventListener('change', alienText);

// Part 4
document.getElementById('form-sub').addEventListener('click', submitForm);
const alertMessage = document.getElementById('alertMessage');
alertMessage.style.display = 'none';

function submitForm() {
    let info = [];
    info.push(document.getElementById('firstname').value);
    info.push(document.getElementById('lastname').value);
    info.push(document.getElementById('email').value);
    info.push(document.getElementById('phone').value);
    info.push(document.getElementById('bday').value);
    info.push(document.getElementById('planet').value);
    info.push(document.getElementById('color').value);
    options = document.forms[0];
    for (i = 0; i < options.length; i++){
        if (options[i].checked){
            info.push(options[i].value);
        }
    }

    if (info[7] != "Male" && info[7] != "Female" && info[7] != "Other"){
        alertMessage.style.display = 'block';
        return;
    } else {
        for (i = 0; i < 8; i++){
            if (info[i].length == 0){
                alertMessage.style.display = 'block';
                return;
            }
        }
    }

    if (!phoneIsValid(info[3]) || !emailIsValid(info[2])){
        alertMessage.style.display = 'block';
        return;
    } else if (info[0].length < 2 || info[1].length < 2){
        alertMessage.style.display = 'block';
        return;
    }

    alertMessage.style.display = 'none';

    newEntry = document.getElementById('myTable').insertRow(-1);

    newEntry.insertCell(0).innerHTML = info[0];
    newEntry.insertCell(1).innerHTML = info[2];
    newEntry.insertCell(2).innerHTML = info[3];
    newEntry.insertCell(3).innerHTML = info[4];
    newEntry.insertCell(4).innerHTML = info[6];
    newEntry.insertCell(5).innerHTML = info[7]; 
    if (info.length > 8) {
        let listText = "<ul>";
        for (i = 8; i < info.length; i++){
            listText = listText + "<li>" + info[i] + "</li>";
        }
        newEntry.insertCell(6).innerHTML = listText + "</ul>";
    }
}

// Phone number regex take from https://www.w3resource.com/javascript/form/phone-no-validation.php
function phoneIsValid(phoneNumber) {
  let phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
  if(phoneNumber.match(phoneno)) {
        return true;
    } else {
        return false;
    }
}

// Email regex take from https://www.w3resource.com/javascript/form/email-validation.php
function emailIsValid(email) {
    let emailCheck = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(email.match(emailCheck)) {
          return true;
      } else {
          return false;
      }
  }

// Part 5
$(document).ready(openDetails());

function openDetails(){
    $("details").mouseenter(function(){
        $("details").attr("open", "true");
    });
    $("details").mouseleave(function(){
        $("details").removeAttr("open");
    });
}

// Part 6
$(document).ready(function() {
    spanElements = $("span").toArray();
    txt = '';
    for (i = 0; i < spanElements.length; i++){
        txt += spanElements[i].innerHTML;
    }
        console.log(txt);
});

// Part 7
$("#earth_time_check").click(function() {
    t = new Date();
    $("#earth_time").text("Earth Time: " + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds());
});

// Part 9
$(document).ready(function() {
    $("h1").on('click', function() {
        setTimeout(function() {
            $("h1").css("background-color", getRandomColor())
        }, 3000);
    });
});

// Random color generating method from https://stackoverflow.com/questions/1484506/random-color-generator
// Some parts were removed/altered to prevent bright and dark colors close to white and black
function getRandomColor() {
    letters = '789ABCD';
    color = '#';
    for (i = 0; i < 6; i++) {
      color += letters[Math.round(Math.random() * 6)];
    }
    return color;
  }

// Part 10
$("#operation").change(function(){
    if ($("#n2").val().length != 0 && $("#n1").val().length != 0){
        performOperation();
    }
});

$("#n1").change(function() {
    if ($("#n2").val().length != 0){
        performOperation();
    }
});

$("#n2").change(function() {
    if ($("#n1").val().length != 0){
        performOperation();
    }
});

function performOperation() {
    operation = document.getElementById('operation');
    result = 0;
    
    if (operation.options[operation.selectedIndex].value == "Add"){
        result = Number($("#n1").val()) + Number($("#n2").val());
    } else if (operation.options[operation.selectedIndex].value == "Subtract"){
        result = $("#n1").val() - $("#n2").val();
    } else if (operation.options[operation.selectedIndex].value == "Multiply"){
        result = $("#n1").val() * $("#n2").val();
    } else if ($("#n2") != 0){
        result = $("#n1").val() / $("#n2").val();
    }

    $("#result").text(result);
}