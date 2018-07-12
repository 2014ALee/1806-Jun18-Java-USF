/**
 * 
 */

window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
//	$('#toRegister').on('click', loadRegister);
//	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
//	$('#toLogout').on('click', loadLogout);
}

function loadLogin() {
	console.log('In loadLogin()');
	
	//Ajax request
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('html injection');
			$('#view').html(xhr.responseText);
			loadLoginInfo();
			//Show buttons for people who haven't loggen in
			$('#toRegister').show();
			$('#toLogin').show();
			
			//Hide unnecessary buttons
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	console.log('In loadLoginInfo()')
	
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	console.log('In login()');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			$('#login-message').show();
			
			if(user == null) {
				$('#login-message').html('Invalid credentials');
			} else {
				alert('Login sucessful!');
				//loadHome();
				console.log(`User id: ${user.id} login successful!`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(json);
}