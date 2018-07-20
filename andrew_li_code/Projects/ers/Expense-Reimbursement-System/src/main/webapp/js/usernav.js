window['loadUserLinks'] = function() {
	window['setClickListener']('toSubmitRequest', function() {
		if (window['selected'] === $('#toSubmitRequest')) {
			return;
		}
		window['selected'].css('background-color', window['selectedclr']);
		window['selected'] = $('#toSubmitRequest');
		window['selectedclr'] = window['selected'].css('background-color');
		window['selected'].css('background-color', '#AAFF66');
		window['loadPage']('submit-request.view');
	});
	window['setClickListener']('toOldRequests', function() {
		window['getOldRequests']();
	});
	window['setClickListener']('toLogout', function() {
		let xhr = new XMLHttpRequest();
		xhr.open('GET', '/Expense-Reimbursement-System/logout', true);
		xhr.send();
		window['loadNav']('guesthome.nav');
		window['loadPage']('guesthome.view');
	});
};
