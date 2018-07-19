window.onload = function(){
	loadLogIn();

}


function loadLogIn(){
	console.log("Logging in");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			$('#view').html(xhr.responseText);
			//document.getElementById("view").innerHTML= xhr.responseText;

		}
	}

	xhr.open('GET', 'Login.view', true);
	xhr.send();
}

/*
function loadUser(){
	console.log("Logged in, going to employee main screen");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			let user = JSON.parse(xhr.responseText);

			$('#user_ID').html(user.userID);
			$('#user_firstName').html(user.firstName);
			$('#user_lastName').html(user.lastName);
			$('#user_email').html(user.email);
			$('#user_userName').html(user.userName);
			$('#user_password').html(user.password);
			$('#user_role').html(user.roleName);

			console.log($('#user_userName').html(user.username) + " is the username returned by servlet");

		}
	}

	if(user.roleName === 'employee'){
		xhr.open('GET', 'LoggedInEmployee.view', true);
		xhr.send();
	} else if(user.roleName === 'manager'){
		xhr.open('GET', 'LoggedInManager.view', true);
		xhr.send();
	}
}
 */

function loadLoggedInManager(user){
	console.log("Logged in, going to manager main screen");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			$('#view').html(xhr.responseText);

			$('#firstNameLoggedIn').html('First Name: ' + user.firstName);
			$('#lastNameLoggedIn').html('Last Name: ' + user.lastName);
			$('#emailLoggedIn').html('Email: ' + user.email);
			$('#userNameLoggedIn').html('Username: ' + user.userName);
			$('#accountTypeLoggedIn').html('Account Type: ' + user.roleName);

			fillReimbsTable(user);
		}
	}

	xhr.open('GET', 'LoggedInManager.view', true);
	xhr.send();
}


function loadAllReimbs(reimbs){

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			console.log("reimbs length is: " + reimbs.length);
			
			fillAllReimbsTable(reimbs);

			$('#view').html(xhr.responseText);
			//document.getElementById("view").innerHTML= xhr.responseText;

		}
	}

	xhr.open('GET', 'AllReimbs.view', true);
	xhr.send();

}


function addReimbursement(){

	let submittedFields = document.getElementsByClassName("newReimbForm")[0];
	let values = submittedFields.getElementsByTagName("input");

	let amount = values[0].value;
	let description = values[1].value;
	let reimbType = document.getElementById("newReimbId").value;

	let toSend = [amount, description, reimbType];
	let json = JSON.stringify(toSend);

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let newReimb = JSON.parse(xhr.responseText);

			if(newReimb == null) {
				$('#reimb-message').html('add reimb unsuccesful');
				alert('add reimb unsuccesful');
				return;
			} else {

				console.log(newReimb.reimbursementAmount + ' is our reimbursement id of the new reimb added');

				addToReimbTable(newReimb);
			}
		}
	}


	xhr.open('POST', 'NewReimbServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);

}

function addToReimbTable(currentReimb, reimbTable){
	let tableRow = document.createElement("tr");

	let amountCell = document.createElement("td");
	let amountCellText = document.createTextNode("$" + currentReimb.reimbursementAmount);
	amountCell.appendChild(amountCellText);
	tableRow.appendChild(amountCell);

	let submittedCell = document.createElement("td");
	let submittedCellText = document.createTextNode(currentReimb.dateSubmitted);
	submittedCell.appendChild(submittedCellText);
	tableRow.appendChild(submittedCell);

	let resolvedCell = document.createElement("td");
	let resolvedCellText = document.createTextNode(currentReimb.dateResolved);
	resolvedCell.appendChild(resolvedCellText);
	tableRow.appendChild(resolvedCell);

	let descriptionCell = document.createElement("td");
	let descriptionCellText = document.createTextNode(currentReimb.description);
	descriptionCell.appendChild(descriptionCellText);
	tableRow.appendChild(descriptionCell);

	let typeCell = document.createElement("td");
	let typeCellText = document.createTextNode(currentReimb.typeName);
	typeCell.appendChild(typeCellText);
	tableRow.appendChild(typeCell);

	let statusCell = document.createElement("td");
	let statusCellText = document.createTextNode(currentReimb.statusName);
	statusCell.appendChild(statusCellText);
	tableRow.appendChild(statusCell);

	reimbTable.appendChild(tableRow);
}

function fillAllReimbsTable(reimbs){

	for(let i = 0; i < reimbs.length; i++){
		let currentReimb = reimbs[i];
		addToAllReimbTable(currentReimb);
	}

}

function addToAllReimbTable(currentReimb){


	let reimbTable = document.getElementsByClassName("allReimbTable")[0];

	let tableRow = document.createElement("tr");

	let idCell = document.createElement("td");
	let idCellText = document.createTextNode("$" + currentReimb.reimbursementID);
	idCell.appendChild(idCellText);
	tableRow.appendChild(idCell);

	let amountCell = document.createElement("td");
	let amountCellText = document.createTextNode("$" + currentReimb.reimbursementAmount);
	amountCell.appendChild(amountCellText);
	tableRow.appendChild(amountCell);

	let submittedCell = document.createElement("td");
	let submittedCellText = document.createTextNode(currentReimb.dateSubmitted);
	submittedCell.appendChild(submittedCellText);
	tableRow.appendChild(submittedCell);

	let resolvedCell = document.createElement("td");
	let resolvedCellText = document.createTextNode(currentReimb.dateResolved);
	resolvedCell.appendChild(resolvedCellText);
	tableRow.appendChild(resolvedCell);

	let descriptionCell = document.createElement("td");
	let descriptionCellText = document.createTextNode(currentReimb.description);
	descriptionCell.appendChild(descriptionCellText);
	tableRow.appendChild(descriptionCell);

	let typeCell = document.createElement("td");
	let typeCellText = document.createTextNode(currentReimb.typeName);
	typeCell.appendChild(typeCellText);
	tableRow.appendChild(typeCell);

	let statusCell = document.createElement("td");
	let statusCellText = document.createTextNode(currentReimb.statusName);
	statusCell.appendChild(statusCellText);
	tableRow.appendChild(statusCell);

	reimbTable.appendChild(tableRow);
}

function addToReimbTable(currentReimb){

	let reimbTable = document.getElementsByClassName("reimbTable")[0];

	let tableRow = document.createElement("tr");

	let amountCell = document.createElement("td");
	let amountCellText = document.createTextNode("$" + currentReimb.reimbursementAmount);
	amountCell.appendChild(amountCellText);
	tableRow.appendChild(amountCell);

	let submittedCell = document.createElement("td");
	let submittedCellText = document.createTextNode(currentReimb.dateSubmitted);
	submittedCell.appendChild(submittedCellText);
	tableRow.appendChild(submittedCell);

	let resolvedCell = document.createElement("td");
	let resolvedCellText = document.createTextNode(currentReimb.dateResolved);
	resolvedCell.appendChild(resolvedCellText);
	tableRow.appendChild(resolvedCell);

	let descriptionCell = document.createElement("td");
	let descriptionCellText = document.createTextNode(currentReimb.description);
	descriptionCell.appendChild(descriptionCellText);
	tableRow.appendChild(descriptionCell);

	let typeCell = document.createElement("td");
	let typeCellText = document.createTextNode(currentReimb.typeName);
	typeCell.appendChild(typeCellText);
	tableRow.appendChild(typeCell);

	let statusCell = document.createElement("td");
	let statusCellText = document.createTextNode(currentReimb.statusName);
	statusCell.appendChild(statusCellText);
	tableRow.appendChild(statusCell);

	reimbTable.appendChild(tableRow);
}


function fillReimbsTable(user){
	//we need a get reimbs function that takes in user, goes to a servlet, returns an array of them


	let xhr = new XMLHttpRequest();

	let toSend = [user];
	let json = JSON.stringify(toSend);
	let reimbTable = document.getElementsByClassName("table")[0];

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			let userReimbList = user.reimbList;

			if(user == null) {
				$('#login-message').html('reimb get failed!');
				alert('reimb get unsuccesful');
				return;
			} else {

				console.log("we will now put everything into our reimb table!!");
				//we have six cells to add per row

				console.log("reimb list is size: " + userReimbList.length);

				for(let i = 0; i < userReimbList.length; i++){
					let currentReimb = userReimbList[i];
					addToReimbTable(currentReimb, reimbTable);
				}
			}
		}
	}


	xhr.open('POST', 'ReimbursementServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);	
}


function loadLoggedInEmployee(user){
	console.log("Logged in, going to employee main screen");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			$('#view').html(xhr.responseText);
			console.log(logged);

			$('#firstNameLoggedIn').html('First Name: ' + user.firstName);
			$('#lastNameLoggedIn').html('Last Name: ' + user.lastName);
			$('#emailLoggedIn').html('Email: ' + user.email);
			$('#userNameLoggedIn').html('Username: ' + user.userName);
			$('#accountTypeLoggedIn').html('Account Type: ' + user.roleName);

			fillReimbsTable(user);
		}
	}

	xhr.open('GET', 'LoggedInEmployee.view', true);
	xhr.send();


}

function loadRegister(){
	console.log("Registering");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			$('#view').html(xhr.responseText);
			//document.getElementById("view").innerHTML= xhr.responseText;

		}
	}

	xhr.open('GET', 'Register.view', true);
	xhr.send();
}


function submitGetAllReimbs(){
	
	let xhr = new XMLHttpRequest();
	let toSend = ["placeholder"];
	let json = JSON.stringify(toSend);

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let reimbs = JSON.parse(xhr.responseText);

			if(user == null) {
				$('#login-message').html('get ALL reimbs unsuccesful');
				alert('get ALL reimbs unsuccesful');
				return;
			} else {
				console.log("ALL reimbs size is: " + reimbs.length);
				
				loadAllReimbs(reimbs);
			}
		}
	}


	xhr.open('POST', 'AllReimbsServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function submitLoginInfo(){

	let xhr = new XMLHttpRequest();

//	after these two statements we have an array of the results
	let submittedFields = document.getElementsByClassName("form-group")[0];
	let values = submittedFields.getElementsByTagName("input");

	let userName = values[0].value;
	let password = values[1].value;
	console.log(password);

	let toSend = [userName, password];
	let json = JSON.stringify(toSend);

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);

			if(user == null) {
				$('#login-message').html('Invalid credentials!');
				alert('Login unsuccesful');
				return;
			} else {

				console.log(user.firstName + "is user first name");
				console.log(user.lastName + "is user last name");

				console.log('our role name is' + user.roleName);

				if(user.roleName === 'employee'){
					loadLoggedInEmployee(user);
				} else if(user.roleName === 'manager'){
					loadLoggedInManager(user);
				}

				//	loadHome();
				//	console.log(`User id: ${user.id} login successful!`)
			}
		}
	}


	xhr.open('POST', 'LoginServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);


}



function submitRegisterInfo(){


	let xhr = new XMLHttpRequest();


	let submittedFields = document.getElementsByClassName("form-group-register")[0];
	let values = submittedFields.getElementsByTagName("input");
	let userName = values[0].value;
	let password = values[1].value;
	let firstName = values[2].value
	let lastName = values[3].value
	let email = values[4].value
	let accountType;

	if(values[5].checked){
		accountType = "employee";
	} else if(values[6].checked){
		accountType = "manager";
	}

	let toSend = [userName, password, firstName, lastName, email, accountType];
	let json = JSON.stringify(toSend);

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			let validRegistration = JSON.parse(xhr.responseText);

			console.log("Is valid is equal to: " + validRegistration);

			if(validRegistration === false){
				$('#email-message').html('Invalid Registration!');
				alert('Invalid Registration!');
			} else {	
				console.log("Registration succesful!!");
			}

		}
	}


	xhr.open('POST', 'RegisterServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);

}


function isValidEmail(){
	//console.log("email is valid!");

	let xhr  = new XMLHttpRequest();

	let submittedEmail = document.getElementById("emailRegister").value;
	let validationType = "email";

	let toSend = [validationType, submittedEmail];

	let json = JSON.stringify(toSend);

	xhr.onreadystatechange = function(){

		if(xhr.readyState == 4 && xhr.status == 200){

			let isValid = JSON.parse(xhr.responseText);

			console.log("Is valid is equal to: " + isValid);

			if(isValid === false){
				$('#email-message').html('Invalid credentials!');
				alert('invalid email!');
			} else {	
				console.log("the email is valid");
			}
		}
	}

	xhr.open('POST', 'ValidateServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function isValidUserName(){

	let xhr  = new XMLHttpRequest();

	let submittedEmail = document.getElementById("userRegister").value;
	let validationType = "userName";

	let toSend = [validationType, submittedEmail];

	let json = JSON.stringify(toSend);

	xhr.onreadystatechange = function(){

		if(xhr.readyState == 4 && xhr.status == 200){

			let isValid = JSON.parse(xhr.responseText);

			console.log("Is valid is equal to: " + isValid);

			if(isValid === false){
				$('#userName-message').html('Invalid credentials!');
				alert('invalid userName!');
			} else {	
				console.log("the username is valid");
			}
		}
	}

	xhr.open('POST', 'ValidateServlet', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}


function isValidUsername(){
	console.log("userName is valid!");
}

