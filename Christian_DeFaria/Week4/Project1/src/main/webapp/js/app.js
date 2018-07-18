window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toHome').on('click', loadHome);
	$('#toLogout').on('click', logout);	
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
			
			if(user == null) {
				$('#login-message').html('Invalid credentials!');
			} else {
//				alert('Login successful!');
				loadHome(user);
				console.log(`User id: ${user.user_id} login successful!`)
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
	$('#reg-username').blur(validateUsername);
	$('#email').blur(validateEmail);
	$('#register').attr('disabled', true);
	$('#register').on('click', register);
}

function register() {
	console.log('in register()');
	
	let fn = $('#fn').val();
	let ln = $('#ln').val();
	let email = $('#email').val();
	let username = $('#reg-username').val();
	let password = $('#reg-password').val();
	let r_id = $('#role_id option:selected').val();
	
	console.log('Role_ID: ' + r_id);
	
	let users = {
		user_id: 0,
		firstname: fn,
		lastname: ln,
		email: email,
		username: username,
		password: password,
		role_id: r_id
	};
	
	let userJson = JSON.stringify(users);
	console.log(`user: ${userJson}`);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#message').hide();
			alert('Enrollment successful! Please login using your credentials.');
			loadLogin();
		}
	}
	
	xhr.open('POST', 'register', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(userJson);
}

function validateUsername() {
	console.log('in validateUsername()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let username = $('#reg-username').val();
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
	
	xhr.open('POST', 'username.validate', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
	
}

function validateEmail() {
	console.log('in validateEmail()');
	
	$('#register').attr('disabled', false);
	$('#reg-message').hide();
	
	let email = $('#email').val();
	let toSend = email;
	let json = JSON.stringify(toSend);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user == null) {
				$('#reg-message').show();
				$('#reg-message').html('Email address is already in use! Please try another.');
				$('#register').attr('disabled', true);
			}
		}
	}
	
	xhr.open('POST', 'email.validate', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function loadHome(user) {
	console.log('in loadHome()');
//	$('#toHome').show();
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadHomeInfo(user);
			
			$('#toHome').show();
			$('#toLogout').show();
			$('#toLogin').hide();
			$('#toRegister').hide();
		}
	}
	
	xhr.open('GET', 'home.view', true);
	xhr.send();
}

function loadHomeInfo(user) {
	console.log('in loadHomeInfo()');
	
	$('#filter').off('blur');
	$('#filter').blur(function() {
		$('table tbody').empty();
		loadHomeInfo(user);
	});
	
	$('#viewMyReimb').text('Back to Home');
	$('#viewMyReimb').off('click');
	$('#viewMyReimb').click(function() {
		managerView(user);
	});
	
	let stat_id = $('#filter option:selected').val();
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('table tbody').empty();
			let homeInfo = JSON.parse(xhr.responseText);
			console.log(homeInfo);
			let reimbs = homeInfo;
			
			$('#user_fn').html(user.firstname);
			$('#user_ln').html(user.lastname);
			$('#user_email').html(user.email);
			$('#user_username').html(user.username);
			
			if(reimbs.length > 0) {
				reimbs.forEach((reimb) => {
					let id = reimb.reimbursement_id;
					let amount = parseFloat(Math.round(reimb.amount * 100) / 100).toFixed(2);
					let submitted = new Date(reimb.submitted).toLocaleDateString('en-US');
					let resolved = new Date(reimb.resolved).toLocaleDateString('en-US');
					let desc = reimb.description;
					let auth = reimb.author;
					let stat = reimb.status_id;
					let type = reimb.type_id;
					
					let markup = "";
					if(stat_id == 0 || stat_id == stat) {
						if(user.role_id === 1) {
							markup = '<tr>' +
							'<td>'+id+'</td>'+
							'<td>$'+amount+'</td>'+
							'<td>'+submitted+'</td>'+
							'<td>'+resolved+'</td>'+
							'<td>'+desc+'</td>'+
							'<td>'+auth+'</td>';
						switch(stat) {
							case 1:
								markup+='<td>Pending</td>';
								break;
							case 2:
								markup+='<td>Denied</td>';
								break;
							case 3:
								markup+='<td>Approved</td>';
								break;
						}
						switch(type) {
							case 1:
								markup+='<td>Lodging</td>';
								break;
							case 2:
								markup+='<td>Travel</td>';
								break;
							case 3:
								markup+='<td>Food</td>';
								break;
							case 4:
								markup+='<td>Other</td>';
								break;
						}
						markup+='<td><button class="btn btn-block btn-primary" id="approve${id}">Approve</button></td>';
						markup+='<td><button class="btn btn-block btn-primary" id="deny${id}">Deny</button></td>';
						markup+='</tr><hr/>';
						} else {
							markup = '<tr>' +
							'<td>'+id+'</td>'+
							'<td>$'+amount+'</td>'+
							'<td>'+submitted+'</td>'+
							'<td>'+resolved+'</td>'+
							'<td>'+desc+'</td>'+
							'<td>'+auth+'</td>';
						switch(stat) {
							case 1:
								markup+='<td>Pending</td>';
								break;
							case 2:
								markup+='<td>Denied</td>';
								break;
							case 3:
								markup+='<td>Approved</td>';
								break;
						}
						switch(type) {
							case 1:
								markup+='<td>Lodging</td>';
								break;
							case 2:
								markup+='<td>Travel</td>';
								break;
							case 3:
								markup+='<td>Food</td>';
								break;
							case 4:
								markup+='<td>Other</td>';
								break;
						}
						markup+='</tr><hr/>';
						}
					}
					
					
					$('table tbody').append(markup);
					if(user.role_id === 1) {
						if(reimbs.length > 0) {
							for(let i = 0; i < reimbs.length; i++) {
								let id = reimb.reimbursement_id;
								let stat = reimbs[i].status_id;
								if(stat_id == 0 || stat_id == stat) {
									$('#approve'+id).click(function() {
										approve(user, id);
									});
									$('#deny'+id).click(function() {
										deny(user, id);
									});
								}
							}
						}
					} else {
						$('#viewMyReimb').attr('hidden', true);
					}
				});
			} else {
				$('#empty-table').html('No accounts on record');
			}
			$('#viewMyReimb').text('View my Reimbursements');
			$('#addReimb').click(function() {
				loadAdd(user);
			})
		}
	}
	
	xhr.open('GET', 'home.loadInfo', true);
	xhr.send();
}

function managerView(user) {
	console.log('in managerView()');
	$('table tbody').empty();
	
	$('#filter').off('blur');
	$('#filter').blur(function(event) {
		$('table tbody').empty();
		managerView(user);
	});

	$('#viewMyReimb').text('Back to Home');
	$('#viewMyReimb').off('click');
	$('#viewMyReimb').click(function(event) {
		loadHomeInfo(user);
	});
	
	let stat_id = $('#filter option:selected').val();
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
//			$('#toHome').hide();
			$('table tbody').empty();
			let homeInfo = JSON.parse(xhr.responseText);
			console.log(homeInfo);
			let reimbs = homeInfo;
			
			$('#user_fn').html(user.firstname);
			$('#user_ln').html(user.lastname);
			$('#user_email').html(user.email);
			$('#user_username').html(user.username);
			
			if(reimbs.length > 0) {
				reimbs.forEach((reimb) => {
					let id = reimb.reimbursement_id;
					let amount = parseFloat(Math.round(reimb.amount * 100) / 100).toFixed(2);
					let submitted = new Date(reimb.submitted).toLocaleDateString('en-US');
					let resolved = new Date(reimb.resolved).toLocaleDateString('en-US');
					let desc = reimb.description;
					let auth = reimb.author;
					let stat = reimb.status_id;
					let type = reimb.type_id;
					
					let markup = "";
					if(stat_id == 0 || stat_id == stat) {
						markup = '<tr>' +
							'<td>'+id+'</td>'+
							'<td>$'+amount+'</td>'+
							'<td>'+submitted+'</td>'+
							'<td>'+resolved+'</td>'+
							'<td>'+desc+'</td>'+
							'<td>'+auth+'</td>';
						switch(stat) {
							case 1:
								markup+='<td>Pending</td>';
								break;
							case 2:
								markup+='<td>Denied</td>';
								break;
							case 3:
								markup+='<td>Approved</td>';
								break;
						}
						switch(type) {
							case 1:
								markup+='<td>Lodging</td>';
								break;
							case 2:
								markup+='<td>Travel</td>';
								break;
							case 3:
								markup+='<td>Food</td>';
								break;
							case 4:
								markup+='<td>Other</td>';
								break;
						}
						markup+='</tr><hr/>';
					}
				
					$('table tbody').append(markup);
				});
			} else {
				$('#empty-table').html('No accounts on record');
			}
			$('#addReimb').click(function() {
				loadAdd(user);
			});
		}
	}

	xhr.open('GET', 'manager.loadInfo', true);
	xhr.send();
}

function logout() {
	console.log("in logout");
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status==200) {
			console.log("Session Invalidated");
			loadLogin();
		}
	}
	
	xhr.open('GET', 'logout', true);
	xhr.send();
}

function loadAdd(user) {
	console.log('in loadAdd()');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadAddInfo(user);
		}
	}
	
	xhr.open('GET', 'add.view', true);
	xhr.send();
}

function loadAddInfo(user) {
	console.log('in loadAddInfo()');
	
	$('#amount').blur(validateAmount);
	$('#addReimb').on('click', function() {
		add(user);
	});
}

function add(user) {
	console.log('in add()');
	console.log('user: ' + JSON.stringify(user));
	
	let amount = $('#amount').val();
	let desc = $('#desc').val();
	let type_id = $('#type_id option:selected').val();
	
	let toSend = [user.user_id, amount, desc, type_id];
	let json = JSON.stringify(toSend);
	console.log(`json: ${json}`);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			alert('Reimbursement successfully added. Routing to home page...');
			loadHome(user);
		}
	}
	
	xhr.open('POST', 'add', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function validateAmount() {
	let amount = Number($('#amount').val());
	if(amount==NaN || amount < 0) {
		$('addReimb').attr('disabled', true);
		alert(`Invalid Amount: ${amount}`)
	}
}

function approve(user, id) {
	console.log(`In approve(${user}, ${id})`);
	let xhr = new XMLHttpRequest();
	let toSend = [user.user_id, id];
	let json = JSON.stringify(toSend);
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status==200) {
			loadHome(user);
		}
	}
	
	xhr.open('POST', 'approve.update', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}

function deny(user, id) {
	console.log(`In deny(${user}, ${id})`);
	let xhr = new XMLHttpRequest();
	let toSend = [user.user_id, id];
	let json = JSON.stringify(toSend);
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status==200) {
			loadHome(user);
		}
	}
	
	xhr.open('POST', 'deny.update', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(json);
}