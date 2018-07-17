/**
 * 
 */
window.onload = function () {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toSignUp').on('click', loadSignUp);
	$('#toLogOut').on('click', logout);
	$('#toLogOut').hide();
	//Hide side bar links and only show depending on user type
	$('#sidebarHome').hide();
	$('#sidebarReim').hide();
	$('#sidebarProfile').hide();
	$('#sidebarManagement').hide();
	$('#sidebarAdmin').hide();
}

function loadLogin() {
	console.log('In loadLogin();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		console.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('loadLogin html injection')
			
			$('#view').html(xhr.responseText);
			
			loadLoginInfo();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	console.log('In loadLoginInfo();');
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	console.log('In app.js login();');
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			if (user == null) {
				alert('Invalid credentials. Please try again.');
			} else {
				console.log('In login(); roleid ' + user.roleid);
				loadHomePage(user);
				console.log(`${user.userid} login successful`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadSignUp() {
	console.log('In loadSignup();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		//console.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('loadSignup html injection')
			
			$('#view').html(xhr.responseText);
			//Add click event for submit button
			$('#signup').on('click', signUp);
		}
	}
	
	xhr.open('GET', 'signup.view', true);
	xhr.send();
}

function signUp() {
	console.log('In app.js signUp();');
	
	let firstname = $('#firstname').val();
	let lastname = $('#lastname').val();
	let username = $('#username').val();
	let email = $('#email').val();
	let pass = $('#password').val();
	
	let userInfo = [firstname, lastname, username, email, pass];
	let json = JSON.stringify(userInfo);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			if (user != null) {
				alert('Sign Up Successful!')
				console.log(`${user.userid} sign up successful`)
				loadLogin();
			} else {
				alert('Error occurred while signing up. Please try again.')
			}
		}
	}
	
	xhr.open('POST', 'signup', true);
	xhr.send(json);
}

//Add credential checks later//

function loadHomePage(user) {
	console.log('In app.js loadHomePage();')
	console.log('In loadHomePage roleid' + user.roleid);
	$('#toLogOut').show();
	$('#toLogin').hide();
	$('#toSignUp').hide();
	
	let homeType;
	$('#sidebarHome').show();
	$('#sidebarReim').show();
	$('#sidebarProfile').show();
	
	if (user.roleid == 1) {
		$('#sidebarManagement').show();
		$('#sidebarAdmin').show();
		homeType = 'adminhome.view';
	} else if (user.roleid == 2) {
		$('#sidebarManagement').show();
		homeType = 'managerhome.view';
	} else {
		homeType = 'home.view';
	}
	//console.log(homeType);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
			loadHomePageInfo();
			loadSideNavInfo();
		}
	}
	
	xhr.open('GET', homeType, true);
	xhr.send();
	
}

function loadSideNavInfo() {
	$('.sidenav').show();
	$('#sidebarHome').on('click', loadHomePageInfo);
	
	//Request the current user info
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			if (user.roleid === 1) {
				$('#viewAllReimb').on('click', loadAllReimb);
				$('#viewUsers').on('click', loadAllUsers);
			} else if (user.roleid === 2) {
				$('#viewAllReimb').on('click', loadAllReimb);
				$('#sidebarProfile').on('click', loadProfile);
			} else if (user.roleid === 3){
				$('#sidebarReim').on('click', loadReimb);
				//$('#submitReimb').on('click', loadSubmitReimb);
				$('#sidebarProfile').on('click', loadProfile);
			}
		}
	}
	
	xhr.open('GET', 'homepage.loadinfo', true);
	xhr.send();
}


function loadHomePageInfo() {
//	let homeType;
//	
//	if (user.roleid == 1) {
//		$('#sidebarManagement').show();
//		$('#sidebarAdmin').show();
//		homeType = 'adminhome.view';
//	} else if (user.roleid == 2) {
//		$('#sidebarManagement').show();
//		homeType = 'managerhome.view';
//	} else {
//		homeType = 'home.view';
//	}
//	//console.log(homeType);
//	
//	let xhr = new XMLHttpRequest();
//	
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			//console.log(xhr.responseText);
//			$('#view').html(xhr.responseText);
//		}
//	}
//	
//	xhr.open('GET', homeType, true);
//	xhr.send();
	console.log('In loadHomePageInfo();')
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
//			if (user.roleid === 1) {
//				$('#viewAllReimb').on('click', loadAllReimb);
//				$('#viewUsers').on('click', loadAllUsers);
//			} else if (user.roleid === 2) {
//				$('#viewAllReimb').on('click', loadAllReimb);
//				$('#sidebarProfile').on('click', loadProfile);
//			} else if (user.roleid === 3){
//				$('#viewReimb').on('click', loadReimb);
//				$('#submitReimb').on('click', loadSubmitReimb);
//				$('#sidebarProfile').on('click', loadProfile);
//			}
		}
	}
	
	xhr.open('GET', 'homepage.loadinfo', true);
	xhr.send();
}

function loadReimb() {
	console.log('In loadReimb();')
}

function loadAllReimb() {
	console.log('In loadAllReimb();')
}

function loadAllUser() {
	console.log('In loadAllUsers();')
}

function loadProfile() {
	console.log('In loadProfile();')
}

function loadSubmitReimb() {
	console.log('In loadSubmitReimb();')
}

function viewReimb() {
	console.log('In viewReimb();')
}

function submitReimb() {
	console.log('In submitReimb();')
}

function viewUsers() {
	console.log('In viewUsers();')
}

function logout() {
	console.log('In logout();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('Session invalidated');
			loadLogin();
			$('.sidenav').hide();
			$('#toLogin').show();
			$('#toSignUp').show();
			$('#toLogOut').hide();
			$('#sidebarHome').hide();
			$('#sidebarReim').hide();
			$('#sidebarProfile').hide();
			$('#sidebarManagement').hide();
			$('#sidebarAdmin').hide();
		}
	}
	
	xhr.open('GET', 'logout', true);
	xhr.send();
}

