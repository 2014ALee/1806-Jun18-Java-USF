window.onload = function() {
	console.log(9);
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
//	$('#toHome').on('click', loadHome);
//	$('#toLogout').on('click', logout);	
}


function loadLogin() {
	console.log("In loadLogin");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			setEventListener();
			
		}

	}
	xhr.open('GET', 'login.view', true);
	xhr.send();
}
function setEventListener() {
	console.log('in setEventListener');

//	$('#toLogin').hide();
//	$('#toLogout').hide();
//	$('#toRegister').show();
//	$('#login-message').hide();
	$('#submitLogin').on('click', login);
}

//loads view for Reimbursements
function loadRegister(){
	console.log("in loadRegister");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			setEventListenersForRegister();
			
			
		}
	}


	xhr.open('GET', 'register.view', true);
	xhr.send();
}

function setEventListenersForRegister(){
	//document.getElementById('reg-username').setEventListener('blur', somefunction)
	
	//$('#toRegister').hide();
	$('#register').on('click', register);
	console.log("inside setEventListenersForRegister");
}

function register(){
	console.log('register function is called');
	
	let firstname = document.getElementById('fn').value;
	let lastname = document.getElementById('ln').value;
	let email = document.getElementById('email').value;
	let username = document.getElementById('reg-username').value;
	let password = document.getElementById('reg-password').value;
	
//	let firstname = $('#fn').val();
//	let lastname = $('#ln').val();
//	let email = $('#email').val();
//	let username = $('#reg-username').val();
//	let password = $('#reg-password').val();
	
	let myarray = [ firstname, lastname, email, username, password];

	
	console.log("added user firstname = " + myarray );
	
	let json = JSON.stringify(myarray);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange	= function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//$('#message').hide();
			alert('Enrollment successful! Please login using your credentials');
			loadLogin();	
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}


function loadHome(){
	console.log("in loadhome");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//document.getElementById('view').html(xhr.responseText);
			$('#view').html(xhr.responseText);
			eventForHome();
		}
	}
	
	xhr.open('GET', 'home.view', true);
	xhr.send();
}

//add eventlistener to add reimbursement button
function eventForHome(){
	console.log('in eventForHome addReimb button');
	$('#addReimb').on('click', viewReimb);
	$('#showReimb').on('click', showReimb);
}


function login() {
	console.log('in login()');

	let username = $('#login-username').val();
	let password = $('#login-password').val();

	let toSend = [username, password];
	let json = JSON.stringify(toSend);

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			console.log("bad user = " + user);//

			if(user == null) {
				$('#login-message').show();
				$('#login-message').html('Invalid credentials!');
				

			} else {
				alert('Login successful!');
				loadHome();
				console.log(`User id: ${user.userId} login successful!`)
				//$('#toLogin').hide();
				$('#toLogout').show();
			}
		}
	}

	xhr.open('POST', 'login', true);    //what is application/json for?
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function viewReimb() {
	console.log("In viewReimb");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			eventForReimb();
			
		}

	}
	xhr.open('GET', 'viewReimb.view', true);
	xhr.send();
}

function eventForReimb(){
	console.log('in eventForReimb');
	$('#add').on('click', addReimb);
}

function showReimb(){

	console.log('in showReimb()');

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			let list = []
			list = user.myReimb;
			
			console.log("user array list = " + list[0].reimbId );
			
			if(user == null) {
				$('#login-message').show();
				$('#login-message').html('Something went wrong!');
				console.log("Failed to get users and its list");

			} else {
				alert('got user with list!');
				console.log("got list successfuly!");
				//$('#toLogin').hide();
				$('#toLogout').show();
				for (let i = 0; i < list.length; i++){
					let table = document.getElementById("table");

					let tr = document.createElement("tr");
					
					let td = document.createElement("td");
					let txt = document.createTextNode(list[i].reimbId);
					td.appendChild(txt);
					tr.appendChild(td);
					
					let td2 = document.createElement("td");
					let txt2 = document.createTextNode(list[i].amount);
					td2.appendChild(txt2);
					tr.appendChild(td2);
					
					let td3 = document.createElement("td");
					let txt3 = document.createTextNode(list[i].sumbitted);
					td3.appendChild(txt3);
					tr.appendChild(td3);
					
					let td4 = document.createElement("td");
					let txt4 = document.createTextNode(list[i].resolved);
					td4.appendChild(txt4);
					tr.appendChild(td4);
					
					let td5 = document.createElement("td");
					let txt5 = document.createTextNode(list[i].description);
					td5.appendChild(txt5);
					tr.appendChild(td5);
					
					let td6 = document.createElement("td");
					let txt6 = document.createTextNode(list[i].receipt);
					td6.appendChild(txt6);
					tr.appendChild(td6);
					
					let td7 = document.createElement("td");
					let txt7 = document.createTextNode(list[i].author);
					td7.appendChild(txt7);
					tr.appendChild(td7);
					
					let td8 = document.createElement("td");
					let txt8 = document.createTextNode(list[i].resolver);
					td8.appendChild(txt8);
					tr.appendChild(td8);
					
					let td9 = document.createElement("td");
					let txt9 = document.createTextNode(list[i].statusId);
					td9.appendChild(txt9);
					tr.appendChild(td9);
					
					let td10 = document.createElement("td");
					let txt10 = document.createTextNode(list[i].typeId);
					td10.appendChild(txt10);
					tr.appendChild(td10);
					
					
					table.appendChild(tr);
					
				}
			}
		}
	}

	xhr.open('GET', 'showReimb', true);    //what is application/json for?
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send();

}

function addReimb(){
	console.log('In addReimb');

	let amount = $('#amount').val();
	let description = $('#description').val();
	let type = $('#select').val();

	console.log("did i get the type? " + type);
	
	let toSend = [amount, description, type];
	let json = JSON.stringify(toSend);

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if(xhr.readyState == 4 && xhr.status == 200) {
			let check = JSON.parse(xhr.responseText);
			console.log("check = " + check);
			
			if(check != '1') {
				$('#login-message').show();
				$('#login-message').html('Reimbursement was not added!');
				console.log("Failed to add Reimbursement");

			} else {
				alert('Reimbursement Added!');
				loadHome();
				console.log("Reimbursement was added successful!");
				//$('#toLogin').hide();
				$('#toLogout').show();
			}
		}
	}

	xhr.open('POST', 'reimb', true);    //what is application/json for?
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}
