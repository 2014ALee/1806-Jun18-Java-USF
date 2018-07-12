window.onload = function () {
	loadLogin();
	$('#toLogin').on('click',loadLogin);
}

function loadLogin() {
	console.log('in loadLogin');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			loadLoginInfo();
			// $('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
			$('#toLogout').hide();
		}
	}
	
	xhr.open('GET','login.view',true);
	xhr.send();
}

function loadLoginInfo() {
	console.log('Load info');
	$('#login').on('click',login);
}

function login() {
	console.log('in login()');
	
	let username = $('#username').val();
	let password = $('#password').val();

	let toSend = [username,password];
	let json = JSON.stringify(toSend);

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			console.log("blue" + user);
			if(user == null) {
				console.log('Invalid');
			} else {
				console.log('Successful');
			}
		}
	}
	
	xhr.open('Post','login',true);
	xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
	xhr.send(json);
}