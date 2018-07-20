window['setLoginButton'] = function() {
	window['setClickListener']('login', function() {
				let toSend = [];
				let username = $('#login-username').val();
				let password = $('#login-password').val();
				$('#login-username').val('');
				$('#login-password').val('');
				if (username.length == 0) {
					alert('You must enter a username.');
					return;
			    }
				if (password.length == 0) {
					alert('You must enter a password.');
					return;
			    }
				toSend[0] = username;
				toSend[1] = password;
				let json = JSON.stringify(toSend);
				let xhr = new XMLHttpRequest();

				xhr.onreadystatechange = function() {
					if(xhr.readyState == 4 && xhr.status == 200) {
						let errorIndex = xhr.responseText.indexOf('error:');
						if (errorIndex >= 0 && errorIndex < 7) {
							$('#login-message').html(xhr.responseText.substring(errorIndex + 6));
						}
						else {
							let xhr3 = new XMLHttpRequest();
							xhr3.onreadystatechange = function() {
								if(xhr3.readyState == 4 && xhr3.status == 200) {
									$('#navlinks').html(xhr3.responseText);
									window['selected'] = $('#toHome');
									window['selectedclr'] = window['selected'].css('background-color');
									window['selected'].css('background-color', '#AAFF66');
								}
							}
							let usrAccount = xhr.responseText;
							try {
								usrAccount = JSON.parse(usrAccount);
							} catch (e) {
								xhr3.open('GET', 'guesthome.nav', true);
								xhr3.send();
								window['loadPage']('guesthome.view');
								window['loadNav']('guesthome.nav');
								return;
							}
							if (usrAccount['role'] == 1) {
								xhr3.open('GET', 'userhome.nav', true);
								xhr3.send();
								window['loadPage']('userhome.view');
								window['loadNav']('userhome.nav');
							}
							else if (usrAccount['role'] == 2) {
								xhr3.open('GET', 'managerhome.nav', true);
								xhr3.send();
								window['loadPage']('managerhome.view');
								window['loadNav']('managerhome.nav');
							}
						}
					}
				}
				
				xhr.open('POST', '/Expense-Reimbursement-System/login', true);
				xhr.setRequestHeader('Content-type', 'application/json');
				xhr.send(json);
		});
}