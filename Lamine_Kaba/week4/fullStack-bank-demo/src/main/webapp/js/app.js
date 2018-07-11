window.onload = function(){
	loadLogin();
	$('#toLogin').on(click, loadLogin);
	$('#toRegister').on(click, loadRegister);
	$('#toHome').on(click, loadHome);
	$('#toProfile').on('click', loadProfile);
	$('#toLogout').on('click', logout);
}

function loadLogin(){
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpResquest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			//loadLogin
			loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
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
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadstatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let user = JSON.parse(xhr.responseText);
			$('#login-message').show();
			
			if(user == null){
				$('#login-message').html('invalid credentials');
			}else{
				alert('login successful');
				
				console.log(`user id: ${user.id} login successfull`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('content')
	xhr.send();
}




