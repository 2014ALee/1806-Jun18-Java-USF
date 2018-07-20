window['setRegisterButton'] = function() {
	window['setClickListener']('register', function() {
				let toSend = [];
				let firstName = $('#register-firstname').val();
				let lastName = $('#register-lastname').val();
				let username = $('#register-username').val();
				let password = $('#register-password').val();
				let confirmPassword = $('#confirm-password').val();
				let email = $('#register-email').val();
				
				$('#register-firstname').val('');
				$('#register-lastname').val('');
				$('#register-username').val('');
				$('#register-password').val('');
				$('#confirm-password').val('');
				$('#register-email').val('');
				toSend[0] = firstName;
				toSend[1] = lastName;
				toSend[2] = username;
				toSend[3] = password;
				toSend[4] = confirmPassword;
				toSend[5] = email;
				let json = JSON.stringify(toSend);
				let xhr = new XMLHttpRequest();

				xhr.onreadystatechange = function() {
					if(xhr.readyState == 4 && xhr.status == 200) {
						let errorIndex = xhr.responseText.indexOf('error:');
						if (errorIndex >= 0 && errorIndex < 7) {
							$('#register-message').html(xhr.responseText.substring(errorIndex + 6));
						}
						else {
							window['loadPage']('registration-success.view');
						}
					}
				}
				
				xhr.open('POST', '/Expense-Reimbursement-System/register', true);
				xhr.setRequestHeader('Content-type', 'application/json');
				xhr.send(json);
		});
}