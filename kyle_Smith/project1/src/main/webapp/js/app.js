window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
//	$('#toProfile').on('click', loadProfile);
	$('#toLogout').on('click', logout);	
}
function loadLogin() {
	//console.log('in loadLogin()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadLoginInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
			$('#theNav').hide();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	//console.log('in loadLoginInfo()');
	
	$('#login-message').hide();
	$('#login').on('click', login);
	$('#toReg').on('click', loadRegister);
}
let thisUser;
function login() {
	//console.log('in login()');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	//console.log(username);
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		//console.log(xhr.readyState + xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			//console.log(user);
			thisUser = user;
			if(user.username == null) {
				$('#login-message').html('Invalid credentials!');
				$('#login-message').show();
			} else {
				//console.log('Login successful!');
				loadHome(user);
				//console.log(`User id: ${user.userId} login successful!`)
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadRegister() {
	//console.log('in loadRegister()');
	
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
	//console.log('in loadRegisterInfo()');
	
	$('#reg-message').hide();
	$('#toLog').on('click', loadLogin);
	$('#reg-username').blur(validateUsername);
	$('#email').blur(validateEmail);
	$('#register').on('click', register);
	
}

function register() {
	//console.log('in register()');
	
	let fn = $('#fn').val();
	let ln = $('#ln').val();
	let email = $('#email').val();
	let username = $('#reg-username').val();
	let password = $('#reg-password').val();
	let password2 = $('#reg-password2').val();
	let user = {
		userId: 0,
		firstName: fn,
		lastName: ln,
		email: email,
		username: username,
		password: password,
		roleId: 1,
		userRole: "Employee"
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#message').show();
			$('#message').html('Enrollment successful! Please login using your credentials.');
			loadLogin();
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
}

function registerManager() {
	//console.log('in registerManger()');
	
	let fn = $('#fn').val();
	let ln = $('#ln').val();
	let email = $('#email').val();
	let username = $('#reg-username').val();
	let password = $('#reg-password').val();
	let password2 = $('#reg-password2').val();
	let user = {
		userId: 0,
		firstName: fn,
		lastName: ln,
		email: email,
		username: username,
		password: password,
		roleId: 2,
		userRole: "Manager"
	}
	
	let userJson = JSON.stringify(user);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#message').show();
			$('#message').html('Enrollment successful! Please login using your credentials.');
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
}

function validateUsername() {
	//console.log('in validateUsername()');
	
	$('#register').attr('disabled', false);
	$('#registerManager').attr('disabled', false);
	$('#reg-message').hide();
	
	let username = $('#reg-username').val();
	let toSend = username;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
//				$('#reg-message').show();
				$('#reg-message').html('Username is already in use! Please try another.');
				//$('#register').attr('disabled', true)
				
			}
		}
	}
	
	xhr.open('POST', 'username.validate', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
	
}

function validateEmail() {
	//console.log('in validateEmail()');
	
	$('#register').attr('disabled', false);
	$('#registerManager').attr('disabled', false);
	$('#reg-message').hide();
	
	let email = $('#email').val();
	let toSend = email;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		//console.log(JSON.parse(xhr.responseText));
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
//				$('#reg-message').show();
				$('#reg-message').html('Email address is already in use! Please try another.');
//				$('#register').attr('disabled', true);
			}
		}
	}
	
	xhr.open('POST', 'email.validate', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadHome(user) {
	//console.log('in loadHome()');
	
	let xhr = new XMLHttpRequest();
	let theView = 'home.view';
	//console.log(user);
	//console.log(user.roleId);
	if(user.roleId == 0){
		theView = 'adminHome.view';
	} else if (user.roleId == 2) {
		theView = 'managerHome.view';
	}
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#theNav').show();
			loadHomeInfo(user);
			
			$('#toHome').show();
			$('#toProfile').show();
			$('#toLogout').show();
			$('#toLogin').hide();
			$('#toRegister').hide();
		}
	}
	
	xhr.open('GET', theView , true);
	xhr.send();
}

function loadHomeInfo(currUser) {
	//console.log('in loadHomeInfo()');
	
	let xhr = new XMLHttpRequest();
	let theInfo = 'home.loadinfo';
	if(currUser.roleId == 0){
		theInfo = 'adminHome.loadinfo';
		//console.log('in loadAdminHomeInfo()');
		$('#reg-message').hide();
		$('#toLog').on('click', loadLogin);
		$('#reg-username').blur(validateUsername);
		$('#email').blur(validateEmail);
		$('#registerManager').attr('disabled', true);
		$('#registerManager').on('click', registerManager);
	} else if (currUser.roleId == 2) {
		theInfo = 'managerHome.loadinfo';
	}
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo.user;
			let reims = homeInfo.reim;
			if (currUser.roleId == 2) {
				managerHome(user, reims);
				currUser.roleId = 1;
				//console.log(currUser);
				loadHomeInfo(currUser);
			}
			
			$('#user_id').html(user.userId);
			$('#user_fn').html(user.firstName);
			$('#user_ln').html(user.lastName);
			$('#user_email').html(user.email);
			$('#user_username').html(user.username);
			$('#user_password').html(user.password);
			$('#createReim').unbind().on('click', createReim);
			if(reims.length > 0 ) {
				$("#serachMyReims").on("keyup", function() {
				    var value = $(this).val().toLowerCase();
					//console.log(value + 'we doing the filter');
				    $("#userReimGen tr").filter(function() {
				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				    });
				  });
				$("#filterMyReims").on("click", function() {
				    var value = $("#serachMyReims").val().toLowerCase();
					//console.log(value + 'we doing the filter');
				    $("#genTable tr").filter(function() {
				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				    });
				  });
				$('#userReimGen').empty();
				if(currUser.roleId != 2){
				reims.forEach((reim) => {
					if(reim.author == user.userId){
						//console.log(reim.author +'auth + user ids ' + user.userId)
					let authId = reim.author;
					let reimId = reim.reimbursmentId;
					let submitted = reim.submitted;
					let description = reim.description;
					subDate = new Date();
					subDate.setTime(submitted);
					if(reim.typeId == 1)
						type = 'Lodging';
					else if(reim.typeId == 2)
						type = 'Travel';
					else if(reim.typeId == 3)
						type = 'Food';
					else if(reim.typeId == 4)
						type = 'Other';
					let status = '';
					if(reim.statusId == 1)
						status = 'Pending';
					else if (reim.statusId == 2)
						status = 'Approved';
					else if (reim.statusId == 3)
						status = 'Denied';
					let amount = parseFloat(Math.round(reim.amount * 100) / 100).toFixed(2);
					
					let markup = `
					<tr id="user${reimId}">
					<td>${reimId}</td>
					<td>${amount}</td>
					<td>${description}</td>
					<td>${subDate}</td>
					<td>${authId}</td>
					<td>${type}</td>
					<td>${status}</td>
					</tr>`;
					
					$('#userReimGen').append(markup);
					//console.log('appending this ' + markup);
					}
				})
				}
			} else {
				$('#acct-info').html('No accounts on record');
			}
		}
	}
	
	xhr.open('GET', theInfo, true);
	xhr.send();
}

function logout() {
	//console.log('in logout()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//console.log('Session invalidated!');
			loadLogin();
		}
	}
	
	xhr.open('GET', 'logout', true);
	xhr.send();
}

function createReim() {
	//console.log('in createReim()');
	let type = $("#reimType option:selected").val();
	let amount = $("#amount").val();
	let description = $("#description").val();
	let receipt = $("#receipt").val();
	//console.log(Date.now())

	let reim = {
		reimbursmentId: 0,
		amount: amount,
		submitted: Date.now(),
		description: description,
		statusId: 1,
		typeId: type//,
	}
	
	let reimJson = JSON.stringify(reim);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		//console.log('xhrReadyState = ' + xhr.readyState +' xhrStatus = ' + xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200) {
			//console.log('we got here boys');
			$('#message').hide();
			//console.log('created successful!');
			loadHomeInfo(thisUser);
		}
	}
	xhr.open('POST', 'createReim', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(reimJson);
}

function managerHome(user, reims) {
	//console.log('in managerHome');
	let manager = user;
	let activeReims = reims;
	$('#user_id').html(user.userId);
	$('#user_fn').html(user.firstName);
	$('#user_ln').html(user.lastName);
	$('#user_email').html(user.email);
	$('#user_username').html(user.username);
	$('#user_password').html(user.password);
	$('#genTable').empty();
	reims.forEach((reim) => {
		let authId = reim.author;
		let reimId = reim.reimbursmentId
		let amount = reim.amount;
		let submitted = reim.submitted;
		let description = reim.description;
		let type;
		if(reim.typeId == 1)
			type = 'Lodging';
		else if(reim.typeId == 2)
			type = 'Travel';
		else if(reim.typeId == 3)
			type = 'Food';
		else if(reim.typeId == 4)
			type = 'Other';
		subDate = new Date();
		subDate.setTime(submitted);
		
		let managerMarkup2 = `
		<tr id="reim${reimId}tr">
			<td>${reimId}</td>
			<td>${amount}</td>
			<td>${description}</td>
			<td>${subDate}</td>
			<td>${authId}</td>
			<td>${type}</td>
			<td>
				<select class="custom-select form-control genElements" id="reim${reimId}">
					<option id="${reimId}" value="-1" selected>Choose...</option>
					<option value="2">Approved</option>
					<option value="3">Denied</option>
				</select>
			</td>
		</tr>
		`
		$('#genTable').append(managerMarkup2);
	});
	$('#genTable').unbind().on('change', 'select', submitReims);
}

function submitReims(event) {
	//console.log('the reim works ' + event.target.value);
	//console.log('the reim works ' + event.target.id);
	let verdict = 0;
	if(event.target.value == 2) {
		verdict = 2
	} else if (event.target.value) {
		verdict = 3;
	}
	let reimId = ''+ event.target.id;
	reimId = reimId.replace('reim', '');
	reimId = parseInt(reimId);

	let reim = {
		reimbursmentId: reimId,
		statusId: verdict//,
	}
	let reimJson = JSON.stringify(reim);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		//console.log('xhrReadyState = ' + xhr.readyState +' xhrStatus = ' + xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200) {
			//console.log('we got here boys');
			// $('#'+event.target.id+'tr').hide();
			$('#'+event.target.id+'tr').remove();
			//console.log('created successful!');
		}
	}
	xhr.open('POST', 'updateReim', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(reimJson);
}
