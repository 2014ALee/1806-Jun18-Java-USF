window['loadHomePage'] = function() {
	window['selected'] = $('#toHome');
	window['selectedclr'] = window['selected'].css('background-color');
	window['selected'].css('background-color', '#AAFF66');
	window['setClickListener']('toHome', function() {
		if (window['selected'] === $('#toHome')) {
			return;
		}
		if (window['selectedclr'] != undefined) {
			window['selected'].css('background-color', window['selectedclr']);
		}
		window['selected'] = $('#toHome');
		window['selectedclr'] = window['selected'].css('background-color');
		window['selected'].css('background-color', '#AAFF66');
		switch ($('#pagetype').val()) {
		case 'user':
			window['loadPage']('userhome.view');
			break;
		case 'guest':
			window['loadPage']('guesthome.view');
			break;
		case 'manager':
			window['loadPage']('managerhome.view');
			break;
		}
	});
}

window['loadPageButtons'] = function() {
	window['setClickListener']('containertype', (function() {
		if ($('#containertype').val() == 'guest') {
			window['setClickListener']('guesthome-tologin', function() {
		        $('#toLogin').click();
			});
			window['setClickListener']('guesthome-toregister', function() {
		        $('#toRegister').click();
		    });
		} else if ($('#containertype').val() == 'user') {
			window['setClickListener']('userhome-tosubmitreimbursement', function() {
		        $('#toSubmitRequest').click();
		    });
		} else if ($('#containertype').val() == 'manager') {
			window['setClickListener']('managerhome-toresolverequest', function() {
				$('#toResolveRequest').click();
			})
		}
		return function() {};
	} ()));
}
/*
$('#navlinks').html(xhr.responseText);
window['selected'] = $('#toHome');
window['selectedclr'] = window['selected'].css('background-color');
window['selected'].css('background-color', '#AAFF66');
window['setClickListener']('toHome', function() {
	if (window['selected'] === $('#toHome')) {
		return;
	}
	if (window['selectedclr'] != undefined) {
		window['selected'].css('background-color', window['selectedclr']);
	}
	window['selected'] = $('#toHome');
	window['selectedclr'] = window['selected'].css('background-color');
	window['selected'].css('background-color', '#AAFF66');
	window['loadPage']('home.view');
});
*/