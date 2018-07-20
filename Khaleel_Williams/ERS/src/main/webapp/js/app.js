window.onload = function() {
	console.log(0);
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toLogout').on('click', logout);	
}

let idList = [];

function loadLogin() {
	console.log("In loadLogin");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			setEventListener();
			$('#toRegister').show();
			$('#toLogin').hide();
			$('#toLogout').hide();
			$('#login-message').hide();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}
function setEventListener() {
	console.log('in setEventListener');

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
			$('#toRegister').hide();
			$('#toLogin').show();
			$('#toLogout').hide();
		}
	}
	
	xhr.open('GET', 'register.view', true);
	xhr.send();
}

function setEventListenersForRegister(){
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
			$('#message').hide();
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
			$('#toLogin').hide();
			$('#toLogout').show();
			$('toRegister').hide();
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

function managerView(){
	console.log("in managerView");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//document.getElementById('view').html(xhr.responseText);
			$('#view').html(xhr.responseText);
			eventForManager();
			$('#toLogin').hide();
			$('#toLogout').show();
			$('toRegister').hide();
		}
	}
	
	xhr.open('GET', 'manager.view', true);
	xhr.send();
}

function eventForManager(){
	$('#showAllReimb').on('click', showAllReimb);
	$('#submitAction').on('click', submitAction);
}

function showAllReimb(){

	console.log('in showReimb()');
	//reinjects the view so to not reappend
	managerView();
	
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			idList = []
			idList = user.myReimb;
			
			if(user == null) {
				$('#login-message').show();
				$('#login-message').html('Something went wrong!');
				console.log("Failed to get users and its list");

			} else {
				//alert('got user with list!');
				console.log("got list successfuly!");
				//$('#toLogin').hide();
				$('#toLogout').show();
				
				
				for (let i = 0; i < idList.length; i++){
					let table = document.getElementById("table");
                    
					let tr = document.createElement("tr");
					tr.setAttribute("id", idList[i].reimbId)
					
					
					let td = document.createElement("td");
					let txt = document.createTextNode(idList[i].reimbId);
					td.appendChild(txt);
					tr.appendChild(td);
					
					let td2 = document.createElement("td");
					let txt2 = document.createTextNode(`$`+idList[i].amount);
					td2.appendChild(txt2);
					tr.appendChild(td2);
					
					let td3 = document.createElement("td");
					let txt3 = document.createTextNode(idList[i].sumbitted);
					td3.appendChild(txt3);
					tr.appendChild(td3);
					
					let td4 = document.createElement("td");
					let txt4 = document.createTextNode(idList[i].resolved);
					td4.appendChild(txt4);
					tr.appendChild(td4);
					
					let td5 = document.createElement("td");
					let txt5 = document.createTextNode(idList[i].description);
					td5.appendChild(txt5);
					tr.appendChild(td5);
					
					let td6 = document.createElement("td");
					let txt6 = document.createTextNode(idList[i].receipt);
					td6.appendChild(txt6);
					tr.appendChild(td6);
					
					let td7 = document.createElement("td");
					let txt7 = document.createTextNode(idList[i].author);
					td7.appendChild(txt7);
					tr.appendChild(td7);
					
					let td8 = document.createElement("td");
					let txt8 = document.createTextNode(idList[i].resolver);
					td8.appendChild(txt8);
					tr.appendChild(td8);
					
					let td9 = document.createElement("td");
					let id = '';
					switch(idList[i].statusId){
					case 1:
						id = 'PENDING';
						//console.log("id = " + id);
						break;
					case 2:
						id = 'APPROVED';
						//console.log("id = " + id);
						break;
					case 3:
						id = 'DENIED';
						//console.log("id = " + id);
						break;
					dafault:
						id = 'DEFAULT'
						console.log('could not get status id')
					}
					let txt9 = document.createTextNode(id);
					td9.appendChild(txt9);
					tr.appendChild(td9);
					
					let td10 = document.createElement("td");
					let type = '';
					switch(idList[i].typeId){
					case 1:
						type = 'LODGING';
						//console.log("type = " + type);
						break;
					case 2:
						type = 'TRAVEL';
						//console.log("type = " + type);
						break;
					case 3:
						type = 'FOOD';
						//console.log("type = " + type);
						break;
					case 4:
						type = 'OTHER';
						//console.log("type = " + type);
						break;
					dafault:
						type = 'DEFAULT'
						console.log('could not get status type')
					}
					let txt10 = document.createTextNode(type);
					td10.appendChild(txt10);
					tr.appendChild(td10);
					
					let td11 = document.createElement("td");
					let select = document.createElement("select");
					select.setAttribute('id', 'select' + idList[i].reimbId);
					
					let opt = document.createElement("option")
					let option = document.createElement("option");
					let option1 = document.createElement("option");
					let tx = document.createTextNode("DENY");
					let tx1 = document.createTextNode("APPROVE");
					
					option.appendChild(tx);
					option1.appendChild(tx1);
					
					opt.setAttribute('value', 'Nothing');
					option.setAttribute('value', 'DENY');
					option1.setAttribute('value', 'APPROVE');
					
					select.appendChild(opt);
					select.appendChild(option);
					select.appendChild(option1);
					
					td11.appendChild(select);
					tr.appendChild(td11);
					
					table.appendChild(tr);
					
					//idList.push(list[i].reimbId);
				}
			}
		}
	}

	xhr.open('GET', 'showAllReimb', true);    //what is application/json for?
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send();

}
function submitAction(){
	console.log('sumbitAction register function is called');
	
	for(let i = 0; i < idList.length; i++){
		idList[i].act = document.getElementById('select'+idList[i].reimbId).value;
	}
	//let id = document.getElementById(idList[0].reimbId);
	//console.log("val=" + document.getElementById('select'+idList[0].reimbId).value);
	
	let json = JSON.stringify(idList);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange	= function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//$('#message').hide();
			alert('Reimbursements Modified');
			managerView();	
		}
	}
	
	xhr.open('POST', 'update', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
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
				if (user.roleId != 1){
					loadHome();
				} else {
					managerView();
				}
	
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

//submitting reimbursement view
function viewReimb() {
	console.log("In viewReimb");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			eventForReimb();
			$('#toLogin').hide();
			$('#toLogout').show();
			$('toRegister').hide();
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
	//reinjects the view so to not reappend
	loadHome();
	
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {

		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			let list = []
			list = user.myReimb;
			
			//console.log("user array list id = " + list[0].reimbId );
			
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
					let txt2 = document.createTextNode(`$`+list[i].amount);
					td2.appendChild(txt2);
					tr.appendChild(td2);
					
					let td3 = document.createElement("" +
							"td");
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
					
					//convert statusId from int to String
					let td9 = document.createElement("td");
					let id = '';
					switch(list[i].statusId){
					case 1:
						id = 'PENDING';
						//console.log("id = " + id);
						break;
					case 2:
						id = 'APPROVED';
						//console.log("id = " + id);
						break;
					case 3:
						id = 'DENIED';
						//console.log("id = " + id);
						break;
					dafault:
						id = 'DEFAULT'
						console.log('could not get status id')
					}
					//console.log("id outside switch = " + id);
					let txt9 = document.createTextNode(id);
					td9.appendChild(txt9);
					tr.appendChild(td9);
					
					let td10 = document.createElement("td");
					let type = '';
					switch(list[i].typeId){
					case 1:
						type = 'LODGING';
						//console.log("type = " + type);
						break;
					case 2:
						type = 'TRAVEL';
						//console.log("type = " + type);
						break;
					case 3:
						type = 'FOOD';
						break;
					case 4:
						type = 'OTHER';
						break;
					dafault:
						id = 'DEFAULT'
						console.log('could not get status type')
					}
					
					let txt10 = document.createTextNode(type);
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
			//console.log("check = " + check);
			
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

function logout(){
	console.log("In logout");

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			alert('You are now logged out');
			loadLogin();
		}

	}
	xhr.open('GET', 'logout', true);
	xhr.send();
}