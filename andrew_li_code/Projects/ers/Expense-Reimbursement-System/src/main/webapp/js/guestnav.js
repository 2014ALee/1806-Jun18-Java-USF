window['loadGuestLinks'] = function() {
	window['setClickListener']('toLogin', function() {
		if (window['selected'] === $('#toLogin')) {
			return;
		}
		window['selected'].css('background-color', window['selectedclr']);
		window['selected'] = $('#toLogin');
		window['selectedclr'] = window['selected'].css('background-color');
		window['selected'].css('background-color', '#AAFF66');
		window['loadPage']('login.view');
	});
	window['setClickListener']('toRegister', function() {
		if (window['selected'] === $('#toRegister')) {
			return;
		}
		window['selected'].css('background-color', window['selectedclr']);
		window['selected'] = $('#toRegister');
		window['selectedclr'] = window['selected'].css('background-color');
		window['selected'].css('background-color', '#AAFF66');
		window['loadPage']('register.view');
	});
};

