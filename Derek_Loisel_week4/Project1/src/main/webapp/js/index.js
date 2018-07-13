window.onload = function() {
	
	loadLogin();
	
	//$('#toLogin').on('click', loadLogin);
	//$('#toRegister').on('click', loadRegister);
	
//	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
//	$('#toLogout').on('click', logout);	
}
 
function loadLogin() {
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
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
	$('#createid').on('click', loadRegister);
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
			//$('#login-message').show();
			
			if(user == null) {
				//$('#login-message').html('Invalid credentials!');
				alert('Invalid credentials!')
			} else {
				alert('Login successful!');
				//loadHome();
				console.log(`User id: ${user.id} login successful!`)
			}
		}
	}
	
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
	
	//$('#reg-message').hide();
	//$('#reg-username').blur(validateUsername);
	//$('#email').blur(validateEmail);
	//$('#register').attr('disabled', true);
	$('#register').on('click', register);
}

function register() {
	console.log('in register()');
	
	let fn = $('#inputFirstname').val();
	let ln = $('#inputLastname').val();
	let em = $('#inputEmail').val();
	let use = $('#inputUsername').val();
	let pass = $('#inputPassword').val();
	
	let user = {
		userID: 0,
		firstname: fn,
		lastname: ln,
		email: em,
		username: use,
		password: pass,
		userRoleID: 0
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//registeration servlet returns json of user
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
//				$('#login-message').html('Username/Email unavailable!');
				alert('Username/Email unavailable!');
			} else {
//				$('#message').hide();
				alert('Account Created!');
				loadLogin();			
			}

		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
}