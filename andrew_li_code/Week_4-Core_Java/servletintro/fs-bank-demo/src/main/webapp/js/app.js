window.onload = function() {
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
	$('#toProfile').on('click', loadProfile);
	$('#toLogout').on('click', logout);
};

function loadLogin() {
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
		}
	};
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			$('login-message').show();
			
			if (user == null) {
				$('#login-message').html('Invalid Credentials')
			} else {
				alert('Login successful!');
				console.log(`User id: ${user.id} logn successful!`)
			}
		}
	};
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(json);
}
