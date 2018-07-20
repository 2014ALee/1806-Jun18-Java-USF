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
	//e.log('In loadLogin();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		//e.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			//e.log('loadLogin html injection')
			
			$('#view').html(xhr.responseText);
			
			loadLoginInfo();
		}
	}
	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loadLoginInfo() {
	//e.log('In loadLoginInfo();');
	$('#login-message').hide();
	$('#login').on('click', login);
}

function login() {
	//e.log('In app.js login();');
	$('#login-message').hide();
	
	let username = $('#login-username').val();
	let password = $('#login-password').val();
	
	let toSend = [username, password];
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			if (user == null) {
				$('#login-message').html('Invalid credentials. Please try again.');
				$('#login-message').show();
			} else {
				//console.log('In login(); roleid ' + user.roleid);
				loadHomePage(user);
				//console.log(`${user.userid} login successful`);
			}
		}
	}
	
	xhr.open('POST', 'login', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadSignUp() {
	//console.log('In loadSignup();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		//console.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			//console.log('loadSignup html injection')
			
			$('#view').html(xhr.responseText);
			//Add click event for submit button
			$('#signup').on('click', signUp);
			loadSignUpInfo();
		}
	}
	
	xhr.open('GET', 'signup.view', true);
	xhr.send();
}

function loadSignUpInfo() {
	//console.log('in loadSignUpInfo()');
	
	$('#signup-message').hide();
	$('#username').blur(validateUsername);
	$('#email').blur(validateEmail);
	$('#register').attr('disabled', true);
}

function signUp() {
	//console.log('In app.js signUp();');
	
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
				//console.log(`${user.userid} sign up successful`)
				loadLogin();
			} else {
				alert('Error occurred while signing up. Please try again.')
			}
		}
	}
	
	xhr.open('POST', 'signup', true);
	xhr.send(json);
}

function validateUsername() {
	//console.log('in validateUsername()');
	
	$('#signup').attr('disabled', false);
	$('#signup-message').hide();
	
	let username = $('#username').val();
	let toSend = username;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#signup-message').show();
				$('#signup-message').html('Username is already in use! Please try another.');
				$('#signup').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', 'username.validate', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function validateEmail() {
	//console.log('in validateEmail()');
	
	$('#signup').attr('disabled', false);
	$('#signup-message').hide();
	
	let email = $('#email').val();
	let toSend = email;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#signup-message').show();
				$('#signup-message').html('Email address is already in use! Please try another.');
				$('#signup').attr('disabled', true)
			}
		}
	}
	
	xhr.open('POST', 'email.validate', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadHomePage(user) {
	//console.log('In app.js loadHomePage();')
	//console.log(user);
	$('#toLogOut').show();
	$('#toLogin').hide();
	$('#toSignUp').hide();
	
	let homeType = 'home.view';
	//console.log(homeType);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
			loadHomePageInfo();
		}
	}
	
	xhr.open('GET', homeType, true);
	xhr.send();
	
}

function loadSideNavInfo() {
	$('.sidenav').show();
	$('#sidebarHome').show();
	$('#sidebarProfile').show();
	
	//Request the current user info
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			
			$('#sidebarHome').on('click', function() {
				loadHomePage(user)
			});
			$('#sidebarProfile').on('click', viewProfile);
			
			if (user.roleid === 1) {
				$('#sidebarManagement').show();
				$('#sidebarAdmin').show();
				$('sidebarReim').hide();
				$('#sidebarManagement').on('click', viewManagerTools);
				$('#sidebarAdmin').on('click', viewAdminTools);
			} else if (user.roleid === 2) {
				$('#sidebarManagement').show();
				$('#sidebarReim').show();
				$('#sidebarManagement').on('click', viewManagerTools);
				$('#viewAllReimb').on('click', loadAllReimb);
				$('#sidebarReim').on('click', loadReimb);
			} else {
				$('#sidebarReim').show();
				$('#sidebarReim').on('click', loadReimb);
			}
		}
	}
	
	xhr.open('GET', 'homepage.loadinfo', true);
	xhr.send();
}


function loadHomePageInfo() {
	//console.log('In loadHomePageInfo();')
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);

			$('#user_firstname').html(user.firstname);
			$('#user_id').html(user.userid);
			$('#user_fn').html(user.firstname);
			$('#user_ln').html(user.lastname);
			$('#user_email').html(user.email);
			$('#user_username').html(user.username);
			loadSideNavInfo();
		}
	}
	
	xhr.open('GET', 'homepage.loadinfo', true);
	xhr.send();
}

function loadReimb() {
	//console.log('In loadReimb();')
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#viewReimb').on('click', viewReimb);
			$('#submitReimb').on('click', loadSubmitReimb);
		}
	}
	xhr.open('GET', 'userReim.view', true);
	xhr.send();
}

function viewReimb() {
	//console.log('In viewReimb();');
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadAllReimb();
		}
	}
	
	xhr.open('GET', 'reimbursements.view', true);
	xhr.send();
}

function loadAllReimb() {
	//console.log('In loadAllReimb();');
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimbs = JSON.parse(xhr.responseText);
			if (reimbs.length > 0) {
				reimbs.forEach((reimb) => {
					let amount = parseFloat(Math.round(reimb.reimbAmount * 100) / 100).toFixed(2);
					let statusInt = reimb.statusId;
					let statusString; 
					if (statusInt == 1) {
						statusString = 'Pending';
					} else if (statusInt == 2) {
						statusString = 'Approved';
					} else if (statusInt == 3) {
						statusString = 'Denied';
					} else {
						statusString = 'Invalid';
					}
					
					let markup = `<tr id="${reimb.reimbId}">
								      <th scope="row">${reimb.reimbId}</th>
								      <td>${reimb.author}</td>
								      <td>${amount}</td>
								      <td>${statusString}</td>
								  </tr>`;
					
					$('table tbody').append(markup);
				})
				$('table').on('click', 'tr', viewReimbDetails);
			} else {
				let noReimb = `<tr>
							      <td colspan="4">No reimbursements found</th>
							    </tr>`;
				$('table tbody').append(noReimb);
			}
		}
	}
	xhr.open('GET', 'reimb.loadreimb', true);
	xhr.send();
}

function viewReimbDetails(event) {
	//console.log('In reimbDetiails();')
	let reimbId = (this.id);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadReimbDetails(reimbId);
		}
	}
	xhr.open('GET', 'reimbDetails.view', true);
	xhr.send();
}

function loadReimbDetails(reimbId) {
	//console.log('In loadReimbDetails();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimbs = JSON.parse(xhr.responseText);
			reimbs.forEach((reimb) => {
				if (reimb.reimbId == reimbId) {
					
					let amount = parseFloat(Math.round(reimb.reimbAmount * 100) / 100).toFixed(2);
					let statusInt = reimb.statusId;
					let statusString; 
					if (statusInt == 1) {
						statusString = 'Pending';
					} else if (statusInt == 2) {
						statusString = 'Approved';
					} else if (statusInt == 3) {
						statusString = 'Denied';
					} else {
						statusString = 'Invalid';
					}
					let subDate = new Date();
					subDate.setTime(reimb.submitted);
					let resolved;
					if (reimb.resolved == null) {
						resolved = 'Not resolved'
					} else {
						let resDate = new Date();
						resDate.setTime(reimb.resolved);
						resolved = resDate;
					}
					let resolver = (reimb.resolver != 0) ? reimb.resolver : "Not resolved";
					
					$('#reimbDetailId').val(reimbId);
					$('#author').val(reimb.author);
					$('#amount').val(amount);
					$('#status').val(statusString);
					$('#submitted').val(subDate);
					$('#resolved').val(resolved);
					$('#resolver').val(resolver);
					$('#description').val(reimb.description);
				}
			})
		}
	}
	xhr.open('GET', 'reimb.loadreimb', true);
	xhr.send();
}

function viewProfile() {
	//console.log('In viewProfile();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadProfileInfo();
		}
	}
	xhr.open('GET', 'userProfile.view', true);
	xhr.send();
}

function loadProfileInfo() {
	//console.log('In loadProfileInfo();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			$('#user_id').html(user.userid);
			$('#user_fn').html(user.firstname);
			$('#user_ln').html(user.lastname);
			$('#user_email').html(user.email);
			$('#user_username').html(user.username);
			$('#user_password').html(user.password);
		}
	}
	xhr.open('GET', 'userProfile.loadinfo', true);
	xhr.send();
}

function loadSubmitReimb() {
	//e.log('In loadSubmitReimb();');
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#submitReimb').on('click', submitReimb);
		}
	}
	xhr.open('GET', 'submitReimb.view', true);
	xhr.send();	
}


function submitReimb() {
	//e.log('In submitReimb();');
	
	let type = $('#typeSelection').val();
	let amount = $('#amount').val();
	let description = $('#description').val();
	
	let reimbInfo = [type, amount, description];
	let json = JSON.stringify(reimbInfo);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimb = JSON.parse(xhr.responseText);
			
			if (reimb != null) {
				alert('Submitted Successful!')
				//e.log(`${reimb.authorId} sign up successful`)
				viewReimb();
			} else {
				alert('Error occurred while submitting. Please try again.')
			}
		}
	}
	xhr.open('POST', 'submitReimb', true);
	xhr.send(json);
}

function viewUsers() {
	//e.log('In viewUsers();')
}

function logout() {
	//e.log('In logout();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//e.log('Session invalidated');
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

function viewManagerTools() {
	//e.log('In viewManagerTools();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#viewUsers').on('click', function() {
				managerViewUsers(3)
			});
			$('#viewManagers').on('click', function() {
				managerViewUsers(2)
			});
			$('#updateReimb').on('click', managerViewReimb);
		}
	}
	xhr.open('GET', 'managerTools.view', true);
	xhr.send();
}

function viewAdminTools() {
	//e.log('In viewAdminTools();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#viewUsers').on('click', function() {
				adminViewUsers(3)
			});
			$('#viewManagers').on('click', function() {
				adminViewUsers(2)
			});
			$('#viewAdmins').on('click', function() {
				adminViewUsers(1);
			});
		}
	}
	xhr.open('GET', 'adminTools.view', true);
	xhr.send();
}

function adminViewUsers(selection) {
	//e.log('In adminViewUsers();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			adminLoadAllUsersInfo(selection);
		}
	}
	xhr.open('GET', 'adminViewUsers.view', true);
	xhr.send();
}

function managerViewUsers(selection) {
	//e.log('In managerViewUsers();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			managerLoadAllUsersInfo(selection);
		}
	}
	xhr.open('GET', 'managerViewUsers.view', true);
	xhr.send();
}

function adminLoadAllUsersInfo(selectionId) {
	//e.log('In adminLoadAllUsersInfo();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let users = JSON.parse(xhr.responseText);
			
			users.forEach((user) => {
				let roleInt = user.roleid;
//				//e.log(user.username);
//				//e.log(roleInt);
				if (roleInt == selectionId) {
					let roleString;
					if (roleInt == 1) {
						roleString = 'Administrator';
					} else if (roleInt == 2) {
						roleString = 'Manager';
					} else {
						roleString = 'User';
					}
					
					let markup = `<tr id="${user.userid}">
									<th scope="row">${user.userid}</th>
									<td>${user.firstname}</td>
									<td>${user.lastname}</td>
									<td>${user.username}</td>
									<td>${roleString}</td>
								 </tr>`;
					$('table tbody').append(markup);
				}
			})
			$('table').on('click', 'tr', adminViewUserDetails);
		}
	}
	xhr.open('GET', 'userInfo.loadinfo', true);
	xhr.send();
}

function managerLoadAllUsersInfo(selectionId) {
	//e.log('In managerLoadAllUsersInfo();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let users = JSON.parse(xhr.responseText);
			
			users.forEach((user) => {
				let roleInt = user.roleid;
//				//e.log(user.username);
//				//e.log(roleInt);
				if (roleInt == selectionId) {
					let roleString;
					if (roleInt == 2) {
						roleString = 'Manager';
					} else {
						roleString = 'User';
					}
					
					let markup = `<tr id="${user.userid}">
									<th scope="row">${user.userid}</th>
									<td>${user.firstname}</td>
									<td>${user.lastname}</td>
									<td>${user.username}</td>
									<td>${roleString}</td>
								 </tr>`;
					$('table tbody').append(markup);
				}
			})
			$('table').on('click', 'tr', managerViewUserDetails);
		}
	}
	xhr.open('GET', 'userInfo.loadinfo', true);
	xhr.send();
}

function adminViewUserDetails() {
	//e.log('In adminViewUserDetails();')
	let userid = (this.id);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			adminUserDetails(userid);
		}
	}
	xhr.open('GET', 'adminUserDetails.view', true);
	xhr.send();
}

function managerViewUserDetails() {
	//e.log('In managerViewUserDetails();')
	let userid = (this.id);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			managerUserDetails(userid);
		}
	}
	xhr.open('GET', 'managerUserDetails.view', true);
	xhr.send();
}

function adminUserDetails(userid) {
	//e.log('In adminUserDetails();');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let users = JSON.parse(xhr.responseText);
			users.forEach((user) => {
				if (user.userid== userid) {
					let roleInt = user.roleid;
					//e.log(user.username);
					//e.log(roleInt);
					let roleString; 
					if (roleInt == 1) {
						roleString = 'Administrator';
					} else if (roleInt == 2) {
						roleString = 'Manager';
					} else if (roleInt == 3) {
						roleString = 'User';
					} else {
						statusString = 'Invalid';
					}
					
					$('#userDetailId').html(user.userid);
					$('#firstname').val(user.firstname);
					$('#lastname').val(user.lastname);
					$('#username').val(user.username);
					$('#email').val(user.email);
					$('#role').val(roleString);
					$('#changeRole').on('change', function() {
						if ($('#changeRole').val() != roleInt) {
							$('#saveRole').show()
						} else {
							$('#saveRole').hide();
						}
					});
					$('#saveRole').on('click', changeUserRole);
				}
			})
		}
	}
	xhr.open('GET', 'userInfo.loadinfo', true);
	xhr.send();
}

function managerUserDetails(userid) {
	//e.log('In managerUserDetails();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let users = JSON.parse(xhr.responseText);
			users.forEach((user) => {
				if (user.userid == userid) {
					let roleInt = user.roleid;
					//e.log(user.username);
					//e.log(roleInt);
					let roleString; 
					if (roleInt == 2) {
						roleString = 'Manager';
					} else if (roleInt == 3) {
						roleString = 'User';
					} else {
						statusString = 'Invalid';
					}					
					$('#userDetailId').html(user.userid);
					$('#firstname').val(user.firstname);
					$('#lastname').val(user.lastname);
					$('#username').val(user.username);
					$('#email').val(user.email);
					$('#role').val(roleString);
				}
			})
		}
	}
	xhr.open('GET', 'userInfo.loadinfo', true);
	xhr.send();
}

function changeUserRole() {
	//e.log('In changeUserRole();');
	let newRole = $('#changeRole').val();
	let userid = $('#userDetailId').text();
	let roleInfo = [newRole, userid];
	let json = JSON.stringify(roleInfo);
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			//e.log(user);
			adminUserDetails(user.userid);
		}
	}
	xhr.open('POST', 'changeRole.userrole', true);
	xhr.send(json);
}

function managerViewReimb() {
	//e.log('In managerViewReimb();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			managerLoadReimbDetails();
		}
	}
	xhr.open('GET', 'managerViewReimb.view', true);
	xhr.send();
}

function managerLoadReimbDetails() {
	//e.log('In managerLoadReimbDetails();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimbs = JSON.parse(xhr.responseText);
			
			reimbs.forEach((reimb) => {
			let typeInt = reimb.typeId;
			let statusInt = reimb.statusId;
			let amount = parseFloat(Math.round(reimb.reimbAmount * 100) / 100).toFixed(2);
				let typeString;
				let statusString;
				if (typeInt == 1) {
					typeString = 'Lodging';
				} else if (typeInt == 2) {
					typeString = 'Travel';
				} else if (typeInt == 3){
					typeString = 'Food';
				} else if (typeInt == 4) {
					typeString = 'Other'
				}
				if (statusInt == 1) {
					statusString = 'Pending';
				} else if (statusInt == 2) {
					statusString = 'Approved';
				} else if (statusInt == 3){
					statusString = 'Denied';
				}
				
				let markup = `<tr id="${reimb.reimbId}">
								<th scope="row">${reimb.reimbId}</th>
								<td>${reimb.author}</td>
								<td>${amount}</td>
								<td>${typeString}</td>
								<td>${statusString}</td>
							 </tr>`;
				$('table tbody').append(markup);
			})
			$('table').on('click', 'tr', managerViewReimbDetails);
		}
	}
	xhr.open('GET', 'reimbInfo.loadinfo', true);
	xhr.send();
}

function managerViewReimbDetails() {
	//e.log('In managerViewReimbDetails();')
	let reimbid = (this.id);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			managerReimbDetails(reimbid);
		}
	}
	xhr.open('GET', 'managerReimbDetails.view', true);
	xhr.send();
}

function managerReimbDetails(reimbid) {
	//e.log('In managerReimbDetails();');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimbs = JSON.parse(xhr.responseText);
			reimbs.forEach((reimb) => {
				if (reimb.reimbId == reimbid) {
					let amount = parseFloat(Math.round(reimb.reimbAmount * 100) / 100).toFixed(2);
					let typeInt = reimb.typeId;
					let statusInt = reimb.statusId;
					let typeString;
					let statusString;
					if (typeInt == 1) {
						typeString = 'Lodging';
					} else if (typeInt == 2) {
						typeString = 'Travel';
					} else if (typeInt == 3){
						typeString = 'Food';
					} else if (typeInt == 4) {
						typeString = 'Other'
					}
					if (statusInt == 1) {
						statusString = 'Pending';
					} else if (statusInt == 2) {
						statusString = 'Approved';
					} else if (statusInt == 3){
						statusString = 'Denied';
					} 
					let subDate = new Date();
					subDate.setTime(reimb.submitted);
					let resolved;
					if (reimb.resolved == null) {
						resolved = 'Not resolved'
					} else {
						let resDate = new Date();
						resDate.setTime(reimb.resolved);
						resolved = resDate;
					}

					let resolver = (reimb.resolver != 0) ? reimb.resolver : "Not resolved";
					
					$('#reimbDetailId').html(reimbid);
					$('#author').val(reimb.author);
					$('#amount').val(amount);
					$('#status').val(statusString);
					$('#submitted').val(subDate);
					$('#resolved').val(resolved);
					$('#resolver').val(resolver);
					$('#description').val(reimb.description);
					$('#changeStatus').on('change', function() {
						if ($('#changeStatus').val() != statusInt) {
							$('#saveReimb').show()
						} else {
							$('#saveReimb').hide();
						}
					});
					$('#saveReimb').on('click', changeReimbStatus);
				}
			})
		}
	}
	xhr.open('GET', 'reimbInfo.loadinfo', true);
	xhr.send();
}

function changeReimbStatus() {
	//e.log('In changeReimbStatus();');
	let newStatus = $('#changeStatus').val();
	let reimbid = $('#reimbDetailId').text();
	let reimbInfo = [newStatus, reimbid];
	let json = JSON.stringify(reimbInfo);
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimb = JSON.parse(xhr.responseText);
			//e.log(reimb);
			managerReimbDetails(reimb.reimbId);
		}
	}
	xhr.open('POST', 'changeStatus.reimb', true);
	xhr.send(json);
}