/**
 * 
 */

window.onload = function () {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toSignUp').on('click', loadSignUp);
}

function loadLogin() {
	console.log('In loadLogin();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		console.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('loadLogin html injection')
			
			$('#view').html(xhr.responseText);
			
			loadLoginInfo();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	console.log('xhr opened');
	xhr.send();
	console.log('xhr sent');
}

function loadLoginInfo() {
	console.log('In loadLoginInfo();');
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	console.log('In login();');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			if (user == null) {
				alert('Invalid credentials. Please try again.');
			} else {
				//loadHomePage();
//				console.log(user);
//				console.log(`${user.userid} login successful`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadSignUp() {
	console.log('In loadSignup();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		console.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('loadSignup html injection')
			
			$('#view').html(xhr.responseText);
			
			loadHomePage()
		}
	}
	
	xhr.open('GET', 'signup.view', true);
	console.log('xhr opened');
	xhr.send();
	console.log('xhr sent');
}

function loadHomePage() {
	
}

