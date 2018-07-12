


submitLoginInfo();
function submitLoginInfo(){
    let ourButton = document.getElementById("submitLogin");  
    ourButton.addEventListener("click", getLogInInfo);
}


function getLogInInfo(){
    let consolePrint = new Array;

//after these two statements we have an array of the results
let submittedFields = document.getElementsByClassName("login")[0];
let values = submittedFields.getElementsByTagName("input");
let userName = values[0].value;
let password = values[1].value;
console.log(password);
}

submitRegisterInfo();
function submitRegisterInfo(){
    let ourButton = document.getElementById("submitRegister");  
    ourButton.addEventListener("click", getRegisterInfo);
}

function getRegisterInfo(){
let submittedFields = document.getElementsByClassName("form-group")[0];
let values = submittedFields.getElementsByTagName("input");
let userName = values[0].value;
let password = values[1].value;
console.log(password);
}