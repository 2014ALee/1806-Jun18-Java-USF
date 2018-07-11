window.onload = function(){

	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
	$('#toProfile').on('click', loadProfile);
	$('#toLogout').on('click', logout);


}

function loadLogin() {
	console.log('in loadLogin()');

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200){
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

function loadLoginInfo(){
	console.log('in loadLoginInfo()');
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login(){
	console.log('in login()');

	let username = $('#login-username').val();
	let password = $('#login-password').val();

	//taking our array object and turning it into json to send to our backend
	let toSend = [username,password];
	let json = JSON.stringify;

	let xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200){

			//we will be getting user object back
			let user = JSON.parse(xhr.responseText)	;
			$('#login-message').show();
			
			if(user == null) {
				$('#login-message').html('Invalid credentials!');
			}else{
				$('#login-message').html('Credentials valid!');
			}
			
		}
	}
	
	//no need for the slash here in javascript
	xhr.open('POST', 'login', true);
	//xhr.setContentHeader( or something);
	xhr.send(json);
}