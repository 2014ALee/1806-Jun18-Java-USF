window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
	$('#toProfile').on('click', loadProfile);
	$('#toLogoutModal').on('click', loadLogout);
	$('#createCase').on('click', loadCreateNew);
	$('#toViewAll').on('click', loadViewAll);
	$('[data-toggle="popover"]').popover('hide');
}

/*
 * Login in stuff
 */

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
			$('#toRegister').removeClass('active');
			
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
				$('#inputUserNameOrEmail').val('');
				$('#inputPassword').val('');
				console.log(`User id: ${user.userId} login failed!`);
			} else {
				$('#login-message').removeClass('bg-warning');
				$('#login-message').html('');
				loadHome();
				console.log(`User id: ${user.userId} login successful!`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

/*
 * Registration Stuff
 */

function loadRegister(){
	console.log('in loadRegister()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#emailExist').hide();
			$('#emailInvalid').hide();
			$('#userNameExist').hide();
			$('#passwordsMatch').hide();
			loadRegisterInfo();
			$('#toRegister').show();
			$('#toLogin').show();
			$('#toLogin').removeClass('active');
			$('#toRegister').addClass('active');
			
			$('#toHome').hide();
			$('#toProfile').hide();
			$('#toLogout').hide();
			$('#navbarDropdownMenuLink').hide();
		}
	}
	
	xhr.open('GET', 'register.view', true);
	xhr.send();
}

function loadRegisterInfo(){
	console.log('in loadRegisterInfo()');
	$('#register').on('click', register);
	$('#register-message').removeClass('bg-warning');
	$('#register-message').html('');
}

function register() {
	console.log('in register()');
	
	if (validateRegister()){
		let firstName = $('#inputFirstName').val();
		let lastName = $('#inputLastName').val();
		let email = $('#inputEmail').val();
		let username = $('#inputUserName').val();
		let password = $('#inputPassword').val();
		let userRoleId = ($('#roleCheckBox').is(':checked')) ? 2 : 1;
		console.log(`valid input. Checking if credentials available and creating user if so`);
		
		let toSend = [firstName, lastName, email, username, password, userRoleId];
		
		let json = JSON.stringify(toSend);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange =  function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				
				let success = JSON.parse(xhr.responseText);
				console.log(`${success} response text in register`);
				if(success[0] == 'true') {
					$('#successfulRegistrationModal').modal('show');
					loadLogin();
					console.log(`Successful registration`);
				} else if (success[1] == '0') {
					$('#failedRegistrationModal').modal('show');
					$('#userNameExist').show();
					$('#emailExist').hide();
					console.log(`Registration failed by username!`);
				} else if (success[1] == '1') {
					$('#failedRegistrationModal').modal('show');
					$('#emailExist').show();
					$('#userNameExist').hide();
					console.log(`Registration failed by email!`);
				}
			}
		}
		
		xhr.open('POST', 'register', true);
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(json);
	}
}

function validateRegister() {
	console.log('in validateRegister()');

	let firstName = $('#inputFirstName').val();
	let lastName = $('#inputLastName').val();
	let email = $('#inputEmail').val();
	let username = $('#inputUserName').val();
	let password = $('#inputPassword').val();
	let confirmedPassword = $('#inputPasswordConfirm').val();
	
	if (firstName == '' || lastName == '' || username == '' || password == '') {
		$('#update-message').addClass('bg-warning');
		$('#update-message').html('All fields must be complete!');
		$('#register-message').addClass('bg-warning');
		$('#register-message').html('All fields must be complete!');
		return false;
	} else {
		$('#update-message').removeClass('bg-warning');
		$('#update-message').html('');
		$('#register-message').removeClass('bg-warning');
		$('#register-message').html('');
	}
	
	if (!isEmail(email) || email == '') {
		$('#emailInvalid').show();
		console.log('email invalid');
		return false;
	} else {
		$('#emailInvalid').hide();
	}
	
	if (password != confirmedPassword) {
		$('#inputPassword').val('');
		$('#inputPasswordConfirm').val('');	
		$('#passwordsMatch').show();
		console.log(`passwords don't match: ${password} and ${confirmedPassword}`);
		return false;
	} else {
		$('#passwordsMatch').hide();
	}
	
	return true;
	
	// Found regex on StackOverflow
	// https://stackoverflow.com/questions/46155/how-to-validate-an-email-address-in-javascript
	function isEmail(emailTest){
	    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    return re.test(emailTest);

	}
}

/*
 * Profile Update Stuff
 */

function loadProfile(){
	console.log('in loadProfile()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#emailExist').hide();
			$('#emailInvalid').hide();
			$('#userNameExist').hide();
			$('#passwordsMatch').hide();
			loadProfileInfo();
			$('#toHome').show();
			$('#toHome').removeClass('active');
			$('#toProfile').show();
			$('#toProfile').addClass('active');
			$('#toLogout').show();
			$('#toLogout').removeClass('active');
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').removeClass('active');
			$('#toViewAll').removeClass('active');
			
			$('#toRegister').hide();
			$('#toLogin').hide();

			$('#managementOption').hide();
		}
	}
	
	xhr.open('GET', 'profile.view', true);
	xhr.send();
}

function loadProfileInfo(){
	console.log('in loadProfileInfo()');
	$('#update').on('click', update);
	$('#update-message').removeClass('bg-warning');
	$('#update-message').html('');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200){
			
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo[0];
			
			console.log(`userRoleId: ${user.userRoleId}`);
			if (user.userRoleId == 1) {
				$('#managementOption').hide();
			} else {
				$('#managementOption').show();
			}
			
			$('#inputFirstName').val(user.firstName);
			$('#inputLastName').val(user.lastName);
			$('#inputEmail').val(user.email);
			$('#inputUserName').val(user.userName);
			
			$('#roleCheckBox').prop('checked', ((user.userRoleId).valueOf() == (1).valueOf()) ? false : true);
			
		}
	}

	xhr.open('GET', 'profile.loadinfo', true);
	xhr.send();
}

function update() {
	console.log('in update()');
	
	if (validateRegister()){
		let firstName = $('#inputFirstName').val();
		let lastName = $('#inputLastName').val();
		let email = $('#inputEmail').val();
		let username = $('#inputUserName').val();
		let password = $('#inputPassword').val();
		let userRoleId = ($('#roleCheckBox').is(':checked')) ? 2 : 1;
		console.log(`valid input. Checking if credentials available and creating user if so`);
		
		let toSend = [firstName, lastName, email, username, password, userRoleId];
		
		let json = JSON.stringify(toSend);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange =  function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				
				let success = JSON.parse(xhr.responseText);
				console.log(`${success} response text in profile`);
				if(success[0] == 'true') {
					$('#successfulUpdateModal').modal('show');
					loadProfile();
					console.log(`Successful update`);
				} else if (success[1] == '0') {
					$('#failedUpdateModal').modal('show');
					$('#userNameExist').show();
					$('#emailExist').hide();
					console.log(`Update failed by username!`);
				} else if (success[1] == '1') {
					$('#failedUpdateModal').modal('show');
					$('#emailExist').show();
					$('#userNameExist').hide();
					console.log(`Update failed by email!`);
				}
			}
		}
		
		xhr.open('POST', 'profile', true);
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(json);
	}
}

/*
 * Home Stuff
 */

function loadHome(){
	console.log('in loadHome()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadHomeInfo();
			$('#toHome').show();
			$('#toHome').addClass('active');
			$('#toProfile').show();
			$('#toProfile').removeClass('active');
			$('#toLogout').show();
			$('#toLogout').removeClass('active');
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').removeClass('active');
			$('#toViewAll').removeClass('active');
			
			$('#toRegister').hide();
			$('#toLogin').hide();

			$('#managementOption').hide();
			
			$('#reimAmount').val('');
			$('#reimType').val('Choose..');
			$('#reimDesc').val('');
		}
	}
	
	xhr.open('GET', 'home.view', true);
	xhr.send();
}

function loadHomeInfo(){
	console.log('in loadHomeInfo()');

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200){
			
			let homeInfo = JSON.parse(xhr.responseText);
			let user = homeInfo[0];
			let reimbursements = homeInfo[1];
			
			console.log(`userRoleId: ${user.userRoleId}`);
			if (user.userRoleId == 1) {
				$('#managementOption').hide();
			} else {
				$('#managementOption').show();
			}
			
			if(reimbursements.length > 0) {
				reimbursements.forEach((reim) => {
					let id = reim.reimId;
					let amount = parseFloat(Math.round(reim.reimAmount * 100) / 100).toFixed(2);
					let subDate = reim.reimSubmitted;
					let resDate = reim.reimResolved;
					let desc = reim.reimDescription;
					let author = reim.reimAuthor;
					let resolver = reim.reimResolver;
					let status = reim.reimStatusString;
					let type = reim.reimTypeString;
					
					let tableEntry = `<tr>
										<td>${id}</td>
										<td>${subDate}</td>
										<td>${desc}</td>
										<td>${type}</td>
										<td>$${amount}</td>
										<td>${status}</td>
									  </tr>`;
					
					$('table tbody').append(tableEntry);
				})
			} else {
				$('#tableDiv').html(`<div class="col justify-content-center pt-4 mt-5" align="center">
		                                 <h4>No reimbursement history.</h4>
		                             </div>`);
			}
		}
	}

	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}

/*
 * Create New Stuff
 */

function loadCreateNew() {
	console.log('in loadCreateNew()');
	$('#reimType').popover('hide');
	$('#reimDesc').popover('hide');
	$('#amountFormat').popover('hide');
	
	let reimAmount = $('#reimAmount').val();
	let reimType = $('#reimType').val();
	let reimDesc = $('#reimDesc').val();
	console.log(`${reimAmount}, ${reimType}, ${reimDesc}`);
	
	if (reimType == 'Choose..') {
		$('#reimType').popover('show');
	} else if (reimDesc == '') {
		$('#reimDesc').popover('show');
	} else if (reimAmount == '') {
		console.log('invalid amount input');
		$('#amountFormat').popover('show');
	} else if (!isMoney(reimAmount)) {
		console.log('valid amount entry but contained e or was negative')
		$('#amountFormat').popover('show');
	} else {
		let toSend = [reimAmount, reimType, reimDesc];
		
		let json = JSON.stringify(toSend);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange =  function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				$('#createModal').modal('hide');
				$('#successfulCreationModal').modal('show');
				loadHome();
			}
		}
		
		xhr.open('POST', 'create', true);
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(json);
	}
}

function isMoney(num){
	let success = true;
    num.toString().split("").forEach(element => {
        if (element == "e" || element == "-") {
            success = false;
        } else if (element == ".") {
        	if ((num.toString().split(".")[1].length).valueOf() != (2).valueOf()) {
        		success = false;
        	}
        }
    });
    console.log(num);
	return success;
}

/*
 * Management Stuff
 */

function loadViewAll(){
	console.log('in loadViewAll()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadViewAllInfo();
			$('#toHome').show();
			$('#toHome').removeClass('active');
			$('#toProfile').show();
			$('#toProfile').removeClass('active');
			$('#toLogout').show();
			$('#toLogout').removeClass('active');
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').addClass('active');
			$('#toViewAll').addClass('active');
			
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#reimAmount').val('');
			$('#reimType').val('Choose..');
			$('#reimDesc').val('');
		}
	}
	
	xhr.open('GET', 'view_all.view', true);
	xhr.send();
}

function loadViewAllInfo(){
	console.log('in loadViewAllInfo()');

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200){
			console.log('getting all reimbursements');
			let allInfo = JSON.parse(xhr.responseText);
			let user = allInfo[0];
			let reimbursements = allInfo[1];
			
			console.log(`userRoleId: ${user.userRoleId} in view_all.loadinfo`);
			let reimbursementsAsc = reverseArr(reimbursements);
			
			function reverseArr(reimArr) {
				let temp = [];
				reimArr.forEach((reim) => {
					temp.unshift(reim);
				})
				return temp;
			};
			
			if(reimbursements.length > 0) {
				$('#tableDiv').html(`<table class="table table-hover table-striped">
							            <thead>
							                <tr>
							                    <th scope="col">Id</th>
							                    <th scope="col">Submitted</th>
							                    <th scope="col">Resolved</th>
							                    <th scope="col">Employee</th>
							                    <th scope="col">Resolver</th>
							                    <th scope="col">Description</th>
							                    <th scope="col">Type</th>
							                    <th scope="col">Amount</th>
							                    <th scope="col">Status</th>
							                </tr>
							            </thead>
							            <tbody>
							            </tbody>
							        </table>`);
			
				reimbursementsAsc.forEach((reim) => {
					let id = reim.reimId;
					let amount = parseFloat(Math.round(reim.reimAmount * 100) / 100).toFixed(2);
					let subDate = reim.reimSubmitted;
					let resDate = reim.reimResolved;
					let desc = reim.reimDescription;
					let author = reim.reimAuthor;
					let resolver = reim.reimResolver;
					let status = reim.reimStatusString;
					let type = reim.reimTypeString;
					
					if ((author).valueOf() != (user.userId).valueOf()) {
						let tableEntry = `<tr>
											<td>${id}</td>
											<td>${subDate}</td>
											<td>${resDate}</td>
											<td>${author}</td>
											<td>${resolver}</td>
											<td>${desc}</td>
											<td>${type}</td>
											<td>$${amount}</td>
											<td>${status}</td>
										  </tr>`;
					
						$('table tbody').append(tableEntry);
					}
					
				})
			}
		}
	}
	xhr.open('GET', 'view_all.loadinfo', true);
	xhr.send();
}

/*
 * Logout Stuff
 */

function loadLogout(){
	console.log('in loadLogout()');

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(`invalidating session.`);
			loadLogin();
		}
	}
	
	xhr.open('GET', 'logout', true);
	xhr.send();
}