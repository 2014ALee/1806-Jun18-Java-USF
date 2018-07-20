window['loadEvents'] = function(page) {
	switch(page) {
	case 'submit-request.view':
		window['setRequestButton']();
		break;
	case 'register.view':
		window['setRegisterButton']();
		break;
	case 'registration-success.view':
		window['setClickListener']('finishregistration-tologin',
			function() {
				$('#toLogin').click();
		});
		window['setClickListener']('finishregistration-tohome', function() {
			$('#toHome').click();
		});
		break;
	case 'finish-submit-request.view':
		window['setClickListener']('finishsubmittingrequest-tosubmitreimbursement',
			function() {
				$('#toSubmitRequest').click();
		});
		window['setClickListener']('finishsubmittingrequest-tohome', function() {
			$('#toHome').click();
		});
		break;
	case 'guesthome.view':
	case 'userhome.view':
	case 'managerhome.view':
	case 'main.view':
		window['loadPageButtons']();
		break;
	case 'login.view':
		window['setLoginButton']();
		break;
	}
}

window['loadPage'] = function(link) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#container').html(xhr.responseText);
			window['loadEvents'](link);
			window['loadPageButtons']();
		}
	}
	xhr.open('GET', link, true);
	xhr.send();
};
window['loadNav'] = function(link) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#navlinks').html(xhr.responseText);
			window['loadHomePage']();
			switch (link) {
			case 'guesthome.nav':
				window['loadGuestLinks']();
				break;
			case 'userhome.nav':
				window['loadUserLinks']();
				break;
			case 'managerhome.nav':
				window['loadManagerLinks']();
				break;
			}
		}
	}
	xhr.open('GET', link, true);
	xhr.send();
};


window.onload = function() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#navlinks').html(xhr.responseText);
			window['loadHomePage']();
			if ($('#pagetype').val() == 'guest') {
				window['loadGuestLinks']();
			} else if ($('#pagetype').val() == 'user') {
				window['loadUserLinks']();
			} else if ($('#pagetype').val() == 'manager') {
				window['loadManagerLinks']();
			}
		}
	}
	xhr.open('GET', 'main.nav', true);
	xhr.send();
	window['loadPage']('main.view');
	window['emptyTable'] = $('#resultlist').html();
	$(function() { $('#closetable').click(function() { 
		$('#view').show();
		let tbody = $('#resultlist').find('tbody')[0];
		let trows = $(tbody).find('tr');
		for (let i = 0; i < trows.length; i++) {
			$(trows[i]).hide();
		}
		$('#resultlist').hide(); 
	}); });
	$(function() { $('#closeticketPage').click(function() { 
		$('#resultlist').show();
		$('#ticketPage').hide(); 
		$('#approveTicket').hide(); 
		$('#denyTicket').hide();
	}); });
	
};