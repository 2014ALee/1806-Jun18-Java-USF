window.onload = function() {
	loadLogin();
	$('#toLogin').on('click', loadLogin);
	$('#toRegister').on('click', loadRegister);
	$('#toEmpReimbursements').on('click', loadEmpReimb);	
//	$('#toHome').on('click', loadHome);
	$('#toLogout').on('click', function(){
		loadLogin();
	});	
	$('#toEmpReimbursements').hide();
	$('#toManReimbursements').hide();
	$('#toAllReimbursements').hide();
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
			$('#toAllReimbursements').hide();
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
	$('#toAllReimbursements').hide();
	
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
	$('#toAllReimbursements').hide();
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

function loadEmpReimb() {
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			loadEmpReimbInfo();
			$('#toRegister').hide();
			$('#toLogin').hide();
			$('#toLogout').on('click', function(){
				loadLogin();
			});	
	
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManagerReimbursements').hide();
			$('#toAllReimbursements').hide();
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
					// With help from Algustus
					let submitTime = reimb.reimb_submitted;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let resolver = reimb.reimb_resolver;
					let resolved = reimb.reimb_resolved;
					
					switch(reimb.reimb_status_id){
					case 1:
						status = 'Pending';
						break;
					case 2:
						status = 'Approved';
						break; 
					case 3:
						status = 'Denied';
						break;
					default:
						status = 'Pending';
					}
					let type = '';
					switch(reimb.reimb_type_id){
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
					
					
					let markup = `<tr>
									<td>${reimbId}</td>
									<td>${amount}</td>
									<td>${sTime}</td>
									
									<td>${description}</td>
									
									
									<td>${type}</td>
									<td>${status}</td>
								  </tr>`;
					
					$('table tbody').append(markup);
				})
			} else {
				$('#reimb-info').html('No reimbursements on record');
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
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log('in callback');
			$('#message').hide();
			alert('Reimbursement Created Successfully!');
			loadEmpReimb();
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
			$('#toManagerReimbursements').hide();
			$('#toAllReimbursements').hide();
			$('#toLogout').show();
			$('#toLogout').on('click', function(){
				loadLogin();
			});	

		}
	}
	
	xhr.open('GET', 'manager-reimbursement.view', true);
	xhr.send();
	
}

function loadManReimbInfo(){
	
	console.log('in manReimbInfo()');
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
								
				let manInfo = JSON.parse(xhr.responseText);
				console.log(manInfo);
				let user = manInfo.user;
				let reimbs = manInfo.userReimbursements;

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

		$('#retrieveAllReimbs').on('click', loadGetAllReimbs);
	}


function loadGetAllReimbs(){
let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			$('#view').html(xhr.responseText);
			getAllReimbs();
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManReimbursements').show();
			$('#toManReimbursements').on('click', loadManReimb);
			$('#toAllReimbursements').hide();
			$('#toLogout').show();
			$('#toLogout').on('click', function(){
				loadLogin();
			});	

		}
	}
	
	xhr.open('GET', 'all-reimbursements.view', true);
	xhr.send();
	
}

function getAllReimbs(){
	
	console.log('In getAllReimbs()');
	
	let xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function(){
    	
    	if(xhr.readyState == 4 && xhr.status == 200){
    	let allInfo = JSON.parse(xhr.responseText);
    	console.log(allInfo);
		let user = allInfo.user;
		let reimbs = allInfo.userReimbursements;
    	
    	if(reimbs.length > 0) {
			reimbs.forEach((reimb) => {
				let author = reimb.reimb_author;
				let reimbId = reimb.reimb_id
				let amount = parseFloat(Math.round(reimb.reimb_amount * 100) / 100).toFixed(2);
				let description = reimb.reimb_description;
				// With help from Algustus
				let submitTime = reimb.reimb_submitted;
				let sYear = new Date(submitTime).getFullYear();
				let sMonth = new Date(submitTime).getMonth();
				let sDay = new Date(submitTime).getDate();
				let sTime = `${sMonth}/${sDay}/${sYear}`;
				let resolver = reimb.reimb_resolver;
				let resolved = reimb.reimb_resolved;
				
				switch(reimb.reimb_status_id){
				case 1:
					status = 'Pending';
					break;
				case 2:
					status = 'Approved';
					break; 
				case 3:
					status = 'Denied';
					break;
				default:
					status = 'Pending';
				}
				let type = '';
				switch(reimb.reimb_type_id){
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
				
				
				let markup = `<tr>
								<td>${reimbId}</td>
								<td>${amount}</td>
								<td>${sTime}</td>
								<td>${resolved}</td>
								<td>${description}</td>
								<td>${author}</td>
								<td>${resolver}</td>			
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
    
    $('#showPending').on('click', loadGetPendingReimbs);
    $('#showApproved').on('click', loadGetApprovedReimbs);
    $('#showDenied').on('click', loadGetDeniedReimbs);
    $('#editReimbs').on('click', loadEditReimbs);
    
    xhr.open('GET', 'allreimbursements.loadinfo', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send();	
}

function loadEditReimbs(){
	console.log('in loadEditReimbs()');

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + xhr.status);
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			editReimbursements();
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManReimbursements').show();
			$('#toManReimbursements').on('click', loadManReimb);
			$('#toAllReimbursements').show();
			$('#toAllReimbursements').on('click', function(){
				loadGetAllReimbs();
			})
	}
	}
	xhr.open('GET', 'edit-reimbursements.view', true);
	xhr.send();
}

function editReimbursements(){
	
	console.log('in editReimbursements.');
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		
		console.log('in update callback function');
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let userReimb = JSON.parse(xhr.responseText);
			let user = userReimb.user;
			let reimbs = userReimb.userReimbursements;
			
			if(reimbs.length > 0){ 
				reimbs.forEach((reimb)=>{
					let reimbId = reimb.reimb_id;
					let resolver = reimb.reimb_resolver;
					let submitID = reimb.reimb_author;
					let resolved = reimb.reimb_author;
					// With help from Algustus
					let submitTime = reimb.reimb_submitted;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let amount = parseFloat(Math.round(reimb.reimb_amount*100)/100).toFixed(2);
					let desc = reimb.reimb_description;
					let status = ' ';
					switch(reimb.reimb_status_id){
					case 1:
						status = 'Pending';
						break;
					case 2:
						status = 'Approved';
						break; 
					case 3:
						status = 'Denied';
						break;
					default:
						status = 'Pending';
					}
					let type = '';
					switch(reimb.reimb_type_id){
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
					
					let adminOption = reimb.edit;
					let markup = 
					`<tr>
					<td>${reimbId}</td>
					<td>${amount}</td>
					<td>${sTime}</td>					
					<td>${resolved}</td>
					<td>${desc}</td>
					<td>${submitID}</td>
					<td>${resolver}</td>
					<td>${type}</td>
					<td>${status}</td>
					<td>
						<select id="${reimbId}">
						<option value="1">Pending</option>
						<option value="2">Approve</option>
						<option value="3">Deny</option>
						</select>
					</td>
					</tr>`;
					
					
					$('table tbody').append(markup);
					
				})  
			}
			else{
				alert('No reimbursements have been submitted.');
			}
				
		}	
	}
	
	$('#editReimbursements-table').on('change', 'select', submitStatus);
	
	xhr.open('GET','editreimbursements.loadinfo', true);
	xhr.send();
}

function submitStatus(event){
	
	console.log('in submitStatus')
	
	let status = $('#managerChoice option:selected').val();
	
	let reimb = {
			reimb_id: event.target.id,
			reimb_amount: 1,
			reimb_submitted: Date.now(),
			reimb_resolver: 1,
			reimb_description: '',
			reimb_status_id: event.target.value,
			reimb_type_id: 1
			}
	
	console.log(event.target.value);
	console.log(event.target.id);
		
	let reimbJson = JSON.stringify(reimb);
	
	let xhr = new XMLHttpRequest();
	
    xhr.readystatechange = function(){
    	if (xhr.readyState == 4 && xhr.status == 200){
    	alert('Reimbursement Successfully Updated')	
    	loadEditReimbs();
    	}
	}
	
	xhr.open('POST', 'update', true);
	xhr.send(reimbJson);
	
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

function loadGetPendingReimbs(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			getPendingReimbs();
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManagerReimbursements').show();
			$('#toManReimbursements').on('click', loadManReimb);
			$('#toAllReimbursements').show();
			$('#toAllReimbursements').on('click', function(){
				loadGetAllReimbs();
			})
			$('#toLogout').show();
			$('#toLogout').on('click', function(){
				loadLogin();
			});
		}
	}
	
	xhr.open('GET', 'pending-reimbursements.view', true);
	xhr.send();
	
}

function getPendingReimbs(){
	
console.log('In getPendingReimbs()');
	
	let xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function(){
    	
    	if(xhr.readyState == 4 && xhr.status == 200){
	    	let pendingInfo = JSON.parse(xhr.responseText);
	    	console.log(pendingInfo);
			let user = pendingInfo.user;
			let reimbs = pendingInfo.userReimbursements;
	    	
	    	if(reimbs.length > 0) {
				reimbs.forEach((reimb) => {
					let author = reimb.reimb_author;
					let reimbId = reimb.reimb_id
					let amount = parseFloat(Math.round(reimb.reimb_amount * 100) / 100).toFixed(2);
					let description = reimb.reimb_description;
					let status = '';
					// With help from Algustus
					let submitTime = reimb.reimb_submitted;
					let sYear = new Date(submitTime).getFullYear();
					let sMonth = new Date(submitTime).getMonth();
					let sDay = new Date(submitTime).getDate();
					let sTime = `${sMonth}/${sDay}/${sYear}`;
					let resolver = reimb.reimb_resolver;
					let resolved = reimb.reimb_resolved;
					
					switch(reimb.reimb_status_id){
					case 1:
						status = 'Pending';
						break;
					case 2:
						status = 'Approved';
						break; 
					case 3:
						status = 'Denied';
						break;
					default:
						status = 'Pending';
					}
					let type = '';
					switch(reimb.reimb_type_id){
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
					
					
					let markup = `<tr>
									<td>${reimbId}</td>
									<td>${amount}</td>
									<td>${sTime}</td>
									<td>${resolved}</td>
									<td>${description}</td>
									<td>${author}</td>
									<td>${resolver}</td>			
									<td>${type}</td>
									<td>${status}</td>
								  </tr>`;
					
					$('table tbody').append(markup);
				})

		} else {
			$('#reimb-info').html('No reimbursements on record');
		}
	}
    }
    
    xhr.open('GET', 'pendingreimbursements.loadinfo', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send();	
    
}

function loadGetApprovedReimbs(){
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			getApprovedReimbs();
			$('#toRegister').hide();
			$('#toLogin').hide();
			
			$('#toHome').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManagerReimbursements').show();
			$('#toAllReimbursements').show();
			$('#toAllReimbursements').on('click', function(){
				loadGetAllReimbs();
			});
			$('#toManReimbursements').on('click', loadManReimb);
			$('#toLogout').show();
			$('#toLogout').on('click', function(){
				loadLogin();
			});
		}
	}
	
	xhr.open('GET', 'approved-reimbursements.view', true);
	xhr.send();
	
}

function getApprovedReimbs(){
	
console.log('In getApprovedReimbs()');
	
	let xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function(){
    	
    	if(xhr.readyState == 4 && xhr.status == 200){
    	let approvedInfo = JSON.parse(xhr.responseText);
    	console.log(approvedInfo);
		let user = approvedInfo.user;
		let reimbs = approvedInfo.userReimbursements;
    	
    	if(reimbs.length > 0) {
			reimbs.forEach((reimb) => {
				let author = reimb.reimb_author;
				let reimbId = reimb.reimb_id
				let amount = parseFloat(Math.round(reimb.reimb_amount * 100) / 100).toFixed(2);
				let description = reimb.reimb_description;
				let status = reimb.reimb_status_id;
				// With help from Algustus
				let submitTime = reimb.reimb_submitted;
				let sYear = new Date(submitTime).getFullYear();
				let sMonth = new Date(submitTime).getMonth();
				let sDay = new Date(submitTime).getDate();
				let sTime = `${sMonth}/${sDay}/${sYear}`;
				let resolver = reimb.reimb_resolver;
				let resolved = reimb.reimb_resolved;
				
				switch(reimb.reimb_status_id){
				case 1:
					status = 'Pending';
					break;
				case 2:
					status = 'Approved';
					break; 
				case 3:
					status = 'Denied';
					break;
				default:
					status = 'Pending';
				}
				let type = '';
				switch(reimb.reimb_type_id){
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
				
				
				let markup = `<tr>
								<td>${reimbId}</td>
								<td>${amount}</td>
								<td>${sTime}</td>
								<td>${resolved}</td>
								<td>${description}</td>
								<td>${author}</td>
								<td>${resolver}</td>			
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
    
    xhr.open('GET', 'approvedreimbursements.loadinfo', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send();
	
}

function loadGetDeniedReimbs(){

	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			getDeniedReimbs();
			$('#toRegister').hide();
			$('#toLogin').hide();
			$('#toEmployeeReimbursements').hide();
			$('#toManagerReimbursements').show();
			$('#toAllReimbursements').show();
			$('#toAllReimbursements').on('click', function(){
				loadGetAllReimbs();
			});
			$('#toManReimbursements').on('click', loadManReimb);
			$('#toLogout').show();
			$('#toLogout').on('click', function(){
				loadLogin();
			});
		}
	}
	
	xhr.open('GET', 'denied-reimbursements.view', true);
	xhr.send();
	
}
function getDeniedReimbs(){
	
	console.log('In getPendingReimbs()');
	
	let xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function(){
    	
    	let deniedInfo = JSON.parse(xhr.responseText);
    	console.log(deniedInfo);
		let user = deniedInfo.user;
		let reimbs = deniedInfo.userReimbursements;
    	
    	if(reimbs.length > 0) {
    		
			reimbs.forEach((reimb) => {
				let author = reimb.reimb_author;
				let reimbId = reimb.reimb_id
				let amount = parseFloat(Math.round(reimb.reimb_amount * 100) / 100).toFixed(2);
				let description = reimb.reimb_description;
				let status = reimb.reimb_status_id;
				// With help from Algustus
				let submitTime = reimb.reimb_submitted;
				let sYear = new Date(submitTime).getFullYear();
				let sMonth = new Date(submitTime).getMonth();
				let sDay = new Date(submitTime).getDate();
				let sTime = `${sMonth}/${sDay}/${sYear}`;
				let resolver = reimb.reimb_resolver;
				let resolved = reimb.reimb_resolved;
				
				switch(reimb.reimb_status_id){
				case 1:
					status = 'Pending';
					break;
				case 2:
					status = 'Approved';
					break; 
				case 3:
					status = 'Denied';
					break;
				default:
					status = 'Pending';
				}
				let type = '';
				switch(reimb.reimb_type_id){
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
				
				
				let markup = `<tr>
								<td>${reimbId}</td>
								<td>${amount}</td>
								<td>${date}</td>
								<td>${resolved}</td>
								<td>${description}</td>
								<td>${author}</td>
								<td>${resolver}</td>			
								<td>${type}</td>
								<td>${status}</td>
							  </tr>`;
				
				$('table tbody').append(markup);
			})

		} else {
			$('#reimb-info').html('No reimbursemnets on record');
		}
	}
    
    xhr.open('GET', 'deniedreimbursements.loadinfo', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send();	
}

//function validateEmail() {
//	console.log('in validateEmail()');
//	
//	$('#register').attr('disabled', false);
//	$('#reg-message').hide();
//	
//	let email = $('#register-email').val();
//	let toSend = email;
//	let json = JSON.stringify(toSend);
//	
//	let xhr = new XMLHttpRequest();
//	
//	xhr.onreadystatechange = function() {
//		if(xhr.readyState == 4 && xhr.status == 200) {
//			let user = JSON.parse(xhr.responseText);
//			if(user == null) {
//				$('#reg-message').show();
//				$('#reg-message').html('Email address is already in use! Please try another.');
//				$('#register').attr('disabled', true)
//			}
//		}
//	}
//	
//	xhr.open('POST', email.validate, true);
//	xhr.setRequestHeader('Content-type', 'application/json');
//	xhr.send(json);
//}

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