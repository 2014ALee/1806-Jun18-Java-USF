window.onload = function() {
	
	loadLogin();
	
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
//	$('#toLogout').on('click', logout);

}
 
function loadLogin() {
console.log('in loadLogin()');


	let xhr = new XMLHttpRequest();
	
	
	
	xhr.onreadystatechange = function() {
		
		console.log('ready state: ' + xhr.readyState);
		console.log('xhr status: ' + xhr.status);
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
	
	let username = $('#inputUsername').val();
	let password = $('#inputPassword').val();
	
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
				if(user.userRoleID == 1){
					loadHome();
				}
				//or maybe something like this should go elsehwere? how should i do manager and admin pages?
//				else if(user.userRoleID == 2){
//					loadManagerHome();
//				}else{
//					loadAdminHome();
//				}
				
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
	
	$('#reg-message').hide();
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
	
	//validate email input
	 let regularExpression = /^([a-zA-Z0-9_\.\-+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 let emailValid = regularExpression.test(myEmail);
	 if(!emailValid){
		 alert("Please enter a valid email!");
		 return;
	 }
	 
	console.log(fn);
	console.log(ln);
	console.log(em);
	console.log(use);
	console.log(pass);
	
	let user = {
		userID: 0,
		firstname: fn,
		lastname: ln,
		email: em,
		username: use,
		password: pass,
		userRoleID: 1
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		
		console.log("xhr readyState: " + xhr.readyState);
		console.log("xhr status: " + xhr.status);
		
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


function loadHome() {
	console.log('in loadHome()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
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
}

function loadHomeInfo() {
	console.log('in loadHomeInfo()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo.user;
			let reimbursements = homeInfo.userReimbursements;
			
			$('#user_id').html(user.userID);
			$('#user_fn').html(user.firstname);
			$('#user_ln').html(user.lastname);
			$('#user_email').html(user.email);
			$('#user_username').html(user.username);
			$('#user_password').html(user.password);
			
			//click nav to go to profile page
//			$('#toProfile').on('click', loadProfile);
			
			
			
//			if(accounts.length > 0) {
//				accounts.forEach((account) => {
//					let id = account.acctId;
//					let type = account.acctType[0].toUpperCase() + account.acctType.substring(1);
//					let balance = parseFloat(Math.round(account.balance * 100) / 100).toFixed(2);
//					
//					let markup = `<tr>
//									<td>${id}</td>
//									<td>${type}</td>
//									<td>${balance}</td>
//								  </tr>`;
//					
//					$('table tbody').append(markup);
//				})
//			} else {
//				$('#acct-info').html('No accounts on record');
//			}
		}
	}
	
	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}