window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toEmpReimbursements').on('click', loadEmpReimb);	
//	$('#toHome').on('click', loadHome);
	$('#toLogout').on('click', logout);	
	$('#toEmpReimbursements').hide();
	$('#toManReimbursements').hide();
}

function loadLogin() {
	console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManagerReimbursements').hide();
			$('#toLogout').hide();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	console.log('in loadLoginInfo()');
	
	$('#toRegister').show();
	$('#toLogout').hide();
	$('#toHome').hide();
	$('#toEmployeeReimbursements').hide();
	$('#toManagerReimbursements').hide();
	
	$('#login-message').hide();
	$('#login-submit').on('click', login);
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
			
			console.log(xhr.status);
			
			
			let user = JSON.parse(xhr.responseText);
			console.log(user);
			
			if(user == null) {
				alert('Invalid credentials! Please try again.');
				loadLoginInfo();
			} else {
				console.log(`User id: ${user.ers_users_id} login successful!`)
				alert('Login successful!');
				if (user.user_role_id == 1){
					loadEmpReimb();
				}
				else{
					console.log(`User id: ${user.ers_users_id} login successful!`)
					loadManReimb();
				}
				 
				
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
	
	$('#toRegister').show();
	$('#toLogout').hide();
	$('#toHome').hide();
	$('#toEmployeeReimbursements').hide();
	$('#toManagerReimbursements').hide();
	$('#reg-message').hide();
	//$('#register-username').blur(validateUsername);
	//$('#register-email').blur(validateEmail);
	//$('#register').attr('disabled', true);
	$('#register').on('click', register);
}



function register() {
	
	console.log('in register()');
	
	let fn = $('#register-firstname').val();
	let ln = $('#register-lastname').val();
	let email = $('#register-email').val();
	let username = $('#register-username').val();
	let password = $('#register-password').val();
	let roleId;
	
	
	if($('emp-rad').checked){
	let roleId = 1;
	}else if($('manager-rad').checked){
	 roleId = 2;
	}else{
	 roleId = 1;
	}

	let userRoleId = roleId;
	
	let user = {
			// field names must match the database format
		ers_users_id: 0,
		ers_username: username,
		ers_password: password,
		user_first_name: fn,
		user_last_name: ln,
		user_email: email,
		user_role_id: userRoleId			
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#reg-message').hide();
			alert('Enrollment successful! Please login using your credentials.');
			loadLogin();
		}else{
			$('reg-message').show();
			$('reg-message').html = "An account with this username has been created. Please try again." 
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
	
}

//function loadHome(){
//console.log('in loadLogin()');
//	
//	let xhr = new XMLHttpRequest();
//	
//	xhr.onreadystatechange = function() {
//		if(xhr.readyState == 4 && xhr.status == 200) {
//			$('#view').html(xhr.responseText);
//			loadHomeInfo();
//			$('#toRegister').show();
//			$('#toLogin').hide();
//			
//			$('#toHome').hide();
//			$('#toEmployeeReimbursements').show();
//			$('#toManagerReimbursements').show();
//			$('#toLogout').show();
//		}
//	}
//	
//	xhr.open('GET', 'home.view', true);
//	xhr.send();
//}

function loadEmpReimb() {
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadEmpReimbInfo();
			$('#toRegister').show();
			$('#toLogin').hide();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').show();
			$('#toManagerReimbursements').show();
			$('#toLogout').show();
		}
	}
	
	xhr.open('GET', 'employee-reimbursement.view', true);
	xhr.send();
	
}

function loadEmpReimbInfo(){
	
console.log('in empReimbInfo()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			

			
			let empInfo = JSON.parse(xhr.responseText);
			console.log(empInfo);
			let user = empInfo.user;
			let reimbs = empInfo.userReimbursements;

			console.log(user.ers_users_id)
			$('#emp-user_id').html(user.ers_users_id);
			$('#emp-user_fn').html(user.user_first_name);
			$('#emp-user_ln').html(user.user_last_name);
			$('#emp-user_email').html(user.user_email);
			$('#emp-user_username').html(user.ers_username);
			$('#emp-user_password').html(user.ers_password);
			if(user.user_role_id == 1){
				$('#emp-user_role').html('Employee');
			} else{ 
				$('#emp-user_role').html('Manager');
			}			
			   
			if(reimbs.length > 0) {
				reimbs.forEach((reimb) => {
					let author = reimb.reimb_author;
					let reimbId = reimb.reimb_id
					let amount = parseFloat(Math.round(reimb.reimb_amount * 100) / 100).toFixed(2);
					let description = reimb.reimb_description;
					let status = reimb.reimb_status_id;
					let type = reimb.reimb_type_id;
					let date = reimb.reimb_submitted;
					let resolver = reimb.reimb_resolver;
					let resolved = reimb.reimb_resolved;
					
//					if(reimb.reimb_status_id === 1){
//						let status = 'Pending';
//					}else if(reimb.reimb_status_id === 2){
//						let status = 'Approved';
//					}else{
//						let status = 'Denied';
//					}
//				 
//					 
//					if(reimb.reimb_type_id === 1){
//						let status = 'Lodging';
//					}else if(reimb.reimb_type_id === 2){
//						let type = 'Travel';
//					}else if (reimb.reimb_type_id === 3){
//						let type = 'Food';
//					}else{
//						let type = 'Other';
//					}
					
					
					let markup = `<tr>
									<td>${reimbId}</td>
									<td>${amount}</td>
									<td>${date}</td>
									
									<td>${description}</td>
									
									
									<td>${type}</td>
									<td>${status}</td>
								  </tr>`;
					
					$('table tbody').append(markup);
				})
			} else {
				$('#reimb-info').html('No reimbursemnets on record');
			}
		}
	}
	
	xhr.open('GET', 'reimbursement.loadinfo', true);
	xhr.send();

	$('#emp-reimb').on('click', createReimb)
}

function createReimb() {
	console.log('in createreimb()');
	let type = $("#reimbType option:selected").val();
	let amount = $("#empAmount").val();
	let description = $("#empDescription").val();
	console.log(Date.now())

	let reim = {
		reimb_id: 0,
		reimb_amount: amount,
		reimb_submitted: Date.now(),
		reimb_resolver: 1,
		reimb_description: description,
		reimb_status_id: 1,
		reimb_type_id: type
	}
	
	let reimJson = JSON.stringify(reim);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		console.log('xhrReadyState = ' + xhr.readyState +' xhrStatus = ' + xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log('in callback');
			$('#message').hide();
			alert('Reimbursement Created Successfully!');
		}
	}
	xhr.open('POST', 'createReim', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(reimJson);
}

function loadManReimb() {
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadManReimbInfo();
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManagerReimbursements').show();
			$('#toLogout').show();
		}
	}
	
	xhr.open('GET', 'manager-reimbursement.view', true);
	xhr.send();
	
}

function loadManReimbInfo(){
	
	console.log('in empReimbInfo()');
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				

				
				let manInfo = JSON.parse(xhr.responseText);
				console.log(manInfo);
				let user = manInfo.user;
				

				console.log(user.ers_users_id)
				$('#man-user_id').html(user.ers_users_id);
				$('#man-user_fn').html(user.user_first_name);
				$('#man-user_ln').html(user.user_last_name);
				$('#man-user_email').html(user.user_email);
				$('#man-user_username').html(user.ers_username);
				$('#man-user_password').html(user.ers_password);
				if(user.user_role_id == 1){
					$('#man-user_role').html('Employee'); 
				} else{ 
					$('#man-user_role').html('Manager');
				}			
				   
				
			}
		}
		
		xhr.open('GET', 'reimbursement.loadinfo', true);
		xhr.send();

		$('#man-reimb').on('click', getEmpReimbs);
		$('#retrieveAllReimbs').on('click', getAllReimbs);
	}


function getAllReimbs(){
	
}


function validateUsername() {
	console.log('in validateUsername()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let username = $('#register-username').val();
	let toSend = username;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Username is already in use! Please try another.');
				$('#register').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', username.validate, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
	
}

function validateEmail() {
	console.log('in validateEmail()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let email = $('#register-email').val();
	let toSend = email;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Email address is already in use! Please try another.');
				$('#register').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', email.validate, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function logout(){
	console.log("in logout")
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystate = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("Session invalidated")
			loadLogin();
		}
	}
	
	xhr.open('GET', 'logout', true);
	xhr.send();
	
}