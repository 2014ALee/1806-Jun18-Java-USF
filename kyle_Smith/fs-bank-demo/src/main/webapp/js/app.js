/**
 * 
 */
window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
//	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
//	$('#toLogout').on('click', loadLogout);
}

function loadLogin() {
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadstatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('view').html(xhr.resonseText);
			loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
			
		}
	}
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	console.log('in loadLoginInfo()');
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	console.log('in login()');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			let user = JSON.parse(xhr.responseText);
			
			if(user == null) {
				$('#login-message').html('Invalid credentials!');
			}else {
				alert('Login successful!');
				//loadHome();
				console.log(`User id: $(user.id} login succesful!`);
			}
		}
	}
<<<<<<< HEAD:kyle_Smith/fs-bank-demo/src/main/webapp/js/app.js
		xhr.open('POST', 'login', true);
		xhr.setRequestHeader('Contnet-type', 'application/json');
		xhr.send(json);
	}
=======
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadRegister() {
	console.log('in loadRegister()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadRegisterInfo();
		}
	}
	
	xhr.open('GET', 'register.view', true);
	xhr.send();
}

function loadRegisterInfo() {
	console.log('in loadRegisterInfo()');
	
	$('#reg-message').hide();
	$('#reg-username').blur(validateUsername);
	$('#email').blur(validateEmail);
	$('#register').attr('disabled', true);
	$('#register').on('click', register);
}

function register() {
	console.log('in register()');
	
	let fn = $('#fn').val();
	let ln = $('#ln').val();
	let email = $('#email').val();
	let username = $('#reg-username').val();
	let password = $('#reg-password').val();
	
	let user = {
		id: 0,
		firstName: fn,
		lastName: ln,
		emailAddress: email,
		username: username,
		password: password
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#message').hide();
			alert('Enrollment successful! Please login using your credentials.');
			loadLogin();
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
}

function validateUsername() {
	console.log('in validateUsername()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let username = $('#reg-username').val();
	let toSend = username;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Username is already in use! Please try another.');
				$('#register').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', username.validate, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
	
}

function validateEmail() {
	console.log('in validateEmail()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let email = $('#email').val();
	let toSend = email;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Email address is already in use! Please try another.');
				$('#register').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', email.validate, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}
>>>>>>> 1e3eeaff2dcb0f59f5bdd169f624fd08e01e4a60:Week_4-Servlets_Angular/fs-bank-demo/src/main/webapp/js/app.js
