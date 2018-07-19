window.onload = function(){
	loadLogin();
	document.getElementById('loginPage').addEventListener('click', loadLogin);
	document.getElementById('registerPage').addEventListener('click', loadRegister);
	document.getElementById('homePage').addEventListener('click', loadHome);
	document.getElementById('reimbPage').addEventListener('click', loadReimbs);
	document.getElementById('reimbPageAdmin').addEventListener('click', loadReimbsAdmin);
	document.getElementById('logoutPage').addEventListener('click', logout);
	document.getElementById('allReimbPage').addEventListener('click', loadAllReimbs);
	document.getElementById('editReimbPage').addEventListener('click', loadEditReimbs);
	document.getElementById('homeAdminPage').addEventListener('click', loadHomeAdmin);
	document.getElementById('registerAdminPage').addEventListener('click', loadRegisterAdmin);
}
function loadLogin(){
	console.log('in loadLogin()');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('registerPage').removeAttribute('hidden', false);
			document.getElementById('loginPage').removeAttribute('hidden', false);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('logoutPage').setAttribute('hidden', true);
			document.getElementById('allReimbPage').setAttribute('hidden', true);
			document.getElementById('editReimbPage').setAttribute('hidden', true);
			document.getElementById('homeAdminPage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').setAttribute('hidden', true);
			document.getElementById('registerAdminPage').setAttribute('hidden', true);
			document.getElementById('loginButton').addEventListener('click', loginButton);
		}
		console.log('past the if statement in login');
	}

	xhr.open('GET', 'login.view', true);
	xhr.send();
}
function loadHome(){
	console.log('in loadHome()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			homePageFunctions();
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homePage').removeAttribute('hidden', false);
			document.getElementById('reimbPage').removeAttribute('hidden', false);
			document.getElementById('reimbPageAdmin').setAttribute('hidden', true);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
			document.getElementById('homeAdminPage').setAttribute('hidden', true);
			document.getElementById('allReimbPage').setAttribute('hidden', true);
			document.getElementById('editReimbPage').setAttribute('hidden', true);
			document.getElementById('registerAdminPage').setAttribute('hidden', true);
		}
		console.log('past the if statement in home');
	}
	xhr.open('GET', 'home.view', true);
	xhr.send();
}
function loadRegister(){
	console.log('in loadRegister()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('registerPage').removeAttribute('hidden', false);
			document.getElementById('loginPage').removeAttribute('hidden', false);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').setAttribute('hidden', true);
			document.getElementById('logoutPage').setAttribute('hidden', true);
			document.getElementById('homeAdminPage').setAttribute('hidden', true);
			document.getElementById('allReimbPage').setAttribute('hidden', true);
			document.getElementById('editReimbPage').setAttribute('hidden', true);
			document.getElementById('registerAdminPage').setAttribute('hidden', true);
			document.getElementById('registerButton').addEventListener('click', registerButton);
		}
		console.log('past the if statement in register');
	}
	xhr.open('GET', 'register.view', true);
	xhr.send();
}
function loadReimbs(){
	console.log('in loadReimbs()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			loadCurrentReimbs();
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homePage').removeAttribute('hidden', false);
			document.getElementById('reimbPage').removeAttribute('hidden', false);
			document.getElementById('reimbPageAdmin').setAttribute('hidden', true);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
			document.getElementById('homeAdminPage').setAttribute('hidden', true);
			document.getElementById('allReimbPage').setAttribute('hidden', true);
			document.getElementById('editReimbPage').setAttribute('hidden', true);
			document.getElementById('registerAdminPage').setAttribute('hidden', true);
		}
		console.log('past the if statement in reimbs');
	}
	xhr.open('GET', 'reimbs.view', true);
	xhr.send();
}
function logout(){
	console.log('in logout()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadLogin();
		}
		console.log('past the if statement in logout');
	}
	xhr.open('GET', 'logout', true);
	xhr.send();
}
function loadHomeAdmin(){
	console.log('in homeAdmin()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			loadAdminFunctions();
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('registerAdminPage').removeAttribute('hidden', false);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homeAdminPage').removeAttribute('hidden', false);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').removeAttribute('hidden', false);
			document.getElementById('allReimbPage').removeAttribute('hidden', false);
			document.getElementById('editReimbPage').removeAttribute('hidden', false);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
		}
		console.log('past the if statement in homeadmin');
	}
	xhr.open('GET', 'homeAdmin.view', true);
	xhr.send();
}
function loadEditReimbs(){
	console.log('in loadEditReimbs()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			loadEditReimbursements();
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homeAdminPage').removeAttribute('hidden', true);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').removeAttribute('hidden', false);
			document.getElementById('allReimbPage').removeAttribute('hidden', false);
			document.getElementById('editReimbPage').removeAttribute('hidden', false);
			document.getElementById('logoutPage').removeAttribute('hidden', true);
			document.getElementById('registerAdminPage').removeAttribute('hidden', true);

		}
		console.log('past the if statement in editreimbs');
	}
	xhr.open('GET', 'loadEditReimbs.view', true);
	xhr.send();
}
function loadAllReimbs(){
	console.log('in loadAllReimbs()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			loadAllReimbursements();
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homeAdminPage').removeAttribute('hidden', true);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').removeAttribute('hidden', false);
			document.getElementById('allReimbPage').removeAttribute('hidden', false);
			document.getElementById('editReimbPage').removeAttribute('hidden', false);
			document.getElementById('logoutPage').removeAttribute('hidden', true);
			document.getElementById('registerAdminPage').removeAttribute('hidden', true);

		}
		console.log('past the if statement in allreimbs');
	}
	xhr.open('GET', 'loadAllReimbs.view', true);
	xhr.send();
}
function loadRegisterAdmin(){
	console.log('in loadRegisterAdmin()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('registerPage').setAttribute('hidden', false);
			document.getElementById('loginPage').setAttribute('hidden', false);
			document.getElementById('homeAdminPage').removeAttribute('hidden', true);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').removeAttribute('hidden', false);
			document.getElementById('editReimbPage').removeAttribute('hidden', false);
			document.getElementById('allReimbPage').removeAttribute('hidden', false);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
			document.getElementById('registerAdminPage').removeAttribute('hidden', true);
			document.getElementById('raButton').addEventListener('click', adminRegisterButton);
		}
		console.log('past the if statement in registerAdmin');
	}
	xhr.open('GET', 'loadRegisterAdmin.view', true);
	xhr.send();
}
function loginButton(){
	let un = document.getElementById('username').value;
	let pw = document.getElementById('password').value;
	let credentials = [un, pw];
	let json = JSON.stringify(credentials);
	if(un =='' || pw == ''){
		console.log('bad alert happens here');
		alert('Please enter both Username and Password!');
	}
	else{
		console.log('else called');
		let xhr = new XMLHttpRequest;
		xhr.onreadystatechange = function(){
			console.log('request sent');
			if(xhr.readyState == 4 && xhr.status == 200){
				let getCode = JSON.parse(xhr.responseText)
				if(getCode == 0){
					alert('Invalid Username or Password!')
				}
				else if(getCode == 1){
					loadHome();
					console.log('valid user login');
				}
				else{
					loadHomeAdmin();
					console.log('valid admin login');
				}
			}
		}
		xhr.open('POST','login', true); //POST is the type of request, login is the servlet
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(json);
	}
};
function registerButton(){
	let fn = document.getElementById('firstname').value;
	let ln = document.getElementById('lastname').value;
	let un = document.getElementById('username').value;
	let pw = document.getElementById('password').value;
	let email = document.getElementById('email').value;
	let userInfo = [fn, ln, un, pw, email];
	let json = JSON.stringify(userInfo);
	let emailRegEx = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
	if(fn=='' || ln=='' || un =='' || pw == ''|| email == ''){
		console.log('bad alert happens here');
		alert('Please enter all fields!');
	}
	else if(!emailRegEx.test(email)){
		console.log('bad alert happens here');
		alert('Invalid Email');
	}
	else{
		console.log('else called');
		let xhr = new XMLHttpRequest;
		xhr.onreadystatechange = function(){
			console.log('request sent');
			if(xhr.readyState == 4 && xhr.status == 200){
				let getCode = JSON.parse(xhr.responseText)
				if(getCode == 1){
					alert('Username taken, try a different one!');
				}
				else if(getCode == 2){
					alert('Email is in use, try another one!');
				}
				else{
					alert('Successful User Registration');
					loadLogin();
					console.log('valid user registration');
				}
			}
		}
		xhr.open('POST','register', true); //POST is the type of request, login is the servlet
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(json);
	}
}
function newReimbursementPage(){
	console.log('in newReimbursementPage()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homePage').removeAttribute('hidden', false);
			document.getElementById('reimbPage').removeAttribute('hidden', false);
			document.getElementById('reimbPageAdmin').setAttribute('hidden', true);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
			document.getElementById('homeAdminPage').setAttribute('hidden', true);
			document.getElementById('editReimbPage').setAttribute('hidden', true);
			document.getElementById('allReimbPage').setAttribute('hidden', true);
			document.getElementById('registerAdminPage').setAttribute('hidden', true);
			document.getElementById('submitReimb').addEventListener('click', submitReimbursement);
		}
		console.log('past the if statement in home');
	}
	xhr.open('GET', 'NewReimbPage.view', true);
	xhr.send();
}
function loadPastReimbs(){
	console.log('loading one user\'s past reimbursements.');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let userReimb = JSON.parse(xhr.responseText);
			let user = userReimb.user;
			let reimbs = userReimb.uReimbs;
			console.log(reimbs);
			if(reimbs.length > 0){
				reimbs.forEach((reimb)=>{
					let submitTime = reimb.submitTime;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let amount = parseFloat(Math.round(reimb.amount*100)/100).toFixed(2);
					let desc = reimb.description;
					let status = (reimb.statusId == 2) ? 'Approved':'Denied';
					let type ='';
					switch(reimb.typeId){
					case 1:
						type = 'Lodging';
						break;
					case 2:
						type = 'Travel';
						break;
					case 3:
						type = 'Food';
						break;
					case 4:
						type = 'Other';
						break;
					default:
						type = 'Other';
					}
					let resolveTime = reimb.resolveTime;
					let rYear = new Date(resolveTime).getFullYear();
					let rMonth = new Date(resolveTime).getMonth();
					let rDay = new Date(resolveTime).getDate();
					let rTime = `${rMonth}/${rDay}/${rYear}`;
					console.log('Reimb.Resolvetime = null?: '+reimb.resolveTime == null);
					if(resolveTime == null || !resolveTime){
						resolveTime == 'N/A';
					}
					let format = `<tr><td>${sTime}</td><td>$${amount}</td><td>${desc}</td>
						<td>${status}</td><td>${type}</td><td>${rTime}</td></tr>`;
					$('table tbody').append(format);

				})
			}
			else{
				$('#Reimbursement-Alert').html('No reimbursements have been submitted.')
			}
		}
	}
	xhr.open('GET','oldReimbs.loadReimbs',true);
	xhr.send()
}
function loadEditReimbursements(){
	console.log('loading all editable user reimbursements.');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let userReimb = JSON.parse(xhr.responseText);
			let user = userReimb.user;
			let reimbs = userReimb.uReimbs;
			console.log('reimbs = '+reimbs);
			if(reimbs.length > 0){
				reimbs.forEach((reimb)=>{
					let submitID = reimb.authorId;
					let resolveID = reimb.resolverId;
					let submitTime = reimb.submitTime;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let amount = parseFloat(Math.round(reimb.amount*100)/100).toFixed(2);
					let desc = reimb.description;
					let theStatus = '';
					switch(reimb.statusId){
					case 1:
						theStatus = 'Pending';
						break;
					case 2:
						theStatus = 'Approved';
						break;
					case 3:
						theStatus = 'Denied';
						break;
					default:
						theStatus = 'Pending';
					}
					let type = '';
					switch(reimb.typeId){
					case 1:
						type = 'Lodging';
						break;
					case 2:
						type = 'Travel';
						break;
					case 3:
						type = 'Food';
						break;
					case 4:
						type = 'Other';
						break;
					default:
						type = 'Other';
					}
					let adminOption = reimb.action;
					let format = `<tr><td>${submitID}</td><td>${resolveID}</td><td>${sTime}</td><td>$${amount}</td><td>${desc}</td>
						<td>${theStatus}</td><td>${type}</td><td><select class="form-control" id="adminChoice"><option>&nbsp;</option><option>Approve</option><option>Deny</option></td></tr>`;
					$('table tbody').append(format);

				})
			}
			else{
				$('#Reimbursement-Alert').html('No reimbursements have been submitted.');
			}
			document.getElementById('SubmitAction').addEventListener('click', function(){
				console.log('submit button hit');
				console.log('does user carry over? '+user);
				let changedReimb = [];
				for (let i = 0; i < reimbs.length; i++){
					if(document.getElementsByClassName('form-control')[i].value == 'Approve' || document.getElementsByClassName('form-control')[i].value == 'Deny'){
						reimbs[i].action = document.getElementsByClassName('form-control')[i].value;
						changedReimb.push(reimbs[i]);
						console.log('pushed an object');
					}
					console.log(reimbs[i]+' at position '+i+' has just been passed.');
				}
				let json = JSON.stringify(changedReimb);
				let xhr2 = new XMLHttpRequest();
				xhr2.onreadystatechange = function(){
					if(xhr2.readyState == 4 && xhr2.status == 200){
						console.log(changedReimb);
						console.log('total of changed reimbs: '+changedReimb.length);
						let getCode = JSON.parse(xhr.responseText)
						if(getCode == 1){
							alert('Username taken, try a different one!');
						}
						else if(getCode == 2){
							alert('Email is in use, try another one!');
						}
						else{
							alert('Successful Submission');
							loadHomeAdmin();
							console.log('valid user registration');
						}
					}
				}
				console.log(json);
				xhr2.open('POST','adminSubmit',true);
				xhr2.send(json);
			});
		}
	}
	xhr.open('GET','editReimbs.loadReimbs',true);
	xhr.send()
}
function homePageFunctions(){
	console.log('loading home info and buttons');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('in the callback function');
			let userInfo = JSON.parse(xhr.responseText);
			console.log(userInfo);
			$('#user-fn').html(userInfo.firstName);
			document.getElementById('new-reimbs').addEventListener('click',newReimbursementPage);
		}
		console.log('should be calling the servlet here')
	}
	xhr.open('GET','user.loadUser',true);
	xhr.send();
}
function loadAdminFunctions(){
	console.log('in the admin functions');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('in the callback function for admin');
			let userInfo = JSON.parse(xhr.responseText);
			console.log(userInfo);
			$('#user-fn').html(userInfo.firstName);
			document.getElementById('new-reimbs').addEventListener('click',newReimbursementPageAdmin);


		}
		console.log('should be calling the servlet here')
	}
	xhr.open('GET','admin.loadUser',true);
	xhr.send();
}
function submitReimbursement(){
	let amount = document.getElementById('amount').value;
	let desc = document.getElementById('desc').value;
	let type = document.getElementById('type').value;
	let reimbInfo = [amount, desc, type];
	let json = JSON.stringify(reimbInfo);
	if(amount=='' || desc=='' || type ==''){
		console.log('bad alert happens here');
		alert('Please enter all fields!');
	}
	else{
		console.log('else called');
		let xhr = new XMLHttpRequest;
		xhr.onreadystatechange = function(){
			console.log('request sent');
			if(xhr.readyState == 4 && xhr.status == 200){
				let getCode = JSON.parse(xhr.responseText)
				if(getCode == 1){
					alert('Unsuccessful submission, aborting.');
				}
				else{
					loadHome();
					console.log('successful submission');
				}
			}
		}
		xhr.open('POST','newReimb', true); //POST is the type of request, login is the servlet
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(json);
	}
}
function adminRegisterButton(){
	let fn = document.getElementById('firstname').value;
	let ln = document.getElementById('lastname').value;
	let un = document.getElementById('username').value;
	let pw = document.getElementById('password').value;
	let email = document.getElementById('email').value;
	let userInfo = [fn, ln, un, pw, email];
	let json = JSON.stringify(userInfo);
	let emailRegEx = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
	if(fn=='' || ln=='' || un =='' || pw == ''|| email == ''){
		console.log('bad alert happens here');
		alert('Please enter all fields!');
	}
	else if(!emailRegEx.test(email)){
		console.log('bad alert happens here');
		alert('Invalid Email');
	}
	else{
		console.log('else called');
		let xhr = new XMLHttpRequest;
		xhr.onreadystatechange = function(){
			console.log('request sent');
			if(xhr.readyState == 4 && xhr.status == 200){
				let getCode = JSON.parse(xhr.responseText)
				if(getCode == 1){
					alert('Username taken, try a different one!');
				}
				else if(getCode == 2){
					alert('Email is in use, try another one!');
				}
				else{
					alert('Successful Admin Registration');
					loadHomeAdmin();
					console.log('valid user registration');
				}
			}
		}
		xhr.open('POST','registerAdmin', true); //POST is the type of request, login is the servlet
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(json);
	}
}
function newReimbursementPageAdmin(){
	console.log('in newReimbursementPage()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').removeAttribute('hidden', true);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
			document.getElementById('homeAdminPage').removeAttribute('hidden', false);
			document.getElementById('editReimbPage').removeAttribute('hidden', false);
			document.getElementById('allReimbPage').removeAttribute('hidden', false);
			document.getElementById('registerAdminPage').removeAttribute('hidden', false);
			document.getElementById('submitReimb').addEventListener('click', submitReimbursementAdmin);
		}
		console.log('past the if statement in home');
	}
	xhr.open('GET', 'NewReimbPage.view', true);
	xhr.send();
}
function loadReimbsAdmin(){
	console.log('in loadReimbsAdmin()');

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readystate);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			// document.getElementById('view').innerHTML = xhr.responseText;
			loadPastReimbs();
			document.getElementById('registerPage').setAttribute('hidden', true);
			document.getElementById('loginPage').setAttribute('hidden', true);
			document.getElementById('homePage').setAttribute('hidden', true);
			document.getElementById('reimbPage').setAttribute('hidden', true);
			document.getElementById('reimbPageAdmin').removeAttribute('hidden', false);
			document.getElementById('logoutPage').removeAttribute('hidden', false);
			document.getElementById('homeAdminPage').removeAttribute('hidden', false);
			document.getElementById('editReimbPage').removeAttribute('hidden', false);
			document.getElementById('allReimbPage').removeAttribute('hidden', false);
			document.getElementById('registerAdminPage').removeAttribute('hidden', false);
		}
		console.log('past the if statement in reimbs');
	}
	xhr.open('GET', 'reimbs.view', true);
	xhr.send();
}
function loadCurrentReimbs(){
	console.log('loading current user reimbursements.');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let userReimb = JSON.parse(xhr.responseText);
			let user = userReimb.user;
			let reimbs = userReimb.uReimbs;
			console.log('reimbs = '+reimbs);
			if(reimbs.length > 0){
				reimbs.forEach((reimb)=>{
					let submitTime = reimb.submitTime;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let amount = parseFloat(Math.round(reimb.amount*100)/100).toFixed(2);
					let desc = reimb.description;
					let theStatus = '';
					switch(reimb.statusId){
					case 1:
						theStatus = 'Pending';
						break;
					case 2:
						theStatus = 'Approved';
						break;
					case 3:
						theStatus = 'Denied';
						break;
					default:
						theStatus = 'Pending';
					}
					let type = '';
					switch(reimb.typeId){
					case 1:
						type = 'Lodging';
						break;
					case 2:
						type = 'Travel';
						break;
					case 3:
						type = 'Food';
						break;
					case 4:
						type = 'Other';
						break;
					default:
						type = 'Other';
					}
					let resolveTime = reimb.resolveTime;
					let rYear = new Date(resolveTime).getFullYear();
					let rMonth = new Date(resolveTime).getMonth();
					let rDay = new Date(resolveTime).getDate();
					let rTime = `${rMonth}/${rDay}/${rYear}`;
					console.log('the resolvetime is: '+resolveTime);
					if(resolveTime == null | !resolveTime){
						resolveTime == 'N/A';
					}
					let format = `<tr><td>${sTime}</td><td>$${amount}</td><td>${desc}</td>
						<td>${theStatus}</td><td>${type}</td><td>${rTime}</td></tr>`;
					$('table tbody').append(format);

				})
			}
			else{
				$('#Reimbursement-Alert').html('No reimbursements have been submitted.')
			}
		}
	}
	xhr.open('GET','reimbs.loadReimbs',true);
	xhr.send();
}
function loadAllReimbursements(){
	console.log('loading all user reimbursements.');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let userReimb = JSON.parse(xhr.responseText);
			let user = userReimb.user;
			let reimbs = userReimb.uReimbs;
			console.log('reimbs = '+reimbs);
			if(reimbs.length > 0){
				reimbs.forEach((reimb)=>{
					console.log(reimb.resolveTime);
					let submitID = reimb.authorId;
					let resolveID = reimb.resolverId;
					let submitTime = reimb.submitTime;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let amount = parseFloat(Math.round(reimb.amount*100)/100).toFixed(2);
					let desc = reimb.description;
					let theStatus = '';
					switch(reimb.statusId){
					case 1:
						theStatus = 'Pending';
						break;
					case 2:
						theStatus = 'Approved';
						break;
					case 3:
						theStatus = 'Denied';
						break;
					default:
						theStatus = 'Pending';
					}
					let type = '';
					switch(reimb.typeId){
					case 1:
						type = 'Lodging';
						break;
					case 2:
						type = 'Travel';
						break;
					case 3:
						type = 'Food';
						break;
					case 4:
						type = 'Other';
						break;
					default:
						type = 'Other';
					}
					let resolveTime = reimb.resolveTime;
					console.log('Please show this at line 787 ');
					console.log(resolveTime);
					let rTime = 'N/A';
					console.log(reimb.statusId);
					console.log((reimb.statusId)+' should equal 1: '+(reimb.statusId !== 1));
					if(resolveTime != null/*reimb.statusId != 1*/){
						let rYear = new Date(resolveTime).getFullYear();
						let rMonth = new Date(resolveTime).getMonth();
						let rDay = new Date(resolveTime).getDate();
						rTime = `${rMonth}/${rDay}/${rYear}`;
					}
					let format = `<tr><td>${submitID}</td><td>${resolveID}</td><td>${sTime}</td><td>$${amount}</td><td>${desc}</td>
						<td>${theStatus}</td><td>${type}</td><td>${rTime}</td></tr>`;
					$('table tbody').append(format);

				})
			}
			else{
				$('#Reimbursement-Alert').html('No reimbursements have been submitted.');
			}
		}
	}
	xhr.open('GET','allReimbs.loadReimbs',true);
	xhr.send();
}
function submitReimbursementAdmin(){
	let amount = document.getElementById('amount').value;
	let desc = document.getElementById('desc').value;
	let type = document.getElementById('type').value;
	let reimbInfo = [amount, desc, type];
	let json = JSON.stringify(reimbInfo);
	if(amount=='' || desc=='' || type ==''){
		console.log('bad alert happens here');
		alert('Please enter all fields!');
	}
	else{
		console.log('else called');
		let xhr = new XMLHttpRequest;
		xhr.onreadystatechange = function(){
			console.log('request sent');
			if(xhr.readyState == 4 && xhr.status == 200){
				let getCode = JSON.parse(xhr.responseText)
				if(getCode == 1){
					alert('Unsuccessful submission, aborting.');
				}
				else{
					loadHomeAdmin();
					console.log('successful submission');
				}
			}
		}
		xhr.open('POST','newReimb', true); //POST is the type of request, login is the servlet
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(json);
	}
}