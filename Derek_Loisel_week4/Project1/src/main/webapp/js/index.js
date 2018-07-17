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
				//alert('Invalid credentials!')
				console.log('invalid credentials!');
			} else {
				
				//alert('Login successful!');
				loadHome(user);
				console.log('username: ' + user.username);
				console.log('User id: ' + user.userID);
				console.log('login successful!');
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


function loadHome(user) {
	console.log('in loadHome()');
	
	let xhr = new XMLHttpRequest();
	
	let currentView = '';
	console.log('user role id inside loadHome after loadHomeInfo: ' + user.userRoleID);
	//set view according to user role
	if(user.userRoleID == 1){
		console.log("employee role signing in");
		currentView = 'home.view';
	}
	else if(user.userRoleID == 2){
		console.log("manager role signing in");
		currentView = 'managerhome.view';
	}else{
		console.log("admin role signing in");
		currentView = 'adminhome.view';
	}
	
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
	
	xhr.open('GET', currentView, true);
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
			$('#user_role_id').html(user.userRoleID);
			
			//click nav to go to profile page
//			$('#toProfile').on('click', loadProfile);
			
			
			//create table: list the users reimbursements if employee signed in 
							//or list from all reimbursements if manager or admin signed in
			console.log('reimbursements length in loadHomeInfo at initial table creation: ' + reimbursements.length);
			if(reimbursements.length > 0) {
				reimbursements.forEach((reimbursement) => {
					
					if(filteringByUser == true && reimbursement.reimursementAuthor == userToFilterBy){
						
					}
					
					let id = reimbursement.reimbursementID;
					let amount = reimbursement.reimbursementAmount;
					let dateSubmitted = reimbursement.reimbursementSubmitted;
					let dateResolved;
					if(reimbursement.reimbursementResolved){
						dateResolved = reimbursement.reimbursementResolved;
					}else{						
						dateResolved = "n/a";
					}		
					
					let description = reimbursement.reimbursementDescription;
					//blob goes in here too
					let author = reimbursement.reimbursementAuthor;
					
					let resolver;
					if(reimbursement.reimbursementResolver){
						resolver = reimbursement.reimbursementResolver;
					}else{					
						resolver = "n/a";
					}
					
					let statusID = reimbursement.reimbursementStatusID;
					let typeID = reimbursement.reimbursementTypeID;
					console.log(dateResolved);
					let markup = `<tr>
									<td>${id}</td>
									<td>${amount}</td>
									<td>${dateSubmitted}</td>
									<td>${dateResolved}</td>
									<td>${description}</td>
									<td>${author}</td>
									<td>${resolver}</td>
									<td>${statusID}</td>
									<td>${typeID}</td>
								  </tr>`;
					
					$('table tbody').append(markup);
				})
			} else {
				$('#acct-info').html('No accounts on record');
			}
			
			//reset filters
			filteringByUser = false;
			filteringByStatus = false;
			
			//set the views event listeners according to user role
			if(user.userRoleID == 1){
							
			}
			if(user.userRoleID == 2 || user.userRoleID == 3){
			
			}
			if(user.userRoleID == 2){
				
			}
			if(user.userRoleID == 3){
				
			}
		}
		
	}
		
	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}
