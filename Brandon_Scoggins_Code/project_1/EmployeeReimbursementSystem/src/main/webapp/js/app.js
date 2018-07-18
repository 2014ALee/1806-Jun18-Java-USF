window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
	$('#toViewResolved').on('click', loadViewResolved);
	$('#toViewUnresolved').on('click', loadViewUnresolved);
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
			$('#userIdNav').hide();
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
				$('#userIdNavValue').html(user.userId);
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
			$('#userIdNav').hide();
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
			$('#userIdNav').show();
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

	xhr.open('GET', 'home.loadinfo', true);
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
			$('#userIdNav').show();
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').removeClass('active');
			$('#toViewAll').removeClass('active');
			$('#toViewResolved').removeClass('active');
			$('#toViewUnresolved').removeClass('active');
			
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
				$('#tableDiv').html(`
				        <table class="table table-hover table-striped header-fixed">
				            <thead>
				                <tr>
				                    <th scope="col" id='tableHeadId'>Id</th>
				                    <th scope="col" id='tableHeadSub'>Submitted</th>
				                    <th scope="col" id='tableHeadDes'>Description</th>
				                    <th scope="col" id='tableHeadTyp'>Type</th>
				                    <th scope="col" id='tableHeadAmo'>Amount</th>
				                    <th scope="col" id='tableHeadSta'>Status</th>
				                </tr>
				            </thead>
				            <tbody>
				            </tbody>
				        </table>`);
				
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
										<td id='tableId'>${id}</td>
										<td id='tableSub'>${subDate}</td>
										<td id='tableDes'>${desc}</td>
										<td id='tableTyp'>${type}</td>
										<td id='tableAmo'>$${amount}</td>
										<td id='tableSta'>${status}</td>
									  </tr>`;
					
					$('table tbody').append(tableEntry);
				})
			}
		}
	}

	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}

/*
 * View Resolved Stuff
 */

function loadViewResolved(){
	console.log('in loadViewResolved()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadViewResolvedInfo();
			$('#toHome').show();
			$('#toHome').removeClass('active');
			$('#toProfile').show();
			$('#toProfile').removeClass('active');
			$('#toLogout').show();
			$('#toLogout').removeClass('active');
			$('#userIdNav').show();
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').removeClass('active');
			$('#toViewAll').removeClass('active');
			$('#toViewResolved').addClass('active');
			$('#toViewUnresolved').removeClass('active');
			
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

function loadViewResolvedInfo(){
	console.log('in loadViewResolvedInfo()');

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200){
			
			let resolvedInfo = JSON.parse(xhr.responseText);
			let user = resolvedInfo[0];
			let reimbursements = resolvedInfo[1];
			
			console.log(`userRoleId: ${user.userRoleId}`);
			if (user.userRoleId == 1) {
				$('#managementOption').hide();
			} else {
				$('#managementOption').show();
			}
			
			if(reimbursements.length > 0) {
				$('#homeTitle').html(`<div>Resolved Reimbursements</div>`);
				$('#tableDiv').html(`
				        <table class="table table-hover table-striped header-fixed">
				            <thead>
				                <tr>
				                    <th scope="col" id='tableHeadId'>Id</th>
				                    <th scope="col" id='tableHeadSub'>Submitted</th>
				                    <th scope="col" id='tableHeadDes'>Description</th>
				                    <th scope="col" id='tableHeadTyp'>Type</th>
				                    <th scope="col" id='tableHeadAmo'>Amount</th>
				                    <th scope="col" id='tableHeadSta'>Status</th>
				                </tr>
				            </thead>
				            <tbody>
				            </tbody>
				        </table>`);
				
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
					
					if (status == 'Approved' || status == 'Denied' || status == 'Canceled'){
						let tableEntry = `<tr>
										<td id='tableId'>${id}</td>
										<td id='tableSub'>${subDate}</td>
										<td id='tableDes'>${desc}</td>
										<td id='tableTyp'>${type}</td>
										<td id='tableAmo'>$${amount}</td>
										<td id='tableSta'>${status}</td>
										  </tr>`;
						
						$('table tbody').append(tableEntry);
					}
				})
			}
		}
	}

	xhr.open('GET', 'home.loadinfo', true);
	xhr.send();
}

/*
 * View Unresolved Stuff
 */

function loadViewUnresolved(){
	console.log('in loadViewUnresolved()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange =  function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadViewUnresolvedInfo();
			$('#toHome').show();
			$('#toHome').removeClass('active');
			$('#toProfile').show();
			$('#toProfile').removeClass('active');
			$('#toLogout').show();
			$('#toLogout').removeClass('active');
			$('#userIdNav').show();
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').removeClass('active');
			$('#toViewAll').removeClass('active');
			$('#toViewResolved').removeClass('active');
			$('#toViewUnresolved').addClass('active');
			
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

function loadViewUnresolvedInfo(){
	console.log('in loadViewUnresolvedInfo()');

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200){
			
			let unresolvedInfo = JSON.parse(xhr.responseText);
			let user = unresolvedInfo[0];
			let reimbursements = unresolvedInfo[1];
			
			console.log(`userRoleId: ${user.userRoleId}`);
			if (user.userRoleId == 1) {
				$('#managementOption').hide();
			} else {
				$('#managementOption').show();
			}
			
			if(reimbursements.length > 0) {
				$('#homeTitle').html(`<div>Unresolved Reimbursements</div>`);
				$('#tableDiv').html(`
				        <table class="table table-hover table-striped header-fixed">
				            <thead>
				                <tr>
				                    <th scope="col" id='tableHeadId'>Id</th>
				                    <th scope="col" id='tableHeadSub'>Submitted</th>
				                    <th scope="col" id='tableHeadDes'>Description</th>
				                    <th scope="col" id='tableHeadTyp'>Type</th>
				                    <th scope="col" id='tableHeadAmo'>Amount</th>
				                    <th scope="col" id='tableHeadSta'>Status</th>
				                </tr>
				            </thead>
				            <tbody>
				            </tbody>
				        </table>`);
				
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
					
					if (status == 'New' || status == 'Viewed'){
						let tableEntry = `<tr>
										<td id='tableId'>${id}</td>
										<td id='tableSub'>${subDate}</td>
										<td id='tableDes'>${desc}</td>
										<td id='tableTyp'>${type}</td>
										<td id='tableAmo'>$${amount}</td>
										<td id='tableSta'>${status}</td>
										  </tr>`;
						
						$('table tbody').append(tableEntry);
					}
				})
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
			$('#userIdNav').show();
			$('#navbarDropdownMenuLink').show();
			$('#navbarDropdownMenuLink').addClass('active');
			$('#toViewAll').addClass('active');
			$('#toViewResolved').removeClass('active');
			$('#toViewUnresolved').removeClass('active');
			
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#reimAmount').val('');
			$('#reimType').val('Choose..');
			$('#reimDesc').val('');
			
			$('#dismissReimUpdateModal').on('click', loadViewAll);
		}
	}
	
	xhr.open('GET', 'view_all.view', true);
	xhr.send();
}

function loadViewAllInfo(){
	console.log('in loadViewAllInfo()');

	$('#viewAllType').addClass('active');
	$('#viewAllStatus').addClass('active');
	
	let selectedReimId = 0;
	
	$('#approveCase').click(function() {
		approveCase(selectedReimId);
	});
	$('#denyCase').click(function() {
		denyCase(selectedReimId);
	});
	$('#viewedCase').click(function() {
		viewedCase(selectedReimId);
	});

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200){
			console.log('getting all reimbursements');
			let allInfo = JSON.parse(xhr.responseText);
			let user = allInfo[0];
			let reimbursements = allInfo[1];
			console.log(`userRoleId: ${user.userRoleId} in view_all.loadinfo`);
			let reimbursementsAsc = reimbursements.reverse();
			let reimByStatus = [];
			let reimByType = [];
			
			if(reimbursements.length > 0) {
				fillTable(reimbursementsAsc);
			}
			
			let currentStatus = '';
			let currentType = '';
			
			$('#viewNew').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimStatusString == 'New') {
						temp.push(reim);
					}
				})
				reimByStatus = temp;
				if (reimByType.length == 0) {
					fillTable(reimByStatus);
				} else {
					fillTable(reimByType.filter(function(reim) {
						if (reim.reimStatusString == 'New') {
							return reim;
						}
					}));
				}
				
				$('#viewNew').addClass('active');
				$('#viewViewed').removeClass('active');
				$('#viewApproved').removeClass('active');
				$('#viewDenied').removeClass('active');
				$('#viewCanceled').removeClass('active');
				$('#viewAllStatus').removeClass('active');
			});
			
			$('#viewViewed').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimStatusString == 'Viewed') {
						temp.push(reim);
					}
				})
				reimByStatus = temp;
				if (reimByType.length == 0) {
					fillTable(reimByStatus);
				} else {
					fillTable(reimByType.filter(function(reim) {
						if (reim.reimStatusString == 'Viewed') {
							return reim;
						}
					}));
				}

				$('#viewNew').removeClass('active');
				$('#viewViewed').addClass('active');
				$('#viewApproved').removeClass('active');
				$('#viewDenied').removeClass('active');
				$('#viewCanceled').removeClass('active');
				$('#viewAllStatus').removeClass('active');
			});
			
			$('#viewApproved').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimStatusString == 'Approved') {
						temp.push(reim);
					}
				})
				reimByStatus = temp;
				if (reimByType.length == 0) {
					fillTable(reimByStatus);
				} else {
					fillTable(reimByType.filter(function(reim) {
						if (reim.reimStatusString == 'Approved') {
							return reim;
						}
					}));
				}

				$('#viewNew').removeClass('active');
				$('#viewViewed').removeClass('active');
				$('#viewApproved').addClass('active');
				$('#viewDenied').removeClass('active');
				$('#viewCanceled').removeClass('active');
				$('#viewAllStatus').removeClass('active');
			});
			
			$('#viewDenied').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimStatusString == 'Denied') {
						temp.push(reim);
					}
				})
				reimByStatus = temp;
				if (reimByType.length == 0) {
					fillTable(reimByStatus);
				} else {
					fillTable(reimByType.filter(function(reim) {
						if (reim.reimStatusString == 'Denied') {
							return reim;
						}
					}));
				}

				$('#viewNew').removeClass('active');
				$('#viewViewed').removeClass('active');
				$('#viewApproved').removeClass('active');
				$('#viewDenied').addClass('active');
				$('#viewCanceled').removeClass('active');
				$('#viewAllStatus').removeClass('active');
			});
			
			$('#viewCanceled').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimStatusString == 'Canceled') {
						temp.push(reim);
					}
				})
				reimByStatus = temp;
				if (reimByType.length == 0) {
					fillTable(reimByStatus);
				} else {
					fillTable(reimByType.filter(function(reim) {
						if (reim.reimStatusString == 'Canceled') {
							return reim;
						}
					}));
				}

				$('#viewNew').removeClass('active');
				$('#viewViewed').removeClass('active');
				$('#viewApproved').removeClass('active');
				$('#viewDenied').removeClass('active');
				$('#viewCanceled').addClass('active');
				$('#viewAllStatus').removeClass('active');
			});
			
			$('#viewAllStatus').click(function() {
				if (reimByType.length == 0) {
					fillTable(reimbursementsAsc);
				} else {
					fillTable(reimByType);
				}
				reimByStatus = [];
				
				$('#viewNew').removeClass('active');
				$('#viewViewed').removeClass('active');
				$('#viewApproved').removeClass('active');
				$('#viewDenied').removeClass('active');
				$('#viewCanceled').removeClass('active');
				$('#viewAllStatus').addClass('active');
			});
			
			$('#viewLodging').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimTypeString == 'Lodging') {
						temp.push(reim);
					}
				})
				reimByType = temp;
				if (reimByStatus.length == 0) {
					fillTable(reimByType);
				} else {
					fillTable(reimByStatus.filter(function(reim) {
						if (reim.reimTypeString == 'Lodging') {
							return reim;
						}
					}));
				}	

				$('#viewLodging').addClass('active');
				$('#viewTravel').removeClass('active');
				$('#viewFood').removeClass('active');
				$('#viewOther').removeClass('active');
				$('#viewAllType').removeClass('active');			
			});
			
			$('#viewTravel').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimTypeString == 'Travel') {
						temp.push(reim);
					}
				})
				reimByType = temp;
				if (reimByStatus.length == 0) {
					fillTable(reimByType);
				} else {
					fillTable(reimByStatus.filter(function(reim) {
						if (reim.reimTypeString == 'Travel') {
							return reim;
						}
					}));
				}

				$('#viewLodging').removeClass('active');
				$('#viewTravel').addClass('active');
				$('#viewFood').removeClass('active');
				$('#viewOther').removeClass('active');
				$('#viewAllType').removeClass('active');
			});
			
			$('#viewFood').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimTypeString == 'Food') {
						temp.push(reim);
					}
				})
				reimByType = temp;
				if (reimByStatus.length == 0) {
					fillTable(reimByType);
				} else {
					fillTable(reimByStatus.filter(function(reim) {
						if (reim.reimTypeString == 'Food') {
							return reim;
						}
					}));
				}

				$('#viewLodging').removeClass('active');
				$('#viewTravel').removeClass('active');
				$('#viewFood').addClass('active');
				$('#viewOther').removeClass('active');
				$('#viewAllType').removeClass('active');
			});
			
			$('#viewOther').click(function() {
				let temp = [];
				reimbursementsAsc.forEach((reim) => {
					if (reim.reimTypeString == 'Other') {
						temp.push(reim);
					}
				})
				reimByType = temp;
				if (reimByStatus.length == 0) {
					fillTable(reimByType);
				} else {
					fillTable(reimByStatus.filter(function(reim) {
						if (reim.reimTypeString == 'Other') {
							return reim;
						}
					}));
				}

				$('#viewLodging').removeClass('active');
				$('#viewTravel').removeClass('active');
				$('#viewFood').removeClass('active');
				$('#viewOther').addClass('active');
				$('#viewAllType').removeClass('active');
			});
			
			$('#viewAllType').click(function() {
				if (reimByStatus.length == 0) {
					fillTable(reimbursementsAsc);
				} else {
					fillTable(reimByStatus);
				}
				reimByType = [];

				$('#viewLodging').removeClass('active');
				$('#viewTravel').removeClass('active');
				$('#viewFood').removeClass('active');
				$('#viewOther').removeClass('active');
				$('#viewAllType').addClass('active');
			});
			
			function fillTable(arr) {
				if (arr.length == 0) {
					$('#tableDiv').html(`<div class="col justify-content-center pt-4 mt-5" align="center">
				                        	<h4>No reimbursements to show.</h4>
				                        </div>`);
				} else {
					$('#tableDiv').html(`<table class="table table-hover table-striped header-fixed">
								            <thead>
								                <tr>
								                    <th scope="col" id='tableAllHeadId'>Id</th>
								                    <th scope="col" id='tableAllHeadSub'>Submitted</th>
								                    <th scope="col" id='tableAllHeadResd'>Resolved</th>
								                    <th scope="col" id='tableAllHeadEmp'>Employee</th>
								                    <th scope="col" id='tableAllHeadRes'>Resolver</th>
								                    <th scope="col" id='tableAllHeadDes'>Description</th>
								                    <th scope="col" id='tableAllHeadTyp'>Type</th>
								                    <th scope="col" id='tableAllHeadAmo'>Amount</th>
								                    <th scope="col" id='tableAllHeadSta'>Status</th>
								                </tr>
								            </thead>
								            <tbody>
								            </tbody>
								        </table>`);
				
					arr.forEach((reim) => {
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
							let tableEntry = `<tr id="${id}" data-toggle="modal" data-target="#managementModal">
												<td id="tableAllId">${id}</td>
												<td id="tableAllSub">${subDate}</td>
												<td id="tableAllResd">${resDate}</td>
												<td id="tableAllAut">${author}</td>
												<td id="tableAllRes">${resolver}</td>
												<td id="tableAllDes">${desc}</td>
												<td id="tableAllTyp">${type}</td>
												<td id="tableAllAmo">$${amount}</td>
												<td id="tableAllSta">${status}</td>
											  </tr>`;
						
							$('table tbody').append(tableEntry);
							$(`#${id}`).on('click', function() {
								selectedReimId = id;
								console.log(amount);
								console.log('print variable test');
								$('#reimAmountModal').html(amount);
								$('#reimTypeModal').html(type);
								$('#reimDescModal').text(desc);
							});
						}
					})
				}
			}
		}
	}	
	xhr.open('GET', 'view_all.loadinfo', true);
	xhr.send();
}

function approveCase(reimId) {
	console.log(`In approveCase. currentId: ${reimId}`);
	let updateSuccess = false;
	if (reimId != 0) {
		let toSend = [reimId, 3];
		
		let json = JSON.stringify(toSend);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				let success = JSON.parse(xhr.responseText);
					$('#managementModal').modal('hide');
				if (success) {
					$('#successfulReimUpdateModal').modal('show');
					updateSuccess = true;
				} else {
					$('#failedReimUpdateModal').modal('show');
				}
			}
		}
		xhr.open('POST', 'update', true);
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(json);
	}
}

function denyCase(reimId) {
	console.log(`In denyCase. currentId: ${reimId}`);
	if (reimId != 0) {
		let toSend = [reimId, 4];
		
		let json = JSON.stringify(toSend);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				let success = JSON.parse(xhr.responseText);
					$('#managementModal').modal('hide');
				if (success) {
					$('#successfulReimUpdateModal').modal('show');
				} else {
					$('#failedReimUpdateModal').modal('show');
				}
			}
		}
		xhr.open('POST', 'update', true);
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(json);
	}
}

function viewedCase(reimId) {
	console.log(`In viewedCase. currentId: ${reimId}`);
	if (reimId != 0) {
		let toSend = [reimId, 2];
		
		let json = JSON.stringify(toSend);
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
			}
		}
		xhr.open('POST', 'update', true);
		xhr.setRequestHeader('Content-type', 'application/json');
		xhr.send(json);
	}
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