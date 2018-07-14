window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
//	$('#toRegister').on('click', loadRegister);
//	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
//	$('#toLogout').on('click', loadLogout);
}

function loadLogin(){
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			$('#toLogin').addClass('active');
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
			$('#navbarDropdownMenuLink').hide();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo(){
	console.log('in loadLoginInfo()');
	$('#login-message').removeClass('bg-warning');
	$('#login-message').html('');
	$('#login').on('click', login);
}

function login() {
	console.log('in login()');
	
	let username = $('#inputUserNameOrEmail').val();
	let password = $('#inputPassword').val();
	
	let toSend = [username, password];
	
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			let user = JSON.parse(xhr.responseText);
			
			if(user.userId == 0) {
				$('#login-message').addClass('bg-warning');
				$('#login-message').html('Invalid Credentials!');
				console.log(`User id: ${user.userId} login failed!`);
			} else {
				alert('Login Successful!');
				$('#login-message').removeClass('bg-warning');
				$('#login-message').html('');
				//laodHome();
				console.log(`User id: ${user.userId} login successful!`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/x-www.form-urlencoded');
	xhr.send(json);
}