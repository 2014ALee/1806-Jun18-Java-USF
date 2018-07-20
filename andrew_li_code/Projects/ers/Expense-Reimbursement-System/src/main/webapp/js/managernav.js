window['loadManagerLinks'] = function() {
	window['setClickListener']('toResolveRequest', function() {
		window['getPendingRequests']();
	});
	window['setClickListener']('toOldResolves', function() {
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
