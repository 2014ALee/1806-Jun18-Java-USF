window.onload = function () {
	loadLogin();
	$('#toLogin').on('click',loadLogin);
//	$('#toRegister').on('click',loadRegister);
//	$('#toHome').on('click',loadHome);
//	$('#toProfile').on('click',loadProfile); 
//	$('#toLogout').on('click',loadLogout); 
}

function loadLogin() {
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			// loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
		}
	}
	
	xhr.open('GET','login.view',true);
	xhr.send();
}

function loadLoginInfo() {
	$('#login-message').hide();
	$('#login').on('click',login);
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
			$('#login-message').show();
			
			if(uer == null) {
				$('#login-message').html('Invalid credentials!');
			} else {
				alert('Login successful');
				// loadHome();
				console.log(`User id: ${user.id} login successful!`);
			}
		}
	}
	
	xhr.open('POST','login',true);
	xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
	xhr.send(json);
}

// in class
function loadHome() {
	console.log('in loadHome()');
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readState == 4 && xhr.status ==200) {
			$('#view').html(xhr.responseText);
			loadHomeInfo();
			
			$('#toHome').show();
			$('#toProfile').show();
			$('#toLogout').show();
			
			$('#toLogin').hide();
			$('#toRegister').hide();
		}
	}
	
	xhr.open('GET','home.view',true);
	xhr.send();
}

function loadInfo() {
	console.log('in loadHomeInfo()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo.user;
			let accounts = homeInfo.userAccounts;
			
			$('#user_id').html(user.id);
			$('#user_fn').html(user.firstName);
			$('#user.ln').html(user.lastname);
			$('#user_email').html(user.emailAddress);
			$('#user_username').html(user.username);
			$('#user_password').html(user.password);
			
			if(accounts.length > 0) {
				accounts.forEach((account) => {
					let id = account.acctId;
					let type = account.acctType[0].toUpperCase() + account.acctType.substring(1);
					let balance = parseFloat(Math.round(account.balance * 100) / 100).toFixed(2);
					
					let markup = `<tr>
								 	<td>${id}</td>
								 	<td>${type}</td>
								 	<td>${balance}</td>
								  </tr>`;
					$('table tbody').append(markup);
				})
			} else {
				$('#acct-into').html('No accounts on record');
			}
		}
		
	}
	
	xhr.open('GET','home.loadinfo',true);
	xhr.send();
}

function logout() {
	console.log('in logout()');
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log('Session invaidated!');
			loadLogin();
		}
	}
	
	xhr.open('GET','logout',true);
	xhr.send();
}
