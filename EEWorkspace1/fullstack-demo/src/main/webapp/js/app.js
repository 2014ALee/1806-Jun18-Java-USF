window.onload = function(){
	loadLogin();
	$('#toLogin').on('click', loadLogin);
//	$('#toRegister').on('click', loadRegister);
//	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
//	$('#toLogout').on('click', logout);
}

function loadLogin(){
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html = xhr.responseText;
			$('#toRegister').show();
			$('#toLogin').show();
			$('toHome').hide();
			$('toProfile').hide();
			$('toLogout').hide();
		}
		console.log('bast the if statement');
		xhr.open('GET', 'login.view', true);
		xhr.send();
	}
}

function loadLoginInfo(){
	console.log('in loadlogininfo');
	$('#login-message').hide();
	$('login').on('click', login);
}

function login(){
	console.log('in login');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let user = JSON.parse(xhr.responseText);
			$('login-message').show();
			
			if(user == null){
				$('login-message').html('Invalid Credentials!');
			}
			else{
				alert('login successful!');
				loadHome();
				console.log(`User id: ${user.id} login successful!`);
			}
		}
		xhr.open('POST', 'login', true);
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xhr.send();
	}
}

function loadHome(){
	console.log('in loadHome()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadHomeInfo();
			
			$('#toHome').show();
			$('#toProfile').show();
			$('#toLogout').show();
			$('#toLogin').hide();
			$('#toRegister').hide();
		}
	}
	
	xhr.open('GET', 'home.view', true);
	xhr.send();
};

function loadHomeInfo(){
	console.log('in loadHomeInfo()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo.user;
			let accounts = homeInfo.userAccounts;
			
			$('#user_id').html(user.id);
			$('#user_fn').html(user.firstName);
			$('#user_ln').html(user.lastName);
			$('#user_email').html(user.emailAddress);
			$('#user_username').html(user.username);
			$('#user_password').html(user.password);
			
			if(accounts.length > 0){
				accounts.forEach((account) =>{
					let id = accout.acctId;
					let type = account.acctType[0].toUpperCase()+account.acctType.substring(1);
					let balance = parseFloat(Math.round(account.balance*100)/100).toFixed(2);
					
					let markup = `<tr><td>${id}</td><td>${type}</td><td>${balance}</td></tr>`;
					
					$('table tbody').append(markup);
				})
			}else{
				$('#acct-info').html('No accounts on record!')
			}
		}
	}
	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}

function logout(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadLogin();
		}
	}
	xhr.open('GET', 'logout', true);
	xhr.send();
}